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
		.text{position:absolute;top:70px;width:65%;right:10px;}
		.textarea{width:450px;}
	</style>
	
  </head>
    <body>		 
  <div class="container-fluid">
	<div class="row-fluid">
  		<div class="span12">
			<div class="navbar">
				<div class="navbar-inner">
					<div class="container-fluid">
						 <a data-target=".navbar-responsive-collapse" data-toggle="collapse" class="btn btn-navbar"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></a> <a href="#" class="brand">网站名</a>
						<div class="nav-collapse collapse navbar-responsive-collapse">
							<ul class="nav">
								<li  class="active">
									<a href="addProduct">主页</a>
								</li>
								<li>
									<a href="addMessage">留言</a>
								</li>
								<!--<li>
									<a href="#">链接</a>
								</li>
								-->
							</ul>
							
						</div>
					</div>
				</div>
			</div>
		</div>
 	  <jsp:include page="left.jsp" />
		<div class="text">
 	  	<p>标题：<input type="text" name="outputName" value="${outputName}" readonly />&nbsp&nbsp&nbsp${outputTime}</p>
 	  	<br />
 	  	<p><textarea class="textarea" name="outputContent" rows="20"  readonly>
		${outputContent}
		</textarea></p>
 	  </div>
		</div>
	</div>
  </body>
</html>

