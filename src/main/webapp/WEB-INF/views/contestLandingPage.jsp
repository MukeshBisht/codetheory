<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page isELIgnored = "false" %>

<html >
    <head>

        <script src="<c:url value=" /resources/script/timer.js " />"></script>
        <script src="<c:url value=" /resources/script/contests.js " />"></script>
        <script>
            var cname = "${contest.contestname}";  
            var start = "${contest.startDate.time}";
            var end = "${contest.endDate.time}";
        </script>
    </head>

    <body onload = "startCountdown()">
        
        <!--  Header  -->
        <jsp:include page="/WEB-INF/shared/header.jsp" />
        <script src="<c:url value=" /resources/script/participate.js " />"></script>

        <section id="contestHeader" class="container cardView">
            <div class ="col-md-2">
                <span class="text text-primary">
                    <i class="fa fa-user">Participant : #12</i><br>
                    
                </span>
            </div>
            <div class="text-center col-md-7"> 
            
                <span style="font-size:70px;font-family:georgia">
                    <i class="fa fa-flash"></i>
                    ${contest.contestname}
                </span>
            
                <div id="part-div" class="text text-danger">
                    <span id = "part"></span>
                    <h4>Contest will starts in</h4>
                    <h4 id = "countdown"></h4>
                </div>

                <button class="btn btn-primary btn-flat" id="participatebtn">
                    <i class="fa fa-user-plus"></i>
                    participate
                </button>
            </div>
            
        </section>
        
        <section class="container">

            <div class="col-md-2 cardView text">
                <span>
                    <strong>Starting Date : </strong><p>${contest.startDate}</p>
                </span>

                <span>
                    <strong>Ending Date : </strong><p>${contest.endDate}</p>
                </span>

                <span>
                    <strong>Duration : </strong> <p>${startDate - endDate}</p>
                </span>

            </div>

            <div class="col-md-8 ">
             <div class="cardView text-p">
                <h3 class="text-active headStyle">Overview</h3>
                <p >Each Code Jam Contest consists of one or more rounds as may be more fully described in rules 
                    posted on the Contest website. Each round consists of one or more problems. In each round,
                    you will receive a score based on the answers you provide to the problem(s). If the Contest 
                    has more than one round and your score exceeds a specified threshold or is one of a specified
                    number of highest scores in that round, you will advance to the next round.
                    </p>
             </div>
                
            <div class="cardView text-p">
                <h3 class="text-active headStyle">Prizes </h3> 
 
               <p> Money prizes will be awarded in U.S. dollars and may be delivered in the form of cash, check, gift card, or other cash equivalent. 
                   You are responsible for any costs associated with currency exchange.
                   Google may either ship your prize to you or request that you come to a Google office
                   or a designated location to collect your prize. 
                 </p>
            </div>
              
            <div class="cardView text-p">
                <h3 class="text-active headStyle"> Rules</h3> 
  
                <p> The creator of this contest is solely responsible for setting and communicating the eligibility requirements associated with prizes awarded to participants, as well as for procurement and distribution of all prizes. The contest creator holds HackerRank harmless from and against any and all claims, losses, damages, costs, awards, settlements, orders, or fines.
                  Code directly from our platform, which supports over 30 languages. Learn more here.
                  Please provide any rules for your contest here.You may be disqualified from the Contest and forfeit any prizes you may be eligible to receive if Google reasonably 
                  believes that you have attempted to undermine the legitimate operation of the Contest.
                  </p> 
            </div>

            <div class="cardView text-p">
                <h3 class="text-active headStyle">  Scoring </h3>  
                  <p>  Each challenge has a pre-determined score.
                    A participant’s score depends on the number of test cases a participant’s code submission successfully passes.
                    If a participant submits more than one solution per challenge, then the participant’s score will reflect the highest score achieved. In a game challenge, the participant's score will reflect the last code submission.
                    Participants are ranked by score. If two or more participants achieve the same score, then the tie is broken by the total time taken to submit the last solution resulting in a higher score
                </p>

            </div>

            </div>

            <div class="col-md-2 cardView" id="shareContest">
                <p class="text-active" style="font-size:15px;font-weight:bold">
                    Tell Your Friend About this Contest!!
                </p>

                <div>
                    <button class="btn btn-primary">
                        <i class="fa fa-facebook fa"></i>
                    </button>

                    <button class="btn btn-danger">
                        <i class="fa fa-google-plus fa"></i>
                    </button>

                    <button class="btn btn-primary">
                        <i class="fa fa-twitter fa"></i>
                    </button>
                    
                </div>
                
                <div style="margin-top:10px">
                    <p class="text-active text-center" style="font-size:15px;font-weight:bold">
                        invite them via email
                        <input class="form-control" type="text" placeholder="">
                        <button class="btn btn-primary btn-sm" style="margin-top:4px">send</button>
                    </p>
                </div>
                    
            </div>

            <!-- clock code -->
            <div id="clockdiv" class="col-md-2 text-center" style="display:none">
                <div>
                    <div class="diaplay-5">
                        <i class="fa fa-calender"></i> 
                        Contest Starts In <hr>
                    </div>
                    
                    <div>
                        <div class="col-xs-3">
                            <span class="days" id="day"></span>
                            <p class="tiny">days</p>
                        </div>
    
                        <div class="col-xs-3">
                            <span class="hours" id="hour"></span>
                            <p class="tiny">hours</p>
                        </div>
                        <div class="col-xs-3">
                            <span class="minutes" id="minute"></span>
                            <p class="tiny">min</p>
                        </div>
                        <div class="col-xs-3">
                            <span class="seconds" id="second"></span>
                            <p class="tiny">sec</p>
                        </div>
                    </div>
                </div>
              </div>

              <div class="col-md-2 cardView">
                    <span>
                        <strong>Organizer : </strong> <p>${contest.orgName}</p>
                    </span>

                    <span>
                            <strong>Sponsors : </strong> <p>Google , Facebook , Twitter, Linkedin</p>
                    </span>
                </div>

        </section>
        <!-- footer -->
        <jsp:include page="/WEB-INF/shared/footer.jsp" />
    </body>
</html>
