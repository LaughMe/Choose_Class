<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery_3.4.1.js"></script>
<script type="text/javascript">
function selectall()
{
	
	var flag=$("#selectAll").prop("checked");
	$(".ah").prop("checked",flag);
	}

</script>
</head>
<body>
<input type="checkbox" onclick="selectall()" id="selectAll">全选<br>
<input type="checkbox" class="ah">1<br>
<input type="checkbox" class="ah">2<br>
<input type="checkbox" class="ah">3<br>

</body>
</html>