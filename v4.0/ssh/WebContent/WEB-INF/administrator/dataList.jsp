<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="javax.servlet.http.*"%>
 
<%@ taglib prefix="s" uri="/struts-tags"%>
 <!DOCTYPE html>
<html>
<head>
<style type="text/css">
	*{padding:0;margin:0;}
	td{text-align:justify;}
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
    <s:iterator value="datas" id="d">
   
        <tr>
        	<td class="long">${d.id}</td>
            <td class="long">${d.name}</td>
            <td class="content"><p class="content">${d.content}</p></td>
            <td class="long">${d.date}</td>
			
			<td class="long"><a href="editDataAdministrator?data.id=${d.id}">edit</a></td> 

            <td class="long"><a href="deleteDataAdministrator?data.id=${d.id}">delete</a></td>
            
        </tr>
    </s:iterator>
</table>
<br/>
<a href="mainAdministrator"><input type="button" value="返回上一级" /></a>

</div>
</body>
</html>