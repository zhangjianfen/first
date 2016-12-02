<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="resources/css/bootstrap.min.css"></link>
<title>显示Blog列表</title>
</head>
<body>
	<h1 class="page-header">${userName},一共有 ${blogs.size()}条Blog</h1>
	<a class="btn btn-primary" role="button" href="blog/add">添加</a>
	
	<table class="table table-bordered">
		<thead>
			<tr><td>标题</td><td>作者</td><td>内容</td><td>操作</td></tr>
		</thead>
		<tbody>
			<c:forEach var="blog" items="${blogs}">
				<tr>
					<td><a href="blog/${blog.id}">${blog.title}</a></td>
					<td>${blog.author}</td>
					<td>${blog.content}</td>
					<td>
						<a href="blog/delete?id=${blog.id}">删除</a>
						<a href="blog/edit?id=${blog.id}">修改</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>