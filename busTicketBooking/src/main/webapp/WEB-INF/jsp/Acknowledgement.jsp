<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<tiles:insertDefinition name="base.definition">
	<tiles:putAttribute name="body">

		<body>
			<h3 style="float: right; color: teal">Welcome ,${uname}</h3>

			<h3 style="color: maroon; font-size: 20px">Ticket Booked !!</h3>

			<pre>

Bus Name             :${bdto.busName}
Reg Num              :${bdto.regNo}
Driver Name          :${bdto.driverName}
Contact Num          :${bdto.contactNo}
Source               :${bdto.source}
Destination          :${bdto.destination}
Arrival Time         :${bdto.arrival}
Departure Time       :${bdto.departure}
Departure Date		 :${strdate}
No of Tickets Booked :${tno}



<br><br><br>
<a href="home1.do">Go to Home</a>
</pre>

		</body>
	</tiles:putAttribute>
</tiles:insertDefinition>

</html>