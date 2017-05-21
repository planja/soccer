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
                if (data.data === "") {
                    window.location.href = "/notfound";
                }
                $scope.teamData = JSON.parse(data.data);
                $scope.players = $scope.teamData.players;
                $.each($scope.players, function (index, value) {
                    value.index = index;
                })
            });

        $scope.getPosition = function (pos) {
            if (pos == "GK")
                return "Вратарь";
            else if (pos == "DF")
                return " Защитник";
            else if (pos == "MF")
                return "Полузащитник";
            else if (pos == "FW")
                return "Нападающий";
        }

    });
