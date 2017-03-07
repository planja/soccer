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

var imageString = null;

soccerApp.controller("registrationController",
    function RegistrationController($scope, $http) {
        $scope.registrationData = {
            login: "",
            name: "",
            mail: "",
            password: ""

        };

        $scope.save = function (registrationData) {
            if (validate(registrationData)) {

                var isValidaForDuplicate = false;
                $.ajax({
                    type: "GET",
                    url: "/registration/isvalidtoduplicate/" + registrationData.login,
                    async: false,
                    success: function (data) {
                        isValidaForDuplicate = data == "true";
                    }
                });

                if (isValidaForDuplicate) {
                    var data = {
                        id: null,
                        login: registrationData.login,
                        name: registrationData.name,
                        mail: registrationData.mail,
                        password: registrationData.password,
                        imageString: imageString == null ? null : imageString.substring(imageString.indexOf("base64,") + 7)
                    };

                    $http.post("/registration/saveuser", data)
                        .then(function (data) {
                            window.location.href = "/";
                        }, function (data) {

                        });
                } else {
                    notify('topCenter', 'error', 'Пользователь с таким логином уже существует');
                }


            }
        }
    });

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


$(document).ready(function () {
});
