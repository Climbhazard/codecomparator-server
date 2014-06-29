'use strict';

/**
 * AccountController
 *
 * @constructor
 */
var AccountController = function($scope, $http) {

    $scope.datos = {};
    console.log('account');  

    $scope.validacion = function(){
    	

		console.log($scope.datos);
    	
    	if($scope.nombre == ""){
    		return false;
    	}
    	if($scope.apPaterno == ""){
    		return false;
    	}
    	if($scope.apMaterno == ""){
    		return false;
    	}
    	if($scope.user == ""){
    		return false;
    	}
    	if($scope.pass == ""){
    		return false;
    	}
    	if($scope.passAgain == ""){
    		return false;
    	}
        return true;
        
    };

    $scope.registrardocente = function() {
    	console.log("registrardocente");
    	//if($scope.validacion()){
    		//voy a pasar un objeto seteado aqui primero
    		
    		$scope.usuario = {};
    		$scope.usuario.usuario = 'braulio.vinces';
    		$scope.usuario.password = '123456';
    		$scope.usuario.docente = {};
    		$scope.usuario.docente.codigo = '10200218';//UPSI    		
    		$scope.usuario.docente.nombre = 'braulio';
    		$scope.usuario.docente.apellidoPaterno = 'sanchez';
    		$scope.usuario.docente.apellidoMaterno = 'vinces';
    		
    		console.log($scope.usuario);
	    	$http.post('account/registrardocente', $scope.usuario).success(function() {
	        	//$scope.user = usuario;	         
	         });
	    	
	    	
	    	
	    		    	
    	//}
	};
    


};