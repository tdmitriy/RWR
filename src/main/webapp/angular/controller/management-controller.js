RwrApp.controller('managementController', ['$scope', '$route', 'appFactory', '$location',
    function ($scope, $route, appFactory, $location) {
        var seekerFactory = appFactory.getSeekerFactory();
        var pageableSeekerFactory = appFactory.getPageableSeekerFactory();
        var modalService = appFactory.getModalService();
        var notifyService = appFactory.getNotificationService();
        var errorService = appFactory.getErrorService();

        $scope.seeker = {
            id: null, firstName: null, lastName: null, dateOfAddition: null, dateOfInterview: null,
            contacts: {seekerEmails: [], seekerPhones: [], seekerIms: []},
            seekerSkills: []
        };

        $scope.inputFields = {phoneField: '', emailField: '', imsField: '', skillField: ''};

        $scope.editableMode = false;

        $scope.getSeekerById = function (id) {
            seekerFactory.getById(id).then(function (response) {
                $scope.seeker = response;
            });
        };

        $scope.saveSeeker = function (seeker) {
            $scope.resetErrors();
            /*seekerFactory.save(seeker).then(function () {
             $scope.backToTable();
             notifyService.success(setNotifyMessage("Seeker has been saved successfully."));
             });*/
            console.log(seeker);
        };

        $scope.deleteSeekerById = function (id) {
            $scope.resetErrors();
            seekerFactory.deleteById(id).then(function () {
                $route.reload();
                notifyService.success(setNotifyMessage("Seeker has been deleted successfully."));
            });
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
            if (!contains)
                $scope.seeker.contacts.seekerPhones.push({id: null, phoneNumber: phone});
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
            if (!contains)
                $scope.seeker.contacts.seekerEmails.push({id: null, email: email});
        };

        $scope.addImsToSeeker = function (imsLogin) {
            var i, imses = $scope.seeker.contacts.seekerIms;
            var contains = false;
            for (i = 0; i < imses.length; i++) {
                if (imses[i].email === email) {
                    contains = true;
                    break;
                }
            }
            //TODO
            /*if (!contains)
             $scope.seeker.contacts.seekerEmails.push({id: null, imsLogin: imsLogin, imsType:{id}});*/
        };

        $scope.deletePhone = function (index) {
            $scope.seeker.contacts.seekerPhones.splice(index, 1);
        };

        $scope.deleteEmail = function (index) {
            $scope.seeker.contacts.seekerEmails.splice(index, 1);
        };

        $scope.resetSeekerModel = function () {
            $scope.seeker = {
                id: null, firstName: null, lastName: null, dateOfAddition: null, dateOfInterview: null,
                contacts: {seekerEmails: [], seekerPhones: [], seekerIms: []},
                seekerSkills: []
            };
        };

        /* Date */
        $scope.date = {
            format: 'yyyy-MM-dd',
            dateOfAddition: new Date(),
            dateOfInterview: '',
            isOpenedDateOfAddition: false,
            isOpenedDateOfInterview: false
        };

        $scope.openDateOfAddition = function ($event) {
            $event.preventDefault();
            $event.stopPropagation();
            $scope.date.isOpenedDateOfAddition = true;
        };

        $scope.openDateOfInterview = function ($event) {
            $event.preventDefault();
            $event.stopPropagation();
            $scope.date.isOpenedDateOfInterview = true;
        };

        /* Rating */
        $scope.rate = {
            rateDefault: 1,
            rateMax: 10,
            isReadOnly: false
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
            return errorService.resetErrors();
        };

        var notifyOptions = {
            delay: 4000,
            positionY: 'top',
            positionX: 'center'
        };

        var setNotifyMessage = function (message) {
            var icon = '<i class="fa fa-fw fa-check-circle"></i>';
            notifyOptions.message = icon + message;
            return notifyOptions;
        };
    }]);