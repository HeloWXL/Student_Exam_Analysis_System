$(function () {
  if('${student}'!=''){
    var studentId  ='${student.studentId}';
    $('#submit').click(function () {
      var btn = ['否', '是'];
      mui.confirm('确认交卷？','提示',btn,function() {
        if (e.index == 1) {
          //获取试卷ID
          var paperId =$('#paperId').val();
          //填空题答案
          var completionString = '';
          //选择题答案
          var selectString = '';
          //获取填空题的值 已经填入的值
          var $input = $('input[type=\'text\']');//这里遍历input不为button和hidden的以外的其他input内容

          //获取选择的总数量
          var $completionTitle = $('.completionTitle');
          //比较填空题数量和答案数量比较
          if($input.length == $completionTitle.length){
            $.each($input, function (i, item) {
              var val = $(item).val();
              completionString+=val+',';
            });
          }else{
            mui.alert('填空未完成');
            return ;
          }




          //获取选择的总数量
          var $selectTitle = $('.selectTitle');
          //获取选择题 已经选择列表
          var $li = $('.mui-table-view-cell.mui-selected');
          if($selectTitle.length==$li.length){
            $.each($li, function (i, item) {
              var val = $(item).attr('value');
              selectString+=val+',';
            });
          }else{
            mui.alert('选择未完成');
          }


          var answer = {
            selectAnswer:selectString,
            completionAnswer:completionString,
            studentId:studentId,
            paperId:paperId
          };


          $.ajax({
            url:ctx+'/answer/insertAnswer',
            data:JSON.stringify(answer),
            dataType:'json',
            type:'post',
            contentType: 'application/json; charset=utf-8',
            success:function (data) {
              if(data==1){
                mui.alert('提交成功',function () {
                  location.href=ctx+'/student/toReport/'+paperId+'/'+studentId;
                });
              }else{
                mui.alert('提交失败');
              }
            }
          });
        } else {
          mui.closeAll();
        }
      });



    });
  }else{
    location.href=ctx+'/student/toLogin';
  }
});
