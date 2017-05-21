/**
 * Created by Никита on 13.05.2017.
 */
readNewsApp.controller("allNewsController",
    function AllNewsControlle($scope, $http) {
        $scope.blogs = [];

        $scope.competitions = [];
        $scope.selectedCompetition = {};
        $scope.allBlogs = [];


        $scope.filteredBlogs = [];
        $scope.currentPage = 1;
        $scope.numPerPage = 3;
        $scope.maxSize = 5;

        $scope.isFirst = true;
        $scope.size = 0;
        $scope.tempBlogs = [];

        $scope.getCompetitions = function () {
            $http.get("/teams/maincompetitions")
                .then(function (data) {
                    $scope.competitions = data.data;
                    $scope.competitions.unshift({text: "Все", id: -1});
                    $scope.selectedCompetition = $scope.competitions[0];
                }, function (data) {
                });
        };

        $scope.filterByPage = function () {
            var begin = (($scope.currentPage - 1) * $scope.numPerPage)
                , end = begin + $scope.numPerPage;

            $scope.filteredBlogs = $scope.isFirst ? $scope.allBlogs.slice(begin, end) : $scope.tempBlogs.slice(begin, end);
        };

        $scope.loadBlogs = function () {
            $http.get("/news/findallnews")
                .then(function (data) {
                    $scope.filteredBlogs = data.data;
                    $scope.allBlogs = data.data;
                    $.each($scope.filteredBlogs, function (index, value) {

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
                    });

                    $scope.numPages = function () {
                        return $scope.isFirst ? Math.ceil($scope.allBlogs.length / $scope.numPerPage) : Math.ceil($scope.size / $scope.numPerPage);
                    };

                    $scope.$watch('currentPage + numPerPage', function () {
                        var begin = (($scope.currentPage - 1) * $scope.numPerPage)
                            , end = begin + $scope.numPerPage;

                        $scope.filteredBlogs = $scope.isFirst ? $scope.allBlogs.slice(begin, end) : $scope.tempBlogs.slice(begin, end);
                    });
                })
        };

        $scope.change = function (selectedCompetition) {
            $scope.isFirst = false;
            $scope.filteredBlogs = $scope.sort(selectedCompetition.id);
            $scope.size = $scope.filteredBlogs.length;
            $scope.tempBlogs = $scope.filteredBlogs;
            $scope.filterByPage();
        };

        $scope.sort = function (id) {
            if (id == -1)
                return $scope.allBlogs;
            var result = [];
            $.each($scope.allBlogs, function (index, value) {
                if (value.mainCompetitionId == id)
                    result.push(value)
            });
            return result;
        };

        $scope.getCompetitions();
        $scope.loadBlogs();

        $scope.mainNews = [];
        $scope.otherNews = [];
        $scope.loadNews = function () {
            $http.get("/news/latestnews")
                .then(function (data) {
                    var news = data.data;
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
                            value.index=$scope.mainNews.length;
                            $scope.mainNews.push(value)
                        } else {
                            value.index=$scope.otherNews.length;
                            $scope.otherNews.push(value)
                        }
                    });
                    var q = 0;
                })
        };



        $scope.loadNews();

    });