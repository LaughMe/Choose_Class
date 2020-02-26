<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="bean.Class,java.util.*, javax.servlet.http.HttpServlet,
 javax.servlet.http.HttpServletRequest,
javax.servlet.http.HttpServletResponse,
 javax.servlet.http.HttpSession,util.DButil,java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
String username=(String)request.getSession().getAttribute("name");
	DButil DB = new DButil();
	String sn=null;
	String sql="select realname from account where username=?";
	Connection conn = null;
	PreparedStatement ps = null;
		try {
		conn = DB.getConn();
		ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
		
			  sn=rs.getString("realname");

		}
		
		
	} catch (Exception e ) {
		
		
		e.printStackTrace();
	} finally {
		DB.close(conn);
		DB.close(ps);
	}
%>

  <script type="text/javascript">
  

      
    
    	 
      
	
	
	
      function fun1( x )
      {		
     		
      
     		  //1.创建一个异步请求对象
      	  var xmlHttp=new XMLHttpRequest();
      	  //2.为异步请求对象身上绑定【工作状态监听器】
      	  xmlHttp.onreadystatechange=function ()
      	  {
      		  
      		  if(xmlHttp.readyState==4&&xmlHttp.status==200)
      		  {
      		  
      		  var date=xmlHttp.responseText;
      		 if (date<0)
      	      { alert("选课成功!!!"); 
      	    var param=x;
      	      fun2(param);
      	    
      	     
      	      }
      	      
      	      else if(date>=0)
      	    	  { alert("您已选过改课，请勿重复操作");
      	    	  window.location.href="/choose_class_gai/Choose_class";
      	    	 
      	    	  }
      		  
      		  }
      			  
      		  
      	  }//3.初始化异步请求对象
      	  var param=x;
        var param1=document.getElementById("sn").value;
        xmlHttp.open("post","Addrecord?classname="+param+"&studentname="+param1,true);
        //4.通知异步请求对象发送请求协议包
        xmlHttp.send();
        
    	  
      
	
	
	}
	function fun2(x)
	{
		
		 //1.创建一个异步请求对象
  	  var xmlHttp=new XMLHttpRequest();
  	  //2.为异步请求对象身上绑定【工作状态监听器】
  	  xmlHttp.onreadystatechange=function ()
  	  {
  		  
  		  if(xmlHttp.readyState==4&&xmlHttp.status==200)
  		  {
  		  
  			window.location.href="/choose_class_gai/Choose_class";		  
  		 
  		  }
  			  
  		  
  	  }//3.初始化异步请求对象
    var param=x;
    xmlHttp.open("post","Getclass?name="+param,true);
    //4.通知异步请求对象发送请求协议包
    xmlHttp.send();
   
		
	}
	
	function fun3(x)
	{
	
		  //1.创建一个异步请求对象
    	  var xmlHttp=new XMLHttpRequest();
    	  //2.为异步请求对象身上绑定【工作状态监听器】
    	  xmlHttp.onreadystatechange=function ()
    	  {
    		  
    		  if(xmlHttp.readyState==4&&xmlHttp.status==200)
    		  {
    		  
    		  var date=xmlHttp.responseText;
    		 if (date<0)
    	      { alert("您未选择该课程!!!"); 
    	      window.location.href="/choose_class_gai/Choose_class";
    	    
    	     
    	      }
    	      
    	      else if(date>=0)
    	    	  { alert("删除选课成功");
    	    	  var param=x;
        	      fun4(param);
    	    	 
    	    	 
    	    	  }
    		  
    		  }
    			  
    		  
    	  }//3.初始化异步请求对象
    	  var param=x;
      var param1=document.getElementById("sn").value;
      xmlHttp.open("post","Deleterecord?classname="+param+"&studentname="+param1,true);
      //4.通知异步请求对象发送请求协议包
      xmlHttp.send();
	}
	
	function fun4(x)
	{
		
		 //1.创建一个异步请求对象
	  	  var xmlHttp=new XMLHttpRequest();
	  	  //2.为异步请求对象身上绑定【工作状态监听器】
	  	  xmlHttp.onreadystatechange=function ()
	  	  {
	  		  
	  		  if(xmlHttp.readyState==4&&xmlHttp.status==200)
	  		  {
	  		  
	  			window.location.href="/choose_class_gai/Choose_class";		  
	  		 
	  		  }
	  			  
	  		  
	  	  }//3.初始化异步请求对象
	    var param=x;
	    xmlHttp.open("post","Deleteclassnumber?name="+param,true);
	    //4.通知异步请求对象发送请求协议包
	    xmlHttp.send();
		
	}
</script>
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
                   {String x=tl.getName();
        %>
          <tr>
              <td><%=tl.getNumber() %>   <input type="hidden"  id="<%=tl.getName() %>"  value="<%=tl.getName() %>">  <input type="hidden"  id="sn"  value="<%=sn%>"></td>
               <td><%=tl.getName() %></td>
               <td><%=tl.getNowpeople() %></td>
              <td><%=tl.getPeople() %></td>
               <td><%=tl.getTeacher() %></td>
             <td><input type="button"  value="选课" onClick="fun1(this.id)" id="<%=tl.getName() %>" ></td>
              <td><input type="button"  value="删除选课" onClick="fun3(this.name)" name="<%=tl.getName() %>" ></td>
          </tr>
            <%}
       %>
  </table>
  

</body>
</html>