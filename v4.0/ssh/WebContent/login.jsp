<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8" isELIgnored="false"%>
 
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
  <head>
	<!--当前页面的三要素-->
	<meta name="Keywords" content="关键词,关键词">
	<meta name="description" content="">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<style type="text/css">
		*{padding:0;margin:0;}
		.main{margin:30px auto;width:180px;}
	</style>
</head>
<body>

					<s:form action="loginAdmin" method="post">
				 		
						<p>名称：<input class="text" type="text" name="id" maxlength="30"  placeholder="请填写"  required /></p>
						    
						 <p>内容：<input class="text" type="password" name="password" maxlength="30"  placeholder="请填写"  required /></p>
						 <p>
							 <input type="submit" value="提交" />
							 <input type="reset" value="重置" />
							 <a href=""><input type="button" value="返回" /></a>
						 </p>
					</s:form>
					
		


</body>
</html>

