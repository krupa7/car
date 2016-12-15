<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<tiles:insertDefinition name="base.definition">

		<tiles:putAttribute name="menu">
			<h3></h3>
		</tiles:putAttribute>
		<tiles:putAttribute name="body">
			<pre>

<a href="forgotUserId.do" style="color: red; font-size: 20px">Forgot UserId</a><br><br><br>
<a href="forgotPassword.do" style="color: red; font-size: 20px">Forgot Password</a>

</pre>

		</tiles:putAttribute>
	</tiles:insertDefinition>



</body>
</html>