<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored = "false" %>


<!-- header -->
<jsp:include page="/WEB-INF/shared/header.jsp" />
<!-- page body -->
<div class="container body-content">
    <div class="col-md-3"></div>
    <div class="col-md-6 cardView">
        <p class="text h2">
            You have already submitted this round <br/>
            Wait for next </br/>
            TIMER GOES HERE <br/>
            Next Round :
            ${nextRound.startTime}

            
            <div class="col-sm-4">
                    <h2 class="text-center btn-primary" id="starttimer">
                    </h2>
            </div>

        </p>
        <a class="btn btn-sm btn-primary" href="/home">Home</a>

    </div>

</div>
<!-- footer -->
<jsp:include page="/WEB-INF/shared/footer.jsp" />