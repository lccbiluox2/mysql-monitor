var id = null;

$(document).ready(function () {
    id = getUrlParam("id");

    /**
     * 显示菜单
     */
    showMenu();
    /**
     * 显示数据库连接信息
     */
    showConnectMessage();

    showDbDetail();

    altRows();
});

/**
 * 表格隔行变色
 */
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
 * 显示菜单
 */
function showMenu() {
    var menu = "<a href='./../tables/tables-list.html?id="+id+"'  target=\"_blank\" >表详情</a>";
    $("#tableMessage").html(menu)

    var explainSql =  "<a href='./../sql/explain-sql.html?id="+id+"'  target=\"_blank\" >SQL执行分析</a>";
    $("#explainSql").html(explainSql)

}

/**
 * 显示数据库详情
 */
function showDbDetail() {

    var param = {
        'id': id
    };

    $.ajax({
        url: AppUrl + '/database/detail',//跨域请求的URL
        data: JSON.stringify(param),
        type: "POST",
        dataType: "json",
        contentType: "application/json;charset=UTF-8",
        success: function (data) {
            $.each(data, function (name, item) {
                if (name == "content") {
                    $.each(item, function (bjectName, objectValue) {
                        if(bjectName == "mySqlHome"){
                            $("#mySqlHome").html("环境变量："+objectValue)
                        }
                        if(bjectName == "basedir"){
                            $("#basedir").html("实际位置："+objectValue)
                        }
                        if(bjectName == "version"){
                            $("#version").html("版本："+objectValue)
                        }
                        if(bjectName == "datadir"){
                            $("#datadir").html("数据存储位置："+objectValue)
                        }
                        if(bjectName == "dbSize"){
                            showVariables("dbSize",objectValue);
                        }
                        if(bjectName == "charMap"){
                            showVariables("charMap",objectValue);
                        }
                        if(bjectName == "logError"){
                            showVariables("logError",objectValue)
                        }
                        if(bjectName == "logBin"){
                            showVariables("logBin",objectValue)
                        }
                        if(bjectName == "generalLog"){
                            showVariables("generalLog",objectValue)
                        }
                        if(bjectName == "slowQueryLog"){
                            showVariables("slowQueryLog",objectValue)
                        }
                        if(bjectName == "maxConnecttion"){
                            showVariables("maxConnecttion",objectValue)
                        }
                        if(bjectName == "threads"){
                            showVariables("threads",objectValue)
                        }
                        if(bjectName == "tableLock"){
                            showVariables("tableLock",objectValue)
                        }

                        if(bjectName == "variables"){
                            showVariables("other",objectValue)
                        }


                    });
                }
            });
            altRows();
        },
        error: function (reason) {
            console.log(reason)
        }
    });
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
