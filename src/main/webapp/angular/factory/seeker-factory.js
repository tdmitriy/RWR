RwrApp.factory('seekerFactory', ['$http', '$q', 'errorService', function ($http, $q, errorService) {

    var urlApi = "service/seeker";

    return {
        getById: function (id) {
            var responseResult = $q.defer();
            $http.get(urlApi + '/show/' + id).then(function (response) {
                responseResult.resolve(response.data);
            }, function (errorMessages) {
                responseResult.reject(errorMessages);
                errorService.setErrors('Could not find seeker.', errorMessages.data.errors);
            });
            return responseResult.promise;
        },

        save: function (seeker) {
            if (seeker.id <= 0) seeker.id = null;
            seeker.firstName = seeker.firstName.trim();
            seeker.lastName = seeker.lastName.trim();

            var responseResult = $q.defer();
            $http.post(urlApi + '/save', seeker).then(function (response) {
                responseResult.resolve(response.data);
            }, function (errorMessages) {
                responseResult.reject(errorMessages);
                errorService.setErrors('Could not save seeker.', errorMessages.data.errors);
            });
            return responseResult.promise;
        },

        deleteById: function (id) {
            var responseResult = $q.defer();
            $http.delete(urlApi + '/delete/' + id).then(function (response) {
                responseResult.resolve(response.data);
            }, function (errorMessages) {
                responseResult.reject(errorMessages);
                errorService.setErrors('Could not delete seeker.', errorMessages.data.errors);
            });
            return responseResult.promise;
        }
    };
}]);