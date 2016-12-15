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

			<h3 style="color: teal; font-size: 20px">Providers</h3>
			<br>
			<br>

			<table border="1">


				<tr>
					<th>Provider Id</th>
					<th>Provider Name</th>
					<th>Description</th>
					<th>Contact</th>
				</tr>


				<c:forEach items="${pro}" var="element">
					<tr>
						<td>${element.pid}</td>
						<td>${element.pname}</td>
						<td>${element.description}</td>
						<td>${element.contactNo}</td>
						<td><a href="edit.do?id1=<c:out value="${element.pid}"/>">Edit</a></td>
						<td><a href="delete.do?id2=<c:out value="${element.pid}"/>">Delete</a></td>
						<td><a
							href="viewservice.do?id3=<c:out value="${element.pid}"/>">View
								Services</a></td>

					</tr>
				</c:forEach>

			</table>
			<br>
			<br>
			<br>
			<a href="addprovider.do">Add Provider</a>

		</body>
	</tiles:putAttribute>
</tiles:insertDefinition>

</html>