<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>

    <title>关于</title>
    <meta name="keywords" content="create from keywords">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <link rel="stylesheet" type="text/css" media="screen" href="css/style.css">
    <link rel="stylesheet" type="text/css" media="screen" href="menu/css/simple_menu.css">

	<script src="js/jquery.tools.min.js" type="text/javascript"></script>
        
    <script type="text/javascript">
        $(function() {
        	$("#prod_nav ul").tabs("#panes > div", {effect: 'fade', fadeOutSpeed: 400});
    	});
    	
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
		    	<div>			
				        <p>此功能是摆设！乱点什么回去买东西去！</p>
		   		</div>
		    </div> 
		</div>
		
		<br clear="all" />
		
		<div id="prod_nav">
			<ul>
				<li><a href="#5"><strong>摆设</strong></li>
			</ul>
		</div>
		
		
	</div>
		<div id="foot"  style="margin-top: auto;">
			<pre>
				     版权所有：坑爹公司
				     地址：告诉你还得了
				     咨询热线：110
				  CopyRight (&copy;) 1970-2020  坑爹公司 粤ICP备123456789号
         	</pre>
	 	 </div>
</body>
</html>