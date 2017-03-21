/**
 * Created by ShchykalauM on 20.03.2017.
 */

soccerApp.controller("userController",
    function UserController($scope, $http) {

        $scope.data = "qwe";
        $scope.loadProfile = function () {
            $.ajax({
                type: "GET",
                url: "/user/loaduserprofile",
                async: false,
                success: function (data) {
                    var q = 0;
                }
            });
        };

        $scope.loadProfile();

    });
