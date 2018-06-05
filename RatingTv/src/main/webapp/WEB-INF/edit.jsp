<!DOCTYPE html>
<html>
<head>
    <title>TvShow's Dashboad</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>


</head>
<body>
    <h1>${tvShow.title}</h1>
    <div class="container">
        <p>${msg}</p>
       <form:form method="POST" action="/show/${tvShow.id}/edit" modelAttribute="tvShow">
            <form:label path="title">Title
            <form:errors path="title"/>
            <form:input path="title"/></form:label>
            <br>
            <form:label path="network">Network
            <form:errors path="network"/>
            <form:input path="network"/></form:label>
            <br>
           
            <input type="hidden" name="avgRating" value="${tvShow.avgRating}">
            
            <input type="submit" value="Update"/>
        </form:form>

        <a href="/show/${tvShow.id}/delete">Delete</a>
    </div>

</body>
</html>