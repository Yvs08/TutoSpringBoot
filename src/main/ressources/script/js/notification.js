(function (global) {
    'use strict';

    function NotificationHandler() {

        this.instance = null;

        if (this.instance) {
            return this.instance;
        }

        var vm = this;

        var messageTypes = ['success'];

        var stompClient = null;

        vm.allTransports = ['websocket', 'xhr-streaming', 'xdr-streaming', 'eventsource', 'iframe-wrap',
            'xdr-polling', 'xhr-polling', 'iframe-eventsource', 'htmlfile', 'xhr-polling', 'xdr-polling', 'jsonp-polling'];

        vm.initWebSocket = function () {
            vm.connect();
        };

        vm.connect = function (transports) {

            var options = {};
            if (transports) {
                options.transports = transports;
            }

            var socket = new SockJS('/notification', undefined, options);

            stompClient = Stomp.over(socket);
//            stompClient.debug = null;

            // Include CSRF Token in Stomp connect() header
            // + Need to relax CSRF protection on endpoint(s) like '/notification/**'

            var token = $("meta[name='_csrf']").attr("content");
            var headerName = $("meta[name='_csrf_header']").attr("content");
            var headers = {};
            headers[headerName] = token;

            stompClient.connect(headers, function (frame) {
                stompClient.subscribe('/topic/notification', function (data) {
                    vm.showMessage(messageTypes[0], JSON.parse(data.body).message);
                });
            });
        };

        vm.disconnect = function () {
            if (stompClient != null) {
                stompClient.disconnect();
            }
        };

        vm.closeNotification = function (notificationElement) {
            notificationElement.animate({bottom: -notificationElement.outerHeight()}, 500);
        };

        vm.registerHideNotification = function (type) {
            $('.notification.' + type).unbind('click').click(function () {
                vm.closeNotification($(this));
            });
            setTimeout(function () {
                vm.closeNotification($('.notification.' + type));
            }, 30000)
        };

        vm.hideNotifications = function () {
            var messagesHeights = new Array(); // this array will store height for each

            for (var i = 0; i < messageTypes.length; i++) {
                messagesHeights[i] = $('.' + messageTypes[i]).outerHeight();
                $('.' + messageTypes[i]).css('bottom', -messagesHeights[i]); //move element outside viewport
            }
        };

        vm.showMessage = function (type, message) {
            vm.registerHideNotification(type);
            $('.notification.' + type).show();
            $('.notification.' + type + ' > .message').text(message);
            $('.notification.' + type).animate({bottom: "0"}, 500);
        }
    };

    global.NotificationHandler = new NotificationHandler();

    $(document).ready(global.NotificationHandler.initWebSocket);
    $(document).ready(global.NotificationHandler.hideNotifications);

})(window);




