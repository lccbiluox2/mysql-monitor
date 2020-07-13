//定义几个全局变量
var AppUrl = "http://localhost:8090";//整个页面的请求页面
var titleId = 0;
var imageBasePath = "";
var keyWord = "";

$(document).ready(function () {
    titleId = getUrlParam("articleId");

    loadArticeDetail();

    // 加载类别
    getCateGoryOnLoad();
    selectCategory();
    enterUp();
    realTimeShow();

});

/**
 * 加载文件详情
 */
function loadArticeDetail(){
    var param = {'id': titleId};
    $.ajax({
        url: AppUrl + '/article/detail',//跨域请求的URL
        data: JSON.stringify(param),
        type: 'POST',
        dataType: 'json',
        contentType: "application/json",
        success: function (data) {
            $.each(data, function (name, item) {
                if (name == "content") {
                    keyWord = item.title
                    $("#title_text").val(item.title);
                    imageBasePath = item.imagePath;
                    setDefaultImageBaseFromUrl();
                    var code = item.content;
                    $("#text_textarea").html(code);
                    showTextFromLeft();
                    // 设置编辑页面地址
                    setEditUrl();
                }
            });
        },
        error: function (reason) {
            console.log(reason)
        }
    });
}

/**
 * 从地址栏中获取相关参数
 */
