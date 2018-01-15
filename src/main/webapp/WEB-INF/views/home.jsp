<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored = "false" %>

<html>
   <body> 
        <!-- header -->
        <jsp:include page="/WEB-INF/shared/header.jsp"/>
        <!-- page body -->
        <div class="container body-content">       
            <!-- Main jumbotron for a primary marketing message or call to action -->
            <div class="jumbotron">
                <div class="container">
                    <h1>Hello, world!</h1>
                    <p>Use it as a starting point to create something more unique.</p>
                </div>
            </div>

            <div class="panel panel-default">
                    <!-- Default panel contents -->
                    <div class="panel-heading">Default Competition</div>
                    <div class="panel-body">
                      <p>try this competition</p>
                    </div>
                  
                    <div class="btn btn-success">Participate</div>
                  </div>
        </div>
    <!-- footer -->
    <jsp:include page="/WEB-INF/shared/footer.jsp"/>
   </body>
</html>