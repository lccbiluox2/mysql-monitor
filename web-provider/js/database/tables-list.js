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
            var itemData = "";
            $.each(data, function (name, item) {
                if (name == "content") {
                    console.log("name:" + name)
                    $.each(item, function (bjectName, objectValues) {
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
                        itemData += "</tr>";
                    });
                }
            });
            $(".tables table").append(itemData);
        },
        error: function (reason) {
            console.log(reason)
        }
    });

    // private String name;
    // private String ;
    // private String ;
    // private String ;
    // private String ;
    // private String ;
    // private String ;
    // private String ;
    // private String ;
    // private String ;
    // private String ;
    // private String ;
    // private String ;
    // private String ;
    // private String ;
    // private String ;
    // private String ;
    // private String ;
    //
    // private String ;
    // private String ;
    // private String ;
    // private String ;
}




function showVariables(htmlId,variables) {
    $.each(variables, function (bjectName, objectValue) {
        var itemData = "<tr>";
        itemData += "<td>" + bjectName + "</td>";
        itemData += "<td>" + objectValue + "</td>";
        itemData += "</tr>";
        $("."+htmlId+" table").append(itemData);
    });
}

function showAllVariables(variables) {
    $.each(variables, function (bjectName, objectValue) {
        var itemData = "<tr>";
        itemData += "<td>" + bjectName + "</td>";
        itemData += "<td>" + objectValue + "</td>";
        itemData += "</tr>";
        $(".variables-list table").append(itemData);
    });
}

/**
 * 显示数据库基本详情
 */
function showConnectMessage() {
    var name = getUrlParam("name");
    var ip = getUrlParam("ip");
    var database = getUrlParam("database");
    var port = getUrlParam("port");
    var username = getUrlParam("username");

    var message = "ID:"+id+"\t名称："+name+"\tip地址："+ip+"\t数据库："+database+"\t端口："+port+"\t用户名："+username+"\t密码:******";
    $("#db-con").html(message)
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
