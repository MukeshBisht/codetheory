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
        <div class="jumbotron cardView">
            <div class="container">
              <p>
                <div class="col-md-8">
                    <h2>&nbsp;Be a Better</h2>
                    <h1>Programmer</h1>
                    <h3>Code. Compete. Create</h3></p>
                    <hr>
                    <a role="button" class="btn btn-primary" href="contest/practice/quiz">Start Quick Challenge</a>&emsp;
                    <a role="button" class="btn btn-danger" href="/contest/all">Participate On Contests</a>&emsp;
                    <a role="button" class="btn btn-blue" href="#">Host Your Own Contests</a>
                </div>
                <div class="col-md-4">
                    <i class ="fa" style="color:grey;font-size:50px">Some Stuff will be here soon...</i>
                </div>
            </div>
        </div>

            <div id="wallpage"></div>
                <p style="text-align:center"><img id="loading" style="display:none" src="<c:url value="/resources/images/loading.gif"/>" alt="loading"/></p>
                <a class="load-more-button" id="loadmore" onclick="loadAndScroll()">Load</a>
            </div>
    <!-- footer -->
    <jsp:include page="/WEB-INF/shared/footer.jsp" />
</html>