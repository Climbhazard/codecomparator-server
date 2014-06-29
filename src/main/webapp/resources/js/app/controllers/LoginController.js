'use strict';

/**
 * LoginController
 * 
 * @constructor
 */
var LoginController = function($scope, $http) {

	// $scope.datos = {};
	$scope.user = {
		usuario : '',
		password : ''
	};

	$scope.loginDocente = function() {
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