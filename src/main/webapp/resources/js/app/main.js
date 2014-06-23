var VarsApp = {
    rootUrl : '',
    baseUrl : '/js',
    libUrl : '../../bower_components',
    autor : "UNMSM"
};


require.config({

	baseUrl: VarsApp.baseUrl,

	paths: {
		angular: VarsApp.libUrl +'/angular/angular',
		angularRoute: VarsApp.libUrl +'/angular-route/angular-route',
		angularMocks: VarsApp.libUrl +'/angular-mocks/angular-mocks',
		angularSocket : VarsApp.libUrl + '/angular-socket-io/socket',
		text: VarsApp.libUrl +'/requirejs-text/text',
		jquery: VarsApp.libUrl +'/jquery/dist/jquery.min',
		templateMain : '../../js/templateMain',
		bootstrap : VarsApp.libUrl +'/bootstrap/dist/js/bootstrap.min',
		socketio : VarsApp.libUrl +'/socket.io-client/dist/socket.io',
		ngStorage : VarsApp.libUrl + '/ngstorage/ngStorage.min',
		uiRouter : VarsApp.libUrl + '/angular-ui-router/release/angular-ui-router.min',
		MainController : '../../js/controllers/MainController',
		angularAnimate: VarsApp.libUrl +'/angular-animate/angular-animate.min',
		angularStrap : VarsApp.libUrl +'/angular-strap/dist/angular-strap.min',
		angularStrapTpl : VarsApp.libUrl +'/angular-strap/dist/angular-strap.tpl.min',
		ngSanitize : VarsApp.libUrl + '/angular-sanitize/angular-sanitize',
		ngTouch : VarsApp.libUrl + '/angular-touch/angular-touch.min',
		jqueryUI: VarsApp.libUrl+ '/jquery-ui/ui/jquery-ui'

	},	
	shim: {
		'angular' : {'exports' : 'angular'},
		'angularRoute': ['angular'],
		'angularMocks': {
			deps:['angular'],
			'exports':'angular.mock'
		},	
		'socketio': {
	      exports: 'io'
	    },
		'jquery': {'exports' : 'jquery'},	
		'templateMain' :{ deps:['jquery','bootstrap']},
		'bootstrap': { deps:['jquery']},
		'angularSocket' : ['angular'],
		'ngStorage' : { deps:['angular']},
		'uiRouter' : { deps:['angular']},
		'services/routeResolver' : { deps:['angular']},
		'MainController' : ['app'],
		'angularStrap' : ['angular'],
		'angularStrapTpl' : ['angular','angularStrap'],
		'angularAnimate' : ['angular'],
		'ngSanitize' : { deps:['angular']},
		'ngTouch' : { deps:['angular']},
		'jqueryUI' :['jquery']
	},
	priority: [
		"jquery","angular"
	]
});

//http://code.angularjs.org/1.2.1/docs/guide/bootstrap#overview_deferred-bootstrap
window.name = "NG_DEFER_BOOTSTRAP!";

require( [
	'angular',
	'jquery',
	'app',
	'angularAnimate',
	'angularStrap',
	'angularStrapTpl',
	'ngSanitize',
	'jqueryUI'
], function(angular,jquery, bootstrap,templateMain,routeResolver,app) {
	'use strict';
	var $html = angular.element(document.getElementsByTagName('html')[0]);
	angular.element().ready(function() {
		angular.bootstrap(document, ['myApp']);
	});
});