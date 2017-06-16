<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="notice${path}" method="post">
		<p><input type="hidden" name="num" value="${dto.num}"></p>
		<p><input type="text" name="writer" value="${dto.writer}"></p>
		<p><input type="text" name="title" value="${dto.title}"></p>
		<p><input type="text" name="contents" value="${dto.contents}"></p>
		<p><input type="submit" name="WRITE"></p>
	</form>
	
	
</body>
</html>