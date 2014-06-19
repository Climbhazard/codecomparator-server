'use strict';

/**
 * LoginController
 * 
 * @constructor
 */
var LoginController = function($scope, $http) {
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

	$scope.fetchUser();
};