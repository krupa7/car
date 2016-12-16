<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
<script src="//code.jquery.com/jquery-1.9.1.js"></script>
<script
	src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>

</head>
<style type="text/css">
.my-error-class {
	color: #FF0000; /* red */
}
</style>
<tiles:insertDefinition name="base.definition">
	<tiles:putAttribute name="body">

		<body>
			<h3 style="color: teal; font-size: 20px">Update Profile</h3>
			<br>
			<br>


			<form action="updateProfile.do" method="post" id="register">
				<pre>
				UserName         : <input type="text" name="username" id="username"
						value="${user.username}" disabled="disabled" /><br>
				Last Name        : <input type="text" name="lastname" id="lastname"
						value="${user.lastname}" /><br> 
				Password 		 : <input type="password" name="password" id="password"
						value="${user.password}" /><br> 
				Confirm Password : <input type="password" name="cpass" id="cpass"
						value="${user.cpass}" /><br>
				Email            : <input type="text" name="email" id="email"
						value="${user.email}" /><br> 
				<!-- <div id="div1"></div> -->
				Phone Number     : <input type="text" name="phoneNo" id="phoneNo"
						value="${user.phoneNo}" /><br> 
				Country          : <select name="country" id="country"
						onchange="getState(this);"><option selected="selected">Select</option>
					<c:forEach items="${country}" var="element">
						<option>${element.country}</option>
					</c:forEach>
				</select><br> 
				State            : <select name="state" id="state"
						onchange="getCity(this);"><option selected="selected">Select</option></select><br>
				 City            : <select name="city" id="city"><option
							selected="selected">Select</option></select><br>
				 Address1        :  <input type="text" name="address1" id="add1"
						value="${user.address1}" /><br>
				Address2         : <input type="text" name="address2" id="add2"
						value="${user.address2}" /><br> <br> <br> <br>
				<input type="submit" value="Update" /><br> <br> <br>

</pre>


			</form>
		</body>
	</tiles:putAttribute>

</tiles:insertDefinition>
<script type="text/javascript">
	function getState(country) {
		var artistURL = "http://localhost:8080/busTicketBooking/nuvizz/rest/fetchState/"
				+ country.value + "";
		var returnData = '';
		$.ajax({
			type : "GET",
			dataType : "json",
			async : false,
			url : artistURL,

			success : function(data) {

				for (index in data) {

					returnData += '<option>' + data[index].state + '</option>';

				}

				$("#state").html(returnData);
			}
		});
	}

	function getCity(city) {
		var artistURL = "http://localhost:8080/busTicketBooking/nuvizz/rest/fetchCity/"
				+ city.value + "";
		var returnData = '';
		$.ajax({
			type : "GET",
			dataType : "json",
			async : false,
			url : artistURL,
			error : function(request, status, error) {
				alert(request.responseText)
			},
			success : function(data) {

				for (index in data) {

					returnData += '<option>' + data[index].city + '</option>';

				}

				$("#city").html(returnData);
			}
		});
	}

	/* 	function checkemail(email) {
			var artistURL = "http://localhost:8091/busTicketBooking/nuvizz/rest/checkEmail/"
					+ email.value + "";
			var returnData = '';
			$
					.ajax({
						type : "GET",
						dataType : "json",
						async : false,
						url : artistURL,
						error : function(request, status, error) {
							alert(request.responseText)
						},
						success : function(data) {

							if (data != null)
								returnData += 'Email Already Exist...please Enter Another Email ID';

							$("#div1").html(returnData);
						}
					});
		} */

	$(function() {

		$("#register")
				.validate(
						{

							rules : {

								lastname : "required",
								country : "required",
								state : "required",
								city : "required",
								address1 : "required",
								email : {
									required : true,
									email : true
								},
								phoneNo : {
									required : true,
									digits : true,
									minlength : 10
								},
								password : {
									required : true,
									minlength : 6
								},
								cpass : {
									required : true,
									minlength : 6
								}

							},
							errorClass : "my-error-class",
							messages : {

								lastname : "Please enter Last Name",
								country : "Please select Country",
								state : " Please select State",
								city : "Please select City",
								address1 : "Please Enter Address",

								password : {
									required : "Please provide a password",
									minlength : "Your password must be at least 6 characters long"
								},
								cpass : {
									required : "Please provide a Confirm password",
									minlength : "Password must be at least 6 characters long"
								},
								phoneNo : {
									required : "Enter Phone Number",
									digits : true,
									minlength : "Please enter 10 digits"
								},
								email : {
									required : "Please Enter Email Id",
									email : "Enter Valid Email Id"
								}

							},

							submitHandler : function(form) {
								form.submit();
							}
						});

	});
</script>






</html>