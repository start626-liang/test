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
		
		.text{width:450px;}
		
		.lg_accordion{background:#f1f1f1;}
		.lg_accordion dl{line-height:50px;margin-top:-19px;}
		.lg_accordion dt{padding:0 15px 0 20px;line-height:50px;font-size:16px;cursor:pointer;color:#666;border-bottom:1px solid #cacaca;background: url('images/pro.png') no-repeat 200px 18px;}
		.lg_accordion .on dt{color:#93d6d6;background-position:200px -17px;}
		.lg_accordion dd{display:none;margin:0 30px;line-height:50px;overflow:hidden;}
		.lg_accordion dd p{border-top:1px solid #d8d8d8;text-overflow:ellipsis;white-space:nowrap;overflow:hideen;}
		.lg_accordion dd p a{font-size:14px;color:#456161;}
		.lg_accordion .pro-show a {color: #fe8b16;}
		
		.list{position:absolute;top:63px;width:18%;left:20px;}
		
		.n{font-size:23px;}
		
		#il{white-space:nowrap; width:400px; overflow:hidden; text-overflow:ellipsis;}
	</style>
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
	
	
	</script>
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
								<li class="active">
									<a href="addProduct">主页</a>
								</li>
								<li >
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
					  <div class="list">
			 <div class="lg_accordion">
				<dl>
					<dt>JAVA</dt>
					<dd>
					<s:iterator value="products_java" var="p">
					
						<p><a href="showProduct?product_java.id=${p.id}&type=JAVA" >${p.name}</a></p>
					
					</s:iterator>
					</dd>
				</dl>
			 </div>
			 <div class="lg_accordion">
				<dl>
					<dt>SQL</dt>
					<dd>
					<s:iterator value="products_sql" var="p">
					
						<p><a href="showProduct?product_sql.id=${p.id}&type=SQL" >${p.name}</a></p>
					
					</s:iterator>
					</dd>
				</dl>
			 </div>
			  <div class="lg_accordion">
				<dl>
					<dt>Other</dt>
					<dd>
					<s:iterator value="products_other" var="p">
					
						<p><a href="showProduct?product_other.id=${p.id}&type=Other" >${p.name}</a></p>
					
					</s:iterator>
					</dd>
				</dl>
			 </div>
		 </div>
				</div>
				<div class="span6">
				${findNull}
					<s:iterator value="products" var="p">
						<ul class="iterator">
								<li class="start">
									<a href="showProduct?product.id=${p.id}&type=main">
										<strong class="n">${p.name}</strong>
									</a>
								</li>
								<li class="start">分类：${p.type}&nbsp;&nbsp;&nbsp;日期：${p.date}</li>
								<li class="start" id="il">${p.content}</li>
						</ul>
						<br />
					</s:iterator>
				</div>
				<div class="span3">
					<form class="form-search" action="findProduct">
							<input class="input-medium search-query" name="findName" value="" type="text" placeholder="请填写" />
							<input type="submit" class="btn" value="提交" />
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>

