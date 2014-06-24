'use strict';

/**
 * LoginController
 * 
 * @constructor
 */
var LoginController = function($scope, $http) {
	
	//$scope.datos = {};
	$scope.user = new Object();
	
	$scope.loginDocente = function(){
		
		/*$http.post('login/docente',$scope.user).success(function(usuario) {
			$scope.userVerified = usuario;
		});*/
		console.log($scope.user.username);
		console.log($scope.user.password);
		if($scope.user.username=="fanny.sobero" && $scope.user.password=='123456'){
			console.log("logged");
			//$scope.url = "inicio";
		}else{
			console.log("not valide user");			
			//$scope.url = "login";
		}
		
	};
	
	$scope.fetchUsuario = function() {
		$http.get('login/user.json').success(function(usuario) {
			$scope.user = usuario;
		});
	};

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

	//$scope.fetchUsuario();
};