function setDefaultImageBaseFromUrl() {
    $("#file-root-input").val(imageBasePath)
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


/**
 * 选择的时候，图片的父路径
 */
function selectCategory() {
    $('#file-root-select').change(function () {
        var p1 = $(this).children('option:selected').val();//这就是selected的值
        if (p1 == "大数据-flink") {
            $("#file-root-input").val("/Users/lcc/IdeaProjects/docs/doc-flink/")
        }
        if (p1 == "大数据-calcite") {
            $("#file-root-input").val("/Users/lcc/IdeaProjects/docs/doc-calcite/")
        }
        if (p1 == "语言-java") {
            $("#file-root-input").val("/Users/lcc/IdeaProjects/docs/doc-java/")
        }
        if (p1 == "语言-jvm") {
            $("#file-root-input").val("/Users/lcc/IdeaProjects/docs/doc-jvm/")
        }
        if (p1 == "大数据-kafka") {
            $("#file-root-input").val("/Users/lcc/IdeaProjects/docs/doc-kafka/")
        }
        if (p1 == "大数据-kylin") {
            $("#file-root-input").val("/Users/lcc/IdeaProjects/docs/doc-kylin/")
        }
        if (p1 == "框架-netty") {
            $("#file-root-input").val("/Users/lcc/IdeaProjects/docs/doc-netty/")
        }
        if (p1 == "大数据-siddhi") {
            $("#file-root-input").val("/Users/lcc/IdeaProjects/docs/doc-siddhi/")
        }
        if (p1 == "大数据-spark") {
            $("#file-root-input").val("/Users/lcc/IdeaProjects/docs/doc-spark/")
        }

    });
}

/**
 * 获取所有的类别
 */
function getCateGoryOnLoad() {
    $.ajax({
        url: AppUrl + '/category/list',//跨域请求的URL
        data: {pageNum: 3, pageSize: 3},
        type: 'get',
        dataType: 'json',
        contentType: "application/json",
        success: function (data) {
            var categoryList = "<option  value='-1' >请选择</option>";
            $.each(data, function (name, item) { //循环得出“genusName”
                if (name == "content") {
                    $.each(item, function (cate_index, cate_obj) { //循环得出“genusName”
                        if (name == "content") {
                            categoryList += " <option  value='" + cate_obj.name + "'><label>" + cate_obj.name + "</label></option>";
                        }
                    });
                }

            });

            $("#file-root select").html(categoryList)

        },
        error: function (reason) {
            console.log(reason)
        }
    });
}


/**
 * 实时左右上下滚动同步
 */
function realTimeShow() {
    $("#text_textarea").scroll(function () {
        $("#neiring_show").scrollTop($(this).scrollTop()); // 纵向滚动条
        $("#neiring_show").scrollLeft($(this).scrollLeft()); // 横向滚动条
    });
    $("#neiring_show").scroll(function () {
        $("#text_textarea").scrollTop($(this).scrollTop());
        $("#neiring_show").scrollLeft($(this).scrollLeft());
    });
}

/**
 * 当键盘按下enter键的时候，重新渲染界面
 */
function enterUp() {
    $("#text_textarea").keyup(function () {
        if (event.keyCode == 13) {
            showTextFromLeft();
        }
    });
}

/**
 * 从左边显示内容到右边
 */
function showTextFromLeft() {
    var text = $("#text_textarea").val();
    var markdownCode = marked(text, {breaks: true});
    $("#neiring_show").html(markdownCode);
    // 重新渲染页面
    reHeightCode();
    var imageBasePath = $("#file-root-input").val();
    reImagePath(imageBasePath);
}

/**
 * 解决问题：因为图片都是相对路径，这里要改成绝对路径，不然找不到图片
 * @param name
 * @returns {*}
 */
function reImagePath(imageBasePath) {
    $("#neiring_show img").each(function () {
        var src = $(this).attr("src");
        $(this).attr('src', imageBasePath + src);
        // $(this).css("height", maxHeight);
        $(this).css("width", "1280px");
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
    $("#neiring_show pre code").each(function () {
        var code = $(this).text();
        var highCode = hljs.highlightAuto(code).value;
        $(this).html(highCode)
    });
}


/**
 * 控制界面左右显示
 * @type {boolean}
 */
var showFlag = true;

function hideShowTime() {

    if (showFlag) {
        $("#neiring_show").hide(1000);
        $("#neiring_show").css("display", "none");
        $("#neoring_add").css("width", "97%");
        showFlag = false;
    } else {
        $("#neiring_show").show(100);
        $("#neiring_show").css("display", "block");
        $("#neoring_add").css("width", "48%");
        showFlag = true;
    }
}


/***
 * 导入本地文件
 */
function inportLocalFile(node) {

    // 判断浏览器支不支持 这个对象
    if (!window.FileReader) {
        alert("Not supported by your browser!");
        return;
    }
    // 初始化 FileReader
    var oFReader = new FileReader();

    // 设置回调函数
    oFReader.onload = function (oFREvent) {
        document
            .getElementById("text_textarea")
            .innerHTML = oFREvent.target.result;
        // 显示数据
        showTextFromLeft();
    };

    // 读取本地文件
    loadFileText(oFReader);

}

/**
 * 读取文件为字符串
 * @param oFReader
 */
function loadFileText(oFReader) {
    if (document.getElementById("picpath").files.length === 0)
        return;
    var oFile = document
        .getElementById("picpath")
        .files[0];
    $("#title_text").val(oFile.name)
    oFReader.readAsText(oFile);
}

/**
 * 获取文件的路径不适用 ，安全问题无法获取
 * @param file
 * @returns {*}
 */
function getObjectURL(file) {
    var url = null;
    if (window.createObjectURL != undefined) { // basic
        url = window.createObjectURL(file);
    } else if (window.URL != undefined) { // mozilla(firefox)
        url = window.URL.createObjectURL(file);
    } else if (window.webkitURL != undefined) { // webkit or chrome
        url = window.webkitURL.createObjectURL(file);
    }
    return url;
}


/**
 * 点击发布文章
 */
function saveArticle() {
    showCateMessage();
}


//获取窗口的高度
var windowHeight;
//获取窗口的宽度
var windowWidth;
//获取弹窗的宽度
var popWidth;
//获取弹窗高度
var popHeight;

function showCateMessage() {
    getCateGory();
    popCenterWindow();
}

function init() {
    windowHeight = $(window).height();
    windowWidth = $(window).width();
    popHeight = $(".window").height();
    popWidth = $(".window").width();
}

//关闭窗口的方法
function closeWindow() {
    $("#window-title img").click(function () {
        $(this).parent().parent().hide("slow");
    });
}

//定义弹出居中窗口的方法
function popCenterWindow() {
    init();
    //计算弹出窗口的左上角Y的偏移量
    var popY = (windowHeight - popHeight) / 2;
    var popX = (windowWidth - popWidth) / 2;
    //设定窗口的位置
    $("#center").css("top", popY).css("left", popX).slideToggle("slow");
    closeWindow();
}

/**
 * 获取所有的类别
 */
function getCateGory() {
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
                    $.each(item, function (cate_index, cate_obj) { //循环得出“genusName”
                        if (name == "content") {
                            categoryList += "<input type=\"checkbox\" name=\"item\" value='" + cate_obj.id + "'><label>" + cate_obj.name + "</label>";
                        }
                    });
                }

            });

            $("#columns-list").html(categoryList)

        },
        error: function (reason) {
            console.log(reason)
        }
    });
}


