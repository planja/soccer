/**
 * Created by Никита on 30.04.2017.
 */
soccerApp.controller("countryController",
    function CountryController($scope, $http) {
        $scope.tournamentsData = [];
        $scope.matches = [];
        $scope.pastMatches = [];
        $scope.futureMatches = [];

        $scope.blogs = [];

        $scope.mainNews = [];
        $scope.otherNews = [];


        $scope.competitions = [];
        $scope.selectedCompetition = {};

        $scope.title = "";
        $scope.dbId = 0;

        $scope.getDbId = function () {
            if (countryId == 0) {
                $scope.dbId = "147";
                $scope.title = "Россия";
            }
            if (countryId == 1) {
                $scope.dbId = "36";
                $scope.title = "Лига Чемпионав";
            }
            if (countryId == 2) {
                $scope.dbId = "37";
                $scope.title = "Лига Европы";
            }
            if (countryId == 3) {
                $scope.dbId = "2";
                $scope.title = "Англия";
            }
            if (countryId == 4) {
                $scope.dbId = "46";
                $scope.title = "Испания";
            }
            if (countryId == 5) {
                $scope.dbId = "49";
                $scope.title = "Италия";
            }
            if (countryId == 6) {
                $scope.dbId = "48";
                $scope.title = "Германия";
            }
            if (countryId == 8) {
                $scope.dbId = "47";
                $scope.title = "Франция";
            }

        };

        $scope.getCompetitions = function () {

            $scope.getDbId();

            var teamIndex = 0;
            $http.get("/teams/getcompetitions")
                .then(function (data) {
                    $scope.competitions = data.data;
                    $.each($scope.competitions, function (index, value) {
                        if (value.dbId == $scope.dbId)
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
                    var d = data.data;
                    $.each(d, function (index, value) {
                        if (value.mainCompetitionId == countryId)
                            $scope.blogs.push(value);
                    });
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

        $scope.loadNews = function () {
            $http.get("/news/latestnews")
                .then(function (data) {



                    var d = data.data;
                    var news = [];
                    $.each(d, function (index, value) {
                        if (value.mainCompetitionId == countryId)
                            news.push(value);
                    });
                    $.each(news, function (index, value) {
                        var dateTime = new Date(value.date);
                        var date = dateTime.toLocaleString('ru', {
                            year: 'numeric',
                            month: 'long',
                            day: 'numeric',
                            hour: 'numeric',
                            minute: 'numeric'
                        });
                        var d = date.substring(0, date.indexOf('г') - 1);
                        var t = date.substring(date.indexOf('г') + 3, date.length);
                        value.date = d + t;
                        if (value.mainNews) {
                            value.index = $scope.mainNews.length;
                            $scope.mainNews.push(value)
                        } else {
                            value.index = $scope.otherNews.length;
                            $scope.otherNews.push(value)
                        }
                    });
                    var q = 0;
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

        $scope.loadNews();
        $scope.loadBlog();
    });