<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored = "false" %>

<html>
	<head>
        <link rel='stylesheet' href="<c:url value="/resources/lib/bootstrap/css/bootstrap.css"/>" type='text/css' media='screen' /> 
		<script src="<c:url value="/resources/lib/jquery/jquery.js" />"></script>	
        <script src="<c:url value="/resources/lib/bootstrap/js/bootstrap.js" />"></script> 
        <link rel='stylesheet' href="<c:url value="/resources/css/site.css"/>" type='text/css' media='screen' />   
		<script src="<c:url value=" /resources/script/register.js " />"></script>
		<style>
			input{
				margin:5px;
				padding:2px;
			}
			.btn{
				margin:0px 0px 50px 0px;
			}
			.signin{
				margin:20px auto;
				width:60%;
				padding:50px;
			}
			.form-signin{
				padding:50px 80px 50px 80px;
			}
			.optional{
				 opacity:0.8;
			}
		</style>
    </head>
    
    <body>
		
		<section class="signin">
		
		 <div class="container-fluid boxShadow" >
			
			<form class="form-signin" action="register">
			
				<header class="text-default text-center">
					<h2>Welcome To CodeTheory</h2>
				</header>

				<p class="text-success text-center">Create Your CodeTheory Account.<br>It will not take long.</p><hr/>
				
				<h2 class="form-signin-heading">Sign in</h2>
				
				<label for="username" class="sr-only">Username</label>
				<input type="text" id="uname" class="form-control" placeholder="Username" required autofocus>
				<div id="uname_response" class="response"></div>
				
				<label for="name" class="sr-only">Name</label>
				<input type="text" id="name" class="form-control" placeholder="Name" required>
				
				<label for="inputEmail" class="sr-only">Email address</label>
				<input type="email" id="inputEmail" class="form-control" placeholder="Email address" required>
				
				<label for="inputPassword" class="sr-only">Password</label>
				<input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
				
				<label for="confirmPassword" class="sr-only">Confirm Password</label>
				<input type="confirmPassword" id="confirmPassword" class="form-control" placeholder="Confirm Password" required>
				
				
				<div class="checkbox optional">
					<label>
					<input type="checkbox" value="newsletter">Send me newsletter & contest invitations
					</label>
				</div>
				
				<div class="checkbox optional">
				<label>
				<input type="checkbox" value="remember">Remember Me
				</label>
				</div>
				
                <button class="btn btn-success" type="submit">Sign up</button>
                
			</form>

        </div>
        
        </section>
        
		<!-- footer -->
		<jsp:include page="/WEB-INF/shared/footer.jsp"/>
		
    </body>
</html>