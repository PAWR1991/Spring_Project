<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
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
    	<div class="row justify-content-md-center">
            
			<div class="col-md-6">
				<nav class="navbar navbar-expand-lg navbar-dark bg-primary ">
                     <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav mr-auto">
                            <li class="nav-item">
                                <a class="nav-link" href="/">Login</a>
                            </li>
                            <li class="nav-item active">
                                <a class="nav-link" href="/registration">Register<span class="sr-only">(current)</span></a>
                            </li>
                        </ul>
                    </div>
                </nav>
					<div class="panel-body border border-primary">
						<div class="row">
							<div class="col-lg-12">
								<form id="login-form" action="/register" method="post" style="display: block;">
									<div class="form-group">
                                        <input type="text" name="username" tabindex="1" class="form-control" placeholder="Username">
                                        <p>${errors.username}</p>
                                    </div>
                                    <div class="form-group">
                                        <input type="text" name="email" tabindex="1" class="form-control" placeholder="Email">
                                        <p>${errors.email}</p>
									</div>
									<div class="form-group">
                                        <input type="password" name="password" tabindex="2" class="form-control" placeholder="Password">
                                        <p>${errors.password}</p>
                                    </div>
                                    <div class="form-group">
                                        <input type="password" name="confirm" tabindex="2" class="form-control" placeholder="Confirm Password" >
                                        <p>${errors.confirm}</p>
                                    </div>
									<div class="form-group">
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3" >
												<input type="submit" class="btn btn-primary btn-block" value="Register">
											</div>
										</div>
									</div>
                                </form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


   
</body>
</html>