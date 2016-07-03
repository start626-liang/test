
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
	<script src="js/jquery-1.11.1.js"></script>
	<style>
		*{margin:0;padding:0;}
		a{text-decoration:none;}
		a:hover{text-decoration:none;}
		
		.text{width:460px;}
		
		.lg_accordion{background:#f1f1f1;}
		.lg_accordion dl{line-height:50px;margin-bottom:0px;}
		.lg_accordion dt{padding:0 0px 0 20px;line-height:50px;font-size:16px;cursor:pointer;color:#666;border-bottom:1px solid #cacaca;background: url('images/pro.png') no-repeat 180px 18px;}
		.lg_accordion .on dt{color:#93d6d6;background-position:18%0px -17px;}
		.lg_accordion dd{display:none;margin:0 30px;line-height:35px;overflow:hidden;}
		.lg_accordion dd p{border-top:1px solid #d8d8d8;text-overflow:ellipsis;white-space:nowrap;overflow:hideen;}
		.lg_accordion dd p a{font-size:14px;color:#456161;}
		.lg_accordion .pro-show a {color: #fe8b16;}
		
		.list{margin-top:-20px;width:70%;}
		
		.right{text-align:right;width:80%;}
		.center {text-align:center;width:80%;}
		
		.container {position:absolute; display:none;height:40px; margin:0;}
  
	.shadow {float:left;}
    .frame {position:relative; background:#fff;paddign:6px; display:block;
        -moz-box-shadow: 3px 3px 10px rgba(0, 0, 0, 0.6);
        -webkit-box-shadow: 3px 3px 10px rgba(0, 0, 0, 0.6);
        box-shadow: 3px 3px 10px rgba(0, 0, 0, 0.6);
    }
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
				<p>类型：${outputType}&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" id="language">编辑</a></p>	
				
				<p>标题：<input class="text" type="text" name="outputName" value="${outputName}" readonly />
				
 	  			
 	  			<p>内容：<textarea class="text" name="outputContent" rows="20"  readonly>
				${outputContent}
				</textarea></p>
				<p class="right">日期：${outputTime}</p>
				
				
	
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

<div class="container">
	<div class="shadow">
		<div class="frame">
			<form action="moveProduct" method="post">
				移动到
				<select  name="moveType">
					<option value="JAVA" id="location0">JAVA</option>
					<option value="SQL" id="location1">SQL</option>
					<option value="Other"  id="location2">Other</option>
				</select>
				<input type="submit"  value="确定">
				<input id="hide" type="button"  value="取消">
			</form>
		</div>
	</div>
</div>

				
							
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
	
	$('#language').bind('focus', function() {
        var offset = $(this).offset(), container = $('.container');
        container.css({top:offset.top+Number($(this).css('height').replace('px', '')), left:offset.left}).show(100);
    });
	
	$('#hide').bind('focus', function() {
        var offset = $(this).offset(), container = $('.container');
        container.css({right:offset.right}).hide("slow");
    });
</script>
</body>
</html>

