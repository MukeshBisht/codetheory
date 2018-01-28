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
              <p>
                <h2>&nbsp;Be a Better</h2>
                <h1>Programmer</h1>
                <h3>Code. Compete. Create</h3></p>
                <a role="button" class="btn btn-primary" href="/RoundOne">Start Quick Challenge</a>
            </div>
        </div>

        <div id="wallpage"></div>
        <p style="text-align:center"><img id="loading" style="display:none" src="<c:url value="/resources/images/loading.gif"/>" alt="loading"/></p>
        <a id="loadmore" onclick="loadAndScroll()">Load More</a>

    </div>
    <!-- footer -->
    <jsp:include page="/WEB-INF/shared/footer.jsp" />
</body>
</html>