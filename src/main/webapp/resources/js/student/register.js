mui.init()
$(function () {

  document.addEventListener("touchmove",function(e){
    e.preventDefault();
    e.stopPropagation();
  },false);


  $("#register").click(function () {
    var name = $.trim($("input[name='name']").val());
    var phone = $.trim($("input[name='phone']").val());
    var password = $.trim($("input[name='password']").val());
    var passwordConfirm = $.trim($("input[name='passwordConfirm']").val());

    if(password!=passwordConfirm){
      mui.alert("密码不一致")
    }else{
      var student={
        studentName:name,
        studentPhone:phone,
        studentPassword:password
      }
      register(student);
    }
  })
})
//登录函数
function register(student) {
  $.ajax({
    url:ctx+'/student/insertStudent',
    data:JSON.stringify(student),
    dataType:'json',
    type:'post',
    contentType:'application/json;charset=UTF-8',
    success:function (data) {
      console.log(data)
      if(data==1){
        mui.alert("注册成功",function () {
          location.href=ctx+'/student/toLogin';
        })
      }else{
        mui.alert("注册失败",function () {
          $("input[name='name']").val('');
          $("input[name='phone']").val('');
          $("input[name='password']").val('');
          $("input[name='passwordConfirm']").val('');
        })
      }
    },error:function (e) {
      mui.alert("服务起内部错误")
    }
  })
}