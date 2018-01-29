<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page isELIgnored = "false" %>

<html>
    <body>
        <!--  Header  -->
        <jsp:include page="/WEB-INF/shared/header.jsp" />
       
        <section class="container ">

            <div class="col-md-8  cardView text-center"  style="margin-right:5px;">
                <h3 class="text text-left">
                    Show your skills at
                </h3>
                <p>
                    <span style="font-size:60px;font-family:georgia">
                        ${contest.contestname}
                    </span>
                    <span class="blockquote">
                        by ${contest.orgName}
                    </span>
                </p>
                <button class="btn btn-primary">participate</button>
            </div>
            <div class="col-md-3 cardView">
                    TIMER<br><br><br><br><br>
                </div>
            <div class="col-md-3 cardView">
                <p>Starting Date</p>
                <p>${contest.startDate}</p>
            </div>
        </section>

        <section class="container">
        
            <div class="col-md-5 cardView" 
            style="height:400px;margin-top:10px;font-family:comic-sans;font-size:20px">
                <h2 class="text-active">SOME CONTEST DETAILS<br>with Advertisement :)</h2>
                   
            </div> 

            <div class="col-md-6 cardView" 
            style="height:400px;margin:10px 0px 0px 5px;font-family:comic-sans;font-size:20px">
                <h2 class="text-active">Blah Blah Blah</h2>
                 
            </div> 
        </section>
        <!-- footer -->
        <jsp:include page="/WEB-INF/shared/footer.jsp" />
    </body>
</html>
