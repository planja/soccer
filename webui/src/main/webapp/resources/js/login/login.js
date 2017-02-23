/**
 * Created by ShchykalauM on 23.02.2017.
 */
function validate(loginData) {
    if (loginData.login.length < 5) {
        notify('topCenter', 'error', 'Укажите корректный логин');
        return false;
    }
    if (loginData.password.length < 5) {
        notify('topCenter', 'error', 'Укажите корректный пароль');
        return false;
    }
    return true;
}

function notify(layout, type, text) {
    noty({
        layout: layout,
        type: type,
        timeout: 3000,
        text: text
    });
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
                        } else window.location.href = "/";
                    }, function (data) {
                    });
            }
        }
    });


$(document).ready(function () {
});
