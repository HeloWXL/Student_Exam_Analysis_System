$(function() {
  $('#submit').click(function(e) {
    e.preventDefault();
    var phone = $.trim($('input[name=\'phone\']').val());
    var password = $.trim($('input[name=\'password\']').val());
    var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;

    if(phone==null||phone==''){
      mui.alert("手机号码不能为空")
      return;
    }
    if(password==null||password==''){
      mui.alert("密码不能为空");
      return ;
    }
    // 判断手机号码是否合法
    if (!myreg.test(phone)) {
      mui.alert("手机号码不合法，请输入正确的手机号码")
      return;
    }
    //登陆的时候先判断 该手机号码是否已经注册过
    hasPhone(phone, password);
  });
});

//判断手机号吗是否已注册
function hasPhone(phone, password) {
  $.ajax({
    url: '/demo/student/selectStudentByPhone',
    data: {phone: phone},
    dataType: 'json',
    type: 'post',
    success: function(data) {
      if (data == false) {
        mui.alert('该手机号码未注册');
      } else {
        checkLogin(phone, password);
      }
    }, error: function(e) {
      mui.alert('服务器内部错误');
    }
  });
}
//登录
function checkLogin(phone, password) {
  $.ajax({
    url: '/demo/student/checkLogin',
    data: {phone: phone, password: password},
    dataType: 'json',
    type: 'post',
    success: function(data) {
      if (data.data == 'true') {
        location.href = ctx + '/student/toIndex';
      } else {
        mui.alert('手机号码或密码错误', function() {
          $('input[name=\'password\']').val('');
        });
      }
    }, error: function(e) {
      mui.alert('服务器内部错误');
    }
  });
}
