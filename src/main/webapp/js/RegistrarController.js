/**
 * 
 */
app.controller('RegistrarController', function($scope, $http, $location) {

	$scope.registrar = function(){
		
		var request = $http.post(CONSTANTS.path + "/finanzas/personas/", $scope.persona);
		request.success(function(response){
			
		});
		request.error(function(response) {
			alert("No se agrego correctamente.");
		});
		
		$scope.usuario.rut = $scope.persona.rut;
		var request2 = $http.post(CONSTANTS.path + "/finanzas/usuarios/", $scope.usuario);
		request2.success(function(response){
			alert("Registrado!")
			$location.path("/");
		});
		request2.error(function(response){
			alert("No se agrego correctamente.")
		});
	};

});