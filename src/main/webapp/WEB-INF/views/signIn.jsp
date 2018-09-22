<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored = "false" %>

<html>

<head>
    <title>Required Authentication!!</title>
</head>

<body>
    <!-- header -->
    <jsp:include page="/WEB-INF/shared/header.jsp" />
    <!-- page body -->
    <div class="container body-content">
        <div class="col-md-3"></div>
        <div class="col-md-6 cardView">
            <p class="text h3">
                Sorry, This Page requires user authentication <br/>
                Please Sing in <br/>
                <span class="text">Don't have an account ?
                    <a href="/register">create here</a>
                </span>
            </p>
            <a class="btn btn-sm btn-primary" href="/home">Home</a>
        </div>
    </div>
    <!-- footer -->
    <jsp:include page="/WEB-INF/shared/footer.jsp" />
</body>

</html>