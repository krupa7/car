<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h3 style="color: blue; font-size: 20px;"><spring:message code="label.welcome"/>  ${user}</h3><br><br><br>
<a href="serviceCar.do"><spring:message code="label.service"></spring:message>   </a>
<a href="procedure.do"><spring:message code="label.allrecords"></spring:message>   </a>

</body>
</html>