/**
 * Created by ShchykalauM on 23.02.2017.
 */
function validate(registrationData) {
    if (registrationData.login.length < 5) {
        notify('topCenter', 'error', 'Длина логина должна быть не менее 5 символов');
        return false;
    }
    if (registrationData.name.length < 5) {
        notify('topCenter', 'error', 'Длина имени должна быть не менее 5 символов');
        return false;
    }
    var regExp = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if (!regExp.test(registrationData.mail)) {
        notify('topCenter', 'error', 'Укажите корректный e-mail');
        return false;
    }
    if (registrationData.password.length < 5) {
        notify('topCenter', 'error', 'Длина пароля должна быть не менее 5 символов');
        return false;
    }

    return true;
}

soccerApp.controller("registrationController",
    function RegistrationController($scope, $http) {
        $scope.registrationData = {
            login: "",
            name: "",
            mail: "",
            password: ""

        };

        $scope.save = function (registrationData) {
            if (validate(registrationData))
                alert("sosi")
        }
    });

function onChangeImage(files) {
    if (files.length != 0) {
        var image = $("#avatar-image")[0];
        image.src = window.URL.createObjectURL(files[files.length - 1]);
        image.height = 89;
        image.width = 100;
    }
}


$(document).ready(function () {
});
