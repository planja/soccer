/**
 * Created by Никита on 26.03.2017.
 */

var dataSourceRoles = (function () {

    var path = "/admin/rolesinfo";


    return {
        getRolesTypeDataSource: function (options) {
            var settings = $.extend(options,
                {
                    async: false
                });

            return new kendo.data.DataSource({
                transport: {
                    read: {
                        url: path,
                        dataType: "json",
                        contentType: "application/json",
                        async: settings.async
                    }
                },
                sort: {field: "text", dir: "asc"}
            });
        }
    };


}());