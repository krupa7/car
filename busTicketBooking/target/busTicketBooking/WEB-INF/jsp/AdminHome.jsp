<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<tiles:insertDefinition name="base.definitionAdmin">
<tiles:putAttribute name="body">
<body>


<p style="color: maroon;font-size: 20px">Welcome ,${uname}</p><br><br><br>

</body>
</tiles:putAttribute>
</tiles:insertDefinition>

</html>