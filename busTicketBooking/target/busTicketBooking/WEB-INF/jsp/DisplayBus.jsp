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
<tiles:insertDefinition name="base.definition">
	<tiles:putAttribute name="body">

		<body>
			<h3 style="float: right; color: teal">Welcome ,${uname}</h3>
			<h3 style="color: teal; font-size: 20px">Bus Services</h3>
			<br>
			<br>

			<table border="1">


				<tr>
					<th>Sevice Id</th>
					<th>Bus Name</th>
					<th>Provider Name</th>
					<th>Reg Num</th>
					<th>Driver Name</th>
					<th>Contact Num</th>
					<th>Source</th>
					<th>Destination</th>
					<th>Arrival Time</th>
					<th><a href="sort.do">Departure Time</a></th>
					<th>Seats</th>
					<th>Departure Date</th>
				</tr>


				<c:forEach items="${bus}" var="element">
					<tr>
						<td>${element.id}</td>
						<td>${element.busName}</td>
						<td>${element.providerDTO.pname}</td>
						<td>${element.regNo}</td>
						<td>${element.driverName}</td>
						<td>${element.contactNo}</td>
						<td>${element.source}</td>
						<td>${element.destination}</td>
						<td>${element.arrival}</td>
						<td>${element.departure}</td>
						<td>${element.seat}</td>
						<td>${element.ddate}</td>
						<td><a href="booking.do?id=<c:out value="${element.id}"/>">Book</a></td>

					</tr>
				</c:forEach>
			</table>
			<br>
			<br>
			<%-- <br> Filter By :
			<select name="filter"><c:forEach items="${bus}" var="ele">
					<option>${ele.providerDTO.pname}</option>
				</c:forEach>
			</select> --%>

			<br>



		</body>

	</tiles:putAttribute>
</tiles:insertDefinition>

</html>