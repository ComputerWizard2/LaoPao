<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:form method="post" action="/registedo">
		<s:textfield name="users.username" label="姓名"/>
		<s:password name="users.password" label="密码"/>
		<s:radio list="#{'男':'男','女':'女'}" value="男" name ="users.sex" label="性别"/>
		<s:select list="#{'吃饭':'吃饭','睡觉':'睡觉','打豆豆':'打豆豆'}" name ="users.hobby" label="兴趣"/>
		<s:textfield name="users.birthday" label="生日" />
		<s:textarea rows="10" cols="10" name ="users.common"/>
		<s:submit value="注册"/>
	</s:form>
	
	
</body>
</html>