/**
 * 多选的时候，显示选择的数据
 */
function selectCheckBox(check) {
    if (check.checked) {
        var valueItem = '';
        $("#columns-list input[type=checkbox]").each(function () {
            var value = $(this).val();      //获得值
            var name = $(this).attr("name");      //获得值
            // 这一点 按照上面的判断居然无效 check.checked
            var isChecked = $(this).is(':checked');
            // 如果已经勾选，而且值相等
            if (isChecked) {
                valueItem += "<span style='background:#bbccee;width: auto;height: 25px;margin-left: 4px;' onclick='removeCheckBox(this,\"" + value + "\")'>" + name + "</span>";
            }
        });
        $("#columns-select").html(valueItem);
    }
}

/**
 * 取消勾选
 * @param checked    当前节点
 * @param valueData  确定哪个是要去除勾选的
 */
function removeCheckBox(checked, valueData) {
    checked.remove();
    $("#columns-list input[type=checkbox]").each(function () {
        var value = $(this).val();      //获得值
        // 这一点 按照上面的判断居然无效 check.checked
        var isChecked = $(this).is(':checked');
        // 如果已经勾选，而且值相等
        if (isChecked && value == valueData) {
            // 取消勾选 .attr("checked",true); 方法不可用
            $(this).prop("checked", false);
        }
    });
}

/**
 * 点击取消连接
 * 此时调用 X 去点击 然后触发 点击事件
 */
function cancle() {
    $("#window-title img").click();
}

/**
 * 发布文章
 */
function releaseArticle() {
    var address = $("#file-root-input").val();
    var title_text = $("#title_text").val();
    var content = $("#text_textarea").val();
    var keys = $("#keys").val();
    var categoryIds = '';
    $("#columns-list input[type=checkbox]").each(function () {
        var value = $(this).val();      //获得值
        // 这一点 按照上面的判断居然无效 check.checked
        var isChecked = $(this).is(':checked');
        // 如果已经勾选
        if (isChecked) {
            categoryIds += value + ",";
        }
    });

    var articleType = $('#articleType input[name="articleTypes"]:checked').val();
    var modality = $('#modality input[name="modalitys"]:checked').val();
    var saveMethod = $('#saveMethod input[name="saveMethos"]:checked').val();

    var param = {
        'id': titleId,
        'title': title_text,
        'content': content,
        'keys': keys,
        'categoryIds': categoryIds,
        'articleType': articleType,
        'modality': modality,
        'saveMethod': saveMethod,
        'address': address
    };

    console.log(JSON.stringify(param))
    $.ajax({
        url: AppUrl + '/article/edit',//跨域请求的URL
        data: JSON.stringify(param),
        type: "POST",
        dataType: "json",
        contentType: "application/json;charset=UTF-8",
        success: function (data) {
            $("#window-title img").click();
        },
        error: function (reason) {
            console.log(reason)
        }
    });
}