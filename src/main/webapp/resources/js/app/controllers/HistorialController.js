'use strict';

/**
 * HistorialController
 *
 * @constructor
 */
var HistorialController = function($scope, $http) {

    $scope.datos = {};
    console.log('historial');
    

    $scope.validacion = function(){
        return true;
    };

    /*$http.post('login/user.json').success(function(usuario) {
     $scope.user = usuario;
     });*/


};