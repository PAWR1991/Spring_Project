<!DOCTYPE html>
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>Ninja Gold</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

</head>
<body>
    <div class=".container">
        <h2>Your Gold: ${gold}</h2>
    </div>
    <div class=".container">
        <div class="row d-flex p-2">
            <div class="col-md-3 border border-dark text-center">
                <h2>Farm</h2>
                <h4>(earns 10-20 gold)</h4>
                <form action="/makeGold" method="post">
                    <input type="hidden" value="farm" name="action">
                    <input type="submit" name="Earn Gold">
                </form>
            </div>

            <div class="col-md-3 border border-dark text-center">
                <h2>Cave</h2>
                <h4>(earns 5-10 gold)</h4>
                <form action="/makeGold" method="post">
                    <input type="hidden" value="cave" name="action">
                    <input type="submit" name="Earn Gold">
                </form>
            </div>

            <div class="col-md-3 border border-dark text-center">
                <h2>House</h2>
                <h4>(earns 2-5 gold)</h4>
                <form action="/makeGold" method="post">
                    <input type="hidden" value="house" name="action">
                    <input type="submit" name="Earn Gold">
                </form>
            </div>

            <div class="col-md-3 border border-dark text-center">
                <h2>Casino!</h2>
                <h4>(earns/takes 0-50 gold)</h4>
                <form action="/makeGold" method="post">
                    <input type="hidden" value="casino" name="action">
                    <input type="submit" name="Earn Gold">
                </form>
            </div>
        </div>
    </div>
    <div class=".container">
        <h2>Activities</h2>
        <div class="pre-scrollable border border-dark">
            <c:forEach items="${activaties}" var="activaties" varStatus="loop">
		        <p> ${activaties}</p>
	        </c:forEach>
        </div>
        
    </div>
   
</body>
</html>