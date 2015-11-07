RwrApp.controller('managementController',
    ['$scope', '$filter', 'appFactory', '$routeParams',
        function ($scope, $filter, appFactory, $routeParams) {
            var managementService = appFactory.getSeekerService();
            var notifyService = appFactory.getNotificationService();

            $scope.seeker = {};

            $scope.getSeekerById = function (id) {

                managementService.getSeekerById(id).then(function (response) {
                    $scope.seeker = response;
                });
            };

            $scope.saveSeeker = function (seeker) {
                //$scope.resetErrors();

                managementService.saveSeeker(seeker).then(function () {
                    //$scope.getUsersList();
                    notifyService.success(/*msg*/);
                }).finally(function () {
                    //$scope.resetUserForm();
                });
            };

            $scope.deleteSeekerById = function (id) {
                //$scope.resetErrors();

                managementService.deleteSeekerById(id).then(function () {
                    //$scope.getUsersList();
                    notifyService.success(/*msg*/);
                }).finally(function () {
                    //$scope.resetUserForm();
                });
            };


        }]);