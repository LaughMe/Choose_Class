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
     
        <%
                   List<String> list =(List)request.getAttribute("list");  
                   for(String tl:list)
                   {
        %>
        <tr>
              
              <td><%=tl %></td>
        
    
          </tr>
            <%}
       %>
  </table>
</body>
</html>