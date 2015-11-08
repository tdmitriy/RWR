RwrApp.factory('appFactory',
    ['modalService', 'seekerFactory', 'errorService', 'Notification',
        'pageableSeekerFactory', 'dbTypesFactory',
        function (modalService, seekerFactory, errorService,
                  Notification, pageableSeekerFactory, dbTypesFactory) {
            return {
                getSeekerFactory: function () {
                    return seekerFactory;
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
                getPageableSeekerFactory: function () {
                    return pageableSeekerFactory;
                },
                getDbTypesFactory: function () {
                    return dbTypesFactory;
                }
            };
        }]);