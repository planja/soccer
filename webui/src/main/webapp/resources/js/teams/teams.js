/**
 * Created by Никита on 23.04.2017.
 */

soccerApp.controller("teamsController",
    function TeamsController($scope, $http) {
        $scope.competitions = [];
        $scope.selectedCompetition = {};

        $scope.currentTeams = [];

        $scope.getCompetitions = function () {

            var teamIndex = 0;
            $http.get("/teams/getcompetitions")
                .then(function (data) {
                    $scope.competitions = data.data;
                    $.each($scope.competitions, function (index, value) {
                        if (value.dbId == 36)
                            teamIndex = index;
                        value.region = " (" + value.region + ")";
                    });
                    $scope.selectedCompetition = $scope.competitions[teamIndex];

                    $("#selectedCompetition").css("display", "");

                    var requestParams = {
                        key: apiKey,
                        url: apiUrl + "teams?competition_ids=" + $scope.selectedCompetition.dbId
                    };
                    $http.post("/getapidata", requestParams)
                        .then(function (data) {
                            $scope.currentTeams = JSON.parse(data.data);
                        })
                }, function (data) {
                });
        };

        $scope.changeTeams = function (selectedCompetition) {
            var requestParams = {
                key: apiKey,
                url: apiUrl + "teams?competition_ids=" + selectedCompetition.dbId
            };
            $http.post("/getapidata", requestParams)
                .then(function (data) {
                    $scope.currentTeams = JSON.parse(data.data);
                })
        };


        $scope.getCompetitions();

    });
