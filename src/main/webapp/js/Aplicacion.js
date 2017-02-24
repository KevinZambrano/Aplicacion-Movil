/**
 * 
 */
var app = angular.module('app', [ 'ngRoute' ]);

app.config([ '$routeProvider', function($routeProvider) {
	
	$routeProvider.when('/', {
		templateUrl : "/SpringAngular/mobile/inicio.html",
		controller : "InicioController"
	});
	
	$routeProvider.when('/ingresos', {
		templateUrl : "/SpringAngular/mobile/ingresos.html",
		controller : "IngresosController"
	});

	$routeProvider.when('/agregar/ingresos', {
		templateUrl : "/SpringAngular/mobile/gregarIngresos.html",
		controller : "AgregarIngresosController"
	});

} ]);