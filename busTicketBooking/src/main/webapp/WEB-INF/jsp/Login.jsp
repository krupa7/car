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

<tiles:putAttribute name="menu">
<h3></h3>
</tiles:putAttribute>
	<tiles:putAttribute name="body">
		<body>

			<script src="//code.jquery.com/jquery-1.9.1.js"></script>
			<script
				src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
			<script>
				$(function() {
					$("#login")
							.validate(
									{

										rules : {
											username : "required",

											password : {
												required : true,
												minlength : 6
											},

										},
										errorClass : "my-error-class",

										messages : {
											userId : "Please enter your USERID",

											password : {
												required : "Please provide a password",
												minlength : "Your password must be at least 6 characters long"
											},

										},

										submitHandler : function(form) {
											form.submit();
										}
									});

				});
			</script>


			<form name="login" action="login.do" method="post" id="login">
				<pre>

UserName : <input type="text" name="username" id="username" />
			<div id="div1"></div>
Password : <input type="password" name="password" id="password" />
			<div id="div1"></div>
<input type="submit" value="Login" id="login1" /><br><br><br>
<!-- <a href="Forgot.jsp" style="color: red; font-size: 20px">Forgot</a>
 -->
 
 <a href="newreg.do" style="font-size: 20px">New Registration</a><br><br>
 <a href="forgot.do" style="color: red; font-size: 20px">Forgot</a>
 
		</pre>

			</form>

		</body>
	</tiles:putAttribute>

</tiles:insertDefinition>

</html>