/**
 * Created by ShchykalauM on 21.02.2017.
 */

//var soccerApp = angular.module("soccerApp", ["kendo.directives"]);


$(document).ready(function () {
    $('.menu > li').parent().find('ul').toggle();

    $('.menu > li div').click(function () {
        $(this).parent().find('ul').toggle();
    });
});