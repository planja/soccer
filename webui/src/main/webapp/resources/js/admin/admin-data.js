/**
 * Created by Никита on 23.04.2017.
 */

soccerApp.controller("adminDataController",
    function AdminDataController($scope, $http) {
        $scope.competitions = [];

        $scope.updateCompetitions = function () {
            $("#spin").show();
            $http.get("/teams/updatecompetitions/" + apiKey)
                .then(function (data) {
                    $("#spin").hide();
                }, function (data) {

                });
        };
    });


$(document).ready(function () {
    $("#admin-data").css("text-decoration", "underline");
    $("#spin").spinner();
});