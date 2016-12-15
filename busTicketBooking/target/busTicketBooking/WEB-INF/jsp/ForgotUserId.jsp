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


			<form name="formId" action="sendId.do" method="post" id="form2">
				<pre>


Enter Email Id : <input type="text" name="email" id="email" />
			
<br><br><br>
<input type="submit" value="Send UserId">


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

		// Setup form validation on the #register-form element
		$("#form2").validate({

			// Specify the validation rules
			rules : {
				email : {
					required : true,
					email : true
				},

			},

			errorClass : "my-error-class",
			messages : {
				email : {
					required : "Please Enter Email Id",
					email : "Please enter valid email Id"
				},

			},

			submitHandler : function(form) {
				form.submit();
			}
		});

	});
</script>



</html>