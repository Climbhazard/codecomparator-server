'use strict';

/**
 * ComparacionController
 * 
 * @constructor
 */
var ComparacionController = function($scope, $http, $location) {

	$scope.evaluacionSeleccionada = {};
	$scope.state = 1;
	$scope.botonReporte = 0;
	$scope.comparison = {};
	$scope.c = Math.floor(Math.random() *100);

	$scope.tiposComparacion = [ {
		llave : 'Comparación de adyacencia',
		valor : 1
	}, {
		llave : 'Comparación de 1 con varios',
		valor : 2
	} ];
	// por defecto Comparaciï¿½n de adyacencia
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
					console.log(evaluaciones);
					$scope.evaluaciones = evaluaciones;
				}).error(function() {
			console.log("error en la conexión con dropbox");
		});
	};

	$scope.comparar = function() {
		$scope.botonReporte = 1;
		console.log($scope.elegidos);
		$scope.contenedorElegidos = new Object();
		$scope.contenedorElegidos.evaluacionId = $scope.evaluacionSeleccionada.n_evaluacion_id;
		$scope.contenedorElegidos.tipoComparacion = $scope.comparacionSeleccionada.valor;
		$scope.contenedorElegidos.posiciones = $scope.elegidos;

		$http.post('comparison/comparar', $scope.contenedorElegidos).success(
				function(resultados) {
					$scope.resultados = resultados;
					console.log('resultados');
					console.log($scope.resultados);
					/*$scope.resultados.comparison = {};
					$scope.resultados.qq = {};
					for(var i=0; i<$scope.resultados.charResults.length; i++){
						var elem = $scope.resultados.charResults;
						$scope.resultados.comparison[i] = {};
						$scope.resultados.qq[i] = {};
						for(var j=0; j<elem.length; j++){
							$scope.resultados.comparison[i][j] = {}; 
							$scope.resultados.comparison[i][j].value = $scope.resultados.charResults[i][j].fdtw;
							$scope.resultados.qq[i][j] = {};
							$scope.resultados.qq[i][j].code1 = $scope.resultados.charResults[i][j].codeFirstProyect.q;
							$scope.resultados.qq[i][j].code2 = $scope.resultados.charResults[i][j].codeSecondProyect.q;
						}
						
						
					}*/
					console.log($scope.resultados);
					$scope.swapChartType();
				});
	};

	$scope.formatearEvaluacion = function(evaluacion) {
		var opcion = new Date(evaluacion.fechaRegistro)
				.customFormat("#DD#/#MM#/#YY#")
				+ ' : '
				+ evaluacion.curso
				+ ' - Grupo '
				+ evaluacion.grupo
				+ " : " + evaluacion.titulo;
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

	$scope.agregarElegido = function(posicion, idElegido) {
		// salir si la posicion estï¿½ vacï¿½a
		if (posicion.alumno == null || posicion.proyecto == null) {
			return;
		}
		// salir si la posicion ya estï¿½ elegida

		if ($scope.elegidos.indexOf(posicion) != -1) {
			return;
		}
		$('#' + idElegido).css({
			'background-color' : 'brown'
		});
		// rgb(37, 172, 80)
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

	$scope.verReporte = function() {
		console.log('reporte');
		$scope.state = 2;
	};
	
	
	//Funciones para graficas de comparacion (charts)
	
	 $scope.addPoints = function () {
	        var seriesArray = $scope.highchartsNG.series;
	        var rndIdx = Math.floor(Math.random() * seriesArray.length);
	        seriesArray[rndIdx].data = seriesArray[rndIdx].data.concat([1, 10, 20]);
	    };

	    $scope.addSeries = function () {
	        var rnd = [];
	        for (var i = 0; i < 10; i++) {
	            rnd.push(Math.floor(Math.random() * 20) + 1);
	        }
	        $scope.highchartsNG.series.push({
	            data: rnd
	        });
	    };

	    $scope.removeRandomSeries = function () {
	        var seriesArray = $scope.highchartsNG.series;
	        var rndIdx = Math.floor(Math.random() * seriesArray.length);
	        seriesArray.splice(rndIdx, 1);
	    };

	    $scope.options = {
	        type: 'line'
	    };

	    $scope.swapChartType = function () {
	    	this.highchartsNG.options.chart.type = 'line';
	        /*if (this.highchartsNG.options.chart.type === 'line') {
	            this.highchartsNG.options.chart.type = 'bar';
	        } else {
	            this.highchartsNG.options.chart.type = 'line';
	        }*/
	    };

	    $scope.highchartsNG = {
	        options: {
	            chart: {
	                type: 'line'
	            }
	        },
	        series: [{
	            //data: [10, 15, 12, 8, 7]
	        data: [0.2625,0,0.15625,0.2375,0,0.1625,0.01875,0,0.15625,0,0.15625,0.01875,0,0.31875,0,0.15625,0.00625,0,0.01875,0,0.275,0,0]
	        	//data: $scope.resultados.charResults[0][0].codeFirstProyect.q
	        }],
	        title: {
	            //text: 'Hello'
	        	text: ''
	        },
	        loading: false
	    };
	    console.log('charts');
	    console.log($scope.highchartsNG);

};