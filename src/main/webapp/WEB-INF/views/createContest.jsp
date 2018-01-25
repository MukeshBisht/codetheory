<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored = "false" %>
<html>

<head>
</head>

<body>
    <!-- header -->
    <jsp:include page="/WEB-INF/shared/header.jsp" />
    <script src="<c:url value=" /resources/script/moment.js " />"></script>
    <script src="<c:url value=" /resources/script/bootstrap-datetimepicker.js " />"></script>
    <link rel='stylesheet' href="<c:url value=" /resources/css/bootstrap-datetimepicker.css "/>" type='text/css' media='screen'
    />
    <link rel='stylesheet' href="<c:url value=" /resources/css/jsgrid.min.css "/>" type='text/css' media='screen' />
    <link rel='stylesheet' href="<c:url value=" /resources/css/jsgrid-theme.css "/>" type='text/css' media='screen' />
    <script src="<c:url value=" /resources/script/jsgrid.js " />"></script>
    <script type="text/javascript">
        $(function () {
            $('#starttimepicker').datetimepicker();
            $('#endtimepicker').datetimepicker();
        });
    </script>

    <div class="container">
        <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="headingOne">
                    <h4 class="panel-title">
                        <h2 role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-controls="collapseOne">
                            <span class="label label-info">Create Contest</span>
                        </h2>
                        <p>Host your own contest on CodeTheory.</p>
                    </h4>
                </div>
                <div id="collapseOne" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
                    <div class="panel-body">
                        <jsp:include page="/WEB-INF/views/contestdetail.jsp"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container bmargin">
        <table class="table">
            <h3>
                Contests Created By @username
            </h3>

            <th>Contest Name</th>
            <th>Starting Date</th>
            <th>Creation Date</th>
            <th>Status</th>
            <th>Number of Participants</th>
            <th></th>
            <c:forEach items="${newContest.myContests}" var="con">
            <tr>
                <td>${con.contestName}</td>
                <td>${con.startingDate}</td>
                <td>${con.creationDate}</td>
                <td>${con.status}</td>
                <td>${con.participants}</td>
                <td>
                    <a href="/contest/manage/${con.contestid}">
                        <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
                    </a>
                </td>
            </tr>
    </c:forEach>
        </table>
    </div>
    </div>
    </section>
    <!-- footer -->
    <jsp:include page="/WEB-INF/shared/footer.jsp" />
</body>

</html>

