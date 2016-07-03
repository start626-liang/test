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
		
		
		
		.lg_accordion{background-color:#F8F8F8;}
		.lg_accordion dl{line-height:50px;margin-bottom:0px;}
		.lg_accordion dt{padding:0 0px 0 20px;line-height:50px;font-size:16px;cursor:pointer;color:#666;border-bottom:1px solid #cacaca;background: url('images/pro.png') no-repeat 165px 18px;background-color:#f1f1f1;}
		.lg_accordion .on dt{background-color:#787878;color:#93d6d6;background-position:165px -17px;}
		.lg_accordion dd{display:none;margin:0 30px;line-height:35px;overflow:hidden;}
		.lg_accordion dd p{border-top:1px solid #d8d8d8;text-overflow:ellipsis;white-space:nowrap;overflow:hideen;}
		.lg_accordion dd p a{font-size:14px;color:#456161;}
		.lg_accordion .pro-show a {color: #fe8b16;}
		
		
		.text{width:90%;}
		
		
		.gotop{width:37px;height:37px;display:none;position:fixed;cursor:pointer;right:5%;bottom:15%;background-image:url('images/top.png');background-repeat:no-repeat;border:1px solid #00FFFF;}
		
		.left{margin-left:25%;}
		.right{padding-left:60%;}
		.middle{margin-left:45%;}
		
		.span7{border:1px solid #f1f1f1;}
		
		.type{padding:10px 0 10px 25px;font-size:15px;border-top:1px solid #f1f1f1;border-bottom:1px solid #f1f1f1;}
		.name{padding:30px 0 0 30px;font-size:25px;}
		.data{padding:0 0 0 80%;font-size:11px;color:#888888;}
		.content{min-height:500px;padding:7px 20px;}
		.button{border-top:1px solid #f1f1f1;}
		
		
		h2{padding:1% 0 1% 5%;}
		strong{color:red;}
	</style>
  </head>
<body>
<h2>学习笔记</h2>
<div class="navbar">
	<div class="navbar-inner">
		<div class="container-fluid">
			<div class="nav-collapse collapse navbar-responsive-collapse">
				<ul class="nav">
					<li class="active"><a href="addData">主页</a></li>
					<li ><a href="addMessage">留言</a></li>
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
					  <div class="list">
			 <div class="lg_accordion">
				<dl>
					<dt>JAVA</dt>
					<dd>
					<s:iterator value="datasJAVA" id="d">
						
						<p><a href="showData?data.id=${d.id}" >${d.name}</a></p>
					
					</s:iterator>
					</dd>
				</dl>
			 </div>
			 <div class="lg_accordion">
				<dl>
					<dt>SQL</dt>
					<dd>
					<s:iterator value="datasSQL" id="d">
					
						<p><a href="showData?data.id=${d.id}" >${d.name}</a></p>
					
					</s:iterator>
					</dd>
				</dl>
			 </div>
			  <div class="lg_accordion">
				<dl>
					<dt>Other</dt>
					<dd>
					<s:iterator value="datasOTHER" id="d" >
					
						<p><a href="showData?data.id=${d.id}" >${d.name}</a></p>
					
					</s:iterator>
					</dd>
				</dl>
			 </div>
		 </div>
				</div>
				<div class="span7">
					
					<p class="name">${data.name}</p>
					<p class="data">${data.date}</p>
					
					<p class="type">分类：<strong>${data.type}</strong></p>	
					
					<p class="content">${data.content}</p>
						
					<form action="editData" method="post" class="button">
						<p>
							<input class="middle" type="submit" value="编辑" />
						</p>
					</form>
				</div>
				
				<div class="span3">
					<form class="form-search" action="findData">
							<input class="input-medium search-query" name="transmitStringB" value="" type="text" placeholder="请填写" /> <input type="submit" class="btn" value="提交" />
					</form>
					
				</div>
			</div>
		</div>
	</div>
</div>
<a class="gotop" href="#"></a>
<script src="js/jquery-1.8.3.min.js"></script>
	<script>
	$(function(){
		$(".lg_accordion dt").on("click",function(){
			$(this).parent().toggleClass("on").siblings().each(function(){
				$(this).removeClass("on").children("dd").stop(true,true).slideUp();
			});
			if ($(this).parent().hasClass("on")) {
				$(this).next().stop(true,true).slideDown();
			}else{
				$(this).next().stop(true,true).slideUp();
			};
		});
	})
	
	
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
