<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="shortcut icon" href="#" />
<meta charset="utf-8">
<title>登录</title>
	  <script type="text/javascript">
  

      function funbutton()
      {
    	  
    	  validateCode();
    	  window.location.href="/choose_class_gai/Log";
    	  
      }
	 
	          function fun1()
	          {
	        	  
	        	  //1.创建一个异步请求对象
	        	  var xmlHttp=new XMLHttpRequest();
	        	  //2.为异步请求对象身上绑定【工作状态监听器】
	        	  xmlHttp.onreadystatechange=function ()
	        	  {
	        		  
	        		  if(xmlHttp.readyState==4&&xmlHttp.status==200)
	        		  {
	        		  
	        		  var date=xmlHttp.responseText;
	        		  
	        		  callback(date);
	        		  }
	        			  
	        		  
	        	  }//3.初始化异步请求对象
	          var param=document.getElementById("username").value;
	          xmlHttp.open("post","Check_username?name="+param,true);
	          //4.通知异步请求对象发送请求协议包
	          xmlHttp.send();
	          
	         
	          }
	          
	          
	          function callback( par)
	          {
	        	  
	        	  
	        	  if (par==0)
	          { document.getElementById("warning_username").innerText='该用户不存在';
	          }
	          
	          else if(par==1)
	        	  {
	        	  
	        	  document.getElementById("warning_username").innerText='该用户可用';
	        	  
	        	  }
	        	  
	          }
	          
	</script>


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
<form action="Log" name="log" method="post">
<div align="center">
<h1>请登录</h1>
用户名:<input id ="username" name="username" type="text"  value=""  onblur="fun1()" ><font color="red" id="warning_username">*</font>
<br>
密码:<input id ="password" name="password" type="password"   value=""  >
<br>
          验证码：<input type="text" id="inputCode" value="" onChange="validateCode()">
          <div id="checkCode" class="code"  onclick="createCode(4)" style="display:inline"   ></div>
<br>
<input type="button" value="确定" onClick="funbutton()" >
</div>
</form>
<script type="text/javascript">
window.onload=function(){
    createCode(4);    
   }

   //生成验证码的方法
   function createCode(length) {
       var code = "";
       var codeLength = parseInt(length); //验证码的长度
       var checkCode = document.getElementById("checkCode");
       ////所有候选组成验证码的字符，当然也可以用中文的
       var codeChars = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
       'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
       'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'); 
       //循环组成验证码的字符串
       for (var i = 0; i < codeLength; i++)
       {
           //获取随机验证码下标
           var charNum = Math.floor(Math.random() * 62);
           //组合成指定字符验证码
           code += codeChars[charNum];
       }
       if (checkCode)
       {
           //为验证码区域添加样式名
           checkCode.className = "code";
           //将生成验证码赋值到显示区
           checkCode.innerHTML = code;
       }
   }
   
   //检查验证码是否正确
   function validateCode()
   {
       //获取显示区生成的验证码
       var checkCode = document.getElementById("checkCode").innerHTML;
       //获取输入的验证码
       var inputCode = document.getElementById("inputCode").value;
       //console.log(checkCode);
       //console.log(inputCode);
       if (inputCode.length == 0||inputCode.toUpperCase() != checkCode.toUpperCase())
       {
           
      
           alert("验证码输入有误！");
           window.location.href="/choose_class_gai/log.jsp";
           createCode(4);
       }
       
   }
   var reg=/^[a-zA-Z]\w*$/;
   var flag1=false,flag2=false,flag3=false;
   /*function chang1(obj)
   {
   var pattern = /^\w+$/i;
   var arr = obj.match(pattern);
   if(arr)
  {}
   else
   alert("用户名格式不正确，4-10位数字/字母/下划线");	
   if(obj.length<4||obj.length>10)
   {		
	   alert("用户名格式不正确，4-10位数字/字母/下划线");			}
   }
   function chang2(obj)
   {	
   
	   var pattern = /^\w+$/i;
	   var arr = obj.match(pattern);
	   if(arr)
	  {}
	   else
	   alert("密码格式不正确，4-10位数字/字母/下划线");	
	   if(obj.length<4||obj.length>10)
	   {		
		   alert("密码格式不正确，4-10位数字/字母/下划线");			}

   }*/
  

</script>
</body>
</html>