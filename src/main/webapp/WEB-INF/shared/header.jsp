<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page isELIgnored = "false" %>

<link rel='stylesheet' href="<c:url value=" /resources/lib/bootstrap/css/bootstrap.css "/>" type='text/css' media='screen'/>
<script src="<c:url value=" /resources/lib/jquery/jquery.js " />"></script>
<script src="<c:url value=" /resources/script/Validate.js " />"></script>
<script src="<c:url value=" /resources/lib/bootstrap/js/bootstrap.js " />"></script>
<link rel='stylesheet' href="<c:url value=" /resources/css/site.css "/>" type='text/css' media='screen' />
<script src="<c:url value=" /resources/script/site.js " />"></script>

<!-- login failure -->
<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
        <div class="container text-center alert alert-danger alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                </button>
                <strong>
                        <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" /> : </strong> Login Failed.
                <a href="#"> reset password</a>
        </div>
</c:if>


<div class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
                <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false"
                                aria-controls="navbar">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">CodeTheory</a>
                </div>

                <!-- navbar-collapse  -->
                <div id="navbar" class="navbar-collapse collapse">
                        <sec:authorize access="isAnonymous()">
                                <form name="f" class="navbar-form navbar-right" method="POST" action="<c:url value='/login'/>" onsubmit="return validate()">
                                        <div class="form-group">
                                                <input class="form-control" placeholder="Email" name="username" value="${sessionScope.username}" type="text" />
                                        </div>
                                        <div class="form-group">
                                                <input class="form-control" placeholder="Password" name="password" type="password" />
                                        </div>
                                        <button type="submit" class="btn btn-success">Sign in</button>
                                        <a class="btn btn-info" href="/register" role="button">Join</a>
                                </form>

                        </sec:authorize>
                        <sec:authorize access="isAuthenticated()">
                                <div class="navbar-form navbar-right" style="margin-top : 0px!important">
                                        <ul class="nav navbar-nav">
                                                <li>
                                                        <a href="/user/profile">Profile</a>
                                                </li>
                                                <li>
                                                        <a href="/user/notifications">Notification</a>
                                                </li>
                                                <li>
                                                        <a href="<c:url value='/logout' />">Logout</a>
                                                </li>
                                        </ul>
                                </div>
                        </sec:authorize>
                </div>
                <!--/.navbar-collapse -->
        </div>
</div>