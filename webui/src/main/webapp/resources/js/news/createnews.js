/**
 * Created by Никита on 23.04.2017.
 */

$(function () {
    $('div#edit').froalaEditor({
        language: 'es'
    })
});


function validate(newsData, html) {
    if (!newsData.name || newsData.name.length < 5) {
        notify('topCenter', 'error', 'Длина названия новости должна быть не менее 5 символов');
        return false;
    }
    if (html.length <= 11) {
        notify('topCenter', 'error', 'Введите содержание новости');
        return false;
    }
    return true;
}

soccerApp.controller("newsController",
    function NewsController($scope, $http) {

        $scope.competitions = [];
        $scope.selectedCompetition = {};
        $scope.newsData = {};

        $scope.getCompetitions = function () {

            $http.get("/teams/maincompetitions")
                .then(function (data) {
                    $scope.competitions = data.data;
                    $scope.selectedCompetition = $scope.competitions[1];
                }, function (data) {
                });
        };


        $scope.save = function (newsData) {
            var html = $(".fr-element").first().html();
            var before = "<div class=\"fr-element fr-view\">";
            var after = "</div>";
            if (validate(newsData, html)) {
                var resultHtml = before + html + after;
                var isMainNews = $("#radio")[0].className;

                var data = {
                    id: null,
                    name: newsData.name,
                    html: resultHtml,
                    mainCompetitionId: $scope.selectedCompetition.id,
                    mainNews: isMainNews.indexOf("ng-not-empty") != -1
                };
                $http.post("/news/savenews", data)
                    .then(function (data) {
                        window.location.href = "/news/readnews/" + data.data;
                    }, function (data) {

                    });
            }
        };

        $scope.getCompetitions();


    });
