/**
 * 
 */
app.controller('AgregarIngresosController', function($scope, $http, $location) {

	$scope.getUsuario = function() {

		$scope.flagLoading = true;

		var request = $http.get(CONSTANTS.path
				+ "/finanzas/usuarios/session/activa");
		request.success(function(response) {
			$scope.usuario = response;
			$scope.flagLoading = false;
		});

		request.error(function(response) {
			aler("No se cargaron datos de usuario.")
			$scope.flagLoading = false;
		});

	};

	$scope.getUsuario();
	
	$scope.agregarCuenta = function() {
		$scope.cuenta.idusuario = $scope.usuario.idusuario;
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