/**
 * 数据库id
 * @type {null}
 */
var id = null;
/**
 * 表名称
 * @type {null}
 */
var tableName = null;

$(document).ready(function () {
    id = getUrlParam("id");
    tableName = getUrlParam("name");

    /**
     * 显示表详情
     */
    showTableDetail();

});

/**
 * 显示建表语句
 */
function showTableDetail() {
    var param = {
        'id': id,
        'name': tableName,
    };

    $.ajax({
        url: AppUrl + '/tables/detail',//跨域请求的URL
        data: JSON.stringify(param),
        type: "POST",
        dataType: "json",
        contentType: "application/json;charset=UTF-8",
        success: function (data) {
            console.log(data)

            $.each(data, function (name, item) {
                if (name == "content") {
                    console.log("name:" + name)
                    $.each(item, function (bjectName, objectValues) {
                        console.log("bjectName:" + bjectName)
                        if (bjectName == "createTable") {
                            showCreateTable(objectValues);
                        }
                        if (bjectName == "tableColumns") {
                            showTableColumns(objectValues);
                        }
                        if (bjectName == "tableIndex") {
                            showTableIndex(objectValues);
                        }
                        altRows();
                    });
                }
            });
        },
        error: function (reason) {
            console.log(reason)
        }
    });

}

/**
 * 显示表索引信息
 */
function showTableIndex(objectValues) {
    var itemData = "";
    $.each(objectValues, function (bjectName, objectValues) {
        itemData += "<tr>";
        itemData += "<td>" + objectValues.table + "</td>";
        itemData += "<td>" + objectValues.nonUnique + "</td>";
        itemData += "<td>" + objectValues.keyName + "</td>";
        itemData += "<td>" + objectValues.seqInIndex + "</td>";
        itemData += "<td>" + objectValues.columnName + "</td>";
        itemData += "<td>" + objectValues.collation + "</td>";
        itemData += "<td>" + objectValues.cardinality + "</td>";
        itemData += "<td>" + objectValues.subPart + "</td>";
        itemData += "<td>" + objectValues.packed + "</td>";
        itemData += "<td>" + objectValues.nullValue + "</td>";
        itemData += "<td>" + objectValues.indexType + "</td>";
        itemData += "<td>" + objectValues.comment + "</td>";
        itemData += "<td>" + objectValues.indexComment + "</td>";
        itemData += "<td>" + objectValues.visible + "</td>";
        itemData += "<td>" + objectValues.expression + "</td>";
        itemData += "</tr>";

    });
    $("#table-index").append(itemData);
}

/**
 * 显示表列的详情信息
 */
function showTableColumns(objectValues) {
    var itemData = "";
    $.each(objectValues, function (bjectName, objectValues) {
        itemData += "<tr>";
        itemData += "<td>" + objectValues.field + "</td>";
        itemData += "<td>" + objectValues.type + "</td>";
        itemData += "<td>" + objectValues.collation + "</td>";
        itemData += "<td>" + objectValues.nu + "</td>";
        itemData += "<td>" + objectValues.key + "</td>";
        itemData += "<td>" + objectValues.defau + "</td>";
        itemData += "<td>" + objectValues.extra + "</td>";
        itemData += "<td>" + objectValues.privileges + "</td>";
        itemData += "<td>" + objectValues.comment + "</td>";
        itemData += "</tr>";

    });
    $("#table-clumn table").append(itemData);
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
 * 显示创建表详情
 * @param objectValues
 */
function showCreateTable(objectValues) {
    $.each(objectValues, function (bjectName, objectValues) {
        console.log(bjectName,objectValues)
        $("#tableName").append(bjectName);

        // 加入代码符号
        objectValues = "```\r\n"+objectValues+"\r\n```\r\n";
        var markdownCode = marked(objectValues, {breaks: true});
        $("#tableCreate").html(markdownCode);
        // 重新渲染页面
        reHeightCode();

    });
}


/**
 * 解决问题：https://blog.csdn.net/qq_21383435/article/details/106886286
 * 代码渲染问题：
 * 循环每个代码段，然后获取代码，并且重新渲染
 * @param name
 * @returns {*}
 */
function reHeightCode() {
    $("pre code").each(function () {
        var code = $(this).text();
        var highCode = hljs.highlightAuto(code).value;
        $(this).html(highCode)
    });
}

/**
 * 获取地址栏 url 的参数信息
 * @param name
 * @returns {*}
 */
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]);
    return null; //返回参数值
}
