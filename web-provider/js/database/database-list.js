$(document).ready(function () {
    /**
     * 加载数据库事件
     */
    locaDatabase();


});


/**
 * 加载所有的数据库
 */
function locaDatabase() {
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
                        // console.log(db_index+" "+db_obj.name)
                        itemData += "<tr>";
                        itemData += "<td>" + db_obj.id + "</td>";
                        itemData += "<td>" + db_obj.name + "</td>";
                        itemData += "<td>" + db_obj.ip + "</td>";
                        itemData += "<td>" + db_obj.database + "</td>";
                        itemData += "<td>" + db_obj.port + "</td>";
                        itemData += "<td>" + db_obj.username + "</td>";
                        itemData += "<td>" + db_obj.password + "</td>";
                        if (db_obj.status == "true") {
                            itemData += "<td style='font-size: 20px;color: green'>&radic;</td>";
                        }else {
                            itemData += "<td style='font-size: 20px;color: red'>X</td>";
                        }
                        itemData += "<td>";
                        itemData += "&nbsp;&nbsp;&nbsp;<a href='#' onclick='deleteThis(this," + db_obj.id + ")' >删除</a>";
                        itemData += "&nbsp;&nbsp;&nbsp;<a href='#' onclick='updateThis(" + db_obj.id + ")' >修改</a>";
                        itemData += "&nbsp;&nbsp;&nbsp;<a href='./database-detail.html?id="+db_obj.id+"&name="+db_obj.name+"&ip="+ db_obj.ip + "&database="+ db_obj.database +"&port="+ db_obj.port +"&username="+ db_obj.username + "'  target='_blank' >查看</a>";
                        itemData += "</tr>";
                    });
                }
            });
            $(".items table").append(itemData);
            altRows();
        },
        error: function (reason) {
            console.log(reason)
        }
    });
}

/**
 * 添加新的数据库
 */
function addDatabase() {
    var name = $("#name").val();
    var ip = $("#ip").val();
    var username = $("#username").val();
    var password = $("#password").val();
    var database = $("#database").val();
    var port = $("#port").val();

    var param = {
        'name': name,
        'ip': ip,
        'username': username,
        'password': password,
        'database': database,
        'port': port
    };

    $.ajax({
        url: AppUrl + '/database/add',//跨域请求的URL
        data: JSON.stringify(param),
        type: "POST",
        dataType: "json",
        contentType: "application/json;charset=UTF-8",
        success: function (data) {
            $.each(data, function (name, item) {
                if (name == "content") {
                    console.log("item:" + item.username)
                    var itemData = "<tr>";
                    itemData += "<td>" + item.id + "</td>";
                    itemData += "<td>" + item.name + "</td>";
                    itemData += "<td>" + item.ip + "</td>";
                    itemData += "<td>" + item.database + "</td>";
                    itemData += "<td>" + item.port + "</td>";
                    itemData += "<td>" + item.username + "</td>";
                    itemData += "<td>" + item.password + "</td>";
                    itemData += "<td>" + item.status + "</td>";
                    itemData += "</tr>";
                    $(".items table").append(itemData);
                }
            });
            altRows();
        },
        error: function (reason) {
            console.log(reason)
        }
    });
}

function deleteThis(element, id) {
    var param = {
        'id': id
    };
    $.ajax({
        url: AppUrl + '/database/delete',//跨域请求的URL
        data: JSON.stringify(param),
        type: "POST",
        dataType: "json",
        contentType: "application/json;charset=UTF-8",
        success: function (data) {
            element.parentElement.parentElement.remove();
            altRows();
        },
        error: function (reason) {
            console.log(reason)
        }
    });
}


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
