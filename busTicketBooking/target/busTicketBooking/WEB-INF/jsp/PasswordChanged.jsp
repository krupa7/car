<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<tiles:insertDefinition name="base.definition">

	<tiles:putAttribute name="menu">
		<h3></h3>
	</tiles:putAttribute>
	<tiles:putAttribute name="body">
		<body>

			<pre>

<h3>Password Successfully Changed !!</h3>
<br><br><br>
<a href="welcome.do">Click here to login</a>

</pre>

		</body>
	</tiles:putAttribute>
</tiles:insertDefinition>

</html>