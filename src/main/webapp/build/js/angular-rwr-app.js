'use strict';
var RwrApp = angular.module('RwrApp',
    [
        'ngRoute',
        'ngAnimate',
        'angular-loading-bar',
        'angularModalService',
        'ui-notification',
        'ui.bootstrap',
        'ngMessages',
    ]);

RwrApp.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: '/home',
        controller: 'pageableController',
        reloadOnSearch: false
    });

    $routeProvider.when('/management/add', {
        templateUrl: '/management/add',
        controller: 'managementController'
    });
}]);;
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
    }]);;
RwrApp.controller('modalController', ['$scope', 'close', 'modalService', function ($scope, close, modalService) {
    //modalView using this options to bind the fields
    $scope.modalOptions = modalService.getOptions();
    $scope.close = function (modalData) {
        close(modalData, 500); // close, but give 500ms for bootstrap to animate
    };
}]);;
RwrApp.controller('pageableController',
    ['$scope', 'appFactory', '$routeParams', '$route', '$location',
        function ($scope, appFactory, $routeParams, $route, $location) {
            var errorService = appFactory.getErrorService();
            var pageableSeekerFactory = appFactory.getPageableSeekerFactory();
            var seekerFactory = appFactory.getSeekerFactory();
            var modalService = appFactory.getModalService();
            var notifyService = appFactory.getNotificationService();

            $scope.page = {
                sortMode: false,
                defaultFirstPage: 1,
                defaultItemsPerPage: 3,
                currentPage: 1,
                maxPagerItemsSize: 5,
                itemsPerPage: null,
                maxTotalItems: null
            };

            $scope.seekersPageable = {};

            $scope.getSeekersNonSortableList = function (page, maxRecordsPerPage) {
                $scope.resetErrors();
                if (typeof page === 'undefined' || page === null) {
                    page = $scope.page.defaultFirstPage;
                }

                if (typeof maxRecordsPerPage === 'undefined' || maxRecordsPerPage === null) {
                    maxRecordsPerPage = $scope.page.defaultItemsPerPage;
                }

                pageableSeekerFactory.getSeekersNonSortableList(page, maxRecordsPerPage).then(function (response) {
                    $scope.seekersPageable = response;
                    console.log($scope.seekersPageable);
                    $scope.setCurrentPage(page);
                    $scope.setItemsPerPage(maxRecordsPerPage);
                    $scope.setTotalNumberOfItems($scope.seekersPageable.rowsCount);
                });
            };

            $scope.getSeekersPageableList = function () {
                $scope.page.sortMode === true ?
                    $scope.getSeekersSortableList($location.search().page,
                        $location.search().max_records, $location.search().order_by, $location.search().sort_by) :
                    $scope.getSeekersNonSortableList($location.search().page, $location.search().max_records);
            };

            $scope.getSeekersSortableList = function (page, maxRecordsPerPage, sortBy, orderBy) {
                $scope.resetErrors();

                pageableSeekerFactory.getSeekersSortableList(page, maxRecordsPerPage, sortBy, orderBy).then(function (response) {
                    $scope.seekersPageable = response;
                });
            };

            $scope.deleteSeekerByIdFromTable = function (id) {
                $scope.isLastItemInTable();
                seekerFactory.deleteById(id).then(function () {
                    $route.reload();
                    notifyService.success(setNotifyMessage("Seeker has been deleted successfully."));
                });
            };

            $scope.pageChanged = function () {
                $location.search('page', $scope.page.currentPage);
                $scope.getSeekersNonSortableList($location.search().page, $scope.page.itemsPerPage);

            };

            $scope.setCurrentPage = function (num) {
                $scope.page.currentPage = num;
            };

            $scope.setItemsPerPage = function (num) {
                $scope.page.itemsPerPage = num;
            };

            $scope.setMaxPagerItemsSize = function (num) {
                $scope.page.maxPagerItemsSize = num;
            };

            $scope.setTotalNumberOfItems = function (num) {
                $scope.page.maxTotalItems = num;
            };

            $scope.setPageSortableMode = function (sortable) {
                $scope.page.sortMode = sortable;
            };

            $scope.savePageableUrl = function () {
                pageableSeekerFactory.setPageableUrl($location.url());
            };

            $scope.isLastItemInTable = function () {
                var lastPage = $scope.seekersPageable.lastPage;
                var listSize = $scope.seekersPageable.collection.length;
                var currPage = $location.search().page;
                if (lastPage === true && listSize === 1 && currPage > 1) {
                    $location.search('page', currPage - 1)
                }
                console.log("lastPage=" + lastPage + ',listSize=' + listSize + ',currPage=' + currPage);
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
                            if (typeof id !== 'undefined' || id !== null)
                                $scope.deleteSeekerByIdFromTable(id);
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

            $scope.getSeekersPageableList();
        }]);;
RwrApp.service('errorService', [function () {
    var errors = {title: '', messages: null};
    var error = false;

    this.setErrors = function (title, messages) {
        error = true;
        errors.title = title;
        errors.messages = messages;
    };

    this.resetErrors = function () {
        error = false;
    };

    this.getErrors = function () {
        return errors;
    };

    this.isError = function () {
        return error;
    };
}]);;
RwrApp.service('modalService', ['ModalService', function (ModalService) {
    var modalDefaultOptions = {
        controller: 'modalController',
        templateUrl: 'angular/template/alertModal.html',

        closeButtonText: 'Cancel',
        actionButtonText: 'Delete',
        headerText: 'Confirmation',
        bodyText: 'Perform this action?'

    };

    this.show = function (customModalOptions) {
        if (typeof customModalOptions !== 'undefined') angular.extend(modalDefaultOptions, customModalOptions);
        return ModalService.showModal(modalDefaultOptions);
    };

    this.getOptions = function () {
        return modalDefaultOptions;
    };
}]);;
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
        }]);;
