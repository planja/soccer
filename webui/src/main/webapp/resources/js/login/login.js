/**
 * Created by ShchykalauM on 23.02.2017.
 */
function validate(loginData) {
    if (loginData.login.length < 5) {
        notify('topCenter', 'error', 'Длина логина должна быть не менее 5 символов');
        return false;
    }
    if (loginData.password.length < 5) {
        notify('topCenter', 'error', 'Длина пароля должна быть не менее 5 символов');
        return false;
    }
    return true;
}

soccerApp.controller("loginController",
    function LoginController($scope, $http) {
        $scope.loginData = {
            login: "",
            password: ""
        };
        $scope.login = function (loginData) {
            if (validate(loginData)) {
                $http.post("/j_spring_security_check",
                    "login=" + encodeURIComponent(loginData.login) +
                    "&password=" + encodeURIComponent(loginData.password),
                    {
                        headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                    })
                    .then(function (data) {
                        if (data.data.indexOf("<title>Login Failure</title>") != -1) {
                            notify('topCenter', 'error', 'Проверьте правильность введённых данных');
                            $scope.loginData = {
                                login: "",
                                password: ""
                            };
                        } else if (data.data.indexOf("/resources/css/admin/admin.css") != -1) {
                            window.location.href = "/admin";
                        }
                        else if (data.data.indexOf("/resources/css/news/createblog.css") != -1) {
                            window.location.href = "/news/createblog";
                        }
                        else if (data.data.indexOf("/resources/css/news/createnews.css") != -1) {
                            window.location.href = "/news/createnews";
                        } else window.location.href = "/";
                    }, function (data) {
                        if (data.data.indexOf("<title>Доступ запрещён</title>") != -1)
                            window.location.href = "/denied";
                    });
            }
        }
    });


$(document).ready(function () {
});
