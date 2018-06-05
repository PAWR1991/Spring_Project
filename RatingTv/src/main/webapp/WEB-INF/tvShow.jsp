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
    
    <div class="container">
        <h1>${tvShow.title}</h1>
        <p>Network: ${tvShow.network}</p>

        <h2>Users who rated this show</h2>
        <table class="table table-bordered">
            <thead>
                <tr class="table-active">
                <th scope="col">Name</th>
                <th scope="col">Rating</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${tvShow.reviews}" var="review">
                    <tr>
                        <td>${review.getReviewer().getUsername()}</td>
                        <td>${review.rating}</td>
                    </tr>
                </c:forEach>
            </tbody>
            </table>

        <a href="/show/${tvShow.id}/edit">Edit</a>
        
        <br>

        <a href="/dashboard">Dashboard</a>
        <br>
        <p>${msg}</p>
        <form:form method="POST" action="/show/${tvShow.id}/review" modelAttribute="review">
            <form:label path="rating">Leave a Rating
            <form:errors path="rating"/>
            <form:select path="rating">
                 <form:option value="5">5</form:option>
                 <form:option value="4">4</form:option>
                 <form:option value="3">3</form:option>
                 <form:option value="2">2</form:option>
                 <form:option value="1">1</form:option>
            </form:select>
        
            </form:label>

            <input type="hidden" name="reviewer" value="${user.id}"/>
            <input type="hidden" name="tvShow" value="${tvShow.id}"/>
            
            <input type="submit" value="Rate"/>
        </form:form>
    </div>

</body>
</html>