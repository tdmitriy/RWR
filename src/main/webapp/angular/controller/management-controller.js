RwrApp.controller('managementController', ['$scope', '$route', 'appFactory', '$location',
    function ($scope, $route, appFactory, $location) {
        var seekerFactory = appFactory.getSeekerFactory();
        var pageableSeekerFactory = appFactory.getPageableSeekerFactory();
        var modalService = appFactory.getModalService();
        var notifyService = appFactory.getNotificationService();
        var errorService = appFactory.getErrorService();

        $scope.seeker = {
            id: null,
            firstName: null,
            lastName: null,
            dateOfAddition: null,
            dateOfInterview: null,
            contacts: {seekerEmails: [], seekerPhones: [], seekerIms: []},
            seekerSkills: []
        };

        $scope.editableMode = false;

        $scope.getSeekerById = function (id) {
            seekerFactory.getById(id).then(function (response) {
                $scope.seeker = response;
            });
        };

        $scope.saveSeeker = function (seeker) {
            $scope.resetErrors();
            seekerFactory.save(seeker).then(function () {
                $scope.backToTable();
                notifyService.success(setNotifyMessage("Seeker has been saved successfully."));
            });
        };

        $scope.deleteSeekerById = function (id) {
            $scope.resetErrors();
            seekerFactory.deleteById(id).then(function () {
                $route.reload();
                notifyService.success(setNotifyMessage("Seeker has been deleted successfully."));
            });
        };

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

        $scope.modal = {};
        $scope.modal.showConfirm = function (id) {
            var options = {bodyText: 'Delete this seeker?'};
            modalService.show(options).then(function (modal) {
                modal.element.modal();
                modal.close.then(function (modalData) {
                    //handle buttons result
                    if (modalData !== 'cancel') {
                        if (typeof id !== 'undefined' || id !== null) {
                            //$scope.deleteSeekerById(id);
                        }
                    }
                });
            });
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