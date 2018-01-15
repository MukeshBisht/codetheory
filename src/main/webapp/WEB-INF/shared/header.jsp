<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page isELIgnored = "false" %>

<head>
    <title>Code</title>
    <link rel='stylesheet' href="<c:url value="/resources/lib/bootstrap/css/bootstrap.css"/>" type='text/css' media='screen' /> 
    <script src="<c:url value="/resources/lib/jquery/jquery.js" />"></script>
    <script src="<c:url value="/resources/lib/bootstrap/js/bootstrap.js" />"></script> 
    <link rel='stylesheet' href="<c:url value="/resources/css/site.css"/>" type='text/css' media='screen' />   
</head>

<div class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">CodeTheory</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
                    
<sec:authorize access="isAnonymous()">
        <form class="navbar-form navbar-right" method="POST" action="<c:url value='/login'/>">
        <div class="form-group">
                <input class="form-control" placeholder="Email" name="username" type="text"/> 
        </div>
        <div class="form-group">
                <input class="form-control" placeholder="Password" name="password" type="password" /> 
        </div>
        <button type="submit" class="btn btn-success">Sign in</button>
        </form>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
            <div id="navbar" class="navbar-form navbar-right" style = "margin-top : 0px!important">
                    <ul class="nav navbar-nav">
                        <li><a href="/user/profile">Profile</a></li>
                        <li><a href="/user/notifications">Notification</a></li>
                        <li><a href="<c:url value='/logout' />">Logout</a></li>
                    </ul>
                </div>
    </sec:authorize>
          </div><!--/.navbar-collapse -->
        </div>
</div>


