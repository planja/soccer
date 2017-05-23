/**
 * Created by Никита on 23.04.2017.
 */

$(function () {
    $('div#edit').froalaEditor({
        language: 'es'
    })
});

var imageString = null;

function validate(newsData, html) {
    if (!newsData.name || newsData.name.length < 5) {
        notify('topCenter', 'error', 'Длина названия статьи должна быть не менее 5 символов');
        return false;
    }
    if (imageString == null) {
        notify('topCenter', 'error', 'Укажите заглавную картинку статьи');
        return false;
    }
    if (!newsData.startNewsText || newsData.startNewsText.length < 5) {
        notify('topCenter', 'error', 'Длина заглавия статьи должна быть не менее 5 символов');
        return false;
    }
    if (html.length <= 11) {
        notify('topCenter', 'error', 'Введите содержание статьи');
        return false;
    }
    return true;
}

function onChangeImage(files) {
    if (files.length != 0) {
        var fileReader = new FileReader();
        fileReader.addEventListener("load", function (e) {
            var image = document.getElementById("avatar-image");
            image.src = e.target.result;
            image.height = 89;
            image.width = 100;
            imageString = e.target.result;
        });

        fileReader.readAsDataURL(files[files.length - 1]);
    }
}


soccerApp.controller("articleController",
    function ArticleController($scope, $http) {

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

                var data = {
                    id: null,
                    name: newsData.name,
                    image: imageString.substring(imageString.indexOf("base64,") + 7),
                    html: resultHtml,
                    blog: true,
                    mainCompetitionId: $scope.selectedCompetition.id,
                    startNewsText: newsData.startNewsText
                };
                $http.post("/news/saveblog", data)
                    .then(function (data) {
                        window.location.href = "/news/readblog/" + data.data;
                    }, function (data) {

                    });
            }
        };

        $scope.getCompetitions();

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
                })
        };



        $scope.loadNews();



    });
