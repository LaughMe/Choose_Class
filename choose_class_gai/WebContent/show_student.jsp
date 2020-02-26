
<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8" import="bean.Student,java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>显示结果</title>

</head>

<body>
<a href="View_student_info">返回浏览界面</a>
<br>
<table border="1">


 <%
 List<Student> list =(List)request.getAttribute("list");  
        for(Student  tl: list)
           {
        	if(tl!=null)
        {%>
        <tr>
              <td><%=tl.getName() %>   </td>
              
          </tr>
          
            <%}
        	}
       %>
</table>


</body>

</html>