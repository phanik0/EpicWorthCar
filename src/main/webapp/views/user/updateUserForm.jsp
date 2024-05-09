<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/style/form.css">
</head>
<c:import url="/header" />

<body>
	<c:if test="${empty user  }">
		<c:redirect url="/login" />
	</c:if>
	<section id="root">
		<h2>회원정보 수정</h2>
		<form method="POST" action="/updateFormAction">
			<div>
				<input type="text" id="id" name="id" value="${user.id }" disabled>
				<input type="password" id="password" name="password"
					placeholder="비밀번호"> <input type="password"
					id="password-new" name="password-new" placeholder="새로운 비밀번호">
				<input type="text" id="email" name="email"
					value="${not empty user.email ? user.email : ''}"
					placeholder="[선택] 이메일주소 (비밀번호 찾기 등 본인 확인용)">
			</div>
			
			<div>
				<input type="text" id="name" name="name" value="${user.name }"
					disabled> 
				
				<input type="text" id="phone" name="phone" value="${user.phone }">
			</div>
			<div class="error-container">
				
				<p class="error-msg" id="error-msg-phone-pattern">* 휴대전화번호:
					휴대전화번호가 정확한지 확인해 주세요.</p>
			</div>
			
			
			<input type="submit" value="회원정보 수정">
		</form>
	</section>
</body>
<jsp:include page="/footer" />
</html>