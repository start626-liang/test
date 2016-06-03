<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8" isELIgnored="false"%>
 
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
  <head>
	<!--声明当前页面的编码集-->
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
	<!--当前页面的三要素-->
	<meta name="Keywords" content="关键词,关键词">
	<meta name="description" content="">
	<title>Document</title>
	<link rel="stylesheet" href="css/style.css">
	
	<script src="js/jquery-1.8.3.min.js"></script>
	<style>
		*{margin:0;padding:0;}
		.form{position:absolute;top:10px;width:70%;right:10px;}
		.form p{margin-bottom:20px;}
		.submit{text-align:center;}
	</style>
	
  </head>
  <body>		 
 	  <jsp:include page="left.jsp" />
		<div class="form">		 	
		 	<form action="save" method="post">
		 		<p>
		 			类型：
					<select name="product.type">
						<option value="JAVA">JAVA</option>
						<option value="SQL">SQL</option>
						<option value="Other">Other</option>
					</select>
				</p>
				<p>名称：<input type="text" name="product.name" value="" maxlength="50" size="50"  placeholder="请填写" required ></p>
				    
				 <p>内容：<textarea name="product.content" rows="30" cols="60" wrap="hard" placeholder="请填写" required></textarea></p>
				 <p class="submit"><input type="submit" value="提交"></p>
			</form>
		 </div>
		
  </body>
</html>

