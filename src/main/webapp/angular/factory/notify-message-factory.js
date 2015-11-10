RwrApp.service('notifyMessageService', ['Notification', function (Notification) {
    var notifyOptions = {
        delay: 4000,
        positionY: 'top',
        positionX: 'center'
    };

    var setNotifyMessage = function (message) {
        var icon = '<i class="fa fa-fw fa-check-circle"></i>';
        notifyOptions.message = icon + message;
        return notifyOptions;
    };

    return {
        successMessage: function (message) {
            return Notification.success(setNotifyMessage(message));
        }
    };
}]);