'use strict';

/**
 * ComparacionController
 * 
 * @constructor
 */
var ComparacionController = function($scope, $http) {
	$scope.fetchEvaluaciones = function() {
		$http.get('comparison/evaluaciones.json').success(function(evaluaciones) {
			$scope.evaluaciones = evaluaciones;
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

	$scope.fetchEvaluaciones();
};