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
	.content {mxn-width:820px;min-width:750px;text-align:left;}
</style>
</head>
<body>
<div class="main">
<h2>信息管理界面</h2><br /><br />
<table border="1">
    <tr>
    	<th>id</td>
        <th>name</td>
        <th>content</td>
        <th>edit</td>
        <th>delete</td>
    </tr>
    <c:forEach items="${heros}" var="hero" varStatus="st">
        <tr>
        	<td class="long">${hero.id}</td>
            <td class="long">${hero.name}</td>
            <td class="content">${hero.content}</td>
            <td class="long"><a href="editHero?id=${hero.id}&type=${hero.type}">edit</a></td>
            <td class="long"><a href="deleteHero?id=${hero.id}&type=${hero.type}">delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<%
	String type = request.getParameter("type"); 
	if(type.equals("message"))	{
%>
<input type="button" onclick="window.location.href='main.html'" value="返回上一级" />
<% 
	}
		else{
%>

		<input type="button" onclick="window.location.href='data.html'" value="返回上一级" />
<%
	}
%>
</div>
</body>
</html>