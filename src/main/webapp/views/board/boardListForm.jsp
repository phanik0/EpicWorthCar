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
			<a href="/writePostForm"><button>글쓰기</button></a>

			<div class="notice_listwrap">
			<ul>
					<c:forEach var="list" items="${noticeList}">
						<li><p>${list.number}</p> <a
							href="/findNoticeAction?number=${list.number}">${list.title}</a>
							<p>${list.id}</p>
							<p>${list.write_date}</p></li>
					</c:forEach>
				</ul>
			</div>
			<div class="user_listwrap">
				<ul>
					<c:forEach var="list" items="${boardList}">
						<li><p>${list.number}</p> <a
							href="/findPostAction?number=${list.number}">${list.title}</a>
							<p>${list.id}</p>
							<p>${list.write_date}</p></li>
					</c:forEach>
				</ul>

			</div>
		</div>

	</div>




</body>
</html>