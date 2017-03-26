/**
 * Created by ShchykalauM on 23.02.2017.
 */

var rolesDataSource = dataSourceRoles.getRolesTypeDataSource();

$(document).ready(function () {
    $("#admin-users").css("text-decoration", "underline");
    rolesDataSource.read();

    var dataSource = new kendo.data.DataSource(
        {
            transport: {
                read: {
                    url: "/admin/findallusers",
                    type: "Get",
                    dataType: "json",
                    contentType: "application/json"
                },
                destroy: {
                    url: function (options) {
                        return "/admin/deleteuser/" + options.id;
                    },
                    type: "Delete",
                    dataType: "json",
                    contentType: "application/json"
                },
                update: {
                    url: "/admin/updateroles",
                    type: "Put",
                    dataType: "json",
                    contentType: "application/json"
                },
                parameterMap: function (model, operation) {
                    if (operation === "destroy" && model) {
                        return model.id;
                    }
                    if (operation === "create" || operation === "update" && model) {
                        if (model.roles == "" || model.roles.length == 0) {
                            model.roles = [3];
                        }
                        return kendo.stringify(model);
                    }
                }
            },
            schema: {
                model: {
                    id: "id",
                    fields: {
                        id: {type: "number", editable: false, nullable: false, defaultValue: null},
                        login: {type: "string", editable: true, nullable: false},
                        roles: [{type: "number", editable: true, nullable: true, defaultValue: null}]
                    }
                }
            },
            pageSize: 5,
            sort: {field: "login", dir: "asc"}
        }
    );

    var grid = $("#grid-users").kendoGrid(
        {
            height: 450,
            dataSource: dataSource,
            filterable: {
                extra: false,
                messages: {
                    info: "Показывать записи которые",
                    clear: "Очистить",
                    filter: "Фильтр"
                },
                operators: {
                    string: {
                        contains: "Содержат",
                        startswith: "Начинаются с",
                        eq: "Равны",
                        neq: "Не равны"

                    }
                }
            },
            pageable: {
                refresh: false,
                pageSize: 5,
                pageSizes: [5, 50, 100, 200, 500],
                messages: {
                    itemsPerPage: "Пользователей",
                    display: "",
                    empty: "Нету данных",
                    allPages: "Показать всех"
                }
            },
            columns: [
                {
                    field: "login",
                    title: "Логин",
                    width: 90
                },
                {
                    filterable: false,
                    field: "roles",
                    title: "Роли",
                    width: 110,
                    template: function (dataItem) {
                        return getRolesNamesById(dataItem.roles, rolesDataSource.data());
                    }
                },
                {
                    command: [
                        {name: "destroy", text: "Удалить"},
                        {name: "edit", text: {edit: "Редактировать", update: "Сохранить", cancel: "Отмена"}}
                    ],
                    width: 200
                }
            ],
            editable: {
                confirmation: "Вы уверены, что хотите удалить эту запись?",
                mode: "popup",
                template: kendo.template($("#popup_editor").html()),
                window: {
                    title: "Пользователь"
                }
            },
            edit: function (e) {
                e.model.dirty = true;
            }
        }
    ).data("kendoGrid");
});

function getRolesNamesById(ids, data) {
    return findInDataSourcePropertiesByValue(data, 'id', ids, 'text');
}