RwrApp.factory('dbTypesFactory', ['$http', '$q', 'errorService', function ($http, $q, errorService) {

    var urlApi = "service/seeker";

    return {
        getSkillTypes: function () {
            var responseResult = $q.defer();
            $http.get(urlApi + '/getSkillTypes').then(function (response) {
                responseResult.resolve(response.data);
            }, function (errorMessages) {
                responseResult.reject(errorMessages);
                errorService.setErrors('Could not get skills list.', errorMessages.data.errors);
            });
            return responseResult.promise;
        },

        getImsTypes: function () {
            var responseResult = $q.defer();
            $http.get(urlApi + '/getImsTypes').then(function (response) {
                responseResult.resolve(response.data);
            }, function (errorMessages) {
                responseResult.reject(errorMessages);
                errorService.setErrors('Could not get ims list.', errorMessages.data.errors);
            });
            return responseResult.promise;
        }
    }
}]);
;
RwrApp.factory('pageableSeekerFactory', ['$http', '$q', 'errorService', 'seekerFactory',
    function ($http, $q, errorService, seekerFactory) {

        var urlApi = "service/seeker";

        var pageableUrl = null;
        var defaultHomeUrl = '/#';

        var sharableSeekerId = null;

        return {
            getSeekersNonSortableList: function (page, maxRecords) {
                var responseResult = $q.defer();
                var url = urlApi + '/getSeekersPageable/' + '?page=' + page + '&max_records=' + maxRecords;
                $http.get(url).then(function (response) {
                    responseResult.resolve(response.data);
                }, function (errorMessages) {
                    responseResult.reject(errorMessages);
                    errorService.setErrors('Could not load seekers list.', errorMessages.data.errors);
                });
                return responseResult.promise;
            },

            getSeekersSortableList: function (page, maxRecords, orderBy, sortBy) {
                var responseResult = $q.defer();
                var url = urlApi + '/getSeekersSortedPageable/' + '?page=' + page + '&max_records=' + maxRecords +
                    '&order_by=' + orderBy + '&sort_by=' + sortBy;
                $http.get(url).then(function (response) {
                    responseResult.resolve(response.data);
                }, function (errorMessages) {
                    responseResult.reject(errorMessages);
                    errorService.setErrors('Could not load seekers list.', errorMessages.data.errors);
                });
                return responseResult.promise;
            },

            getSharableSeekerId: function () {
                return sharableSeekerId;
            },

            setSharableSeekerId: function (id) {
                sharableSeekerId = id;
            },

            getPageableUrl: function () {
                return pageableUrl;
            },

            getDefaultHomeUrl: function () {
                return defaultHomeUrl;
            },

            setPageableUrl: function (url) {
                pageableUrl = url;
            }
        }
    }]);
;
RwrApp.factory('seekerFactory', ['$http', '$q', 'errorService', function ($http, $q, errorService) {

    var urlApi = "service/seeker";

    return {
        getById: function (id) {
            var responseResult = $q.defer();
            $http.get(urlApi + '/show/' + id).then(function (response) {
                responseResult.resolve(response.data);
            }, function (errorMessages) {
                responseResult.reject(errorMessages);
                errorService.setErrors('Could not find seeker.', errorMessages.data.errors);
            });
            return responseResult.promise;
        },

        save: function (seeker) {
            if (seeker.id <= 0) seeker.id = null;
            seeker.firstName = seeker.firstName.trim();
            seeker.lastName = seeker.lastName.trim();

            var responseResult = $q.defer();
            $http.post(urlApi + '/save', seeker).then(function (response) {
                responseResult.resolve(response.data);
            }, function (errorMessages) {
                responseResult.reject(errorMessages);
                errorService.setErrors('Could not save seeker.', errorMessages.data.errors);
            });
            return responseResult.promise;
        },

        deleteById: function (id) {
            var responseResult = $q.defer();
            $http.delete(urlApi + '/delete/' + id).then(function (response) {
                responseResult.resolve(response.data);
            }, function (errorMessages) {
                responseResult.reject(errorMessages);
                errorService.setErrors('Could not delete seeker.', errorMessages.data.errors);
            });
            return responseResult.promise;
        }
    };
}]);