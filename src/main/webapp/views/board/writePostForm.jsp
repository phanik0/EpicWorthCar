<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

</head>
<c:import url="/header" />
<body>
<div id="root">
<form method = "POST" action = "/writePostFormAction">
		<div>
		<ul>
		<li id = "title"><input type = "text" name = "title"></li>
		<li id = "body"><input type = "text" name = "body"></li>
		</ul>
		</div>
		<input type = "submit" value = "글쓰기">
</form>
	</div>
</body>
</html>