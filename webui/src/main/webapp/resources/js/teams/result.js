/**
 * Created by Никита on 23.04.2017.
 */

soccerApp.controller("resultController",
    function resultController($scope, $http) {
        $scope.competitions = [];
        $scope.selectedCompetition = {};

        $scope.map = [
            {
                date: "",
                matches: []
            }
        ];

        $scope.loadTournament = function (id) {
            var requestParams = {
                key: apiKey,
                url: apiUrl + "league-tables?competition_id=" + id
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
                    $scope.loadMatches($scope.selectedCompetition.dbId);

                    $("#selectedCompetition").css("display", "");
                }, function (data) {
                });
        };

        $scope.changeTeams = function (selectedCompetition) {
            $scope.map = [];
            $scope.loadMatches(selectedCompetition.dbId);
        };

        $scope.loadMatches = function (id) {
            var requestParams = {
                key: apiKey,
                url: apiUrl + "matches?competition_id=" + id
            };
            $http.post("/getapidata", requestParams)
                .then(function (data) {
                    $scope.matches = JSON.parse(data.data);
                    var longTime = new Date().getTime();
                    $.each($scope.matches, function (index, value) {
                        var matchDate = new Date(value.start);
                        var date = matchDate.toLocaleString('ru', {
                            year: 'numeric',
                            month: 'long',
                            day: 'numeric'
                        });
                        var time = matchDate.toLocaleString('ru', {
                            hour: 'numeric',
                            minute: 'numeric'
                        });
                        value.date = date;
                        value.time = time;

                        var find = false;
                        var badMatch = false;

                        $.each($scope.map, function (mapIndex, mapValue) {
                            if (mapValue.date === value.date) {
                                if (value.start < longTime && value.isResult) {
                                    mapValue.matches.push(value);
                                    find = true;
                                } else if (value.start >= longTime) {
                                    mapValue.matches.push(value);
                                    find = true;
                                } else if (value.start < longTime && !value.isResult) {
                                    badMatch = true;
                                }
                            }

                        });
                        if (!find && !badMatch) {
                            var obj = {
                                date: value.date,
                                matches: []
                            };
                            obj.matches.push(value);
                            if (value.start < longTime && value.isResult)
                                $scope.map.push(obj);
                            else if (value.start < longTime && !value.isResult) {
                                $scope.map.push(obj);
                            } else if (value.start >= longTime) {
                                $scope.map.push(obj);
                            }
                        }
                    });
                    $scope.map.splice(0, 1);
                    $scope.map = $scope.map.reverse();
                })
        };


        $scope.getCompetitions();
    });
