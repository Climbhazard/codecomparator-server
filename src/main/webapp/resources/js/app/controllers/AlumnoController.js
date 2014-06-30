'use strict';

/**
 * AlumnoController
 *
 * @constructor
 */
var AlumnoController = function($scope, $http) {

    $scope.datos = {};
    console.log('alumno');
    
    $scope.datos = {};
    $scope.showMsg = 0;
    $scope.msg1 = "Complete todos los campos";
    $scope.msg2 = "Alumno registrado con éxito";
    
    console.log('curso');
    
    $scope.validacion = function(){
    	

    	if($scope.datos.codigo == "" || $scope.datos.codigo == undefined){
    		$scope.showMsg = 1;
    		return false;
    	}
    	if($scope.datos.nombre == "" || $scope.datos.nombre == undefined){
    		$scope.showMsg = 1;
    		return false;
    	}
    	if($scope.datos.apellidoPaterno == "" || $scope.datos.apellidoPaterno == undefined){
    		$scope.showMsg = 1;
    		return false;
    	}
    	if($scope.datos.apellidoMaterno == "" || $scope.datos.apellidoMaterno == undefined){
    		$scope.showMsg = 1;
    		return false;
    	}
    	return true;
    	
    };
    
    $scope.registraralumno = function(){
    	alert('curso');
    	if($scope.validacion()){
        	console.log($scope.datos);
        	
        	$scope.alumno = {};
        	$scope.alumno.codigo = $scope.datos.codigo;
        	$scope.alumno.nombre = $scope.datos.nombre;
        	$scope.alumno.apellidoPaterno = $scope.datos.apellidoPaterno;
        	$scope.alumno.apellidoMaterno = $scope.datos.apellidoMaterno;
        	
        	
    		$http.post('alumno/registrar', $scope.alumno).success(
    				function() {
    					$scope.showMsg = 2;
    				});
    		
    	}
    
    	
    };
    
    $scope.getAllCursos = function(){
    	$scope.docente = {};
    	$scope.docente.docenteId = "2";
    	  $http.get('curso/lista/'+$scope.docente.docenteId).success(function(workers){
              console.log('getAllCursos');
              console.log(workers);
    	  });

    };
    
    $scope.getAllCursos();

    

};