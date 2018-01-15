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
	<!--查找所有的电影  -->
	<table border="1">
		<tr>
		<th>电影名称</th>
		<th>时间</th>
		<th>分数</th>
		<th>图片</th>
		<th>导演</th>
		<th>演员</th>
		</tr>
		<s:iterator value="list" var ="i">
			<tr>
				<td><a href ="/LaoPao/selfpageMovie?mid=<s:property value="#i.mid"/>"><s:property value="#i.moviename"/></a></td>
				<td><s:property value="#i.time"/></td>
				<td><s:property value="#i.score"/></td>
				<td><img src="<s:property value="#i.imagepath"/>"></td>
				<td><s:property value="#i.director"/></td>
				<td><s:property value="#i.performer"/></td>
				<td><a href="/LaoPao/deleteMovie?mid=<s:property value="#i.mid"/>">删除</a></td>
				<td> <a href="<s:url action='updataMovie'></s:url>">更新</a></td>
			</tr>
		</s:iterator>
	
		
	</table>
	<a href="/LaoPao/insertMovie">新增一个Movie对象</a>
		
			
</body>
</html>