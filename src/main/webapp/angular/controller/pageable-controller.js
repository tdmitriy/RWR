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
        }]);