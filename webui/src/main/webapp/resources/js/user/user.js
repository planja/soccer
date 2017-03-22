/**
 * Created by ShchykalauM on 20.03.2017.
 */

function validate(userProfile) {
    if (userProfile.login.length < 5) {
        notify('topCenter', 'error', 'Длина логина должна быть не менее 5 символов');
        return false;
    }
    if (userProfile.name.length < 5) {
        notify('topCenter', 'error', 'Длина имени должна быть не менее 5 символов');
        return false;
    }
    var regExp = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if (!regExp.test(userProfile.mail)) {
        notify('topCenter', 'error', 'Укажите корректный e-mail');
        return false;
    }
    if (userProfile.password.length < 5) {
        notify('topCenter', 'error', 'Длина пароля должна быть не менее 5 символов');
        return false;
    }

    return true;
}

var imageString = null;

soccerApp.controller("userController",
    function UserController($scope, $http) {

        $scope.data = null;

        $scope.showProfileValue = false;
        $scope.showCommentsValue = false;

        $scope.loadProfile = function () {
            $.ajax({
                type: "GET",
                url: "/user/loaduserprofile",
                async: false,
                success: function (data) {
                    $scope.data = data;
                    if (data.imageString != null) {
                        var image = document.getElementById("avatar-image");
                        image.src = "data:image/gif;base64," + data.imageString;
                        image.height = 89;
                        image.width = 100;

                    }
                }
            });
        };
        $scope.loadProfile();

        $scope.showProfile = function () {
            $scope.showCommentsValue = false;
            $scope.showProfileValue = true;
        };

        $scope.showComments = function () {
            $scope.showCommentsValue = true;
            $scope.showProfileValue = false;
        };

        $scope.updateProfile = function (userData) {
            if (validate(userData)) {

                var isValidaForDuplicate = false;
                $.ajax({
                    type: "GET",
                    url: "/registration/isvalidtoduplicate/" + userData.login,
                    async: false,
                    success: function (data) {
                        isValidaForDuplicate = data == "true";
                    }
                });

                if (isValidaForDuplicate) {

                    var imageForSave = null;

                    if ($scope.data.imageString == null) {
                        imageForSave = imageString == null ? null : imageString.substring(imageString.indexOf("base64,") + 7)
                    } else {
                        if (imageString != null) {
                            imageForSave = imageString != null ? imageString.substring(imageString.indexOf("base64,") + 7) : $scope.data.imageString;
                        } else {
                            imageForSave = $scope.data.imageString;
                        }
                    }

                    var data = {
                        id: $scope.data.id,
                        login: userData.login,
                        name: userData.name,
                        mail: userData.mail,
                        password: userData.password,
                        imageString: imageForSave
                    };


                    $http.post("/user/updateuser", data)
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
