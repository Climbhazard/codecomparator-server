'use strict';

/**
 * AccountController
 *
 * @constructor
 */
var CursoController = function($scope, $http) {

    $scope.datos = {};
    $scope.showMsg = 0;
    $scope.msg1 = "Complete todos los campos";
    $scope.msg2 = "Curso registrado con éxito";
    
    console.log('curso');
    
    $scope.validacion = function(){
    	if($scope.datos.nombre == "" || $scope.datos.nombre == undefined){
    		$scope.showMsg = 1;
    		return false;
    	}
    	if($scope.datos.grupo == "" || $scope.datos.grupo == undefined){
    		$scope.showMsg = 1;
    		return false;
    	}
    	return true;
    	
    };
    
    $scope.registrarcurso = function(){
    	alert('curso');
    	if($scope.validacion()){
        	console.log($scope.datos);
        	
        	$scope.curso = {};
        	$scope.curso.nombre = $scope.datos.nombre;
        	$scope.curso.grupo = $scope.datos.grupo;
        	$scope.curso.docente = {};
        	$scope.curso.docente.docenteId = "2";//id de docente de la session logueada
        	
    		$http.post('curso/registrar', $scope.curso).success(
    				function() {
    					$scope.showMsg = 2;
    				});
    		
    	}
    
    	
    };

};