RwrApp.controller('pageableController',
    ['$scope', 'appFactory', '$routeParams', '$route', '$location',
        function ($scope, appFactory, $routeParams, $route, $location) {
            var errorService = appFactory.getErrorService();
            var pageableSeekerFactory = appFactory.getPageableSeekerFactory();

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

            $scope.getSeekersSortableList = function (page, maxRecordsPerPage, sortBy, orderBy) {
                $scope.resetErrors();

                pageableSeekerFactory.getSeekersSortableList(page, maxRecordsPerPage, sortBy, orderBy).then(function (response) {
                    $scope.seekersPageable = response;
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

            $scope.isError = function () {
                return errorService.isError();
            };

            $scope.getErrors = function () {
                return errorService.getErrors();
            };

            $scope.resetErrors = function () {
                return errorService.resetErrors();
            };

            $scope.page.sortMode === true ?
                $scope.getSeekersSortableList($location.search().page,
                    $location.search().max_records, $location.search().order_by, $location.search().sort_by) :
                $scope.getSeekersNonSortableList($location.search().page, $location.search().max_records);

        }]);