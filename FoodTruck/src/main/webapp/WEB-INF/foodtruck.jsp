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
        

        <article class="media">
            <figure class="media-left">
                <p class="image is-64x64">
                <i class="fas fa-truck fa-3x"></i>
                </p>
            </figure>
            <div class="media-content">
                <div class="content has-text-centered">
                <p>
                    <strong class="title">${foodtruck.name}</strong>
                    <br>
                    Style: ${foodtruck.style}
                    <br>
                    Description: ${foodtruck.description}
                </p>
                </div>
            </div>
        </article>
        <form:form method="POST" action="/foodtruck/${foodtruck.id}/review" modelAttribute="comment">
        <div class="columns">
            <div class="column">
                 <div class="field">
                    <label class="label">Title</label>
                    <div class="control has-icons-left">
                        <form:input path="title" placeholder="Title" class="input"/>
                        <form:errors path="title"/>
                    </div>
                </div>
                <div class="field">
                    <label class="label">Review</label>
                    <div class="control has-icons-left">
                        <form:input path="review" placeholder="Review" class="input"/>
                        <form:errors path="review"/>
                    </div>
                </div>
            </div>
            <div class="column">
                <div class="field">
                    <label class="label">Rating</label>
                    <div class="control has-icons-left">
                        <form:select path="rating" class="input">
                            <c:forEach items="${stars}" var="star" varStatus="loop">
                                <form:option value="${5-loop.index}">${star}</form:option>
                            </c:forEach>
                        </form:select>
                        <form:errors path="rating"/>
                    </div>
                </div>
                <br>
                <input type="hidden" name="truck" value="${foodtruck.id}"/>
                <input type="hidden" name="reviewer" value="${user.id}"/>
                <button type="submit" class="button is-primary">Submit</button>
            </div>
            <div class="column">
                
            </div>
        </div>
           
        </form:form>
  </div>
    
   
</body>
</html>