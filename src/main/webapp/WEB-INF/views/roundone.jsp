<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored = "false" %>
<html>
<head>
        <script src="<c:url value=" /resources/lib/jquery/jquery.js " />"></script>

        <script src="<c:url value=" /resources/script/question.js " />"></script>

</head>

<body>
    <!-- header -->
    <jsp:include page="/WEB-INF/shared/header.jsp" />
    <!-- page body -->
        <div id="question"></div>
    <!-- footer -->
    <jsp:include page="/WEB-INF/shared/footer.jsp" />
</body>
</html>