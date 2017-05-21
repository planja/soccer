/**
 * Created by Никита on 30.04.2017.
 */
soccerApp.controller("topAndBottomController",
    function TopAndBottom($scope, $http) {
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