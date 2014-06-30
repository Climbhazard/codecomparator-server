'use strict';

/**
 * AccountController
 * 
 * @constructor
 */
var AccountController = function($scope, $http, $location, $timeout) {

	$scope.datos = {};
	$scope.msgCompletaData = "Complete todos los campos";
	$scope.msgLoggedData = 'Cuenta de usuario creada con éxito';
	$scope.msgCompleta = -1;
	console.log('account');

	$scope.validacion = function() {

		console.log($scope.datos);
		if ($scope.datos.codigo == "" || $scope.datos.codigo == undefined) {
			console.log('0');
			$scope.msgCompleta = 1;
			return false;
		}
		if ($scope.datos.nombres == "" || $scope.datos.nombres == undefined) {
			console.log('1');
			$scope.msgCompleta = 1;
			return false;
		}
		if ($scope.datos.apPaterno == "" || $scope.datos.apPaterno == undefined) {
			console.log('2');
			$scope.msgCompleta = 1;
			return false;
		}
		if ($scope.datos.apMaterno == "" || $scope.datos.apMaterno == undefined) {
			console.log('3');
			$scope.msgCompleta = 1;
			return false;
		}
		if ($scope.datos.user == "" || $scope.datos.user == undefined) {
			console.log('4');
			$scope.msgCompleta = 1;
			return false;
		}
		if ($scope.datos.pass == "" || $scope.datos.pass == undefined) {
			console.log('5');
			$scope.msgCompleta = 1;
			return false;
		}
		if ($scope.datos.passAgain == "" || $scope.datos.pass == undefined) {
			console.log('6');
			$scope.msgCompleta = 1;
			return false;
		}
		return true;

	};

	$scope.registrardocente = function() {
		console.log("registrardocente");
		if ($scope.validacion()) {
				
			$scope.usuario = {};
			$scope.usuario.usuario = $scope.datos.user;
			$scope.usuario.password = $scope.datos.pass;
			$scope.usuario.docente = {};
			$scope.usuario.docente.codigo = $scope.datos.codigo;
			$scope.usuario.docente.nombre = $scope.datos.nombres;
			$scope.usuario.docente.apellidoPaterno = $scope.datos.apPaterno;
			$scope.usuario.docente.apellidoMaterno = $scope.datos.apMaterno;

			console.log($scope.usuario);
			$http.post('account/registrardocente', $scope.usuario).success(
					function(userReturned) {
						$scope.userReturned = userReturned;
						$scope.msgCompleta = 2;

						$timeout(delay, 1500);

//						$location.path("/login");
					});

		} else {

		}
	};

	var delay = function() {
		$location.path("/login");
	};

};