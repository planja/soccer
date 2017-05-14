/**
 * Created by Никита on 23.04.2017.
 */

soccerApp.controller("tableController",
    function TableController($scope, $http) {
        $scope.competitions = [];
        $scope.selectedCompetition = {};
        $scope.tournamentsData = [];

        $scope.loadTournament = function (id) {
            var requestParams = {
                key: apiKey,
                url: apiUrl + "league-tables?competition_id="+id
            };
            $http.post("/getapidata", requestParams)
                .then(function (data) {
                    $scope.tournamentsData = JSON.parse(data.data);
                    $.each($scope.tournamentsData, function (index, value) {
                        value.index = index;
                        $.each(value.leagueTable, function (teamIndex, teamValue) {
                            teamValue.index = teamIndex;
                        });
                    });
                })
        };


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
                    $scope.loadTournament($scope.selectedCompetition.dbId);
                }, function (data) {
                });
        };

        $scope.changeTeams = function (selectedCompetition) {
            $scope.loadTournament(selectedCompetition.dbId);
        };


        $scope.getCompetitions();
    });
