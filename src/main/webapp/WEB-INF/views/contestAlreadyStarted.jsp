<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored = "false" %>

<html>

<head>
    <title>Can't Participate Now!!</title>
</head>

<body>
    <!-- header -->
    <jsp:include page="/WEB-INF/shared/header.jsp" />
    <!-- page body -->
    <div class="container body-content">
        <div class="col-md-3"></div>
        <div class="col-md-6 cardView">
            <p class="text h3">
                Sorry, This Contest is not available right now, <br/>
                But There are lots of similiar contest like this...<br/>
                <span class="text text-primary">So, Hrry Up! and participate...</span>
            </p>
            <a class="btn btn-sm btn-primary" href="/home">Home</a>
        </div>
    </div>
    <!-- footer -->
    <jsp:include page="/WEB-INF/shared/footer.jsp" />
</body>

</html>