<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>首页</title>
    <meta name="keywords" content="create from keywords">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" media="screen" href="css/style.css">
    <link rel="stylesheet" type="text/css" media="screen" href="menu/css/simple_menu.css">
	<script src="js/jquery.tools.min.js" type="text/javascript"></script>
    <style type="text/css">
   		img:HOVER{
   			transition:all 800ms ease-out;
			transform:rotate(360deg);
   		}
   	</style>
    <script type="text/javascript">
        $(function() {
        $("#prod_nav ul").tabs("#panes > div", {effect: 'fade', fadeOutSpeed: 400});
    });
    </script>
    
    <script type="text/javascript">
            $(document).ready(function(){
            $(".pane-list li").click(function(){
            window.location=$(this).find("a").attr("href");return false;
        });
    
    });
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
	
		    <div id="panes">
			    <c:forEach var="pro" items="${sessionScope.goods }">
				    <div>
				    	<img src="${pro.value.img }" alt="demo" height="300" />				
				    	<h5>${pro.value.name }</h5>
				        <p>${pro.value.describe }</p>
				    	<p style="text-align:right; margin-right: 16px"> <a href="goods.jsp" class="button">购买</a></p>	
				    </div>
			    </c:forEach>
		    </div> 
		</div>
	
		<br clear="all" />
	
		<div id="prod_nav">
			<ul>
			
				<li><a href="#1"><img src="./img/picture/iPad.jpg" alt="demo"/><strong>iPad</strong>3599</a></li>
				
				<li><a href="#2"><img src="./img/picture/Z2.jpg" alt="demo"/><strong>Z2</strong>3999</a></li>
				
				<li><a href="#3"><img src="./img/picture/iPhone5S.jpg" alt="demo" /><strong>iPhone5S</strong>4599</a></li>
				
				<li><a href="#4"><img src="./img/picture/MX3.jpg" alt="demo" /><strong>MX3</strong>1799</a></li>
				
				<li><a href="#5"><img src="./img/picture/mi3.jpg" alt="demo" /><strong>MI3</strong>1999</a></li>
			
			</ul>
		</div>
		<div id="foot" style="margin-top: 5px;">
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