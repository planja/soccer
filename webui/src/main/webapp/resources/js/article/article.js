/**
 * Created by Никита on 23.04.2017.
 */

$(function () {
    $('div#edit').froalaEditor({
        language: 'es'
    })
});

var imageString = null;

function validate(newsData) {
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
            if (validate(newsData)) {

                var data = {
                    id: null,
                    name: newsData.name,
                    image: imageString.substring(imageString.indexOf("base64,") + 7),
                    html: null,
                    isBlog: true,
                    mainCompetitionId: $scope.selectedCompetition.id,
                    startNewsText: newsData.startNewsText
                };

                alert('qwe')
            }
        };

        $scope.getCompetitions();


    });
