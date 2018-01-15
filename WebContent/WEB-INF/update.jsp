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
	<s:form action="doinsertMovie" method="post" enctype="multipart/form-data">
		<s:textfield name="movieTable.moviename" label="电影名称"/>
		<s:textfield name="movieTable.time" label="时长"/>
		<s:textfield name="movieTable.score" label="分数"/>
		<s:file  name ="fileupload" label="上传图片"/>
		<s:textfield name="movieTable.director" label="导演"/>
		<s:textfield name="movieTable.performer" label="演员"/>
		<s:submit value="提交"/>
	</s:form>
		
</body>
</html>