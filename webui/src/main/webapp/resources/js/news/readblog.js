/**
 * Created by Никита on 13.05.2017.
 */
soccerApp.controller("blogController",
    function BlogController($scope, $http, $sce) {

        $scope.blog = {};
        $scope.html = "";

        $scope.loadBlog = function () {
            $http.get("/news/loadblog/" + blogId)
                .then(function (data) {
                    $scope.blog = data.data;
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

        $scope.loadBlog();

    });