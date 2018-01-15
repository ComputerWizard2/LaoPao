<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:form action="/logindo" method ="post">
		<s:textfield name="users.username" label="姓名"/>
		<s:password name="users.password" label="密码"/>
		<s:submit value="登录"/>
		<s:reset value="重置"/>
		
	</s:form>
	<a href="<s:url action="registerdo"></s:url>">注册用户</a>
</body>
</html>