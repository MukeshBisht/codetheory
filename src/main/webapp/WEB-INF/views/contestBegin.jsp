<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page isELIgnored = "false" %>

<html >
    <body>
        <!--  Header  -->
        <jsp:include page="/WEB-INF/shared/header.jsp" />
       
        <section class="container ">

            <div class="col-md-8  cardView text-center" 
             style="margin-right:5px;background:rgba(6, 38, 180, 0.5);border-radius: 5px 20px">
                <h3 class="text text-left">
                    Show your skills at
                </h3>
                <p>
                    <span style="font-size:60px;font-family:georgia">
                        <i class="fa fa-flash"></i>
                        ${contest.contestname}
                    </span>
                    <span class="blockquote">
                        by ${contest.orgName}
                    </span>
                </p>
                <button class="btn btn-active">
                    <i class="fa fa-user-plus"></i>
                    participate
                </button>
            </div>
            <div class="col-md-3 cardView" style="background:rgba(0, 0, 0, 0.4)">
                <h2>
                    <i class="fa fa-calendar"></i>
                    Days Left
                </h2><br>
                </div>
                
            <div class="col-md-3 cardView" style="background:rgba(0,0,0,0.2)">
                <h3>Starting Date
                    ${contest.startDate}</h3>
            </div>
        </section>

        <section class="container">
        
            <div class="col-md-5 cardView" 
            style="height:400px;margin-top:10px;font-family:comic-sans;font-size:20px;
            background:rgba(228, 205, 184, 0.5)">
                   
            </div> 

            <div class="col-md-6 cardView" 
            style="height:400px;margin:10px 0px 0px 5px;font-family:comic-sans;font-size:20px;
            background:rgba(247, 245, 244, 0.4)">
                 
            </div> 
        </section>
        <!-- footer -->
        <jsp:include page="/WEB-INF/shared/footer.jsp" />
    </body>
</html>
