<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored = "false" %>
<html>

<head>
</head>

<body>
    <!-- header -->
    <jsp:include page="/WEB-INF/shared/header.jsp" />
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
                        <jsp:include page="/contest/new"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container bmargin">
        <div class="table-responsive">
        <table class="table table-striped table-hover">
            <h3>
                Contests Created By ${newContest.user}
            </h3>

            <th scope="col">Contest Name</th>
            <th scope="col">Starting Date</th>
            <th scope="col">Creation Date</th>
            <th scope="col">Status</th>
            <th scope="col">Participants</th>
            <th></th>
            <c:forEach items="${newContest.myContests}" var="con">
            <tr class="clickable-row" data-href="/contest/manage/${con.contestname}">
                <td>${con.contestname}</td>
                <td>${con.startDate}</td>
                <td>${con.creationDate}</td>
                <td>${con.status}</td>
                <td>${con.participants}</td>
                <td>
                    <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>                   
                </td>
            </tr>
        </c:forEach>
        </table>
    </div>
    </div>
    </div>
    </section>
    <!-- footer -->
    <jsp:include page="/WEB-INF/shared/footer.jsp" />
</body>

</html>

