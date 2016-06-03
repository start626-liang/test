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
		.lg_accordion{background:#f1f1f1;}
		.lg_accordion dl{line-height:50px;}
		.lg_accordion dt{padding:0 15px 0 20px;font-size:16px;cursor:pointer;color:#666;border-bottom:1px solid #cacaca;background: url('images/pro.png') no-repeat 232px 17px;}
		.lg_accordion .on dt{color:#93d6d6;background-position:232px -13px;}
		.lg_accordion dd{display:none;margin:0 30px;line-height:50px;overflow:hidden;}
		.lg_accordion dd p{border-top:1px solid #d8d8d8;text-overflow:ellipsis;white-space:nowrap;overflow:hideen;}
		.lg_accordion dd p a{font-size:14px;color:#456161;}
		.lg_accordion .pro-show a {color: #fe8b16;}
		.form, .list{position:absolute;top:10px;}
		.form{width:70%;right:10px;}
		.form p{margin-bottom:20px;}
		.list{width:20%;left:20px;}
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
  	<div class="main">
		 <div class="list">
			 <div class="lg_accordion">
				<dl>
					<dt>JAVA</dt>
					<dd>
					<s:iterator value="products_java" var="p">
					
						<p><a href="show?product_java.id=${p.id}&type=JAVA" >${p.name}</a></p>
					
					</s:iterator>
					</dd>
				</dl>
			 </div>
			 <div class="lg_accordion">
				<dl>
					<dt>SQL</dt>
					<dd>
					<s:iterator value="products_sql" var="p">
					
						<p><a href="show?product_sql.id=${p.id}&type=SQL" >${p.name}</a></p>
					
					</s:iterator>
					</dd>
				</dl>
			 </div>
			  <div class="lg_accordion">
				<dl>
					<dt>Other</dt>
					<dd>
					<s:iterator value="products_other" var="p">
					
						<p><a href="show?product_other.id=${p.id}&type=Other" >${p.name}</a></p>
					
					</s:iterator>
					</dd>
				</dl>
			 </div>
		 </div>
	</div>
  </body>
</html>