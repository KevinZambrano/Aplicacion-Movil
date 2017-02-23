/**
 * 
 */
app.controller("IngresosController", function($scope, $http){
	
	$scope.flagLoading = false;
	
	$scope.totalFinanzas = function (){
		$scope.flagLoading = true;
		
		var request =
		$http.get(CONSTANTS.path + "/finanzas/cuentas/ingresos/" + $scope.usuario.idusuario);
		request.success(function(response)
		{
			
			$scope.total = response;
			
			$scope.flagLoading = false;
		});
		request.error(function(error){
			
			alert(error);
			$scope.flagLoading = false;
		});
	};	
	 
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
	
	$scope.cargarCuentas = function (){
		$scope.flagLoading = true;
		
		var request = 
		$http.get(CONSTANTS.path + "/finanzas/cuentas");
		request.success(function(response)
		{
			$scope.cuentas = response;
			$scope.totalFinanzas();
			$scope.flagLoading = false;
		});
		request.error(function(error)
		{
			alert(error);
			$scope.flagLoading = false;
		});
	};
	
	
	$scope.eliminar = function(cuenta){
		var request =
		$http.delete( CONSTANTS.path + "/finanzas/cuentas/" + cuenta.idcuenta +'/');
		request.success(function(response){
			
			$scope.cargarCuentas();
			
		});
		request.error(function(error){
			
			alert(error);
			$scope.flagLoading = false;
		});
	};
	
	$scope.cargarCuentas();
	$scope.getUsuario();
	
	
});