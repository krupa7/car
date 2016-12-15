<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.8.2.min.js"></script>

</head>
<body>

	<form action="service.do" method="post">
		<pre>
                         <h3 style="color: maroon; font-size: 20px">${user}</h3>
<spring:message code="label.owner"/>      : <input type="text" name="owner" id="owner" /><br>
<spring:message code="label.vehicle"/>   : <input type="text" name="vehicleNo" id="vno" /><br>
<spring:message code="label.chassis"/>    : <input type="text" name="chasisNo" id="cno" /><br>
<spring:message code="label.manu"/>     : <select name="manufacturer" id="menu" onchange="getModel(this);">
											<c:forEach items="${manu}" var="element">
			<option>${element.manufacturer}</option>
		</c:forEach></select><br>
<spring:message code="label.model"/>            : <select name="model" id="model"></select><br>
<spring:message code="label.comment"/>          : <textarea name="comment" id="comment" rows="5"
				cols="10"></textarea>
			<br><br><br>
<input type="submit" value="<spring:message code="label.submit"/>" /><br><br><br>

</pre>


	</form>
<script type="text/javascript">
		function getModel(manu) {
			var artistURL = "http://localhost:8095/carService/nuvizz/rest/fetchModel/"
					+ manu.value + "";
			var returnData = '';
			$.ajax({
				type : "GET",
				dataType : "json",
				async : false,
				url : artistURL,
				error : function(request, status, error) {
					alert(request.responseText)
				},
				success : function(data) {

					for (index in data) {

						returnData += '<option>' + data[index].model
								+ '</option>';

					}

					$("#model").html(returnData);
				}
			});
		}
	</script>



</body>
</html>