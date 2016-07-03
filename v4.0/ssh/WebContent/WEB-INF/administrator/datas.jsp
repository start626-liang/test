<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	*{padding:0;margin:0;}
	.main{margin:30px auto;width:80%;}
	.main h2{margin:0 auto;width:50%;}
    .main button{height:50px;width:80px;font-size:16px;padding:12px;}
    .main input{margin-top:20px;}
</style>
</head>
<body>
		<div class="main">
		<h2>知识库管理界面</h2><br /><br />
		<a href="dataAdministrator?transmitStringB=JAVA"><button>JAVA</button></a>
		<a href="dataAdministrator?transmitStringB=SQL"><button>SQL</button></a>
		<a href="dataAdministrator?transmitStringB=OTHER"><button>OTHER</button></a>
		<button onclick="window.location.href='#'">...</button>
		<br /><a href="mainAdministrator"><input type="button" value="返回上一级" /></a>
		</div>
</body>

</html>