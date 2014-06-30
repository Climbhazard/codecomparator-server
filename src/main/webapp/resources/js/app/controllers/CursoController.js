'use strict';

/**
 * AccountController
 *
 * @constructor
 */
var CursoController = function($scope, $http) {

    $scope.datos = {};
    $scope.msgCompleta = 0;
    $scope.msgCompletaData = "Complete todos los campos";
    console.log('curso');
    
    $scope.validacion = function(){
    	if($scope.datos.nombre == "" || $scope.datos.nombre == undefined){
    		$scope.msgCompleta = 1;
    		return false;
    	}
    	if($scope.datos.grupo == "" || $scope.datos.grupo == undefined){
    		$scope.msgCompleta = 1;
    		return false;
    	}
    	return true;
    	
    };
    
    $scope.registrarcurso = function(){
    	alert('curso');
    	console.log($scope.datos);
    	if($scope.validacion()){
    		$scope.datos.docenteId = 2;
    		/*$http.get('curso/registrar', $scope.datos.nombre,$scope.datos.grupo,$scope.datos.idDocente).success(
    				function() {
    					$scope.msgCompleta = 2;

    					//$timeout(delay, 1500);

//    					$location.path("/login");
    				});*/
    		
    	}
    
    	
    };

};