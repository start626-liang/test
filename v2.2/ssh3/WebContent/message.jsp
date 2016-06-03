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
	<link rel="stylesheet" href="css/bootstrap-combined.min.css">
	
	<script src="js/jquery-1.8.3.min.js"></script>
	<style>
		*{margin:0;padding:0;}
		.text{width:450px;}
		.{margin:0 auto;}
	</style>
	
  </head>
  <body>	
  <div class="main">	 
  <div class="container-fluid">
	<div class="row-fluid">
  		<div class="span12">
  		
			<div class="navbar">
				<div class="navbar-inner">
					<div class="container-fluid">
						 <a data-target=".navbar-responsive-collapse" data-toggle="collapse" class="btn btn-navbar"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></a> <a href="#" class="brand">网站名</a>
						<div class="nav-collapse collapse navbar-responsive-collapse">
							<ul class="nav">
								<li>
									<a href="addProduct">主页</a>
								</li>
								<li class="active">
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
		<div class="span3">
		</div>
		<div class="span6">
				
			<dl class="dl-horizontal" contenteditable="true">
				<s:iterator value="messages" var="m">
					<dt>${m.name}</dt>
					<dd>${m.content}</dd>
				</s:iterator>
			</dl>
			<div class="form">		 	
			 	<form action="saveMessage" method="post">
					<p>昵称：<input type="text" name="message.name" value=""  size="50"  placeholder="请填写"  required /></p>
					    
					 <p>内容：<textarea class="text" name="message.content" rows="20" wrap="hard" placeholder="请填写" required></textarea></p>
					 <p><input type="submit" value="提交"></p>
				</form>
			 </div>
		</div>
		<div class="span3">
		</div>
		
		</div>
	</div>
	</div>
  </body>
</html>

