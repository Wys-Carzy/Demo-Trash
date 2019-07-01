<%@page import="entity.Product"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>

    <title>收藏</title>
    <meta name="keywords" content="create from keywords">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<!-- CSS Files -->

    <link rel="stylesheet" type="text/css" media="screen" href="css/style.css">
    <link rel="stylesheet" type="text/css" media="screen" href="menu/css/simple_menu.css">
	<style type="text/css">
   		img:HOVER{
   			transition:all 800ms ease-out;
			transform:rotate(360deg);
   		}
   	</style>
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
    		<div class="heading_bg" style="background: url(img/heading_bg.png) repeat-x 0 30px; width: 931px; line-height:30px;"><h1>收藏夹</h1></div>
				<c:forEach var="pro" items="${sessionScope.showCollect }">
					<div class="one-third">
						<div class="heading_bg" style="background: url(img/heading_bg.png) repeat-x 0 30px;">
							<h2>${pro.value.SID }</h2>
						</div>
						<form action="ProductServlet?param=buy&id=${pro.value.SID }" method="post">
							<img src="${pro.value.img }" alt="image description" />
							<ul class="post_meta" style="margin:0">
						    	<li class="post_meta_admin"></li>
						    	<li class="post_meta_date"></li>
							</ul>
								商品单价：${pro.value.money }
								<input type="submit" value="删除" formaction="ProductServlet?param=delCollect&id=${pro.value.SID }" style="margin-left: 200px">
								<input type="submit" value="立即购买" style="margin-left: 220px">
						</form>	
					</div>
				</c:forEach>
		</div>
			<div id="foot" style="margin-top: 1150px;">
			  <pre>
			     版权所有：坑爹公司
			     地址：告诉你还得了
			     咨询热线：110
			  CopyRight (&copy;) 1970-2020  坑爹公司 粤ICP备123456789号
			 </pre>
 	 		</div>
	</div>
</body>
</html>
