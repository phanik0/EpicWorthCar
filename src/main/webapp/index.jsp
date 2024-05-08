<%@page import="epicworthcar.user.model.Cars"%>
<%@page import="epicworthcar.user.model.CarsResponseDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="epicworthcar.user.model.CarsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>hello</h1>
	<%
	
	List<CarsResponseDto> list = CarsDao.getInstance().findCarAll();

	for(int i = 0 ; i<list.size(); i++){
		out.print(list.get(i));
	}
	%>
</body>
</html>