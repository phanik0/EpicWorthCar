<!-- header.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Epic Worth Car</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<c:choose>
    <c:when test="${not empty isLoggedIn and isLoggedIn}">
       
        <style type="text/css">
            #loginButtons .loginBtn,
            #loginButtons .signupBtn {
                display: none;
            }
        </style>
    </c:when>
    <c:otherwise>
        
        <style type="text/css">
            #loginButtons .logoutBtn,
            #loginButtons .myPageBtn {
                display: none;
            }
        </style>
    </c:otherwise>
</c:choose>

</head>
<body>


<div id="loginButtons">
    <button class="loginBtn">로그인</button>
    <button class="signupBtn">회원가입</button>
    <button class="logoutBtn">로그아웃</button>
    <button class="myPageBtn">마이페이지</button>
</div>
<script src="/resources/script/header.js"></script>
</body>
</html>
