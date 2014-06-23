'use strict';

/**
 * AccountController
 *
 * @constructor
 */
var AccountController = function($scope, $http) {

    $scope.datos = {};
    console.log('account');
    $scope.crearUsuario = function() {

        if(validacion()){
            alert('quieres loguearte :O');
        }
        /*$http.get('login/user.json').success(function(usuario) {
            $scope.user = usuario; 
        });*/
    };

    $scope.validacion = function(){
        return true;
    };

    /*$http.post('login/user.json').success(function(usuario) {
     $scope.user = usuario;
     });*/


};