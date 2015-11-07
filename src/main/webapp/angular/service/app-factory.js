RwrApp.factory('appFactory',
    ['modalService', 'seekerService', 'errorService', 'Notification', 'loadingStateService',
        'pageableService',
        function (modalService, seekerService, errorService,
                  Notification, loadingStateService, pageableService) {
            return {
                getSeekerService: function () {
                    return seekerService;
                },
                getModalService: function () {
                    return modalService;
                },
                getErrorService: function () {
                    return errorService;
                },
                getNotificationService: function () {
                    return Notification;
                },
                getLoadingStateService: function () {
                    return loadingStateService;
                },
                getPageableService: function () {
                    return pageableService;
                }
            };
        }]);