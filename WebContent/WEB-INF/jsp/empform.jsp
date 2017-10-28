<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Form</title>
</head>
<body>

<form:form method="POST" action="save">
	<table>
		<tr>
			<td>Name:</td>
			<td><form:input path="name"/></td>
		</tr>
		<tr>
			<td>Salary:</td>
			<td><form:input path="salary"/></td>
		</tr>
		<tr>
			<td>Designation:</td>
			<td><form:input path="designation"/></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Save"></td>
		</tr>
	</table>

</form:form>

</body>
</html>