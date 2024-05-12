<%@page import="epicworthcar.user.model.cars.CarsDao"%>
<%@page import="epicworthcar.user.model.cars.CarsResponseDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<c:import url="/header" />
<body>
	<div id="root">

		<div class="container">
			<div class="content">
				<c:forEach var="car" items="${carList}">
					<div class="car_box">
						<div class="car_model"></div>
						<ul class="car_info_box">
							<li class="car_info" ><a class="info_list">
									<div class="car_name">${car.name}</div>
									<div class="price_wrap">
										<div class="price_info">${car.rental_fee}</div>
										<div class="reserve_btn" ">
											<form method="POST" action="/findCarInfoAction">
											 <input type="hidden" name="carCode" value="${car.code}">
												<button class="reserve ">예약</button>
											</form>
										</div>
									</div>
							</a></li>
						</ul>
					</div>

				</c:forEach>
			</div>
		</div>

	</div>
</body>
</html>