<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
<tiles:insertDefinition name="base.definition">

	<tiles:putAttribute name="body">
		<body>
			<h3 style="float: right; color: teal">Welcome ,${uname}</h3>

			<h3 style="color: teal; font-size: 20px">Book Bus</h3>
			<br>
			<br>
			<form action="searchBus.do" method="post" id="book">


				<pre>
Source : <select name="source" id="source"><c:forEach
							items="${slist}" var="element">
			<option>${element}</option>
		</c:forEach></select><br>
Destination : <select name="destination" id="destination"><c:forEach
							items="${dlist}" var="element">
			<option>${element}</option>
		</c:forEach></select><br><p id="error" style="color: red"></p>
		
Date : <input type="text" name="date1" id="startDatePicker" /> 
<script>
	$(document).ready(function() {
		var dateToday = new Date();
		$("#startDatePicker").datepicker({
			dateFormat : "mm/dd/yy",
			minDate : dateToday
		});
	});
</script>
			<br><br><br>
<input type="submit" value="Search" id="button" />


</pre>

			</form>


		</body>
	</tiles:putAttribute>
</tiles:insertDefinition>


<script
	src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>

<script>
	$(function() {

		$("#book").validate({

			rules : {
				source : "required",
				destination : "required",
				date1 : {
					required : true,
					date : true
				}

			},
			errorClass : "my-error-class",
			messages : {
				source : "Please select Source",
				destination : "Please select destination",
				date1 : {
					required : "Select date",
					date : "Enter Valid Date"
				}

			},

			submitHandler : function(form) {
				form.submit();
			}
		});

	});

	$(document)
			.ready(
					function() {
						$("#button")
								.click(
										function() {
											var src = document
													.getElementById('source').value;
											var dest = document
													.getElementById('destination').value;
											if (src == dest) {
												document
														.getElementById("error").innerHTML = "Source And Destination cannot be same !! Please select different destination !!!";
												return false;
											}
										});
					});
</script>




</html>