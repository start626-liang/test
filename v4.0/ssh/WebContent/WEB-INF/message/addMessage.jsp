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
		.left{margin-left:25%;}
		.skip{position:relative;left:82%;}
		
		.iterator {padding:10px 20px;width:90%;}
		.iterator li{padding:14px 15px;}
		.start {border-top:1px  #C0C0C0 solid;color:#A8A8A8;}
		.content {height:80px;padding-top:10px;}
		.end {border-bottom:1px  #C0C0C0 solid;}
		
		.gotop{width:37px;height:37px;display:none;position:fixed;cursor:pointer;right:5%;bottom:15%;background-image:url('images/top.png');background-repeat:no-repeat;border:1px solid #00FFFF;}
		
		strong{font-size:22px;color:#0066FF;}
		
		
		h2{padding:1% 0 1% 5%;}
	</style>
  </head>
<body>
<h2>学习笔记</h2>
<div class="navbar">
	<div class="navbar-inner">
		<div class="container-fluid">
			<div class="nav-collapse collapse navbar-responsive-collapse">
				<ul class="nav">
					<li><a href="addData">主页</a></li>
					<li class="active"><a href="addMessage">留言</a></li>
				</ul>
				<ul class="nav pull-right">
					<li><a href="login.jsp">管理员权限</a></li>
											
				</ul>
			</div>
		</div>
	</div>
</div>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="row-fluid">
				<div class="span2">
					 
				</div>
				<div class="span7">
					<%int i=0;%>
					<div class="skip">
						<a href="#message"><input type="button" value="留言" /></a>
					</div>
					<div >
						${transmitStringB}
						<ul class="iterator">
						<s:iterator value="messages" var="m">
							<li class="start"><strong>${m.name}</strong>&nbsp;&nbsp;&nbsp;第<%=++i%>层</li>
							<li class="content">${m.content}</li>
							<li class="end">${m.date}</li>
						</s:iterator>
						</ul>
					</div>
					<div>		 	
					 	<form action="saveMessage" method="post" id="message">
							<p>昵称：<input class="text" type="text" name="message.name" value=""  size="110"  max="30" maxlength="30" placeholder="请填写" required /></p>
							    
							 <p>内容：<textarea class="text" name="message.content" rows="20" wrap="hard" max="800" maxlength="800" placeholder="请填写" required></textarea></p>
							 <p>
								 <input class="left" type="submit" value="提交">
								 <input class="left" type="reset" value="重置" />
							 </p>
						</form>
					 </div>
				</div>
				
				<div class="span3">
					${transmitStringC}
					
				</div>
			</div>
		</div>
	</div>
</div>
<a class="gotop" href="#"></a>
<script src="js/jquery-1.8.3.min.js"></script>
	<script>
	
	
	
		$(function(){
			$(window).scroll(function(){
				if($(window).scrollTop() >= 180){
					$(".gotop").fadeIn(300);
				}else{
					$(".gotop").stop(true,true).fadeOut(300);
				}
			});
			$(".gotop").click(function(){
				$("html,body").animate({scrollTop:0},"slow");
			});
		});
		
		
	</script>
</body>
</html>
