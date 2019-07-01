<%@page import="entity.Product"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>

    <title>商品列表</title>
    <meta name="keywords" content="create from keywords">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" media="screen" href="css/style.css">
    <link rel="stylesheet" type="text/css" media="screen" href="css/div.css">
    <link rel="stylesheet" type="text/css" media="screen" href="menu/css/simple_menu.css">
    <script type="text/javascript" src="js/jquery.js"></script>
   	<style type="text/css">
   		img:HOVER{
   			transition:all 800ms ease-out;
			transform:rotate(360deg);
   		}
   	</style>
	<script type="text/javascript">
		function upNumber(ele){
			var result = document.getElementById(ele);
			if( result.value < 5 ){
				result.value = parseInt(result.value) +1;
			}
		}
		function downNumber(ele){
			var result = document.getElementById(ele);
			if(result.value > 1){
				result.value = parseInt(result.value) -1;
			}
		}
		
		function add(ID) {
			$.post("ProductServlet",{param:'collect',id:ID},function( result ){
				var msg = "";
				if(result=='null'){
					window.open("Login.jsp", "_top")
				}else if(result=='false'){
					msg = "<font color='#FF0000'>收藏夹已存在此商品！</font>"
				}else if(result=='true'){
					msg = "<font color='#FF8080'>收藏成功！</font>"
				}
				$(".dialog_msg:first").html(msg);
				$("#dialog").slideToggle('fast');
				window.setTimeout("hide_dialog()", 2000);
			});
		}
		
		function hide_dialog() {
			$("#dialog").slideToggle();
		}
	</script>
</head>

<body>
		<c:if test="${empty cookie.user }">
			欢迎来到坑爹商城！若想入坑，<a href='Login.jsp'>请登录</a>或<a href="addName.jsp">注册</a>
		</c:if>
		<c:if test="${not empty cookie.user }">
			早上好!${cookie.user.value }
			<a href="ProductServlet?param=showCollect">收藏夹</a>
			<a href="UsersServlet?param=out">注销</a>
		</c:if>
		<hr />
		
		<c:if test="${empty sessionScope.goods }">
			<h2><font color="red">商城内部错误!</font></h2>
			<a href='Login.jsp'>请登录</a>
		</c:if>
   <div id="dialog">
		<span class="dialog_msg">
				
		</span>
   </div>
   <div class="header">
	   
       <ol id="menu">
	        <li class="active_menu_item"><a href="home.jsp">首页</a></li>
	        
	        <li><a href="goods.jsp">全部商品</a></li>
	        
	        <li><a href="ProductServlet?param=Shop">购物车</a></li>
	              
	        <li><a href="ProductServlet?param=Indent">订单</a></li>
	        
	        <li><a href="about.jsp">关于我们</a></li>       
      </ol>
   </div>
    
    <div id="container"> 
		<div id="prod_wrapper">
    		<div class="heading_bg" style="background: url(img/heading_bg.png) repeat-x 0 30px; width: 931px; line-height:30px;"><h1>全部商品</h1></div>
				<c:forEach var="pro" items="${sessionScope.goods }">
					<div class="one-third">
						<div class="heading_bg" style="background: url(img/heading_bg.png) repeat-x 0 30px;">
							<h2>${pro.value.id }</h2>
						</div>
						<form action="ProductServlet?param=buy&id=${pro.value.id }" method="post">
							<img src="${pro.value.img }" alt="image description" />
							<ul class="post_meta" style="margin:0">
						    	<li class="post_meta_admin">${pro.value.name }</li>
						    	<li class="post_meta_date">${pro.value.money }</li>
							</ul>
								${pro.value.describe }<p />
								<a href="javascript:downNumber('${pro.value.id }')" style="padding: 30px; display: inline;">-</a>
								<input type="text" id="${pro.value.id }" size="3" value="1" name="admin" readonly="readonly" style="padding: 0px; display: inline;">
								<a href="javascript:upNumber('${pro.value.id }')" style="padding: 00px 30px;">+</a>
								（最大数量5件）<br />
								<input type="submit" value="加入收藏" style="margin-left: 200px" formaction="javascript:add('${pro.value.id }')">
								<input type="submit" value="加入购物车" style="margin-left: 220px">
						</form>	
					</div>
				</c:forEach>
		</div>
		<div id="foot" style="margin-top: 1150px;">
			<pre>
			     版权所有：坑爹公司
			     地址：告诉你还得了
			     咨询热线：110
			  CopyRight (&copy;) 2014-2024  坑爹公司 粤ICP备123456789号
			</pre>
 	 	</div>
	</div>
</body>
</html>
