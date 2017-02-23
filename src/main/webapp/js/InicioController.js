/**
 * 
 */
app.controller('InicioController', function($scope,$http) {

	$scope.flagLoading = false;

	$scope.getUsuario = function(){
		
		$scope.flagLoading = true;
		
		var request =
		$http.get(CONSTANTS.path + "/finanzas/usuarios/session/activa");
		request.success(function(response){
			$scope.usuario = response;
			$scope.flagLoading = false;
		});
		
		request.error(function(response){
			aler("No se cargaron datos de usuario.")
			$scope.flagLoading = false;
		});
		
	};
	
	$scope.getUsuario();	
});