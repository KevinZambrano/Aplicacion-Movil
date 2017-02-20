/**
 * 
 */
app.controller('AgregarIngresosController', function($scope, $http, $location) {

	$scope.agregarCuenta = function() {

		var request = $http.post(CONSTANTS.path + "/finanzas/cuentas/ingresos",
				$scope.cuenta);
		request.success(function(response) {
			alert("Cuenta Agregada!");
			$location.path('/ingresos');
		});
		request.error(function(response) {
			alert("No se agrego correctamente.");
		});
	};
});