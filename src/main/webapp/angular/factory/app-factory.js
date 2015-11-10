RwrApp.factory('appFactory',
    ['modalService', 'seekerFactory', 'errorService', 'notifyMessageService',
        'pageableSeekerFactory', 'dbTypesFactory',
        function (modalService, seekerFactory, errorService,
                  notifyMessageService, pageableSeekerFactory, dbTypesFactory) {
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
                getNotifyMessageService: function () {
                    return notifyMessageService;
                },
                getPageableSeekerFactory: function () {
                    return pageableSeekerFactory;
                },
                getDbTypesFactory: function () {
                    return dbTypesFactory;
                }
            };
        }]);