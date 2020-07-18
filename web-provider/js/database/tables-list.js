var id = null;

$(document).ready(function () {
    id = getUrlParam("id");

    /**
     * 显示菜单
     */
    showTables();

});

/**
 * 显示菜单
 */
function showTables() {
    var param = {
        'id': id
    };

    $.ajax({
        url: AppUrl + '/tables/list',//跨域请求的URL
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
                        if (bjectName == "tableDescsMain") {
                            showTableDescsMain(objectValues);
                        }
                        if (bjectName == "tableDescsOther") {
                            showTableDescsOther(objectValues);
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

function showTableDescsOther(objectValues) {
    var itemData = "";
    $.each(objectValues, function (bjectName, objectValues) {
        itemData += "<tr>";
        itemData += "<td>" + objectValues.name + "</td>";
        itemData += "<td>" + objectValues.rowFormat + "</td>";
        itemData += "<td>" + objectValues.avgRowLength + "</td>";
        itemData += "<td>" + objectValues.dataLength + "</td>";
        itemData += "<td>" + objectValues.indexLength + "</td>";
        itemData += "<td>" + objectValues.dataFree + "</td>";
        itemData += "<td>" + objectValues.createTime + "</td>";
        itemData += "<td>" + objectValues.updateTime + "</td>";
        itemData += "<td>" + objectValues.checkTime + "</td>";
        itemData += "<td>" + objectValues.checksum + "</td>";
        itemData += "<td>" + objectValues.createOptions + "</td>";
        itemData += "<td>" + objectValues.comment + "</td>";
        itemData += "</tr>";
    });
    $(".tableDescsOther table").append(itemData);

}

/**
 * 表重要信息展示
 * @param objectValues
 */
function showTableDescsMain(objectValues) {
    var itemData = "";
    $.each(objectValues, function (bjectName, objectValues) {
        itemData += "<tr>";
        itemData += "<td>" + objectValues.name + "</td>";
        itemData += "<td>" + objectValues.engine + "</td>";
        itemData += "<td>" + objectValues.rows + "</td>";
        itemData += "<td>" + objectValues.autoIncrement + "</td>";
        itemData += "<td>" + objectValues.collation + "</td>";
        itemData += "<td>" + objectValues.dataMb + "</td>";
        itemData += "<td>" + objectValues.indexMb + "</td>";
        itemData += "<td>" + objectValues.allMb + "</td>";
        itemData += "<td>" + objectValues.count + "</td>";
        itemData += "<td>";
        itemData += "&nbsp;&nbsp;&nbsp;<a href='#'  >删除</a>";
        itemData += "&nbsp;&nbsp;&nbsp;<a href='./tables-detail.html?id="+id+"&name="+objectValues.name+ "'  target='_blank' >查看</a>";
        itemData += "</td>";
        itemData += "</tr>";
    });
    $(".tableDescsMain table").append(itemData);
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
