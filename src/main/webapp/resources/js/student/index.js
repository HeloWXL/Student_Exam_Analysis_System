$(function () {
    if('${student}'==''){
        location.href=ctx+"/student/toLogin";
        return ;
    }
    $.ajax({
        url:ctx+'/test/getTestAdmin',
        dataType:'json',
        type:'get',
        success:function (data) {
            for(var i = 0 ;i<data.length;i++){
                $node = $('<a href="/demo/student/getPaperByList/'+data[i].testId+'">\n' +
                    '<div class="mui-card">\n' +
                    '\t<!--页眉，放置标题-->\n' +
                    '\t<div class="mui-card-header"><p>考试名称：<span style="color: #000000;">'+data[i].testName+'</span></p></div>\n' +
                    '\t<!--内容区-->\n' +
                    '\t<div class="mui-card-content"><img src="/demo/resources/images/logo.png" /></div>\n' +
                    '\t<!--页脚，放置补充信息或支持的操作-->\n' +
                    '\t<div class="mui-card-footer"><p>发布时间：<span>'+data[i].createTime+'</span></p></div>\n' +
                    '</a>\n' +
                    '</div>')
                $("#content").append($node);
            }
        }
    })

})