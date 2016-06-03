<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8" isELIgnored="false"%>
 
<%@ taglib prefix="s" uri="/struts-tags"%>
 
<html>
 
<body>

<table align="center" border="1" cellspacing="0" width="500px">
 
    <tr>
        <td>id</td>
        <td>contentType</td>
        <td>name</td>
        <td>content</td>
        <td>time</td>
    </tr>
 
    <s:iterator value="products" var="p">
        <tr>
            <td>${p.id}</td>
            <td>${p.type}</td>
            <td>${p.name}</td>
            <td>${p.content}</td>
            <td>${p.date}</td>
        </tr>
      <!--  -->
    </s:iterator>
</table>
 
<form action="save" method="post">
<table align="center" border="1" cellspacing="0">
<tr>
    <td>
        contnetType:
    </td>
    <td>
        <select name="product.type">
		  <option value="java">java</option>
		  <option value="mysql">mysql</option>
		  <option value="html/css">html/css</option>
		  <option value="javascript">javascript</option>
		  <option value="other">other</option>
		</select>
    </td>
 </tr>
 <tr>
    <td>
        name:
    </td>
    <td>
        <input type="text" name="product.name" value="">
    </td>
 </tr>
 <tr>
    <td>
        content:
    </td>
    <td>
        <input type="text" name="product.content" value="">
    </td>
 </tr>
 <tr>
    <td colspan="2" align="center"> 
        <input type="submit" value="submit">
    </td>
 </tr>
</table>

</form>
 
</body>
</html>