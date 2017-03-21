/**
 * Created by ShchykalauM on 21.02.2017.
 */

var soccerApp = angular.module("soccerApp", ["ngRoute"])
    .config(function ($routeProvider) {
        $routeProvider.when('/userprofile',
            {
                templateUrl: 'user/user-profile.jsp',
                controller: 'userController'
            });
    });

function notify(layout, type, text) {
    noty({
        layout: layout,
        type: type,
        timeout: 3000,
        text: text
    });
}


$(document).ready(function () {
    $('.menu > li').parent().find('ul').toggle();

    $('.menu > li div').click(function () {
        $(this).parent().find('ul').toggle();
    });
});