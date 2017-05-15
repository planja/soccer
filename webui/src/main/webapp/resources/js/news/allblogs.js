/**
 * Created by Никита on 13.05.2017.
 */
soccerApp.controller("allBlogsController",
    function AllBlogsControlle($scope, $http) {
        $scope.blogs = [];

        $scope.competitions = [];
        $scope.selectedCompetition = {};

        $scope.getCompetitions = function () {
            $http.get("/teams/maincompetitions")
                .then(function (data) {
                    $scope.competitions = data.data;
                    $scope.competitions.push({text: "Все", id: 0});
                    $scope.selectedCompetition = $scope.competitions[$scope.competitions.length - 1];
                }, function (data) {
                });
        };


        $scope.loadBlogs = function () {
            $http.get("/news/findallblogs")
                .then(function (data) {
                    $scope.blogs = data.data;
                    $.each($scope.blogs, function (index, value) {

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
                        value.image = "data:image/png;base64," + value.image;
                    })
                })
        };

        $scope.getCompetitions();
        $scope.loadBlogs();

    });