/**
 * Created by Никита on 13.05.2017.
 */

function validate(text) {
    if (text.length < 5) {
        notify('topCenter', 'error', 'Длина комментария должна быть не менее 5 символов');
        return false;
    }
    return true;
}

soccerApp.controller("newsController",
    function NewsController($scope, $http, $sce) {

        $scope.news = {};
        $scope.html = "";
        $scope.comments = [];


        $scope.loadNews = function () {
            $http.get("/news/loadnews/" + newsId)
                .then(function (data) {
                    $scope.news = data.data;
                    $scope.comments = $scope.news.comments;
                    $.each($scope.comments, function (index, value) {

                        if (value.userImage !== null) {
                            value.userImage = "data:image/gif;base64," + value.userImage;
                        } else {
                            value.userImage = "/resources/images/registration/default-avatar.gif"
                        }

                        var commentDate = new Date(value.date);
                        var date = commentDate.toLocaleString('ru', {
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
                    var newsDate = new Date($scope.news.date);
                    var date = newsDate.toLocaleString('ru', {
                        year: 'numeric',
                        month: 'long',
                        day: 'numeric',
                        hour: 'numeric',
                        minute: 'numeric'
                    });
                    var d = date.substring(0, date.indexOf('г') - 1);
                    var t = date.substring(date.indexOf('г') + 3, date.length);
                    $scope.news.date = d + t;
                    $scope.html = $sce.trustAsHtml($scope.news.html);
                })
        };

        $scope.readMore = function () {
            $http.get("/news/readmoreblogs/" + "-1")
                .then(function (data) {
                    $scope.blogs = data.data;
                    $.each($scope.blogs, function (index, value) {
                        value.image = "data:image/png;base64," + value.image;
                    })
                })
        };
        $scope.readMore();

        $scope.loadNews();

        $scope.mainNews = [];
        $scope.otherNews = [];

        $scope.loadAllNews = function () {
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
                        if (value.mainNews && value.id !== parseInt(newsId)) {
                            value.index = $scope.mainNews.length;
                            $scope.mainNews.push(value)
                        } else if (value.id !== parseInt(newsId)) {
                            value.index = $scope.otherNews.length;
                            $scope.otherNews.push(value)
                        }
                    });
                    var q = 0;
                })
        };

        $scope.deleteComment = function (id) {
            $http.get("/news/deletenewscommentary/" + id)
                .then(function (data) {
                    var deleteIndex = 0;
                    $.each($scope.comments, function (index, value) {
                        if (value.id === id)
                            deleteIndex = index;
                    });
                    $scope.comments.splice(deleteIndex, 1);
                })
        };

        $scope.loadAllNews();

        $scope.commentText = "";

        $scope.saveComment = function (commentText) {
            var data = {
                text: commentText,
                newsId: parseInt(newsId)
            };
            if (validate(commentText)) {
                $http.post("/news/savenewscomment", data)
                    .then(function (data) {
                        var comment = data.data;
                        if (comment.userImage !== null) {
                            comment.userImage = "data:image/gif;base64," + comment.userImage;
                        } else {
                            comment.userImage = "/resources/images/registration/default-avatar.gif"
                        }

                        var commentDate = new Date(comment.date);
                        var date = commentDate.toLocaleString('ru', {
                            year: 'numeric',
                            month: 'long',
                            day: 'numeric',
                            hour: 'numeric',
                            minute: 'numeric'
                        });
                        var d = date.substring(0, date.indexOf('г') - 1);
                        var t = date.substring(date.indexOf('г') + 3, date.length);
                        comment.date = d + t;
                        $scope.commentText = "";
                        $scope.comments.unshift(comment);
                    })
            }
        };

    });