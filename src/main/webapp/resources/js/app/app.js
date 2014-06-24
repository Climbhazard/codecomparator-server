'use strict';

var AngularSpringApp = {};

var App = angular.module('AngularSpringApp', [ 'AngularSpringApp.filters',
		'AngularSpringApp.services', 'AngularSpringApp.directives' ]);

// Declare app level module which depends on filters, and services
App.config([ '$routeProvider', function($routeProvider) {
	
	$routeProvider.when('/inicio', {
		templateUrl : 'inicio/layout',
		controller : InicioController
	});
	
	$routeProvider.when('/login', {
		templateUrl : 'login/layout',
		controller : LoginController
	});

    $routeProvider.when('/account', {
        templateUrl : 'account/layout',
        controller : AccountController
    });
    
    $routeProvider.when('/comparacion', {
        templateUrl : 'comparison/layout',
        controller : ComparacionController
    });
    
	$routeProvider.otherwise({
		redirectTo : '/inicio'
	});
} ]);
