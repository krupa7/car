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
</style>
<tiles:insertDefinition name="base.definition">

	<tiles:putAttribute name="menu">
		<h3></h3>
	</tiles:putAttribute>
	<tiles:putAttribute name="body">
		<body>
			<form name="forgotPassword" action="sendPassword.do" method="post"
				id="form1">
				<pre>


Enter Email Id         : <input type="text" name="email" id="email" />
			<br>
New Password           : <input type="password" name="password"
						id="password" />
			
			<br>
New Confirm Password   : <input type="password" name="cpass" id="cpass" />
			
<br><br><br>
<input type="submit" value="Change Password" id="btn" />


</pre>
			</form>
		</body>
	</tiles:putAttribute>
</tiles:insertDefinition>


<script src="//code.jquery.com/jquery-1.9.1.js"></script>
<script
	src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>


<!-- <script type="text/javascript" src="jquery-3.1.1.min.js"></script>
 -->
<script>
	$(function() {

		// Setup form validation on the #register-form element
		$("#form1")
				.validate(
						{

							// Specify the validation rules
							rules : {
								email : {
									required : true,
									email : true
								},

								password : {
									required : true,
									minlength : 6
								},
								cpass : {
									required : true,
									minlength : 6
								},

							},

							errorClass : "my-error-class",
							messages : {
								email : {
									required : "Please Enter Email Id",
									email : "Please enter valid email Id"
								},

								password : {
									required : "Please provide a password",
									minlength : "password must be at least 6 characters long"
								},
								cpass : {
									required : "Please provide a confirm password",
									minlength : "Confirm password must be at least 6 characters long"
								},
							},

							submitHandler : function(form) {
								form.submit();
							}
						});

	});
</script>


</html>
