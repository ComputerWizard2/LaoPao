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
		<table border="1">
		<tr>
		<th>电影名</th>
		<th>时长</th>
		<th>评分</th>
		<th>图片</th>
		<th>导演</th>
		<th>演员</th>
		</tr>
			<tr>
				<td><s:property value="movieTable.moviename"/></td>
				<td><s:property value="movieTable.time"/></td>
				<td><s:property value="movieTable.score"/></td>
				<td><img src="<s:property value="movieTable.imagepath"/>"></td>
				<td><s:property value="movieTable.director"/></td>
				<td><s:property value="movieTable.performer"/></td>
			</tr>
		
		<s:iterator value="select" var="i">
		<tr>
		<td>评论</td>
		<td>
		
		<s:property value="#i.decs"/>
	
		</td>
		
		</tr>
			</s:iterator>
		</table>
		
		<s:form action ="/updateDescMovie" method="post">
			<s:hidden value="3" name="movieTable.mid"/>
			<s:textarea name="movieDec.decs" label="评论"/>
			<s:select label="评分" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5','6':'6','7':'7','8':'8','9':'9','10':'10'}" name ="movieDec.score"/>
			<s:submit value ="提交"/>
		</s:form>
		
</body>
</html>