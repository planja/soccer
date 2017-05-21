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

soccerApp.controller("blogController",
    function BlogController($scope, $http, $sce) {

        $scope.blog = {};
        $scope.html = "";

        $scope.blogs = [];

        $scope.comments = [];

        $scope.loadBlog = function () {
            $http.get("/news/loadblog/" + blogId)
                .then(function (data) {
                    $scope.blog = data.data;
                    $scope.comments = $scope.blog.comments;
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
                    var blogDate = new Date($scope.blog.date);
                    var date = blogDate.toLocaleString('ru', {
                        year: 'numeric',
                        month: 'long',
                        day: 'numeric',
                        hour: 'numeric',
                        minute: 'numeric'
                    });
                    var d = date.substring(0, date.indexOf('г') - 1);
                    var t = date.substring(date.indexOf('г') + 3, date.length);
                    $scope.blog.date = d + t;
                    $scope.html = $sce.trustAsHtml($scope.blog.html);
                })
        };

        $scope.readMore = function () {
            $http.get("/news/readmoreblogs/" + blogId)
                .then(function (data) {
                    $scope.blogs = data.data;
                    $.each($scope.blogs, function (index, value) {
                        value.image = "data:image/png;base64," + value.image;
                    })
                })
        };
        $scope.readMore();
        $scope.loadBlog();

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

        $scope.deleteComment = function (id) {
            $http.get("/news/deleteblogcommentary/" + id)
                .then(function (data) {
                    var deleteIndex = 0;
                    $.each($scope.comments, function (index, value) {
                        if (value.id === id)
                            deleteIndex = index;
                    });
                    $scope.comments.splice(deleteIndex, 1);
                })
        };

        $scope.commentText = "";

        $scope.saveComment = function (commentText) {
            var data = {
                text: commentText,
                newsId: parseInt(blogId)
            };
            if (validate(commentText)) {
                $http.post("/news/saveblogcomment", data)
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