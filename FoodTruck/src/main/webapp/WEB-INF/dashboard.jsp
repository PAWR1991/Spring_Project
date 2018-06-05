<!DOCTYPE html>
<html>
<head>
    <title>Dashboard of Food Trucks</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css">
	<link type="text/css" rel="stylesheet" href="/css/style.css">
	<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>


</head>
<body>
    <div class="container">
		
		<div class="hero is-dark">
            <div class="hero-body is-bold">
                <h1 class="title">
                	<span><i class="fas fa-truck"></i></span>
                	<span>Foodtrucks</span>
                </h1>
            </div>
        </div>
        
        <div class="tabs is-medium">
        	<ul>
            	<li class="is-active">
                	<a href="/dashboard">
                    	<span class="icon is-small">
                        	<i class="fas fa-table"></i>
                        </span>
                        <span>Dashboard</span>
                    </a>
                </li>
                <li>
                	<a href="/logout">
                    	<span class="icon is-small">
                        	<i class="fas fa-sign-out-alt"></i>
                        </span>
                        <span>Sign out</span>
                    </a>
                </li>
                <li>
                	<a href="/foodtrucks/new">
                    	<span class="icon is-small">
                        	<i class="fas fa-truck"></i>
                        </span>
                        <span>Add a truck</span>
                    </a>
                </li>
            </ul>
        </div>

        <c:if test="${user != null}">
            <div class="notification is-primary">
                Welcome back ${user.username}!
            </div>
        </c:if>
        <c:forEach items="${foodtrucks}" var="foodtruck">

            <article class="media">
                <figure class="media-left">
                    <p class="image is-64x64">
                    <i class="fas fa-truck fa-3x"></i>
                    </p>
                </figure>
                <div class="media-content">
                    <div class="content">
                    <p>
                        <strong>${foodtruck.name}</strong>
                        <br>
                        Style: ${foodtruck.style}
                        <br>
                        Description: ${foodtruck.description}
                        <br>
                        Rating: ${foodtruck.avgRating}
                    </p>
                    </div>
                    
                </div>
                <div class="media-right">
                    <c:if test="${user.id == foodtruck.op.id}">
                        <a href="/foodtruck/${foodtruck.id}/edit" class="button is-info">Edit</a>
                    </c:if>
                     <a href="/foodtruck/${foodtruck.id}" class="button is-primary">Review</a>
                </div>
        </article>
    </c:forEach>

  </div>
    
   
</body>
</html>