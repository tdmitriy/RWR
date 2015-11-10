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
}]);