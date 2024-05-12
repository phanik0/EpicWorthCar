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

		<div class="container">
			<div class = "notice_listwrap">
			
			
			</div>
			<div class="user_listwrap">
					<ul>
				<c:forEach var="list" items="${boardList}">
					<li>
					<p >${boardList.number}</p>
					<a href = "/listFormAction">${boardList.title}</a>
					<p>${boardList.id}</p>
					<p>${boardList.write_date}</p>
				
					</li>
				</c:forEach>
					</ul>

			</div>
		</div>

	</div>
</body>
</html>