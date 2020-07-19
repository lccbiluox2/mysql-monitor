var dataBaseId = null;

$(document).ready(function () {
    dataBaseId = getUrlParam("id");

    /**
     * 显示所有的数据库
     */
    showDataBases();

});

/**
 * 显示所有的数据库
 */
function showDataBases() {

    $.ajax({
        url: AppUrl + '/database/list',//跨域请求的URL
        data: "",
        type: "GET",
        dataType: "json",
        contentType: "application/json;charset=UTF-8",
        success: function (data) {
            var itemData = "";
            $.each(data, function (name, item) {
                if (name == "content") {
                    $.each(item, function (db_index, db_obj) {
                        // 添加默认选择当前数据库
                        if (dataBaseId == db_obj.id) {
                            itemData += "<option value='" + db_obj.id + "' selected>" + db_obj.name + "</option>";
                        } else {
                            itemData += "<option value='" + db_obj.id + "'>" + db_obj.name + "</option>";
                        }
                    });
                }
            });
            $("#database-list").append(itemData);
            altRows();
        },
        error: function (reason) {
            console.log(reason)
        }
    });

}

function altRows() {
    var rows = $("tr");
    for (i = 0; i < rows.length; i++) {
        if (i % 2 == 0) {
            rows[i].className = "evenrowcolor";
        } else {
            rows[i].className = "oddrowcolor";
        }
    }
}


/**
 * 格式化代码
 */
function formatCode() {
    var sqlText = $('#sql-text').val();

    var param = {
        'sql': sqlText
    };

    console.log(JSON.stringify(param))
    $.ajax({
        url: AppUrl + '/sql/format',//跨域请求的URL
        data: JSON.stringify(param),
        type: "POST",
        dataType: "json",
        contentType: "application/json;charset=UTF-8",
        success: function (data) {
            $.each(data, function (name, item) {
                if (name == "content") {
                    // 加入代码符号
                    var sqlCode = "```\r\n"+item+"\r\n```\r\n";
                    var markdownCode = marked(sqlCode, {breaks: true});
                    $("#sql-show").html(markdownCode);
                    // 重新渲染页面
                    reHeightCode();
                }
            });

        },
        error: function (reason) {
            console.log(reason)
        }
    });
}

/**
 * 分析SQL
 */
function analyseSql() {
    var sqlText = $('#sql-text').val();

    var param = {
        'sql': sqlText
    };

    console.log(JSON.stringify(param))
    $.ajax({
        url: AppUrl + '/sql/analyse',//跨域请求的URL
        data: JSON.stringify(param),
        type: "POST",
        dataType: "json",
        contentType: "application/json;charset=UTF-8",
        success: function (data) {
            $.each(data, function (name, item) {
                if (name == "content") {
                    // 加入代码符号
                    var sqlCode = "```\r\n"+item+"\r\n```\r\n";
                    var markdownCode = marked(sqlCode, {breaks: true});
                    $("#sql-show").html(markdownCode);
                    // 重新渲染页面
                    reHeightCode();
                }
            });

        },
        error: function (reason) {
            console.log(reason)
        }
    });
}