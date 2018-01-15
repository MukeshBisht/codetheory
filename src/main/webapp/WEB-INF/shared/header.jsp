<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored = "false" %>

<head>
    <title>Code</title>
    <link rel='stylesheet' href="<c:url value="/resources/lib/bootstrap/css/bootstrap.css"/>" type='text/css' media='screen' /> 
    <script src="<c:url value="/resources/lib/jquery/jquery.js" />"></script>
    <script src="<c:url value="/resources/lib/bootstrap/js/bootstrap.js" />"></script> 
    <link rel='stylesheet' href="<c:url value="/resources/css/site.css"/>" type='text/css' media='screen' />   
</head>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a asp-area="" asp-controller="Home" asp-action="Index" class="navbar-brand">CodeTheory</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a asp-area="" asp-controller="Home" asp-action="Index">Home</a></li>
                <li><a asp-area="" asp-controller="Home" asp-action="About">About</a></li>
                <li><a asp-area="" asp-controller="Home" asp-action="Contact">Contact</a></li>
            </ul>
        </div>
    </div>
</nav>