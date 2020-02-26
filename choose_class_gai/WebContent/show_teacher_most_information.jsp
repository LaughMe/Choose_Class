
<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8" import="bean.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>显示结果</title>

</head>

<body>
<a href="Viewclass">返回浏览界面</a>
<br>
<%
	Teacher teacher = (Teacher)request.getAttribute("teacher_info");
%>


编号:<%=teacher.getNumber() %>
<br>
姓名:<%=teacher.getName() %>
<br>
性别:<%=teacher.getSex() %>
<br>
学院:<%=teacher.getCollege() %>
<br>
职称:<%=teacher.getPlace() %>




</body>

</html>