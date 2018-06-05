<!DOCTYPE html>
<html>
<head>
	<title>Survey</title>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	<h1>Welcome to THE DATE PAGE</h1>
	
    	
	<p><c:out value="${date }"></c:out></p><br>
	
    <a href="/"> Home Page</a><br>
    <a href="/time"> Click here for the TIME</a>
	
</body>
</html>