<%@page import="servlet.UsersServlet"%>
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
	<link rel="stylesheet" href="css/div.css" type="text/css" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<title>修改密码</title>
	<script type="text/javascript">
		function pass() {
			var username = $("#username").val();
			var password = $("#password").val();
			var pwd = $("#pwd").val();
			$.post("UsersServlet",{param:"pass",username:username,password:password,pass:pwd},function( result ){
				var msg = "";
					if(result=="false"){
						msg = "<font color='red'>用户名不存在或原密码错误！</font>"
						$(".dialog_msg:first").html(msg);
						$("#dialog").slideDown("fast",function(){
							window.setTimeout("hide()", 2000);
						});
					}else{
						msg = "<font color='greed'>修改成功！</font>"
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
	</head>
	<body>
		<div id="dialog">
			<span class="dialog_msg">
				
			</span>
	   </div>
		<form action="" method="post">
			<table border="0" cellpadding="0" cellspacing="0" align="center" style="padding-top:200px;">
				<tr>
					<td colspan="2" align="center"><h3>欢迎来到丑翔的修改密码页面！</h3></td>
				</tr>
                <tr>
                	<td>用户名：</td>
                    <td><input type="text" name="username" pattern="^[a-zA-Z0-9]{1,20}$" placeholder="请输入用户名" required
                   title="用户名格式为：1-20长度的字符串，其中可包含数字" id="username"></td>
                </tr>
                <tr>
                	<td>原密码：</td>
                    <td><input type="password" name="password" pattern="^[a-zA-Z0-9]{3,20}$" placeholder="请输入原密码" required
                   title="密码格式为：3-20长度的字符串，其中可包含数字" id="password"></td>
                </tr>
                <tr>
                	<td>新密码：</td>
                    <td><input type="password" name="pass" pattern="^[a-zA-Z0-9]{3,20}$" placeholder="请输入新密码" required
                   title="密码格式为：3-20长度的字符串，其中可包含数字" id="pwd"></td>
                </tr>
                <tr align="center">
                    <td colspan="2"><input type="submit" value="提交" formaction="javascript:pass()"></td>
                </tr>
			</table>
		</form>
	</body>
</html>
