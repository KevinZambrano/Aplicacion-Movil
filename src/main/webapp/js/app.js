/**
 * 
 */
var app = angular.module('app', [ 'ngRoute' ]);

app.config([ '$routeProvider', function($routeProvider) {

	$routeProvider.when('/', {
		templateUrl : "inicio.html",
		controller : "InicioController"
	});

	$routeProvider.when('/ingresos', {
		templateUrl : "mobile/ingresos.html",
		controller : "IngresosController"
	});

	$routeProvider.when('/agregar/ingresos', {
		templateUrl : "mobile/agregarIngresos.html",
		controller : "AgregarIngresosController"
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