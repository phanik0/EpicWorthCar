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

<%-- 		<c:if test="${sessionScope.user.id == post.id}"> --%>
			<a href="/updatePostForm?title=${notice.title }&body=${notice.body }&number=${post.number } "><button>글 수정</button></a>
			<a href="/deletePostFormAction?number=${notice.number }"><button>글 삭제</button></a>
<%-- 		</c:if> --%>
		<div>
		<ul>
		<li>${notice.title }</li>
		<li>${notice.body }</li>
		</ul>
		</div>

	</div>
</body>
</html>
