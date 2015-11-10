'use strict';
var RwrApp = angular.module('RwrApp',
    [
        'ngRoute',
        'ngAnimate',
        'angular-loading-bar',
        'angularModalService',
        'ui-notification',
        'ui.bootstrap',
        'ngMessages'
    ]);

RwrApp.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: '/home',
        controller: 'pageableController',
        reloadOnSearch: false
    });

    $routeProvider.when('/management', {
        templateUrl: '/management',
        controller: 'managementController'
    });

    $routeProvider.when('/management/:id', {
        templateUrl: '/management',
        controller: 'managementController'
    });

    $routeProvider.when('/404', {
        templateUrl: '/404',
        controller: 'pageNotFoundController'
    });
    $routeProvider.otherwise({redirectTo: '/404'});
}]);;
RwrApp.controller('formItemsController', ['$scope', function ($scope) {
    $scope.date = {
        format: 'yyyy-MM-dd',
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


    $scope.dropdown = {isOpen: false};

    $scope.toggleDropdown = function ($event) {
        $event.preventDefault();
        $event.stopPropagation();
        $scope.dropdown.isOpen = !$scope.dropdown.isOpen;
    };
}]);;
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
;;
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
            var notifyService = appFactory.getNotifyMessageService();

            $scope.page = {
                sortMode: false,
                defaultFirstPage: 1,
                defaultItemsPerPage: 10,
                currentPage: 1,
                maxPagerItemsSize: 5,
                itemsPerPage: null,
                maxTotalItems: null
            };

            $scope.searcKeyword = {};

            $scope.seekersPageable = {};

            $scope

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
                $scope.checkLastItemInTable();
                seekerFactory.deleteById(id).then(function () {
                    $route.reload();
                    notifyService.successMessage("Seeker has been deleted successfully.");
                });
            };

            $scope.editSeeker = function (id) {
                $scope.savePageableUrl();
                $location.path('/management/' + id);
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

            $scope.checkLastItemInTable = function () {
                var lastPage = $scope.seekersPageable.lastPage;
                var listSize = $scope.seekersPageable.collection.length;
                var currPage = $location.search().page;
                if (lastPage === true && listSize === 1 && currPage > 1) {
                    $location.search('page', currPage - 1)
                }
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
RwrApp.filter('search', function ($filter) {
    return function (items, text) {
        if (!text || text.length === 0)
            return items;

        var searchTerms = text.split(' ');

        // search for single terms.
        // this reduces the item list step by step
        searchTerms.forEach(function (term) {
            if (term && term.length)
                items = $filter('filter')(items, term);
        });

        return items
    };
});
;
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
RwrApp.service('notifyMessageService', ['Notification', function (Notification) {
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

    return {
        successMessage: function (message) {
            return Notification.success(setNotifyMessage(message));
        }
    };
}]);;
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