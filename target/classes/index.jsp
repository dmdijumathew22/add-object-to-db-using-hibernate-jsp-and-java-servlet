<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student Details</title>
</head>
<body>
	<form action= "/myweb/student" method="post">
	<table style="with: 50%">
				<tr>
					<td>First Name</td>
					<td><input type="text" name="first_name" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="last_name" /></td>
				</tr>
				<tr>
					<td> Percentage</td>
					<td><input type="text" name="percentage"/></td>
				</tr>
	</table>
	<input type="submit" value="Add Details"/>	
	
	</form>
</body>
</html>