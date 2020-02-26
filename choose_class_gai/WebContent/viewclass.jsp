<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="bean.Class,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <a href="student_main_menu.jsp">返回主界面</a>
  <table border="1">
      <tr>
          <td>编号</td>
          <td>名称</td>
          <td>已选人数</td>
          <td>最大人数</td>
          <td>教师</td>
            
      </tr>
        <%
                   List<Class> list =(List)request.getAttribute("list");  
                   for(Class tl:list)
                   {
        %>
        <tr>
              <td><%=tl.getNumber() %></td>
                <td><%=tl.getName() %></td>
                <td><%=tl.getNowpeople() %></td>
              <td><%=tl.getPeople() %></td>
        <td><a href="Teacher_most_information?teacher_name=<%=tl.getTeacher() %>"><%=tl.getTeacher() %></a></td>
    
          </tr>
            <%}
       %>
  </table>
</body>
</html>