<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改Blog</title>
</head>
<body>
	<form method="post">
		标题：<input type="text" name="title" value="${blog.title}"/><br/>
		作者：<input type="text" name="author" value="${blog.author}"/><br/>
		内容：<textarea name="content" rows="5" cols="80">${blog.content}</textarea> <br/>
		<input type="submit">
	</form>
</body>
</html>