if($('#msg').val()!=""){
    tankuan();
}

function tankuan(){
    layui.use(['layer','jquery','form','carousel','element','upload'],function() {
        var layer = layui.layer;//弹出层组件
        var form = layui.form;//表单组件
        var element = layui.element;
        var carousel = layui.carousel;//轮播组件
        var $ = layui.jquery;//jquery
        var upload = layui.upload;// 文件上传组件
        var error = "错误~";

        //提示密码错误
        if($('#msg').val()!=""){
            var str='${msg}';
            msg(str);
        }

    })
    //设置弹框提示
    function msg(str, icon, offset) {
        str = str == null ? "没有内容" : str;
        offset = offset == null ? "20px" : offset;
        if (icon == null || icon == "") {
            return layer.msg(str, {offset: offset});
        } else {
            return layer.msg(str, {icon: icon}, {offset: offset});
        }
    }
}
