RwrApp.service('pageableService', ['$http', '$q', 'errorService',
    'loadingStateService', function ($http, $q, errorService, loadingStateService) {
        var responseResult = null;

        var urlFetchSeekers = "service/seeker/getSeekersPageable";
        var urlFetchSeekersWithSorting = "service/seeker/getSeekersSortedPageable";

        this.fetchSeekersWithoutSorting = function (page, maxRecords) {
            loadingStateService.setBusyState(true);
            loadingStateService.setSeekersLoadedState(false);
            responseResult = $q.defer();

            var url = urlFetchSeekers + '?page=' + page + '&max_records=' + maxRecords;

            $http.get(url).then(function (response) {
                responseResult.resolve(response.data);
                loadingStateService.setBusyState(false);
                loadingStateService.setSeekersLoadedState(true);
            }, function (errorMessages) {
                responseResult.reject(errorMessages);
                errorService.setErrors('Could not load seekers list.', errorMessages.data.errors);
                loadingStateService.setBusyState(true);
                loadingStateService.setSeekersLoadedState(false);
            });

            return responseResult.promise;
        };

        this.fetchSeekersWithSorting = function (page, maxRecords, orderBy, sortBy) {
            loadingStateService.setBusyState(true);
            loadingStateService.setSeekersLoadedState(false);
            responseResult = $q.defer();

            var url = urlFetchSeekersWithSorting + '?page=' + page + '&max_records=' + maxRecords +
                '&order_by=' + orderBy + '&sort_by=' + sortBy;

            $http.get(url).then(function (response) {
                responseResult.resolve(response.data);
                loadingStateService.setBusyState(false);
                loadingStateService.setSeekersLoadedState(true);
            }, function (errorMessages) {
                responseResult.reject(errorMessages);
                errorService.setErrors('Could not load seekers list.', errorMessages.data.errors);
                loadingStateService.setBusyState(false);
                loadingStateService.setSeekersLoadedState(false);
            });

            return responseResult.promise;
        };
    }]);