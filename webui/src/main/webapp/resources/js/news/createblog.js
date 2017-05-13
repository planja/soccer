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
    if (newsData.name.length < 5) {
        notify('topCenter', 'error', 'Длина названия новости должна быть не менее 5 символов');
        return false;
    }
    if (imageString == null) {
        notify('topCenter', 'error', 'Укажите заглавную картинку новости');
        return false;
    }
    if (newsData.startNewsText.length < 5) {
        notify('topCenter', 'error', 'Длина заглавия новости должна быть не менее 5 символов');
        return false;
    }
    if (html.length < 5) {
        notify('topCenter', 'error', 'Введите содержание новости');
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


    });
