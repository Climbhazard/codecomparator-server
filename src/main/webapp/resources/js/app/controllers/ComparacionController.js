'use strict';

/**
 * ComparacionController
 * 
 * @constructor
 */
var ComparacionController = function($scope, $http) {
	$scope.evaluacionSeleccionada = {};
	$scope.tiposComparacion = [ {
		llave : 'Comparación de adyacencia',
		valor : 1
	}, {
		llave : 'Comparación de 1 con varios',
		valor : 2
	} ];
	// por defecto Comparación de adyacencia
	$scope.comparacionSeleccionada = $scope.tiposComparacion[0];
	$scope.i = {};
	$scope.ii = {};
	$scope.iii = {};
	$scope.iv = {};
	$scope.v = {};
	$scope.vi = {};
	$scope.vii = {};
	$scope.viii = {};
	$scope.ix = {};
	$scope.x = {};
	$scope.xi = {};
	$scope.xii = {};
	$scope.xiii = {};
	$scope.xiv = {};
	$scope.xv = {};
	$scope.xvi = {};
	$scope.xvii = {};
	$scope.xviii = {};
	$scope.xix = {};
	$scope.xx = {};
	$scope.elegidos = [];

	$scope.fetchEvaluaciones = function() {
		$http.get('comparison/evaluaciones.json').success(
				function(evaluaciones) {
					alert(evaluaciones.length);
					console.log(evaluaciones);
					$scope.evaluaciones = evaluaciones;
				});
	};

	$scope.comparar = function() {
		/*$http.post('comparison/elegidos', $scope.elegidos).success(function() {
			alert('comparación realizada');
		});
		alert('comparación realizada');
		console.log("elegidos");
		console.log($scope.elegidos);*/
		console.log($scope.elegidos);
		$scope.contenedorelegidos = new Object();
		$scope.contenedorelegidos.posiciones = $scope.elegidos;

		console.log($scope.contenedorelegidos);
		$http.post('comparison/comparar', $scope.contenedorelegidos).success(function() {
			alert('comparación realizada');
			
			console.log($scope.contenedorelegidos);
		});
	};

	$scope.formatearEvaluacion = function(evaluacion) {
		var opcion = new Date(evaluacion.fechaRegistro)
				.customFormat("#DD#/#MM#/#YY#")
				+ ' : '
				+ evaluacion.curso.nombre
				+ ' - Grupo '
				+ evaluacion.curso.grupo + " : " + evaluacion.descripcion;
		return opcion;
	};

	$scope.poblarPosiciones = function(evaluacionSeleccionada) {
		if (!evaluacionSeleccionada) {
			$scope.borrarPosiciones();
		}
		var posiciones = evaluacionSeleccionada.matriz;
		$scope.i = posiciones[0];
		$scope.ii = posiciones[1];
		$scope.iii = posiciones[2];
		$scope.iv = posiciones[3];
		$scope.v = posiciones[4];
		$scope.vi = posiciones[5];
		$scope.vii = posiciones[6];
		$scope.viii = posiciones[7];
		$scope.ix = posiciones[8];
		$scope.x = posiciones[9];
		$scope.xi = posiciones[10];
		$scope.xii = posiciones[11];
		$scope.xiii = posiciones[12];
		$scope.xiv = posiciones[13];
		$scope.xv = posiciones[14];
		$scope.xvi = posiciones[15];
		$scope.xvii = posiciones[16];
		$scope.xviii = posiciones[17];
		$scope.xix = posiciones[18];
		$scope.xx = posiciones[19];
		// alert($scope.ii.alumno.alumnoId);
	};

	$scope.agregarElegido = function(posicion) {
		// salir si la posicion está vacía
		if (posicion.alumno == null || posicion.proyecto == null) {
			return;
		}
		// salir si la posicion ya está elegida
		if ($scope.elegidos.indexOf(posicion) != -1) {
			return;
		}
		var cuenta = $scope.elegidos.length;
		if (cuenta == 5) {
			alert('Puede seleccionar máximo 5 alumnos para comparar.');
			return;
		}
		$scope.elegidos[cuenta] = posicion;
	};

	$scope.fetchEvaluaciones();

	$scope.borrarPosiciones = function() {
		$scope.i = {};
		$scope.ii = {};
		$scope.iii = {};
		$scope.iv = {};
		$scope.v = {};
		$scope.vi = {};
		$scope.vii = {};
		$scope.viii = {};
		$scope.ix = {};
		$scope.x = {};
		$scope.xi = {};
		$scope.xii = {};
		$scope.xiii = {};
		$scope.xiv = {};
		$scope.xv = {};
		$scope.xvi = {};
		$scope.xvii = {};
		$scope.xviii = {};
		$scope.xix = {};
		$scope.xx = {};
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

	Date.prototype.customFormat = function(formatString) {
		var YYYY, YY, MMMM, MMM, MM, M, DDDD, DDD, DD, D, hhh, hh, h, mm, m, ss, s, ampm, AMPM, dMod, th;
		var dateObject = this;
		YY = ((YYYY = dateObject.getFullYear()) + "").slice(-2);
		MM = (M = dateObject.getMonth() + 1) < 10 ? ('0' + M) : M;
		MMM = (MMMM = [ "January", "February", "March", "April", "May", "June",
				"July", "August", "September", "October", "November",
				"December" ][M - 1]).substring(0, 3);
		DD = (D = dateObject.getDate()) < 10 ? ('0' + D) : D;
		DDD = (DDDD = [ "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday",
				"Friday", "Saturday" ][dateObject.getDay()]).substring(0, 3);
		th = (D >= 10 && D <= 20) ? 'th' : ((dMod = D % 10) == 1) ? 'st'
				: (dMod == 2) ? 'nd' : (dMod == 3) ? 'rd' : 'th';
		formatString = formatString.replace("#YYYY#", YYYY).replace("#YY#", YY)
				.replace("#MMMM#", MMMM).replace("#MMM#", MMM).replace("#MM#",
						MM).replace("#M#", M).replace("#DDDD#", DDDD).replace(
						"#DDD#", DDD).replace("#DD#", DD).replace("#D#", D)
				.replace("#th#", th);

		h = (hhh = dateObject.getHours());
		if (h == 0)
			h = 24;
		if (h > 12)
			h -= 12;
		hh = h < 10 ? ('0' + h) : h;
		AMPM = (ampm = hhh < 12 ? 'am' : 'pm').toUpperCase();
		mm = (m = dateObject.getMinutes()) < 10 ? ('0' + m) : m;
		ss = (s = dateObject.getSeconds()) < 10 ? ('0' + s) : s;
		return formatString.replace("#hhh#", hhh).replace("#hh#", hh).replace(
				"#h#", h).replace("#mm#", mm).replace("#m#", m).replace("#ss#",
				ss).replace("#s#", s).replace("#ampm#", ampm).replace("#AMPM#",
				AMPM);
	};
};