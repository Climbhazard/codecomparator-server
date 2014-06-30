'use strict';

/**
 * LoginController
 * 
 * @constructor
 */

var LoginController = function($scope, $http, $location) {

	// $scope.datos = {};
	$scope.user = {};
	// $scope.msjUsuarioIncorrecto = 'Usuario incorrecto';
	// $scope.mensaje = -1;

	$scope.validar = function() {
		if ($scope.user == undefined || $scope.user.password == undefined
				|| $scope.user.usuario == undefined
				|| $scope.user.usuario == '' || $scope.user.password == '') {
			return false;
		} else {
			return true;
		}
	};

	$scope.loginDocente = function() {

		var state = false;
		state = $scope.validar();
		if (state) {
			$scope.loginService();
		} else {
			alert('¡Complete todos los campos!');
		}

		/*
		 * loginService.login($scope.user).then(function(data){
		 * console.log(data); console.log('data'); $scope.user = data;
		 * 
		 * });
		 */

	};

	$scope.loginService = function() {

		$http.post('login/docente', $scope.user).success(function(docente) {
			$scope.userVerified = docente;
			if ($scope.userVerified != '') {
				$location.path('/comparacion');
			} else {
				// $scope.mensaje = 1;
				alert('Usuario incorrecto');
				$scope.user = {};
			}
			console.log($scope.userVerified == '');
		}).error(function() {
			console.log("Error en el servidor");
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