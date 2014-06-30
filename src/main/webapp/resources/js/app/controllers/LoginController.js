'use strict';

/**
 * LoginController
 * 
 * @constructor
 */

var LoginController = function($scope, $http) {

	// $scope.datos = {};
	$scope.user = {};
	
	$scope.validar = function(){
		console.log($scope.user);
		if($scope.user == undefined || $scope.user.password==undefined || $scope.user.usuario==undefined || 
				$scope.user.usuario =='' || 
				$scope.user.password == '' ){
			return false;
		}else{
			return true;
		}
	};

	$scope.loginDocente = function() {
<<<<<<< HEAD
		var state = false;
		console.log($scope.user);
		state = $scope.validar();
		if(state){
			console.log('login');
			$scope.loginService();
		}else{
			console.log('bye bye');
			
		}
		
      /*loginService.login($scope.user).then(function(data){
           console.log(data);
           console.log('data');
           $scope.user = data;
            
       });*/

	};
		
	$scope.loginService = function() {

		$http.post('login/docente', $scope.user).success(function(usuario) {
			$scope.userVerified = usuario;
			console.log($scope.userVerified);
			if($scope.userVerified ==null){
				console.log('null');
			}
			if($scope.userVerified  == undefined){
				console.log('u');
			}
		});
=======
		console.log('LoginController.loginDocente');
		$http.post('login/docente', $scope.user).success(function(usuario) {
			$scope.user = usuario;

			console.log($scope.user.id);
			console.log($scope.user.usuario);
			console.log($scope.user.password);
			if ($scope.user != null) {
				console.log("logged");
				// $scope.url = "inicio";
			} else {
				console.log("not valide user");
				// $scope.url = "login";
			}

		}).error(function() {
			console.log('Error desde el servidor');
		});

>>>>>>> 720f3b2ee7542a172e7d401cde630be0deaa09cc
	};
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	/*
	 * $scope.fetchUsuario = function() {
	 * $http.get('login/user.json').success(function(usuario) { $scope.user =
	 * usuario; }); };
	 */

	/*
	 * $scope.addNewCar = function(newCar) { $http.post('cars/addCar/' +
	 * newCar).success(function() { $scope.fetchCarsList(); }); $scope.carName =
	 * ''; };
	 * 
	 * $scope.removeCar = function(car) { $http.delete('cars/removeCar/' +
	 * car).success(function() { $scope.fetchCarsList(); }); };
	 * 
	 * $scope.removeAllCars = function() {
	 * $http.delete('cars/removeAllCars').success(function() {
	 * $scope.fetchCarsList(); }); };
	 */

	// $scope.fetchUsuario();
	
};