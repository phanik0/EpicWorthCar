<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet" href = "/resources/style/calendar.css">
</head>
<c:import url="/header" />
<body>
	<div id="root">
	<form method="POST" action="/reserveFormAction">
		<div class="container">
			<div class="content">
				<div class="title_wrap"></div>
				<div class="top_product"></div>
			</div>
			<div class="sidebar">
				<div class="month-container">
					<div class="calendar">
						<div class="header">
							<button id="prevBtn">&lt;</button>
							<h2 id="monthYear">May 2024</h2>
							<button id="nextBtn">&gt;</button>
						</div>
						<div class="days"></div>
					</div>
				</div>
			</div>
		</div>
		<input type="submit" value="예약하기">
		</form>
	</div>
	<script src = "/resources/script/reserve/create-calendar.js"></script>
</body>
</html>
