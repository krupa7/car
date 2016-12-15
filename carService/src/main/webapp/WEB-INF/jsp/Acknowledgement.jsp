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



<h2 style="color: teal;font-size: 30px"><spring:message code="label.text"/>           ${user}</h2>
<pre>
<spring:message code="label.owner"/>    : ${obj.owner}
<spring:message code="label.vehicle"/>  : ${obj.vehicleNo}
<spring:message code="label.chassis"/>  : ${obj.chasisNo}
<spring:message code="label.manu"/>     : ${obj.manufacturer}
<spring:message code="label.model"/>    : ${obj.model}
<spring:message code="label.date"/>     : ${obj.date}
<spring:message code="label.comment"/>  : ${obj.comment}


</pre>
<a href="procedure.do"><spring:message code="label.allrecords"></spring:message>   </a>

</body>
</html>