<%@page import="entity.Product"%>
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>

    <title>购物车</title>
    <meta name="keywords" content="create from keywords">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<!-- CSS Files -->

    <link rel="stylesheet" type="text/css" media="screen" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/div.css" />
    <link rel="stylesheet" type="text/css" media="screen" href="menu/css/simple_menu.css">
    <script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/Shop.js"></script>
	<script type="text/javascript">
		function submitData(NO){
		var num = document.getElementById(NO);
		window.location="ProductServlet?param=buy&num=" + num.value;
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
    		<div class="heading_bg" style="background: url(img/heading_bg.png) repeat-x 0 30px; width: 931px; line-height:30px;"><h1>购物车</h1></div>
    		<table id="order-table">
				<tr>
					<th>商品ID</th>
					<th>数量</th>
					<th>X</th>
					<th>单价</th>
					<th>=</th>
					<th style="text-align: left;">总计</th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
		<c:set var="pay" scope="page" value="0"></c:set>
		<c:forEach var="pro" items="${sessionScope.shop }">
				<form action="ProductServlet?param=del&id=${pro.value.SID }" method="post">
					<tr class="odd">
						<td class="product-title">${pro.value.SName }</td>
						<td class="num-pallets">
							<input type="text" class="num" value="${pro.value.SNumber }" name="num" id="${pro.value.SID }">
						</td>
						<td class="times">X</td>
						<td class="money">$<span>${pro.value.money }</span></td>
						<td class="equals">=</td>
						<td class="money_td">
							<input type="text" class="money_input" id="turface-pro-league-row-total" disabled="disabled" value="${pro.value.money*pro.value.SNumber}">
						</td>
						<td>
							<input type="submit" value="删除"/>
						</td>
						<td>
							<input type="submit" value="确认购买" formaction="ProductServlet?param=tobuy&id=${pro.value.SID }"/>
						</td>
						<td>
							<input type="submit" value="修改数量"  formaction="javascript:num('${pro.value.SID }')" />
						</td>
					</tr>
				<c:set var="pay" scope="page" value="${pay+pro.value.SNumber*pro.value.money}"></c:set>
				</form>
		</c:forEach>
					<tr>
						<td colspan="9" style="padding-left: 72%;">产品小计:
							<input type="text" class="total-box" id="money_td" disabled="disabled" style="margin-left: 0%;" value="${pay}"></input>
						</td>
					</tr>
			</table>
		</div>
	</div>
	<div id="foot" style="margin-top: auto;">
		<pre>
			版权所有：坑爹公司
			地址：告诉你还得了
			咨询热线：110
			CopyRight (&copy;) 1970-2020  坑爹公司 粤ICP备123456789号
		</pre>
 	</div>
</body>
</html>

