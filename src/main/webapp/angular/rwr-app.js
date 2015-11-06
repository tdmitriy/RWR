'use strict';
var RwrApp = angular.module('RwrApp',
    [
        'ngRoute',
        'ngAnimate',
        'angular-loading-bar',
        'angularModalService',
        'ui-notification',
        'ngMessages'
    ]);

RwrApp.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: '/home',
        controller: 'indexController'
    });
}]);