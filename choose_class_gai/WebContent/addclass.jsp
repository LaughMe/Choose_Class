<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>增加课程</title>
</head>
<body>
	<%
		Object message = request.getAttribute("message");
		if (message != null && !"".equals(message)) {
	%>
	<script type="text/javascript">
	          alert("<%=request.getAttribute("message")%>");
	</script>
	<%
		}
	%>
	<a href="teacher_main_menu.jsp">返回主界面</a>
	<form action="Addclass" name="create" method="post">
		<div align="center">
			<h1>请输入此课程信息</h1>
			课程编号:<input id="number" name="number" type="text" value=""
				onChange="change1(this.value)"> <br> 课程名称: <input
				id="name" name="name" type="text" > <br> 
				选课人数:<input
				id="people" name="people" type="text" value=""
				onChange="change3(this.value)">  <br> 
				
			<input type="submit" value="确定">
		</div>
	</form>
	
</body>
</html>