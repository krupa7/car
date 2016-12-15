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
			<h3 style="color: teal; font-size: 20px">Add Service</h3>
			<br>
			<br>


			<form action="addser.do" method="post" id="service">

				<pre>

Bus Name : <input type="text" name="busName" id="busName" /><br>
Registration Number :<input type="number" name="regNo" id="regNo" /><br>
Driver Name : <input type="text" name="driverName" id="driverName" /><br>
Contact No : <input type="text" name="contactNo" id="contactNo" /><br>
Source : <input name="source" id="source" /><br>
Destination :<input name="destination" id="destination" /><br>
Arrival Time : <input type="text" name="arrival" id="arrival" /><br>
Departure Time : <input type="text" name="departure" id="departure" /><br>
Seats :<input type="number" name="seat" id="seat" /><br>
Departure Date : <input type="text" name="ddate" id="startDatePicker" /> 
<script>
	$(document).ready(function() {
		var dateToday = new Date();
		$("#startDatePicker").datepicker({
			//dateFormat : "yy-mm-dd",
			minDate : dateToday
		});
	});
</script>
					<br><br><br>

<input type="submit" value="Add Service" />


</pre>
			</form>
		</body>
	</tiles:putAttribute>
</tiles:insertDefinition>


<!-- <script src="//code.jquery.com/jquery-1.9.1.js"></script>
	 -->
<script
	src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
<script>
	$.validator.addMethod("time24", function(value, element) {
		return /^([01]?[0-9]|2[0-3])(:[0-5][0-9]){2}$/.test(value);
	}, "Invalid time format.");
	$(function() {

		$("#service").validate({

			rules : {
				busName : "required",
				regNo : "required",
				driverName : "required",
				contactNo : {

					required : true,
					minlength : 10,
					digits : true
				},
				source : "required",
				destination : "required",
				arrival : {
					required : true,
					time24 : true
				},
				departure : {
					required : true,
					time24 : true
				},
				seat : "required"
			},

			errorClass : "my-error-class",
			messages : {
				busName : "Enter Bus Name",
				regNo : "Enter registration Number",
				driverName : "Enter Driver Name",
				contactNo : {
					digits : "Please Enter Only digits",
					required : "Enter Contact Number",
					minlength : "Enter 10 digits"
				},
				source : "Enter Source",
				destination : "Enter Destination",
				arrival : {
					required : "Enter Arrival Time",
					time24 : "Enter Valid Time"
				},
				departure : {
					required : "Enter departure Time",
					time24 : "Enter Valid Time"
				},
				seat : "Enter Number of Seats"
			},

			submitHandler : function(form) {
				form.submit();
			}
		});

	});
</script>
</html>