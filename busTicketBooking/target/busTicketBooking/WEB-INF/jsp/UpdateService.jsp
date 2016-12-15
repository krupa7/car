<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.12.4.js"></script>
<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

</head>
<style type="text/css">
.my-error-class {
	color: #FF0000; /* red */
}
</style>
<tiles:insertDefinition name="base.definitionAdmin">
	<tiles:putAttribute name="body">
		<body>

			<h3 style="color: teal; font-size: 20px">Update Service</h3>
			<br>
			<br>

			<form action="editser.do" method="post" id="service">

				<pre>

Bus Name : <input type="text" name="busName" id="busName"
						value="${sdto.busName}" disabled="disabled" /><br>
Registration Number :<input type="number" name="regNo" id="regNo"
						value="${sdto.regNo}" /><br>
Driver Name : <input type="text" name="driverName" id="driverName"
						value="${sdto.driverName}" /><br>
Contact No : <input type="text" name="contactNo" id="contactNo"
						value="${sdto.contactNo}" /><br>
Source : <input name="source" id="source" value="${sdto.source}" /><br>
Destination :<input name="destination" id="destination"
						value="${sdto.destination}" /><br>
Arrival Time : <input type="text" name="arrival" id="arrival"
						value="${sdto.arrival}" /><br>
Departure Time : <input type="text" name="departure" id="departure"
						value="${sdto.departure}" /><br>
Seats :<input type="number" name="seat" id="seat" value="${sdto.seat}" /><br>
Departure Date : <input type="text" name="ddate" value="${sdto.ddate}" id="startDatePicker" /> 
<script>
	$(document).ready(function() {
		var dateToday = new Date(); 
		$("#startDatePicker").datepicker({ 
			/* dateFormat: "yy-mm-dd", */minDate: dateToday});
	});
</script>
					<br><br><br>

<input type="submit" value="Update" />


</pre>
			</form>
		</body>
	</tiles:putAttribute>
</tiles:insertDefinition>

<script
	src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
<script>
	$(function() {

		$("#service").validate({

			rules : {
				regNo : "required",
				driverName : "required",
				contactNo : {

					required : true,
					minlength : 10,
					digits : true
				},
				source : "required",
				destination : "required",
				arrival : "required",
				departure : "required",
				seat : "required"
			},
			errorClass : "my-error-class",
			messages : {
				regNo : "Enter registration Number",
				driverName : "Enter Driver Name",
				contactNo : {
					digits : "Please Enter Only digits",
					required : "Enter Contact Number",
					minlength : "Enter 10 digits"
				},
				source : "Enter Source",
				destination : "Enter Destination",
				arrival : "Enter Arrival Time",
				departure : "Enter Departure Time",
				seat : "Enter Number of Seats"
			},

			submitHandler : function(form) {
				form.submit();
			}
		});

	});
</script>
</html>