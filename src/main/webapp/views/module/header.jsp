<!-- header.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Epic Worth Car</title>
<link rel="stylesheet" href="/resources/style/header.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link>
<%-- <c:choose> --%>
<%--     <c:when test="${not empty user }"> --%>

<!--         <style type="text/css"> -->
<!-- /*             #loginButtons .loginBtn, */ -->
<!-- /*             #loginButtons .signupBtn { */ -->
<!-- /*                 display: none; */ -->
<!-- /*             } */ -->
<!--         </style> -->
<%--     </c:when> --%>
<%--     <c:otherwise> --%>

<!--         <style type="text/css"> -->
<!-- /*             #loginButtons .logoutBtn, */ -->
<!-- /*             #loginButtons .myPageBtn { */ -->
<!-- /*                 display: none; */ -->
<!-- /*             } */ -->
<!--         </style> -->
<%--     </c:otherwise> --%>
<%-- </c:choose> --%>

</head>
<body>

	<header>
		<h1>
			<a class="brand " href = "/mainFormAction">EpicWorthCar</a>
		</h1>
		<nav>
			<ul>
				<li class = "reserveBtn"><a href = "/mainFormAction">예약</a></li>
				<li class = "mypageBtn"><a href = "/mypage">예약확인</a></li>
				<li class = "boardBtn"><a href = "/boardListFormAction">게시판</a></li>	
			</ul>
		</nav>
		<div class = "member">
		<ul class="${not empty user ? 'userLoggedIn' : 'userLoggedOut'}">
			<li class="loginBtn"><a href = "/login" >로그인</a></li>
			<li class="signupBtn"><a href = "/join" >회원가입</a></li>
			<li class="logoutBtn"><a href = "/logout" >회원가입</a></li>
			<li class="myPageBtn"><a href = "/mypage" >회원가입</a></li>
		</ul>
		</div>
<%-- 		<div id="loginButtons" class="${not empty user ? 'userLoggedIn' : ''}"> --%>
<!-- 			<button onclick="location.href='/login'" class="loginBtn">로그인</button> -->
<!-- 			<button onclick="location.href='/join'" class="signupBtn">회원가입</button> -->
<!-- 			<button onclick="location.href='/logout'" class="logoutBtn">로그아웃</button> -->
<!-- 			<button onclick="location.href='/mypage'" class="myPageBtn">마이페이지</button> -->
<!-- 		</div> -->
	</header>
</body>
</html>
