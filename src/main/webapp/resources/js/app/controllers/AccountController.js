'use strict';

/**
 * AccountController
 *
 * @constructor
 */
var AccountController = function($scope, $http) {

    $scope.datos = {};
    $scope.msgCompletaData = "Complete todos los campos";
    $scope.msgLoggedData = 'Cuenta de usuario creada con éxito';	
    $scope.msgCompleta = -1;
    console.log('account');  

    $scope.validacion = function(){
    	

		console.log($scope.datos);
    	
    	if($scope.datos.nombres == "" || $scope.datos.nombres == undefined){
    		console.log('1');
    		$scope.msgCompleta = 1;
    		return false;
    	}
    	if($scope.datos.apPaterno == "" || $scope.datos.apPaterno == undefined){
    		console.log('2');
    		$scope.msgCompleta = 1;
    		return false;
    	}
    	if($scope.datos.apMaterno == "" || $scope.datos.apMaterno == undefined){
    		console.log('3');
    		$scope.msgCompleta = 1;
    		return false;
    	}
    	if($scope.datos.user == "" || $scope.datos.user == undefined){
    		console.log('4');
    		$scope.msgCompleta = 1;
    		return false;
    	}
    	if($scope.datos.pass == "" || $scope.datos.pass == undefined){
    		console.log('5');
    		$scope.msgCompleta = 1;
    		return false;
    	}
    	if($scope.datos.passAgain == "" || $scope.datos.pass == undefined){
    		console.log('6');
    		$scope.msgCompleta = 1;
    		return false;
    	}
        return true;
        
    };

    $scope.registrardocente = function() {
    	console.log("registrardocente");
    	if($scope.validacion()){
    		//voy a pasar un objeto seteado aqui primero
    		
    		/*$scope.usuario = {};
    		$scope.usuario.usuario = 'braulio.vinces';
    		$scope.usuario.password = '123456';
    		$scope.usuario.docente = {};
    		$scope.usuario.docente.codigo = '10200218';//UPSI    		
    		$scope.usuario.docente.nombre = 'braulio';
    		$scope.usuario.docente.apellidoPaterno = 'sanchez';
    		$scope.usuario.docente.apellidoMaterno = 'vinces';*/
    	

		$scope.usuario = {};
		$scope.usuario.usuario = $scope.datos.user;
		$scope.usuario.password = $scope.datos.pass;
		$scope.usuario.docente = {};
		//$scope.usuario.docente.codigo = $scope.datos.codigo;	
		$scope.usuario.docente.nombre = $scope.datos.nombres;
		$scope.usuario.docente.apellidoPaterno = $scope.datos.apPaterno;
		$scope.usuario.docente.apellidoMaterno = $scope.datos.apMaterno;
    		
    		console.log($scope.usuario);
	    	$http.post('account/registrardocente', $scope.usuario).success(function(userReturned) {
	        	$scope.userReturned = userReturned;
	        	console.log($scope.userReturned);

	    		$scope.msgCompleta = 2;
	         });
	    	
    	}else{
    		
    	}
	};
    


};