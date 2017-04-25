/**
 * Created by Никита on 23.04.2017.
 */

soccerApp.controller("teamInfoController",
    function TeamInfoController($scope, $http) {

        $scope.teamData = {};

        $scope.players = [];

        var requestParams = {
            key: apiKey,
            url: apiUrl + "teams/" + teamId
        };
        $http.post("/getapidata", requestParams)
            .then(function (data) {
                $scope.teamData = JSON.parse(data.data);
                $scope.players = $scope.teamData.players;
                $.each($scope.players, function (index, value) {
                    value.index=index;
                })
            })

    });