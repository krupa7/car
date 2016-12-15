<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>

		<tr>
			<th>Vehicle No</th>
			<th>Chassis No</th>
			<th>Manufacturer</th>
			<th>Model</th>
		</tr>

		<c:forEach items="${records}" var="element">
			<tr>
				<td>${element.vehicleNo}</td>
				<td>${element.chasisNo}</td>
				<td>${element.manufacturer}</td>
				<td>${element.model}</td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>