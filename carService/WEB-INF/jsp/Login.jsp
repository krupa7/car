<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script src="//code.jquery.com/jquery-1.9.1.js"></script>
  <script src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
  <script>
	
$(function() {
	  
    // Setup form validation on the #register-form element
    $("#login").validate({
    
        // Specify the validation rules
        rules: {
         uid: "required",
         
            
            password: {
                required: true,
                minlength: 6
            },
           
        },
        
        // Specify the validation error messages
        messages: {
        	uid: "Please enter your USERID",
            
            password: {
                required: "Please provide a password",
                minlength: "Your password must be at least 6 characters long"
            },
            
        },
        
        submitHandler: function(form) {
            form.submit();
        }
    });

  });
</script>

</head>
<body>


<form action="login.do" method="post" id="login">

<pre>
<spring:message code="label.uid"></spring:message>  : <input type="text" name="uid" id="uid"/><br>
<spring:message code="label.password"></spring:message> : <input type="password" name="password" id="password"/><br><br><br> 
<input type="submit" value="<spring:message code="label.login"/>"/><br><br><br>
<a href="?lan=fr">French</a>
<a href="?lan=en">English</a>
</pre>


</form>

</body>
</html>