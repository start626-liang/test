<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="javax.servlet.http.*"%>
 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html>
<html>
<head>
<style type="text/css">
	*{padding:0;margin:0;}
	td{text-align:center;}
	.main{margin:30px auto;width:90%;}
	.main h2{margin:0 auto;width:25%;}
	
	.long {width:60px;max-width:240px;}
	.content {white-space:nowrap;width:800px;overflow:hidden;text-overflow:ellipsis;height:20px}
	
</style>
</head>
<body>
<div class="main">
<h2>信息管理界面</h2><br /><br />
<table border="1">
    <tr>
    	<th>id</th>
        <th>name</th>
        <th>content</th>
        <th>date</th>
        <th>edit</th>
        <th>delete</th>
    </tr>
    <c:forEach items="${heros}" var="hero" varStatus="st">
        <tr>
        	<td class="long">${hero.id}</td>
            <td class="long">${hero.name}</td>
            <td class="content"><p class="content">${hero.content}</p></td>
            <td class="long">${hero.date}</td>
        	<td class="long"><a href="editMessage?id=${hero.id}&typeName=${typeName}">edit</a></td>
            <td class="long"><a href="deleteMessage?id=${hero.id}&typeName=${typeName}">delete</a></td>
            
        </tr>
    </c:forEach>
</table>
<br/>
<input type="button" onclick="window.location.href='main.html'" value="返回上一级" />

</div>
</body>
</html>