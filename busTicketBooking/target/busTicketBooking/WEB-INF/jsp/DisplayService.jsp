<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<tiles:insertDefinition name="base.definitionAdmin">
	<tiles:putAttribute name="body">
		<body>

			<h3 style="color: teal; font-size: 20px">Services</h3>
			<br>
			<br>

			<table border="1">


				<tr>
					<th>Sevice Id</th>
					<th>Bus Name</th>
					<th>Reg Num</th>
					<th>Driver Name</th>
					<th>Contact Num</th>
					<th>Source</th>
					<th>Destination</th>
					<th>Arrival Time</th>
					<th>Departure Time</th>
					<th>Seats</th>
					<th>Departure Date</th>
				</tr>


				<c:forEach items="${service}" var="element">
					<tr>
						<td>${element.id}</td>
						<td>${element.busName}</td>
						<td>${element.regNo}</td>
						<td>${element.driverName}</td>
						<td>${element.contactNo}</td>
						<td>${element.source}</td>
						<td>${element.destination}</td>
						<td>${element.arrival}</td>
						<td>${element.departure}</td>
						<td>${element.seat}</td>
						<td>${element.ddate}</td>
						<td><a href="edit1.do?id4=<c:out value="${element.id}"/>">Edit</a></td>
						<td><a href="delete1.do?id5=<c:out value="${element.id}"/>">Delete</a></td>

					</tr>
				</c:forEach>

			</table>
			<br>
			<br>
			<br>
			<a href="addservice.do"> Add Service</a>
			<%-- <a href="addservice.do?id6=<c:out value="${element.id}"/>"> --%>

		</body>
	</tiles:putAttribute>
</tiles:insertDefinition>

</html>