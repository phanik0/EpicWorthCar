<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<c:import url="/header"/>
<body>
<div id="root">
	<form method="POST" action="/reserveFormAction">
		<div class="container">
			<div class="content">
				<div class="title_wrap"></div>
				<div class="top_product"></div>
			</div>
			
		</div>
		<input type="submit" value="예약하기">
		</form>
	</div>
</body>
</html>