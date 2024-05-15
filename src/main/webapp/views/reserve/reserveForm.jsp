<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/style/calendar.css">
</head>
<c:import url="/header" />
<body>
	<div id="root">
		<form method="POST" action="/reserveFormAction">
			<div class="container">
				<div class="content">
					<div class="title_wrap"></div>
					<div class="car_box">
						<div class="car_image"></div>
						<div class="car_info">
							<p class="car_logo"></p>
							<div class="brand_info">
								<h2>
									${car.brand} <strong>${car.name }</strong>
								</h2>
								<p class="sub_info">${car.model }</p>
							</div>
						</div>
						<ul class="car_spec">
							<li><p class="ico">
									<img src="/assets/img/contents/ico_oil.png" alt="">
								</p>
								<p class="sbj">연료</p>
								<p class="obj">${car.engine }</p></li>
							<li><p class="ico">
									<img src="/assets/img/contents/ico_oil.png" alt="">
								</p>
								<p class="sbj">색깔</p>
								<p class="obj">${car.color }</p></li>
							<li><p class="ico">
									<img src="/assets/img/contents/ico_oil.png" alt="">
								</p>
								<p class="sbj">차종</p>
								<p class="obj">${car.type }</p></li>
						</ul>
					</div>
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
			<input type="hidden" name="startDay" id="startDayInput">
			 <input	type="hidden" name="endDay" id="endDayInput">
			 	<input	type="hidden" name="carCode" id="carCode" value = "${car.code }">
			 
			  <input type="submit" id = "reserve" value="예약하기">
		</form>
	</div>
	<script src="/resources/script/reserve/create-calendar.js"></script>
</body>
</html>
