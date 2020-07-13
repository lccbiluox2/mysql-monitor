//定义几个全局变量
var AppUrl = "http://localhost:8090";//整个页面的请求页面


$(document).ready(function () {
    /**
     * 加载类别事件
     */
    loadCate();
    /**
     * 搜索点击事件
     */
    clickSearch();

});



/**
 * 搜索点击事件
 */
function clickCate(type) {
    console.log(type);
    var param = {'categoryId': type};
    $.ajax({
        url: AppUrl + '/article/getArticleByCate',//跨域请求的URL
        data: JSON.stringify(param),
        type: "POST",
        dataType: "json",
        contentType: "application/json;charset=UTF-8",
        success: function (data) {
            drawArticle(data);
        },
        error: function (reason) {
            console.log(reason)
        }
    });
}

/**
 * 搜索点击事件
 */
function clickSearch() {

    $("#search-button").click(function () {
        console.log($("#search-text").val())
        var text = $("#search-text").val();
        var param = {'searchText': text};
        $.ajax({
            url: AppUrl + '/searchController/search',//跨域请求的URL
            data: JSON.stringify(param),
            type: "POST",
            dataType: "json",
            contentType: "application/json;charset=UTF-8",
            success: function (data) {
                drawArticle(data);
            },
            error: function (reason) {
                console.log(reason)
            }
        });
    });
}


/**
 * 加载类别事件
 */
function loadCate() {

    $.ajax({
        url: AppUrl + '/category/list',//跨域请求的URL
        data: {pageNum: 3, pageSize: 3},
        type: 'get',
        dataType: 'json',
        contentType: "application/json",
        success: function (data) {
            var categoryList = '';
            $.each(data, function (name, item) { //循环得出“genusName”
                if (name == "content") {
                    // alert("c")
                    // alert(item)
                    $.each(item, function (cate_index, cate_obj) { //循环得出“genusName”
                        if (name == "content") {
                            categoryList += "<div class='cate_item' >";
                            categoryList += "<div class='cate_item_img' ></div>";
                            categoryList += "<div class='cate_item_a' >";
                            categoryList += "<a class='cate_link' href='javascript:void(0);' onclick=\"clickCate('" + cate_obj.id + "');\" >" + cate_obj.name + "</a>";
                            categoryList += "</div>";
                            categoryList += "<div class='cate_item_count' >"+cate_obj.count+"篇</div>";
                            categoryList += "</div>";
                        }
                    });
                }

            });

            $("#cate-list").html(categoryList)

        },
        error: function (reason) {
            console.log(reason)
        }
    });
}


/**
 * 渲染点击类别或者搜索
 * @param data
 */
function drawArticle(data) {
    var categoryList = '';
    $.each(data,function (name,item) { //循环得出“genusName”
        if(name == "content"){
            $.each(item,function (cate_index,cate_obj) { //循环得出“genusName”
                if(name == "content"){
                    categoryList += "<div class='aritle_item' >";
                    categoryList += "<div class='aritle_item_title' >";
                    categoryList += "<a href='./html/article/ArticleDetail.html?articleId="+cate_obj.id+"' target='_blank'>";
                    categoryList += "<font color='red'>原创</font> &nbsp;&nbsp;&nbsp;&nbsp;"+cate_obj.title+"</div>";
                    categoryList += "</a>";
                    categoryList += "<div class='aritle_item_zhaiyao' >"+cate_obj.digest+"</div>";
                    categoryList += "<div class='aritle_item_message' >2017-07-30 17:55:26 &nbsp;&nbsp;&nbsp;&nbsp; 访问量:165 &nbsp;&nbsp;&nbsp;&nbsp; 评论:2</div>";
                    categoryList += "</div>";
                }
            });
        }

    });

    $("#cntent-chapter").html(categoryList)
}