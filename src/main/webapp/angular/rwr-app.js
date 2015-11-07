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

    $routeProvider.when('/list', {
        templateUrl: '/blabla',
        controller: 'pageableController'
    });
}]);