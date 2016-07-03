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
	<script src="js/jquery-1.8.3.min.js"></script>
	<style>
		*{margin:0;padding:0;}
		a{text-decoration:none;}
		a:hover{text-decoration:none;}
		
		.gotop{width:37px;height:37px;display:none;position:fixed;cursor:pointer;right:5%;bottom:15%;background-image:url('images/top.png');background-repeat:no-repeat;border:1px solid #00FFFF;}
		
		.text{width:80%;line-heigth:50px;}
	</style>
  </head>
<body>

					<h2>信息更新界面</h2><br /><br />
					<form action='updateDataAdministrator' method='post'>
						<p>
							id：<input class="text" type='text' name='data.id' value='${data.id}' readonly required>
						</p>
					    <p>
					    	name：<input class="text"  name='data.name' id="name" value='${data.name}'  max="30"  maxlength="240"  placeholder="请填写"  required />
					    </p>
					    <p>
					    	content：
						    <textarea class="text" name='data.content' id="content" maxlength="8000" rows="20" placeholder="请填写" required>
						    	${data.content}
						    </textarea>
					    </p>
					    <p>
					  	  time： <input class="text" type='text' name='data.date' value='${data.date}' readonly required>
					    </p>
					    <p>
						    <input type="submit" value="提交" onclick="return valName();" />
						    <input type="reset" value="重置" />
						    <a href="dataAdministrator"><input  type="button" value="返回" /></a>
					    </p>
					</form>
<!-- 
	<s:debug></s:debug>
-->
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
		
		function valName(){
			

			var str1=document.getElementById("name").value;
			var str2=document.getElementById("content").value;
			if(str1.length > 240){
				str1.substring(0,240);
				document.getElementById("name").innerHTML=str1;
				alert("名称不得超出240个字");
				return false;
			}
			else if(str2.length > 800000){
				str2.substring(0,800000);
				document.getElementById("content").innerHTML=str2;
				alert("名称不得超出800000个字");
				return false;
			}
			else{
				return true;
			}
			
		}
	</script>
</body>
</html>
