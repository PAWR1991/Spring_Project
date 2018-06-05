<!DOCTYPE html>
<html>
<head>
    <title>Movies List Homepage</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

</head>
<body>
    <div class=".container">
        <h2>Movies</h2>
        
    </div>
    <div class=".container">
        
        <legend>Add a Movie</legend>
        <form:form method="POST" action="/movies" modelAttribute="movie">
        <form:label path="title">Title
        <form:errors path="title"/>
        <form:input path="title"/></form:label>
    
        <form:label path="year">Year
        <form:errors path="year"/>
        <form:input type="number" path="year"/></form:label>
    
    
         <input type="submit" value="Submit"/>
    </form:form>
    </div>

     <div class=".container">
        
        <legend>Add an Actor or Actress</legend>
        <form:form method="POST" action="/actors" modelAttribute="actress">
        <form:label path="name">Name
        <form:errors path="name"/>
        <form:input path="name"/></form:label>

         <input type="submit" value="Submit"/>
        </form:form>
    </div>

     <div class=".container border border-dark">
         <fieldset>
             <legend>All Movies</legend>
             <c:forEach items="${movies}" var="movie">
                 <p><a href="/movie/${movie.id}">${movie.title}</a> (${movie.year})</p>
                 <p>Cast: </p>
                 <ul>
                    <c:forEach items="${movie.actresses}" var="actor">
                        <li>${actor.name}</li>
                    </c:forEach>
                 </ul>
    
             </c:forEach>
         </fieldset>
     </div>

      <div class=".container border border-dark">
         <fieldset>
             <legend>All Actors and Actresses</legend>
             <c:forEach items="${actresses}" var="actor">
                 <p><a href="/actor/${actor.id}">${actor.name}</a></p>
             </c:forEach>
         </fieldset>
     </div>

     <div class=".container border border-dark">
         <fieldset>
             <legend>Add an Actor or Actress to a Movie</legend>
             <form:form method="POST" action="/cast">
                <p>Actors and Actress: 
                    <select name="actor_id">
                        <c:forEach items="${actresses}" var="actor">
                           <option value="${actor.id}">${actor.name}</option>
                        </c:forEach>
                    </select>
                </p>
                <p>Movies: 
                    <select name="movie_id">
                        <c:forEach items="${movies}" var="movie">
                           <option value="${movie.id}">${movie.title}</option>
                        </c:forEach>
                    </select>
                </p>
                <input type="submit" value="Submit"/>
            </form:form>
         </fieldset>
     </div>

   
</body>
</html>