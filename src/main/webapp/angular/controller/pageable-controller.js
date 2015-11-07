RwrApp.controller('pageableController',
    ['$scope', 'appFactory', '$routeParams', '$route', '$location',
        function ($scope, appFactory, $routeParams, $route, $location) {
            var errorService = appFactory.getErrorService();
            var pageableService = appFactory.getPageableService();

            var lastRoute = $route.current;

            var DEFAULT_FIRST_PAGE = 1;
            var DEFAULT_ITEMS_PER_PAGE = 3;

            $scope.page = {};
            $scope.page.currentPage = 1;
            $scope.page.maxPagerItemsSize = 5;
            $scope.page.itemsPerPage = null;
            $scope.page.maxTotalItems = null;

            $scope.getSeekersPageable = function (page, maxRecordsPerPage) {
                //$scope.resetErrors();
                page = $scope.page.currentPage === null ? DEFAULT_FIRST_PAGE : $scope.page.currentPage;
                maxRecordsPerPage = $scope.page.itemsPerPage === null ?
                    DEFAULT_ITEMS_PER_PAGE : $scope.page.itemsPerPage;

                pageableService.fetchSeekersWithoutSorting(page, maxRecordsPerPage).then(function (response) {
                    $scope.seekersPageable = response;
                    $scope.setCurrentPage(page);
                    $scope.setItemsPerPage(maxRecordsPerPage);
                    $scope.setTotalNumberOfItems($scope.seekersPageable.rowsCount);
                });
            };

            $scope.getSeekersSortedPageable = function (page, maxRecordsPerPage, sortBy, orderBy) {
                //$scope.resetErrors();
                $scope.seekersPageable = [];

                pageableService.fetchSeekersWithSorting(page, maxRecordsPerPage, sortBy, orderBy).then(function (response) {
                    $scope.seekersPageable = response;
                });
            };

            $scope.$on('$routeChangeStart', function (event, next, current) {
                //$route.current = lastRoute;
                console.log($routeParams);
            });

            $scope.pageChanged = function () {
                //$scope.getSeekersPageable($scope.page.currentPage, DEFAULT_ITEMS_PER_PAGE);
                $location.url('?page=' + $scope.page.currentPage);
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

            $scope.getSeekersPageable();

        }]);