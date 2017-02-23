/**
 * 
 */
var app = angular.module('app', [ 'ngRoute' ]);

app.config([ '$routeProvider', function($routeProvider) {

	$routeProvider.when('/', {
		templateUrl : "inicio.html",
		controller : "InicioController"
	});

	
	$routeProvider.when('/registrar', {
		templateUrl : "registrar.html",
		controller : "RegistrarController"
	});
	
	$routeProvider.when('/login', {
		templateUrl : "login.html",
		controller : "InicioController"
	});
	
} ]);