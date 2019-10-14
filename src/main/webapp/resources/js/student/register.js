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
    var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;

    if(name==null||name==''){
      mui.alert("真实姓名不能为空");
      return;
    }

    if(phone==null||phone==''){
      mui.alert("手机号码不能为空");
      return;
    }
    if(password==null||password==''){
      mui.alert("密码不能为空")
      return;
    }

    if(passwordConfirm==null||passwordConfirm==''){
      mui.alert("确认密码不能为空");
      return;
    }

    // 判断手机号码是否合法
    if (!myreg.test(phone)) {
      mui.alert("手机号码不合法，请输入正确的手机号码")
      return;
    }
    if(password!=passwordConfirm){
      mui.alert("密码不一致");
      return ;
    }
    var student={
      studentName:name,
      studentPhone:phone,
      studentPassword:password
    }
    register(student);
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