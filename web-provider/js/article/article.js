//定义几个全局变量
var AppUrl = "http://localhost:8090";//整个页面的请求页面
// 图片的根路径
var imageBasePath = '';

$(document).ready(function () {
    loadArticeDetail();
});


function setEditUrl() {
    var titleId = getUrlParam("articleId");
    var editUrl = "./../../html/article/editArticle.html?articleId=" + titleId + "&imageBasePath=" + imageBasePath;
    $("#edit").attr('href', editUrl);
}


function loadArticeDetail() {
    var titleId = getUrlParam("articleId");
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
                    $("#title").html(item.title);
                    imageBasePath = item.imagePath;
                    var code = item.content;
                    var markdownCode = marked(code, {breaks: true})
                    $("#neoring").html(markdownCode);
                    // 重新渲染页面
                    reHeightCode();
                    reImagePath(imageBasePath);
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
 * 解决问题：因为图片都是相对路径，这里要改成绝对路径，不然找不到图片
 * @param name
 * @returns {*}
 */
function reImagePath(imageBasePath) {
    $("#neoring img").each(function () {
        var src = $(this).attr("src")
        $(this).attr('src', imageBasePath + src);
        // $(this).css("height", maxHeight);
        $(this).css("width", "1100px");
    });
}