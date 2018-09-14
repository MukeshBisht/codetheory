<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored = "false" %>


<!-- header -->
<jsp:include page="/WEB-INF/shared/header.jsp" />
<!-- page body -->
<script src="<c:url value=" /resources/script/timer.js " />"></script>
<script src="<c:url value=" /resources/script/contests.js " />"></script>
<script>
    var start = '${contestStartDate}';
</script>
<div class="container body-content">
    <div class="col-md-3"></div>
    <div class="col-md-6 cardView">

        <p class="text h2 text-danger">
            You have already submitted!!! <br/>
            Next Round will starts in</br/>
            
            <h3 class="text-center bg-primary" id = "countdown"></h3>
            <script>startCountdown()</script>

        </p>
        
        <h4 class="text-active">Next Round Details</h4>
        <p class = "text text-default">

            <span>Name : ${nextRound.name} </span><br>
            <span>Type : ${nextRound.type}</span><br>
            <span>Starting : ${nextRound.startTime}</span><br>
            <span>Ending : ${nextRound.endTime}</span><br>
            
        </p>
        
        <a class="btn btn-sm btn-primary" href="/home">Home</a>
    </div>

</div>
<!-- footer -->
<jsp:include page="/WEB-INF/shared/footer.jsp" />