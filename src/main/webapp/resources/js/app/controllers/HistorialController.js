'use strict';

/**
 * HistorialController
 * 
 * @constructor
 */
var HistorialController = function($scope, $http) {

	$scope.comparaciones = {};

	$scope.fetchComparaciones = function() {
		$http.get('historial/comparaciones.json').success(function(cmps) {
			$scope.comparaciones = cmps;
			console.log($scope.comparaciones);
		}).error(function() {
			console.log('Error en el servidor');
		});

	};
	
	$scope.fetchComparaciones();

};