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
            color:#FF0000;  /* red */
        },
 </style>
 <tiles:insertDefinition name="base.definitionAdmin">
<tiles:putAttribute name="body">
<h3 style="color: teal;font-size: 20px">Add Provider</h3>

	<form action="addpro.do" method="post" id="provider"><br><br>

		<pre>

Provider Name 	: <input type="text" name="pname" id="pname" /><br>
Description 	: <textarea rows="5" cols="15" name="description"></textarea>
			<br>
contact Number 	: <input type="number" name="contactNo" id="con" /><br><br><br>

<input type="submit" value="Add Provider" />


</pre>
	</form>
</body>
</tiles:putAttribute>
</tiles:insertDefinition>



<script src="//code.jquery.com/jquery-1.9.1.js"></script>
  <script src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
  

<!-- <script type="text/javascript" src="jquery-3.1.1.min.js"></script>
 --><script>
	
$(function() {
	  
    $("#provider").validate({
    
        rules: {
         pname: "required",
         description: "required",
         contactNo: {
				required : true,
				digits: true,
				minlength : 10
			}
           
        },
        errorClass: "my-error-class",
        messages: {
        	pname: "Please enter Provider Name",
        	description:"Please enter description",
        	contactNo: {
				required : "Please Enter Contact Number",
				minlength : "Please Enter 10 digits",
				digits: "Please Enter Only digits"
			}    
            
        },
        
        submitHandler: function(form) {
            form.submit();
        }
    });

  });
	
</script>


</html>