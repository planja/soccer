/**
 * Created by Никита on 30.04.2017.
 */
soccerApp.controller("indexController",
    function IndexController($scope, $http) {
        $scope.tournamentsData = [];
        $scope.matches = [];
        $scope.pastMatches = [];
        $scope.futureMatches = [];

        $scope.loadTournament = function () {
            var requestParams = {
                key: apiKey,
                url: apiUrl + "league-tables?competition_id=36"
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

        $scope.loadMatches = function () {
            var requestParams = {
                key: apiKey,
                url: apiUrl + "matches?competition_id=36"
            };
            $http.post("/getapidata", requestParams)
                .then(function (data) {
                    $scope.matches = JSON.parse(data.data);
                    var time = new Date().getTime();
                    $.each($scope.matches, function (index, value) {
                        var matchDate = new Date(value.start);
                        var date = matchDate.toLocaleString('ru', {
                            year: 'numeric',
                            month: 'long',
                            day: 'numeric'
                        });
                        value.date = date;
                        value.minutes = matchDate.getMinutes();
                        value.hours = matchDate.getHours();
                        if (time <= value.start) {
                            $scope.futureMatches.push(value);
                        } else {
                            $scope.pastMatches.push(value);
                        }
                    });
                    if ($scope.futureMatches.length >= 10) {
                        $scope.futureMatches = $scope.futureMatches.slice(0, 10);
                    }
                    if ($scope.pastMatches.length >= 10) {
                        $scope.pastMatches = $scope.pastMatches.slice($scope.pastMatches.length - 10, $scope.pastMatches.length);
                    }
                    $scope.pastMatches = $scope.pastMatches.reverse();
                })
        };
        $scope.loadMatches();
        $scope.loadTournament();
    });