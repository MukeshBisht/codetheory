<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored = "false" %>

<html>

<head>
    <title>Contest Standings</title>
</head>

<body>
    <!-- header -->
    <jsp:include page="/WEB-INF/shared/header.jsp" />
    <!-- page body -->
    <div class="container body-content">
        <div class="col-md-3"></div>
        <jsp:useBean id="today" class="java.util.Date" />
        <c:choose>
            <c:when test = "${today.time lt contest.endDate.time}">
                <div class="col-md-6 cardView">
                    <h3>
                        Contest Results will be shown at ${contest.endDate}
                    </h3>
                    <span class="text text-primary">Know more about other contests...</span>                
                </div>
            </c:when>

            <c:otherwise>

                <div class="col-md-6 cardView">
                    <div>
                        <span class="text text-primary text-center">
                            <h2>
                                <i class="fa fa-hourglass-end"></i>
                                This Contest Has Already Ended
                            </h2> <hr>
                        </span>
                
                        <span class="text text-warning">
                            <h4>Here is the final results of this contest</h4>
                        </span>
                                
                    </div>
    
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <span class="h4">
                            <strong>
                                Standings
                            </strong>
                        </span>
                    </div>
                    
                    <table class="table table-hover">
                        <thead>
                            <th>Rank</th>
                            <th>Name</th>
                            <th>Points</th>
                        </thead>
    
                        <tbody>
                            <c:forEach var="participant" items="${result}" varStatus = "status">
                                <div class="panel-body cardView" style="background:whitesmoke">
                                    <tr>
                                        <td>${status.index+1}</td>
                                        <td>${participant.username}</td>
                                        <td>${participant.score}</td>
                                    </tr>    
                            </c:forEach>
                        </tbody>
                    </table>
                    
                </div>
                <span class="text text-primary">Know more about other contests...</span>
            </div>
        </c:otherwise>
        
    </c:choose>
    
    </div>
    <!-- footer -->
    <jsp:include page="/WEB-INF/shared/footer.jsp" />
</body>

</html>