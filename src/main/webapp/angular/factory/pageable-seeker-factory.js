RwrApp.factory('pageableSeekerFactory', ['$http', '$q', 'errorService', 'seekerFactory',
    function ($http, $q, errorService, seekerFactory) {

        var urlApi = "service/seeker";

        var pageableUrl = null;
        var defaultHomeUrl = '/#';

        var sharableSeekerId = null;

        return {
            getSeekersNonSortableList: function (page, maxRecords) {
                var responseResult = $q.defer();
                var url = urlApi + '/getSeekersPageable/' + '?page=' + page + '&max_records=' + maxRecords;
                $http.get(url).then(function (response) {
                    responseResult.resolve(response.data);
                }, function (errorMessages) {
                    responseResult.reject(errorMessages);
                    errorService.setErrors('Could not load seekers list.', errorMessages.data.errors);
                });
                return responseResult.promise;
            },

            getSeekersSortableList: function (page, maxRecords, orderBy, sortBy) {
                var responseResult = $q.defer();
                var url = urlApi + '/getSeekersSortedPageable/' + '?page=' + page + '&max_records=' + maxRecords +
                    '&order_by=' + orderBy + '&sort_by=' + sortBy;
                $http.get(url).then(function (response) {
                    responseResult.resolve(response.data);
                }, function (errorMessages) {
                    responseResult.reject(errorMessages);
                    errorService.setErrors('Could not load seekers list.', errorMessages.data.errors);
                });
                return responseResult.promise;
            },

            getSharableSeekerId: function () {
                return sharableSeekerId;
            },

            setSharableSeekerId: function (id) {
                sharableSeekerId = id;
            },

            getPageableUrl: function () {
                return pageableUrl;
            },

            getDefaultHomeUrl: function () {
                return defaultHomeUrl;
            },

            setPageableUrl: function (url) {
                pageableUrl = url;
            }
        }
    }]);
