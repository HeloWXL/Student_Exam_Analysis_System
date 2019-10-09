$(function() {
  $('#submit').click(function() {
    var phone = $.trim($('input[name=\'phone\']').val());
    var password = $.trim($('input[name=\'password\']').val());
    //登陆的时候先判断 该手机号码是否已经注册过
    hasPhone(phone, password);
  });
});

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
