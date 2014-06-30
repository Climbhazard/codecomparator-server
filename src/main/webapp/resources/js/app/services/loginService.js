'use strict';

define(['app'], function (app) {

    var loginService = function ($http) {
    	var loginFactory = {};	  

        var standardSuccessFunction = function (result){
            if(result.status==200)
                return result.data; 
        };

        loginFactory.login = function($scope){    
        	
        	
        	
        	var cad = "";

    		console.log(date);
	        cad = $sessionStorage['JSESSION'];           

	        return $http({
	            method  : 'GET',
	            url     : 'login/docente/'+$scope.user,
	            headers : { 'Cookie-REST': cad }  
	        })
	        .then(standardSuccessFunction);         	
	      
        };
    	
    	        
    	
	    return loginFactory;

    };  	
    
    app.factory('loginService', ['$http',loginService]);

});