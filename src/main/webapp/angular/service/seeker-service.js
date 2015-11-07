RwrApp.service('seekerService', ['$http', '$q', 'errorService',
    'loadingStateService', function ($http, $q, errorService, loadingStateService) {
        var responseResult = null;

        //URL'S
        var urlGetSeeker = "service/seeker/show";
        var urlSaveSeeker = "service/seeker/save";
        var urlDeleteSeekerById = "service/seeker/delete";

        var urlFetchAllSkills = "service/seeker/getSkillTypes";
        var urlFetchAllIms = "service/seeker/getImsTypes";

        this.getSeekerById = function (id) {
            loadingStateService.setBusyState(true);
            responseResult = $q.defer();
            $http.get(urlGetSeeker + '/' + id).then(function (response) {
                responseResult.resolve(response.data);
                loadingStateService.setBusyState(false);
            }, function (errorMessages) {
                responseResult.reject(errorMessages);
                errorService.setErrors('Could not find seeker.', errorMessages.data.errors);
                loadingStateService.setBusyState(false);
            });

            return responseResult.promise;
        };

        this.saveSeeker = function (seeker) {
            loadingStateService.setBusyState(true);
            seeker = validatedSeeker(seeker);
            responseResult = $q.defer();
            $http.post(urlSaveSeeker, seeker).then(function (response) {
                responseResult.resolve(response.data);
                loadingStateService.setBusyState(false);
            }, function (errorMessages) {
                responseResult.reject(errorMessages);
                errorService.setErrors('Could not save seeker.', errorMessages.data.errors);
                loadingStateService.setBusyState(false);
            });

            return responseResult.promise;
        };

        this.deleteSeekerById = function (id) {
            loadingStateService.setBusyState(true);
            responseResult = $q.defer();
            $http.delete(urlDeleteSeekerById + '/' + id).then(function (response) {
                responseResult.resolve(response.data);
                loadingStateService.setBusyState(false);
            }, function (errorMessages) {
                responseResult.reject(errorMessages);
                errorService.setErrors('Could not delete seeker.', errorMessages.data.errors);
                loadingStateService.setBusyState(false);
            });

            return responseResult.promise;
        };

        this.fetchSkillTypes = function () {
            loadingStateService.setBusyState(true);
            responseResult = $q.defer();

            $http.get(urlFetchAllSkills).then(function (response) {
                responseResult.resolve(response.data);
                loadingStateService.setBusyState(false);
            }, function (errorMessages) {
                responseResult.reject(errorMessages);
                errorService.setErrors('Could not fetch skills list.', errorMessages.data.errors);
                loadingStateService.setBusyState(true);
            });

            return responseResult.promise;
        };

        this.fetchImsTypes = function () {
            loadingStateService.setBusyState(true);
            responseResult = $q.defer();

            $http.get(urlFetchAllIms).then(function (response) {
                responseResult.resolve(response.data);
                loadingStateService.setBusyState(false);
            }, function (errorMessages) {
                responseResult.reject(errorMessages);
                errorService.setErrors('Could not fetch ims list.', errorMessages.data.errors);
                loadingStateService.setBusyState(true);
            });

            return responseResult.promise;
        };

        var validatedSeeker = function (seeker) {
            if (seeker.id <= 0) seeker.id = null;
            seeker.firstName = user.firstName.trim();
            seeker.lastName = seeker.lastName.trim();
            return seeker;
        };
    }]);