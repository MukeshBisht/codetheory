<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored = "false" %>
<html>
<head>
 
</head>

<body onload="loadCard()">
    <!-- header -->
    <jsp:include page="/WEB-INF/shared/header.jsp" />
    <!-- page body -->
    <div class="container body-content">
        <!-- Main jumbotron for a primary marketing message or call to action -->
        <div class="jumbotron">
            <div class="container">
                <h1>Hello, world!</h1>
                <p>Use it as a starting point to create something more unique.</p>
                <a role="button" class="btn btn-success">Start Quick Quiz</a>
            </div>
        </div>

        <div id="wallpage"></div>
        <p style="text-align:center"><img id="loading" style="display:none" src="<c:url value="/resources/images/loading.gif"/>" alt="loading"/></p>
        <a id="loadmore" onclick="loadCard()">Load More</a>

    </div>
    <!-- footer -->
    <jsp:include page="/WEB-INF/shared/footer.jsp" />
</body>
</html>