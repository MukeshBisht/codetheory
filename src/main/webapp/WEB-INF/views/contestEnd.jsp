<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored = "false" %>

<html>

<head>

</head>

<body>
    <!-- header -->
    <jsp:include page="/WEB-INF/shared/header.jsp" />
    <!-- page body -->
    <div class="container body-content">
        <div class="col-md-3"></div>
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
                <div class="panel-body cardView" style="background:whitesmoke">
                    <table class="table table-hover">
                        <thead>
                            <th>Rank</th>
                            <th>Name</th>
                            <th>Points</th>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>Sagar Rawat</td>
                                <td>600</td>
                            </tr>

                            <tr>
                                <td>2</td>
                                <td>Mukesh Bisht</td>
                                <td>550</td>
                            </tr>
                            
                            <tr>
                                <td>3</td>
                                <td>Sandip Sarraf</td>
                                <td>400</td>
                            </tr>
                                
                        </tbody>
                    </table>
                </div>
            </div>
            <span class="text text-primary">Know more about other contests...</span>
    </div>
    <!-- footer -->
    <jsp:include page="/WEB-INF/shared/footer.jsp" />
</body>

</html>