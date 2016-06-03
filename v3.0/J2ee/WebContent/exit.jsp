<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8" %>
 <%@ page import="javax.servlet.http.*"%>
<jsp:forward page="login.html"/>

<%

request.getSession().setAttribute("userName", null);
%>
