<%@page import="servlet.UsersServlet"%>
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html dir="ltr" lang="en-US">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
	<title>登录</title>
	<link rel="stylesheet" href="css/Login.css" type="text/css" />
	<link rel="stylesheet" href="css/div.css" type="text/css" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
		function login() {
			var time = $("#time").val();
			var username = $("#username").val();
			var password = $("#password").val();
			$.post("UsersServlet",{param:'login',username:username,password:password,time:time},function( result ){
				var msg = "";
					if(result=="false"){
						msg = "<font color='red'>用户名或密码错误！</font>"
						$(".dialog_msg:first").html(msg);
						$("#dialog").slideDown("fast",function(){
							window.setTimeout("hide()", 2000);
						});
					}else{
						msg = "<font color='greed'>登录成功！</font>"
						$(".dialog_msg:first").html(msg);
						$("#dialog").slideDown("fast",function(){
							window.setTimeout("hide_dialog()", 1000);
						});
					}
			});
		}
		
		function hide(){
			$("#dialog").slideToggle()
		}
		
		function hide_dialog() {
			$("#dialog").slideUp(200,function(){
				window.location.href="index.jsp";
			});
		}
		
	</script>
	</head>

	<body>
		<div id="dialog">
			<span class="dialog_msg">
				
			</span>
		</div>
		<div id="container">
			<form action="" method="post">
				<div class="login">登录</div>
				<div class="username-text">用户名:</div>
				<div class="password-text">密码:</div>
				<div class="username-field">
					<input type="text" id="username" pattern="^[a-zA-Z0-9]{1,20}$" placeholder="请输入用户名" required
                   title="用户名格式为：1-20长度的字符串，其中可包含数字" value="${cookie.user.value }"/>
				</div>
				<div class="password-field">
					<input type="password" id="password" pattern="^[a-zA-Z0-9]{3,20}$" placeholder="请输入密码" required
                   title="密码格式为：3-20长度的字符串，其中可包含数字"/>
				</div>
				<input type="checkbox" name="time" id="time" value="${60*60*24*30 }" /><label for="time">记住我30天</label>
				<div class="forgot-usr-pwd"><a href="Password.jsp">忘记密码？</a>&nbsp&nbsp<a href="addName.jsp">注册</a></div>
				<input type="submit" name="submit" value="GO" formaction="javascript:login()">
			</form>
		</div>
	</body>
</html>
