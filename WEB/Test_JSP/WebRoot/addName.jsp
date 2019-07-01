<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html dir="ltr" lang="en-US">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
	<title>注册</title>
	<link rel="stylesheet" href="css/Login.css" type="text/css" />
	<link rel="stylesheet" href="css/div.css" type="text/css" />
	<script type="text/javascript" src="js/jquery.js"></script>
	</head>
	<script type="text/javascript">
		function Add() {
			var username = $("#username").val();
			var password = $("#password").val();
			$.post("UsersServlet",{param:"add",username:username,password:password},function( result ){
				var msg = "";
					if(result=="false"){
						msg = "<font color='red'>用户名已存在！</font>"
						$(".dialog_msg:first").html(msg);
						$("#dialog").slideDown("fast",function(){
							window.setTimeout("hide()", 2000);
						});
					}else{
						msg = "<font color='greed'>注册成功！</font>"
						$(".dialog_msg:first").html(msg);
						$("#dialog").slideDown("fast",function(){
							window.setTimeout("hide_dialog()", 2000);
						});
					}
			});
		}
		
		function hide(){
			$("#dialog").slideToggle()
		}
		
		function hide_dialog() {
			$("#dialog").slideUp(200,function(){
				window.location.href="Login.jsp";
			});
		}
		
	</script>
	<body>
		<div id="dialog">
			<span class="dialog_msg">
					
			</span>
	   </div>
		<div id="container">
			<form action="" method="post">
				<div class="login">注册</div>
				<div class="username-text">用户名:</div>
				<div class="password-text">密码:</div>
				<div class="username-field">
					<input type="text" name="username" pattern="^[a-zA-Z0-9]{1,20}$" placeholder="请输入用户名" required
                   title="用户名格式为：1-20长度的字符串，其中可包含数字" id="username"/>
				</div>
				<div class="password-field">
					<input type="password" name="password" pattern="^[a-zA-Z0-9]{3,20}$" placeholder="请输入密码" required
                   title="密码格式为：3-20长度的字符串，其中可包含数字" id="password"/>
				</div>
				<input type="checkbox" name="remember-me" id="remember-me" /><label for="remember-me">同意服务条款</label>
				<input type="checkbox" name="remember" id="remember" /><label for="remember">你真的确定要同意服务条款？</label>
				<input type="submit" name="submit" value="GO" formaction="javascript:Add()"/>
			</form>
		</div>
	</body>
</html>
