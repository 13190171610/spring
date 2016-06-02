<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

	<a href="user/getUser.do">获取用户列表</a>
	<a href="user/addUser.do">添加用户</a>
	<a href="user/updateUser.do">修改用户</a>
	
	<form action="user/getInfo.do" >
		姓名：<input type="text" name="name"></input><br>
		学号：<input type="text" name="number"></input><br>
		兴趣：篮球<input type="checkbox" name="xq" value="篮球"></input>
			   足球<input type="checkbox" name="xq" value="足球"></input>
		 	   排球<input type="checkbox" name="xq" value="排球"></input><br>
		时间：<input type="text" name = "date"><br>
			<input type="submit" value="提交"> 
	</form>
	
	<form action="user/getDate.do">
		时间：<input type="text" name = "date"><br>
			<input type="submit" value="提交"> 
	</form>
	
</body>
</html>