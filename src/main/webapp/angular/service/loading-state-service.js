RwrApp.service('loadingStateService', [function () {
    //loading states
    var seekersLoadedState = false;
    var busyState = false;

    this.getSeekersLoadedState = function () {
        return seekersLoadedState;
    };

    this.getBusyState = function () {
        return busyState;
    };

    this.setSeekersLoadedState = function (value) {
        seekersLoadedState = value;
    };

    this.setBusyState = function (value) {
        busyState = value;
    };
}]);