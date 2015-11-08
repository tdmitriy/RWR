RwrApp.factory('dbTypesFactory', ['$http', '$q', 'errorService', function ($http, $q, errorService) {

    var urlApi = "service/seeker";

    return {
        getSkillTypes: function () {
            var responseResult = $q.defer();
            $http.get(urlApi + '/getSkillTypes').then(function (response) {
                responseResult.resolve(response.data);
            }, function (errorMessages) {
                responseResult.reject(errorMessages);
                errorService.setErrors('Could not get skills list.', errorMessages.data.errors);
            });
            return responseResult.promise;
        },

        getImsTypes: function () {
            var responseResult = $q.defer();
            $http.get(urlApi + '/getImsTypes').then(function (response) {
                responseResult.resolve(response.data);
            }, function (errorMessages) {
                responseResult.reject(errorMessages);
                errorService.setErrors('Could not get ims list.', errorMessages.data.errors);
            });
            return responseResult.promise;
        }
    }
}]);
