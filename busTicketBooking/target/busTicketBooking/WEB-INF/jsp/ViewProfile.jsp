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

	<tiles:putAttribute name="body">
		<body>
			<h3 style="color: blue; font-size: 30px">Profile</h3>
			<pre>

User Name     : ${user.username}
Last Name     : ${user.lastname}
Email         : ${user.email}
Phone Number  : ${user.phoneNo}
Address       : ${user.address1},
${user.address2},
${user.city}
${user.state}
${user.country}


</pre>

			<a href="updatePro.do">Update Profile</a>

		</body>

	</tiles:putAttribute>

</tiles:insertDefinition>

</html>