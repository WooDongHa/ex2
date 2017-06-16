<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Notice View</h1>
	<h3>WRITER : ${dto.writer}</h3>
	<h3>TITLE : ${dto.title}</h3>
	<h3>CONTENTS : ${dto.contents}</h3>
	
	<a href="noticeDelete?num=${dto.num}">DELETE</a>
	<a href="noticeUpdate?num=${dto.num}">UPDATE</a>
	
</body>
</html>