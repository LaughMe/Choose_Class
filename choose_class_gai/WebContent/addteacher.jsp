<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>增加教师</title>
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
	<a href="admin_main_menu.jsp">返回主界面</a>
	<form action="Addteacher" name="create" method="post">
		<div align="center">
			<h1>请输入此成员信息</h1>
			工号:<input id="number" name="number" type="text" value=""
				onChange="change1(this.value)"> <br> 姓名: <input
				id="name" name="name" type="text" > <br> 
				性别:<input
				id="sex" name="sex" type="text" value=""
				onChange="change3(this.value)"> <br> 
				所在学院:<input
				id="college" name="college" type="text" value=""
				onChange="change4(this.value)"> <br>
				 职称:<input id="place"
				name="place" type="text" value="" onChange="change4(this.value)">
			   <br> 
			<input type="submit" value="确定">
		</div>
	</form>
	
</body>
</html>