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
}]);