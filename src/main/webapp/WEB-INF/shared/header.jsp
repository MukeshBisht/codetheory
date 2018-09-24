<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page isELIgnored = "false" %>
<title>Online Quiz Contests | Coding Contests</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel='stylesheet' href="<c:url value=" /resources/lib/bootstrap/css/bootstrap.css "/>" type='text/css' media='screen'/>
<link rel='stylesheet' href="<c:url value=" /resources/font-awesome\css/font-awesome.min.css "/>" type='text/css' media='screen'/>
<script src="<c:url value=" /resources/lib/jquery/jquery.js " />"></script>
<script src="<c:url value=" /resources/script/Validate.js " />"></script>
<script src="<c:url value=" /resources/lib/bootstrap/js/bootstrap.js " />"></script>
<script src="<c:url value=" /resources/script/timer.js " />"></script>
<script src="<c:url value=" /resources/script/dialog.js " />"></script>
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
                <a href="#resetPD" data-toggle="modal" data-target="#resetPD">reset password</a>
        </div>
</c:if>

<!-- reset password dialog -->
<div id="resetPD" class="modal" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">Reset Password</h4>
            </div>
            <div class="input-group">
                <span class="input-group-addon">Your Email please</span>
                <input id="emailid" type="text" placeholder="Email" class="form-control" required/>
            </div>
            <p id="info" class="text-danger"></p>
            <button id="sendMail" onclick="resetPassword()" class="btn btn-block btn-success">Send</button>
            <button data-dismiss="modal" class="btn btn-block btn-info">Cancel</button>
        </div>
    </div>
</div>

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
                        <a class="navbar-brand" href="/home">CodeTheory</a>
                </div>

                <!-- navbar-collapse  -->
                <div id="navbar" class="navbar-collapse collapse">
                        <sec:authorize access="isAnonymous()">
                                <form name="f" class="navbar-form navbar-right" method="POST" action="<c:url value='/login'/>" onsubmit="return validate()">
                                        <div class="form-group">
                                                <input class="form-control" placeholder="Username" name="username" value="${sessionScope.username}" type="text" />
                                        </div>
                                        <div class="form-group">
                                                <input class="form-control" placeholder="Password" name="password" type="password" />
                                        </div>
                                        <button type="submit" class="btn btn-success">Sign in</button>
                                        
                                        <a class="btn btn-primary" href="/register" role="button">New User</a>
                                </form>

                        </sec:authorize>
                        <sec:authorize access="isAuthenticated()">
                                <div class="navbar-form navbar-right" style="margin-top : 0px!important">
                                      
                                        <ul class="nav navbar-nav">
                                          <li class="nav-icon-btn nav-icon-btn-danger dropdown">
                                            
                                                <!--a href="#notifications" class="dropdown-toggle" data-toggle="dropdown">
                                                                <i class="fa fa-bell"style="font-size:24px;color:white"></i>
                                                </a>

                                                
                                                <div class="dropdown-menu cardView" style="width: 300px;border-radius:5px;font-family:tahoma">
                                                        <div class="notifications-list" id="navbar-notifications">
                                                                <div class="notification">
                                                                        <strong class="text-primary">Contest Invite : </strong>
                                                                        <p>Take part in CodeChamp Held in 28/03/2018 for free. And get Exciting prices.</p>
                                                                </div>
                                                                
                                                                <div class="notification">
                                                                        <strong class="text-primary">Contest Invite : </strong>
                                                                        <p>Take part in CodeChamp Held in 28/03/2018 for free. And get Exciting prices.</p>
                                                                </div>
                                                                
                                                                <div class="notification">
                                                                        <strong class="text-primary">Contest Invite : </strong>
                                                                        <p>Take part in CodeChamp Held in 28/03/2018 for free. And get Exciting prices.</p>
                                                                </div>
                                                
                                                        </div> 

                                                        <a href="#" class="notifications-link">see all Notifications</a>
                                                   
                                                        </div--> 
                                                </li>

                                                
                                                <li class="dropdown">   
                                                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">    
                                                                <div style="font-size:24px;color:white">
                                                                        <i class="fa fa-user-circle" ></i>
                                                                        <span style="font-size:15px">Hello,
                                                                                <strong>${pageContext.request.remoteUser}</strong>
                                                                        </span>
                                                                        <i class="fa fa-caret-down" style="font-size:14px"></i>
                                                                </div>                                                                
                                                        </a>
                                                       <ul class="dropdown-menu">
                                                                <li><a href="/user/profile">Profile</a></li>                                                      
                                                                <li><a href="/contest/create">Manage Contest</a></li>
                                                                <li><a href="/challenge/group">Manage Challenges</a></li>                                                     
                                                                <li><a href="<c:url value='/logout' />">logout</a></li>
                                                        </ul>
                                                </li>
                                        </ul>
                                </div>
                        </sec:authorize>
                </div>
                <!--/.navbar-collapse -->
        </div>
</div>