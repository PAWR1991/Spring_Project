<!DOCTYPE html>
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<title>Survey</title>

</head>
<body>
    <h1>Dojo Survey</h1>
    
    <fieldset>
		<legend>Survey</legend>
		<form action="/process" method="post">
			<p>Name: <input type="text" name="name"></p>
			<p class="error">${nameerror}</p>
			<p>Location: <select name="location">
				<option>Seattle</option>
				<option>San Jose</option>
				<option>Burbank</option>
				<option>Tulsa</option>
				<option>Dallas</option>
				<option>Chicago</option>
				<option>Tysons</option>
				<option>Online</option>
			</select></p>
			<p>Language: <select name="language">
				<option>Java</option>
				<option>JavaScript</option>
				<option>C#</option>
				<option>Python</option>
				<option>Ruby</option>
				<option>Swift</option>
				<option>PHP</option>
			</select></p>
			<p>Comment: <textarea name="comment"></textarea></p>
			<input type="submit">
		</form>
		
	</fieldset>
    
</body>
</html>