/**
 * Created by Никита on 30.04.2017.
 */
soccerApp.controller("indexController",
    function IndexController($scope, $http) {
        $scope.tournamentsData = [];
        $scope.matches = [];
        $scope.pastMatches = [];
        $scope.futureMatches = [];

        $scope.blogs = [];


        $scope.competitions = [];
        $scope.selectedCompetition = {};

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

                    $scope.loadMatches($scope.selectedCompetition.dbId);
                    $scope.loadTournament($scope.selectedCompetition.dbId);
                }, function (data) {
                });
        };

        $scope.changeTeams = function (selectedCompetition) {
            $scope.tournamentsData = [];
            $scope.matches = [];
            $scope.pastMatches = [];
            $scope.futureMatches = [];
            $scope.loadMatches(selectedCompetition.dbId);
            $scope.loadTournament(selectedCompetition.dbId);
        };

        $scope.getCompetitions();


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

        $scope.loadBlog = function () {
            $http.get("/news/latestblog")
                .then(function (data) {
                    $scope.blogs = data.data;
                    $.each($scope.blogs, function (index, value) {
                        value.image = "data:image/png;base64," + value.image;
                        var blogDate = new Date(value.date);
                        var date = blogDate.toLocaleString('ru', {
                            year: 'numeric',
                            month: 'long',
                            day: 'numeric',
                            hour: 'numeric',
                            minute: 'numeric'
                        });
                        var d = date.substring(0, date.indexOf('г') - 1);
                        var t = date.substring(date.indexOf('г') + 3, date.length);
                        value.date = d + t;
                    })
                })
        };


        $scope.loadMatches = function (id) {
            var requestParams = {
                key: apiKey,
                url: apiUrl + "matches?competition_id=" + id
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
                        var minutes = matchDate.getMinutes().toString();
                        var hours = matchDate.getHours().toString();
                        value.minutes = minutes.length == 1 ? "0" + minutes : minutes;
                        value.hours = hours.length == 1 ? "0" + hours : hours;
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

        $scope.loadBlog();
    });