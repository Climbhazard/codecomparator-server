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
    	if($scope.validacion()){
    		
    		    	
	    	/*$http.post('/account/registrardocente').success(function(usuario) {
	        	$scope.user = usuario;	         
	         });*/
	    	
    	}
	}
    


};