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
			<a href="/updatePostForm?title=${post.title }&body=${post.body }&number=${post.number } "><button>글 수정</button></a>
			<a href="/deletePostFormAction?number=${post.number }"><button>글 삭제</button></a>
<%-- 		</c:if> --%>
		<div>
		<ul>
		<li>${post.title }</li>
		<li>${post.body }</li>
		</ul>
		</div>

	</div>
</body>
</html>
