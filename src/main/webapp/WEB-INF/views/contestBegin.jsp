<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page isELIgnored = "false" %>

<html >
    <body>
        <!--  Header  -->
        <jsp:include page="/WEB-INF/shared/header.jsp" />
       
        <section class="container ">

            <div class="jumbotron text-center"> 
             
                <p>
                    <span style="font-size:60px;font-family:georgia">
                        <i class="fa fa-flash"></i>
                        ${contest.contestname}
                    </span>
                    <span class="blockquote">
                        by ${contest.orgName}
                    </span>
                </p>
                <p>${contest.startDate}</p>
                <button class="btn btn-active btn-flat">
                    <i class="fa fa-user-plus"></i>
                    participate
                </button>
            </div>
            
        </section>

        <section class="container cardView">
            <div class="col-md-1"></div>
            <div class="text text-center col-md-10 ">
             <h3>   About</h3>
             <p>   Please provide a short description of your contest here! This will also be used as metadata.
                </p>

               <h3>Prizes </h3> 

              <p> Prizes are optional. You may add any prizes that you would like to offer here.
                </p>
              
              <h3> Rules</h3> 

              <p> The creator of this contest is solely responsible for setting and communicating the eligibility requirements associated with prizes awarded to participants, as well as for procurement and distribution of all prizes. The contest creator holds HackerRank harmless from and against any and all claims, losses, damages, costs, awards, settlements, orders, or fines.
                Code directly from our platform, which supports over 30 languages. Learn more here.
                Please provide any rules for your contest here.
                </p> 
            
            <h3>  Scoring </h3>  
              <p>  Each challenge has a pre-determined score.
                A participant’s score depends on the number of test cases a participant’s code submission successfully passes.
                If a participant submits more than one solution per challenge, then the participant’s score will reflect the highest score achieved. In a game challenge, the participant's score will reflect the last code submission.
                Participants are ranked by score. If two or more participants achieve the same score, then the tie is broken by the total time taken to submit the last solution resulting in a higher score
            </p>
            </div>
        </section>
        <!-- footer -->
        <jsp:include page="/WEB-INF/shared/footer.jsp" />
    </body>
</html>
