<!DOCTYPE html>
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<title>Survey</title>

</head>
<body>
    
    <fieldset>
        <legend>Submitted Info</legend>
        <ul>
			<li>Name: ${body.name}</li>
			<li>Location: ${body.location}</li>
			<li>Language: ${body.language}</li>
			<li>Comment: ${body.comment}</li>
		</ul>
		
	</fieldset>
    
	
</body>
</html>