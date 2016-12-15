<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style type="text/css">
.my-error-class {
	color: #FF0000; /* red */
}
,
</style>

<tiles:insertDefinition name="base.definition">
	<tiles:putAttribute name="body">
		<body>



			<h3 style="float: right; color: teal">Welcome ,${uname}</h3>

			<form action="confirmBooking.do" method="post" id="seat">
				<pre>

Available Seats : <input type="text" name="anum" id="anum"
						value="${seat}" disabled="disabled" /> 

No of tickets : <input type="text" name="num" id="num"/><p style="color: red"  id="error"></p>
						<!-- onblur="return checkSeat()" --> <br><br><br>

<input type="submit" value="Confirm Booking" id="button"/> 


</pre>
				
			</form>
		</body>

	</tiles:putAttribute>
</tiles:insertDefinition>

<script src="//code.jquery.com/jquery-1.9.1.js"></script>
<script
	src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
<script>
	$(function() {

		$("#seat").validate({

			rules : {
				num : {
					digits : true,
					required : true
				}
			},
			errorClass : "my-error-class",
			messages : {
				num : {
					digits : "Only Digits",
					required : "Please enter No of Tickets"
				}
			},

			submitHandler : function(form) {
				form.submit();
			}
		});

	});
	$(document).ready(function(){
	    $("#button").click(function(){
	    	var aseat = document.getElementById('anum').value;
			var full = document.getElementById('num').value;
			if (aseat < full) {
				document.getElementById("error").innerHTML = "Number of tickets you have entered are Not available...";
				return false;
			}
	    });
	});
</script>
<!-- <script type="text/javascript">
	function checkSeat() {
		var aseat = document.getElementById('anum').value;
		var full = document.getElementById('num').value;
		if (aseat < full) {
			document.getElementById("error").innerHTML = "Tickets Not available";
			return false;
		}
	}
</script> -->

</html>