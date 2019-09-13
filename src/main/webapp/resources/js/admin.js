/**
* 全局js
* @Author MrLiu
*/
layui.use(['layer','jquery','form','carousel','element','upload'],function(){
	var layer = layui.layer;//弹出层组件
	var form = layui.form;//表单组件
	var element = layui.element;
	var carousel = layui.carousel;//轮播组件
	var $ = layui.jquery;//jquery
	var upload = layui.upload;// 文件上传组件
	var error = "错误~";
	
	// 初始化页面
	msg("LeoAdmin 欢迎你");
	// 初始化提示消息
	function msg(str,icon,offset){
		str = str == null ? "没有内容" : str;
		offset = offset == null ? "20px" : offset;
		if(icon == null || icon == ""){
			return layer.msg(str,{offset:offset});
		}else{
			return layer.msg(str,{icon:icon},{offset:offset});
		}
	}
	// 控制台输出方法
	function l(object,alias){
		var agmlen = arguments.length;
		true === alias ? layer.closeAll() : alias ;
		for(var i = 0;i < agmlen;i++){
			console.log("[type => "+typeof arguments[i]+",content => "+arguments[i]+"]");
		}
	}
	// 删除节点
	function remove_dom(object){
		var agmlen = arguments.length;
		for (var i = 0; i < agmlen; i++) {
			if(typeof arguments[i] == "object" && arguments[i] != "undefined"){
				arguments[i].remove();
			}
		}
	}
	// 阻止冒泡事件
	function stopPropagation(e) {
        var ev = e || window.event;
        if (ev.stopPropagation) {
            ev.stopPropagation();
        } else if (window.event) {
            window.event.cancelBubble = true;//兼容IE
        }
    };
    // 自定义绑定事件方法
    function bf(dom,fn,type,child) {
		if(typeof dom == 'object' && dom != 'undefined'){
			type = type == null ? "click" : type;
			if(child != "" && child != 'object'){
				return dom.on(type,child,fn);
			} else {
				return dom.on(type,fn);
			}
		}
	};
	// 遮罩层
	function shade(dom,load){
		if(load == true){
			var shade = "<div class=\"tpl-shade\" style=\"display: block;\"><div><i class=\"fa fa-star-o shade-load\"></i></div></div>";
		}else{
			var shade = "<div class=\"tpl-shade\" style=\"display: block;\"></div>";
		}
		return dom.append(shade);
	};
	// 播放视频处理
	function do_play(src,dom){
		
		var html = "";
		html += "<div class=\"tpl-layer\"><div class=\"tpl-layer-content\">";
		html += "<a href=\"javscript:;\" class=\"video-close\" id=\"close\">x</a>";
		html += "<video controls>";
		html += "<source src=\""+src+"\"  type=\"video/mp4\">";
		html += "您的浏览器不支持 HTML5 video 标签。";
		html += "</video></div></div>";
		dom.append(html);
		return true;
	}
	bf($(".test1"),function(){
		l("郭敏是傻子");
	},"click");
	// 收放导航列表
	bf($(".switch-list"),function(){
		var ans = "";
		if($(this).children("i").hasClass("fa-hand-o-left")){
			$(this).children("i").removeClass("fa-hand-o-left");
			$(this).children("i").addClass("fa-hand-o-right");
		}else{
			$(this).children("i").removeClass("fa-hand-o-right");
			$(this).children("i").addClass("fa-hand-o-left");
		}
		if ($(".tm-tpl").hasClass("small-item")){
			$(".tm-tpl").removeClass("small-item");
			ans = 2;
		} else {
			$(".tm-tpl").addClass("small-item");
			ans = 1;
		}
		// 保持操作状态
		$.ajax({ 
			url:"../index/view",
			type:"post",
			datatype:"json",
			data:{
				left_item:ans
			},
			success:function(data){
				l(data);
			}
		})
	});
	// 刷新页面
	bf($(".refresh"),function(){
		window.location.reload();
	});
	// 呼出右侧列表
	bf($(".dashboard,.user"),function(e){
		var bar = $(this).attr("tag");
		if($(".right-bar").hasClass(bar)){
			remove_dom($(".right-bar").find($(".tpl-shade")));
			if ($("."+bar).css("right") == "-1500px"){
				$(".right-bar").css("right","-1500px");
				$("."+bar).css("right",0);
				$(".tpl-body").css("overflow","hidden");
			} else {
				$("."+bar).css("right","-1500px");
				$(".tpl-body").css("overflow","auto");
			}
			// shade($("."+bar).find(".right-bar-fluid"),true);
			stopPropagation(e);
		}else{
			msg("配置的tag目标为空");
		}
	});
	bf($(".right-bar"),function(e){
		stopPropagation(e);
	});
	// 页面的点击冒泡
	bf($(document),function(){
		$(".right-bar").css("right","-1500px");
		
	})
	// 点击更换页面主题
	bf($("#style-list"),function(e){
		var style = $(this).attr("data-style");
		var styleName = $(".tm-tpl").attr("style-name");
		$(".tm-tpl").removeClass(styleName);
		$(".tm-tpl").attr("style-name",style);
		$(".tm-tpl").addClass(style);
		$.ajax({ //使用服务器端session保存操作
			url:"../index/view",
			type:"post",
			datatype:"json",
			data:{
				stylename:style // 传递到后台，用session保存即可
			},
			success:function(data){
				l(data);
			}
		});
		stopPropagation(e);
	},"click","li");
	// 退出登录
	bf($(".logout"),function(){
		msg("退出成功");
		$.ajax({
			url:"../user/logout",
			type:"post",
			success:function(data){
				window.location.href = "../user/login";
			}
		})
	})
	// 轮播图实例
	carousel.render({
	    elem: '#carousel_1',
	    width: '100%', //设置容器宽度
	    arrow: 'always' //始终显示箭头 详细请参考layui文档
	});
	// 点击播放
	bf($(".play"),function(){
		do_play($(this).attr("data-src"),$(".tm-tpl"));//获取视频地址，弹出窗口准备播放
	});
	// 关闭播放
	bf($(".tm-tpl"),function(){
		// l(this);
		remove_dom($(".tpl-layer"),$(".tpl-shade"));//删除播放窗口和遮罩层
	},"click","#close");
	
	// 左侧工具栏
	bf($(".sidebar-footer a"),function(){
		var title = $(this).attr("data-title");
		var tips = $(".tm-tpl").hasClass("small-item") ? 2 : 1;
		layer.tips(title,$(this),{tips:tips});
	},"mouseover");
	// 卡片提示
	bf($(".tpl-icon-tips"),function(){
		var title = $(this).attr("data-title");
		layer.tips(title,$(this),{tips:1});
	});
	bf($(".user-tips a"),function(){
		var tip = $(this).attr("data-tips");
		layer.tips(tip,$(this),{tips:1});
	})
	// 通用的返回上一页方法
	bf($(".back"),function(){
		window.history.back();
	});
	// 删除权限规则
	bf($(".auth_delete"),function(){
		var id = $(this).parent().attr("data-id"),tag = $(this);
		layer.load(1);
		$.ajax({
			url:"../auth/delete",
			type:"post",
			data:{
				del_id:id
			},
			success:function(data){
				layer.closeAll("loading");
				if(data.status == 1){
					window.location.reload();
				}
				msg(data.msg);
			},
			error:function(){
				layer.closeAll("loading");
				l(error);
			}
		})
	});
	// 删除权限组
	bf($(".delrule"),function(){
		var id = $(this).parent().attr("data-id"),tag = $(this);
		layer.load(1);
		$.ajax({
			url:"../auth/delrule",
			type:"post",
			data:{
				delid:id
			},
			success:function(data){
				layer.closeAll("loading");
				if(data.status == 1){
					remove_dom(tag.parent().parent());
				}
				msg(data.msg);
			},
			error:function(){
				layer.closeAll("loading");
				msg(error);
			}
		})
	});
	bf($(".update-password"),function(){
		$(this).hide();
		$(".dit-update-password").show();
		$(this).parent().children("input[name='password']").removeAttr("disabled");
		$(this).parent().children("input[name='password']").attr("required","");
		$(".pwd1").find("input[name='password1']").removeAttr("disabled");
		$(".pwd1").find("input[name='password1']").attr("required","");
		$(this).parent().children("input[name='password']").removeClass("layui-disabled");
		$(".pwd1").show();
	});
	bf($(".dit-update-password"),function(){
		$(this).hide();
		$(".update-password").show();
		$(".pwd1").find("input[name='password1']").attr("disabled","");
		$(this).parent().children("input[name='password']").attr("disabled","");
		$(this).parent().children("input[name='password']").val("");
		$(this).parent().children("input[name='password']").addClass("layui-disabled");
		$(".pwd1").find("input[name='password1']").removeAttr("required");
		$(this).parent().children("input[name='password']").removeAttr("required");
		$(".pwd1").hide();
	});
	// 删除用户
	bf($(".delete-user"),function(){
		var id = $(this).parent().attr("data-id"),tag = $(this);
		$.ajax({
			url:"../auth/delete_user",
			type:"post",
			datatype:"json",
			data:{
				id:id
			},
			success:function(data){
				layer.closeAll("loading");
				if(data.status == 1){
					remove_dom(tag.parent().parent());
				}
				msg(data.msg);
			},
			error:function(){
				layer.closeAll("loading");
			}
		})
	});
	var old_img = null;
	bf($(".user-upload"),function(){
		old_img = "";
		old_img += $(this).attr("src");
	});
	var userImg = upload.render({
		elem: '.user-upload', //绑定元素
		url: '../upload/user_upload', //上传接口
		accept: 'file',
		exts: 'jpg|png|jpeg|gif', //只允许上传压缩文件
		choose: function(obj){
			shade($(".user-bar").find(".right-bar-fluid"),true);
		},
		done: function(res){
			$(".user-upload").attr("src",res.data);
			$.ajax({
				url: '../user/save_img', //上传接口
				type:"post",
				datatype:"json",
				data:{
					img:res.data,
					old_img:old_img
				},
				success:function(data){
					remove_dom($(".right-bar").find($(".tpl-shade")));
				}
			})
		}
	});
})
	