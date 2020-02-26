
<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8" import="bean.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>显示结果</title>

</head>

<body>
<a href="teacher_main_menu.jsp">返回主界面</a>
<br>
<%
	Teacher teacher = (Teacher)request.getAttribute("teacher");
%>


<form action="Updating_te_info"  name="create" method="post" >
<div align="center">
<h1>请修改此成员信息</h1>
编号:<input id ="number" name="number" type="text"  value="<%=teacher.getNumber() %>"  onChange="change1(this.value)">
<br>
姓名:<%=teacher.getName() %>
<input id ="name" name="name" type="hidden"  value="<%=teacher.getName() %>"  onChange="change1(this.value)">
<br>
性别:<input id ="sex" name="sex" type="text"  value="<%=teacher.getSex() %>"  onChange="change1(this.value)">
<br>
学院:<input id ="college" name="college" type="text"  value="<%=teacher.getCollege() %>"  onChange="change1(this.value)">
<br>
职称:<input id ="place" name="place" type="text"  value="<%=teacher.getPlace() %>"  onChange="change1(this.value)">
<br>
  <input type="submit" value="确定" onclick="return window.confirm&#40;'您确定修改吗?'&#41;">
</div>
</form>




</body>

</html>
