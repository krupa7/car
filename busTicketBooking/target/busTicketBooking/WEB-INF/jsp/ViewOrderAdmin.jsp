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


			<h3 style="color: teal; font-size: 20px">Order History</h3>
			<br>
			<br>
			<table border="1">


				<tr>
					<th>Order Id</th>
					<th>User Name</th>
					<th>Bus Name</th>
					<th>Source</th>
					<th>Destination</th>
					<th>Date of Booking</th>
					<th>No of Tickets Booked</th>
				</tr>


				<c:forEach items="${order1}" var="element">
					<tr>
						<td>${element.oid}</td>
						<td>${element.username}</td>
						<td>${element.busname}</td>
						<td>${element.source}</td>
						<td>${element.destination}</td>
						<td>${element.bookdate}</td>
						<td>${element.ticket}</td>


					</tr>
				</c:forEach>

			</table>
		</body>
	</tiles:putAttribute>
</tiles:insertDefinition>

</html>