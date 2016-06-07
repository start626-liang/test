<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.how2java.action.*,java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	*{padding:0;margin:0;}
	.main{margin:30px auto;width:480px;}
	.main h2{margin:0 auto;width:50%;}
	textarea{width:500px;}
</style>
</head>
<body>
<div class="main">
<h2>信息更新界面</h2><br /><br />
<form action='updateProdect?typeName=${typeName}' method='post'>
  id：<input type='text' name='id' value='${hero.id}' readonly required> <br>
    name：<input  name='name' value='${hero.name}'  max="1000"   placeholder="请填写"  required /> <br>
    content：<textarea name='content' rows="20" wrap="hard" placeholder="请填写" required>${hero.content}</textarea><br>
      time： <input type='text' name='date' value='${hero.date}' readonly required> <br>
    <input type='submit' value='更新'>
</form>
</div>
</body>
</html>