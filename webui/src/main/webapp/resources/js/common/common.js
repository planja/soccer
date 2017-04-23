/**
 * Created by ShchykalauM on 21.02.2017.
 */

var soccerApp = angular.module("soccerApp", []);

var apiKey = "2b540c29c8394bd2aae779960d4fa5b5";

var apiUrl = "https://api.crowdscores.com/v1/";

function notify(layout, type, text) {
    noty({
        layout: layout,
        type: type,
        timeout: 3000,
        text: text
    });
}

function findInDataSourcePropertiesByValue(data, filter_property, values, return_property) {
    if (data == null) return "";
    var items = [];
    $.each(values, function (index, value) {
        var found = $.grep(data, function (item) {
            return item[filter_property] === value;
        });
        if (found != null && found.length > 0) items.push(found[0][return_property]);
    });
    return items.join(',\n');
}

$(document).ready(function () {
    $('.menu > li').parent().find('ul').toggle();

    $('.menu > li div').click(function () {
        $(this).parent().find('ul').toggle();
    });
});