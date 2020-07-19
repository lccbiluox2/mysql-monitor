//定义几个全局变量
var AppUrl = "http://localhost:8090";//整个页面的请求页面



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