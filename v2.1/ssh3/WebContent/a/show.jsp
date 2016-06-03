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
		.text{position:absolute;top:10px;width:70%;right:10px;}
	</style>
	
  </head>
  <body>		 
 	  <jsp:include page="left.jsp" />
 	 
 	  <div class="text">
 	  	<h2><p>标题：<input type="text" name="outputName" value="${outputName}" readonly /></p></h2>
 	  	<br />
 	  	<p><textarea name="outputContent" rows="30" cols="80"  readonly>
		${outputContent}
		</textarea></p>
 	  </div>
		
		
  </body>
</html>

