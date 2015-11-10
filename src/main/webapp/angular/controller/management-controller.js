RwrApp.controller('managementController', ['$scope', '$route', 'appFactory', '$location', '$routeParams',
    function ($scope, $route, appFactory, $location, $routeParams) {
        var seekerFactory = appFactory.getSeekerFactory();
        var pageableSeekerFactory = appFactory.getPageableSeekerFactory();
        var modalService = appFactory.getModalService();
        var notifyService = appFactory.getNotifyMessageService();
        var errorService = appFactory.getErrorService();
        var dbTypesFactory = appFactory.getDbTypesFactory();


        $scope.seekerForm = {};
        $scope.seeker = {};

        $scope.seekerUpdatable = {
            id: null, firstName: null, lastName: null, dateOfAddition: new Date(), dateOfInterview: null,
            contacts: {seekerEmails: [], seekerPhones: [], seekerIms: []},
            seekerSkills: []
        };

        $scope.inputFields = {
            phoneField: null,
            emailField: null,
            imsField: null,
            skillField: null,
            skillRatingField: null
        };

        $scope.isEditableState = function () {
            var editableId = $routeParams.id;
            if (typeof editableId !== 'undefined' && editableId !== null) {
                $scope.setEditableMode(true);
                $scope.getSeekerById(editableId);
            }
        };


        $scope.getSeekerById = function (id) {
            seekerFactory.getById(id).then(function (response) {
                $scope.seekerUpdatable = response;
                console.log($scope.seekerUpdatable);
            });
        };

        $scope.saveSeeker = function (seeker) {
            $scope.resetErrors();
            seekerFactory.save(seeker).then(function () {
                $scope.backToTable();
                notifyService.successMessage("Seeker has been saved successfully.");
            });
            console.log(seeker);
        };

        $scope.deleteSeekerById = function (id) {
            $scope.resetErrors();
            seekerFactory.deleteById(id).then(function () {
                $route.reload();
                notifyService.successMessage("Seeker has been deleted successfully.");
            });
        };

        $scope.imsTypes = [];
        $scope.skillTypes = [];

        $scope.getImsTypes = function () {
            dbTypesFactory.getImsTypes().then(function (response) {
                $scope.imsTypes = response;
            });
        };

        $scope.getSkillTypes = function () {
            dbTypesFactory.getSkillTypes().then(function (response) {
                $scope.skillTypes = response;
            });
        };

        $scope.imsType = null;
        $scope.selectedImsType = function (imsType) {
            $scope.imsType = imsType;
        };

        $scope.skillType = null;
        $scope.selectedSkillType = function (skillType) {
            $scope.skillType = skillType;
            $scope.inputFields.skillField = skillType.skillName;
            $scope.inputFields.skillRatingField = 1;
        };

        $scope.addPhoneToSeeker = function (phone) {
            if (phone.trim() !== '') {
                var i, phones = $scope.seekerUpdatable.contacts.seekerPhones;
                var contains = false;
                for (i = 0; i < phones.length; i++) {
                    if (phones[i].phoneNumber === phone) {
                        contains = true;
                        break;
                    }
                }
                if (!contains) {
                    $scope.seekerUpdatable.contacts.seekerPhones.push({phoneNumber: phone});
                    $scope.inputFields.phoneField = null;
                }
            }
        };

        $scope.addEmailToSeeker = function (email) {
            if (email.trim() !== '') {
                var i, emails = $scope.seekerUpdatable.contacts.seekerEmails;
                var contains = false;
                for (i = 0; i < emails.length; i++) {
                    if (emails[i].email === email) {
                        contains = true;
                        break;
                    }
                }
                if (!contains) {
                    $scope.seekerUpdatable.contacts.seekerEmails.push({email: email});
                    $scope.inputFields.emailField = null;
                }
            }
        };

        $scope.addImsToSeeker = function (login) {
            if (login.trim() !== '') {
                var type = $scope.imsType;
                var i, imses = $scope.seekerUpdatable.contacts.seekerIms;
                var contains = false;
                if (typeof type !== 'undefined' && type !== null) {
                    for (i = 0; i < imses.length; i++) {
                        if (imses[i].imsType.id === type.id) {
                            contains = true;
                            break;
                        }
                    }
                    if (!contains) {
                        $scope.seekerUpdatable.contacts.seekerIms.push({imsLogin: login, imsType: type});
                        $scope.imsType = null;
                        $scope.inputFields.imsField = null;
                    }
                }
            }
        };


        $scope.addSkillToSeeker = function (skill) {
            if ($scope.inputFields.skillRatingField !== null || $scope.inputFields.skillRatingField.trim() !== '')
                var type = $scope.skillType;
            var i, skills = $scope.seekerUpdatable.seekerSkills;
            var contains = false;

            for (i = 0; i < skills.length; i++) {
                if (skills[i].skillType.skillName.toLowerCase() === skill.toLowerCase()) {
                    contains = true;
                    break;
                }
            }
            if (typeof type === 'undefined' || type === null) {
                addNonExistingSkill(contains, skill);
            }
            if (typeof type !== 'undefined' && type !== null) {
                addSkillFromDropdown(contains, type);
            }

            $scope.getSkillTypes();

            $scope.skillType = null;
            $scope.inputFields.skillField = null;
            $scope.inputFields.skillRatingField = null;
        };

        var addNonExistingSkill = function (contains, skill) {
            if (!contains) {
                $scope.seekerUpdatable.seekerSkills.push({
                    id: null,
                    skillRating: $scope.inputFields.skillRatingField,
                    skillType: {skillName: skill.toLowerCase()}
                });
            }
        };

        var addSkillFromDropdown = function (contains, type) {
            if (!contains) {
                $scope.seekerUpdatable.seekerSkills.push({
                    id: null,
                    skillRating: $scope.inputFields.skillRatingField,
                    skillType: type
                });
            }
        };

        $scope.deletePhone = function (index) {
            $scope.seekerUpdatable.contacts.seekerPhones.splice(index, 1);
        };

        $scope.deleteEmail = function (index) {
            $scope.seekerUpdatable.contacts.seekerEmails.splice(index, 1);
        };

        $scope.deleteIms = function (index) {
            $scope.seekerUpdatable.contacts.seekerIms.splice(index, 1);
        };

        $scope.deleteSkill = function (index) {
            $scope.seekerUpdatable.seekerSkills.splice(index, 1);
        };

        $scope.resetSeekerModel = function () {
            $scope.seekerUpdatable = {
                id: null, firstName: null, lastName: null, dateOfAddition: new Date(), dateOfInterview: null,
                contacts: {seekerEmails: [], seekerPhones: [], seekerIms: []},
                seekerSkills: []
            };
        };

        $scope.skillRatingSetReadOnly = function (value) {
            $scope.skillRating = value;
        };

        $scope.backToTable = function () {
            var url = pageableSeekerFactory.getPageableUrl();
            if (typeof url === 'undefined' || url === null) url = pageableSeekerFactory.getDefaultHomeUrl();
            $location.url(url);
        };

        $scope.editableMode = null;
        $scope.setEditableMode = function (value) {
            $scope.editableMode = value;
        };

        $scope.isError = function () {
            return errorService.isError();
        };

        $scope.getErrors = function () {
            return errorService.getErrors();
        };

        $scope.resetErrors = function () {
            errorService.resetErrors();
        };

        $scope.isEditableState();
        $scope.getImsTypes();
        $scope.getSkillTypes();
    }
])
;