<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Trainee Details</title>
</head>
<body>
<h1> Trainee Details</h1>
 <table border="2">
        <tr><th>Trainee ID</th><th>Trainee Name</th><th>Trainee Location</th><th>Trainee Domain</th></tr>
        
        	
        <c:forEach items="${traineeList}" var="trainee">
        <tr>
            <td>${trainee.traineeId }</td>
            <td>${trainee.traineeName }</td>
            <td>${trainee.traineeLocation }</td>
            <td>${trainee.traineeDomain }</td>
        </tr>
        </c:forEach>
        
    
    </table>

</body>
</html>