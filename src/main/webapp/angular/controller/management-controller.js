RwrApp.controller('managementController', ['$scope', '$route', 'appFactory', '$location',
    function ($scope, $route, appFactory, $location) {
        var seekerFactory = appFactory.getSeekerFactory();
        var pageableSeekerFactory = appFactory.getPageableSeekerFactory();
        var modalService = appFactory.getModalService();
        var notifyService = appFactory.getNotifyMessageService();
        var errorService = appFactory.getErrorService();
        var dbTypesFactory = appFactory.getDbTypesFactory();


        $scope.seekerForm = {};
        $scope.seeker = {
            id: null, firstName: null, lastName: null, dateOfAddition: new Date(), dateOfInterview: null,
            contacts: {seekerEmails: [], seekerPhones: [], seekerIms: []},
            seekerSkills: []
        };

        $scope.inputFields = {phoneField: '', emailField: '', imsField: '', skillField: '', skillRatingField: ''};

        $scope.getSeekerById = function (id) {
            seekerFactory.getById(id).then(function (response) {
                $scope.seeker = response;
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
        };

        $scope.addPhoneToSeeker = function (phone) {
            var i, phones = $scope.seeker.contacts.seekerPhones;
            var contains = false;
            for (i = 0; i < phones.length; i++) {
                if (phones[i].phoneNumber === phone) {
                    contains = true;
                    break;
                }
            }
            if (!contains) {
                $scope.seeker.contacts.seekerPhones.push({phoneNumber: phone});
                $scope.inputFields.phoneField = null;
            }

        };

        $scope.addEmailToSeeker = function (email) {
            var i, emails = $scope.seeker.contacts.seekerEmails;
            var contains = false;
            for (i = 0; i < emails.length; i++) {
                if (emails[i].email === email) {
                    contains = true;
                    break;
                }
            }
            if (!contains) {
                $scope.seeker.contacts.seekerEmails.push({email: email});
                $scope.inputFields.emailField = null;
            }

        };

        $scope.addImsToSeeker = function (login) {
            var type = $scope.imsType;
            var i, imses = $scope.seeker.contacts.seekerIms;
            var contains = false;
            if (typeof type !== 'undefined' && type !== null) {
                for (i = 0; i < imses.length; i++) {
                    if (imses[i].imsType.id === type.id) {
                        contains = true;
                        break;
                    }
                }
            }
            if (!contains) {
                $scope.seeker.contacts.seekerIms.push({imsLogin: login, imsType: type});
                $scope.imsType = null;
                $scope.inputFields.imsField = null;
            }
        };


        $scope.addSkillToSeeker = function (skill) {
            var type = $scope.skillType;
            var i, skills = $scope.seeker.seekerSkills;
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

            $scope.skillType = null;
            $scope.inputFields.skillField = null;
            $scope.inputFields.skillRatingField = null;
        };

        var addNonExistingSkill = function (contains, skill) {
            if (!contains) {
                $scope.seeker.seekerSkills.push({
                    id: null,
                    skillRating: $scope.inputFields.skillRatingField,
                    skillType: {skillName: skill.toLowerCase()}
                });
            }
        };

        var addSkillFromDropdown = function (contains, type) {
            if (!contains) {
                $scope.seeker.seekerSkills.push({
                    id: null,
                    skillRating: $scope.inputFields.skillRatingField,
                    skillType: type
                });
            }
        };

        $scope.deletePhone = function (index) {
            $scope.seeker.contacts.seekerPhones.splice(index, 1);
        };

        $scope.deleteEmail = function (index) {
            $scope.seeker.contacts.seekerEmails.splice(index, 1);
        };

        $scope.deleteIms = function (index) {
            $scope.seeker.contacts.seekerIms.splice(index, 1);
        };

        $scope.resetSeekerModel = function () {
            $scope.seeker = {
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

        //$scope.getImsTypes();
        //$scope.getSkillTypes();
    }]);