
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8" isELIgnored="false"%>
 
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
  <head>
	<!--当前页面的三要素-->
	<meta name="Keywords" content="关键词,关键词">
	<meta name="description" content="">
	<title></title>
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/bootstrap-combined.min.css">
	
	<script src="js/jquery-1.8.3.min.js"></script>
	<style>
		*{margin:0;padding:0;}
		a{text-decoration:none;}
		a:hover{text-decoration:none;}
		
		.text{width:90%;}
		.iterator {padding:10px 20px;width:85%;}
		.iterator li{padding:14px 15px;}
		.start {border-top:1px  #C0C0C0 solid;color:#A8A8A8;}
		.content {height:80px;padding-top:10px;}
		.end {border-bottom:1px  #C0C0C0 solid;}
		strong{font-size:22px;color:#0066FF;}
	</style>
	
  </head>
<body>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="row-fluid">
				<div class="span12">
					<div class="navbar">
				<div class="navbar-inner">
					<div class="container-fluid">
						 <a data-target=".navbar-responsive-collapse" data-toggle="collapse" class="btn btn-navbar"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></a> <a href="addProduct" class="brand">知识库</a>
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
							<ul class="nav pull-right">
								<li>
									<a href="http://115.28.188.77/b/login.html">管理员权限</a>
								</li>
								
								
							</ul>
						</div>
					</div>
				</div>
			</div>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span3">
				
				</div>
				<%int i=0; %>
				<div class="span6">
			<div >
				<ul class="iterator">
				<s:iterator value="messages" var="m">
					<li class="start"><strong>${m.name}</strong>&nbsp;&nbsp;&nbsp;第<%=++i%>楼</li>
					<li class="content">${m.content}</li>
					<li class="end">${m.date}</li>
				</s:iterator>
				</ul>
			</div>
			<div>		 	
			 	<form action="saveMessage" method="post">
					<p>昵称：<input class="text" type="text" name="message.name" value=""  size="110"  max="30" maxlength="30" placeholder="请填写"  required /></p>
					    
					 <p>内容：<textarea class="text" name="message.content" rows="20" wrap="hard" max="800" maxlength="800" placeholder="请填写" required></textarea></p>
					 <p><input type="submit" value="提交"></p>
				</form>
			 </div>
				</div>
				<div class="span3">
					<form class="form-search" action="findProduct">
							<input class="input-medium search-query" name="findName" value="" type="text" placeholder="请填写" /> <input type="submit" class="btn" value="提交" />
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>

