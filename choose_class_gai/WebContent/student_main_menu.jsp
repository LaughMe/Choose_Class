<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="bean.Class,java.util.*, javax.servlet.http.HttpServlet,
 javax.servlet.http.HttpServletRequest,
javax.servlet.http.HttpServletResponse,
 javax.servlet.http.HttpSession,util.DButil,java.sql.*,javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>主菜单</title> 		
</head>
<body>
<%
String username=(String)session.getAttribute("name");
System.out.println(username);
%>
<a href="log.jsp">返回登录界面</a>
<div align="center">
<h1>请选择功能</h1>
<br>
<a href="Viewclass">浏览课程信息</a>
<br>
<a href="Update_student_information">修改个人信息</a>
<br>
<a href="Choose_class">选课</a>
<br>
<a href="Myclass">我的选课</a>
</div>
</body>
</html>