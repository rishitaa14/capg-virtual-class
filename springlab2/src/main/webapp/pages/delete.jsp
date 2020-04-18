<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Delete Operation</h1>
<form action="http://localhost:8083/trainee/deletetrainee" method="post">
<table class="col-mid-4" border="1">

<tr>
<td>
Please enter trainee ID
</td>
<td>
<input type="number" name="traineeId" >
</td>
<td>
<button type="submit">search</button>
</td>
</tr>


</table>
</form>

</body>
</html>