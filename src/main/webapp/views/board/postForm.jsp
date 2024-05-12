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

		<div>
		<ul>
		<li>${post.title }</li>
		<li>${post.body }</li>
		</ul>
		</div>

	</div>
</body>
</html>