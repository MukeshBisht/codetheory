<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored = "false" %>
<html>
<head>

</head>

<body>
    <!-- header -->
    <jsp:include page="/WEB-INF/shared/header.jsp" />
    <script src="<c:url value=" /resources/script/roundOne.js " />"></script>
    <div class="container">
    <!-- page body -->
    <!-- <div class="row"><div class="col-sm-4">.col-sm-4</div><div class="col-sm-4">.col-sm-4</div><div class="col-sm-4">.col-sm-4</div></div> -->
            <div class="row">
              <div class="col-sm-4">
                <h1>Round 1</h1>
              </div>
              <div class="col-sm-4">
                    <div id="timer">
                        <h1 class="text-active boxShadow" id="starttimer"></h1>           
                    </div>
              </div>
              <div class="col-sm-4">
                <a class="btn btn-success" href="#" id="submitRoundOne">Submit</a>
              </div>
            </div>

        <section class="container roundOneSection" id="roundOneSection">
            <div class="instruction col-md-7" id="roundOneInstruction">
                <h3>Instructions for the Guidance of User During Round One</h3>
                <ul>
                    <li>
                       <strong> Timetable and seating lists</strong>
                        <p>
                            Please ensure your students are informed of examination dates and locations. 
                            Post the details in your class and on your course website, if applicable.
                        </p>
                    </li>
                    <li>
                      <strong> Permissible and non-permissible aid</strong> 
                        <p>
                            A candidate is permitted to bring the following items to an exam: pen, pencil, 
                            drafting instruments, and, if specifically permitted, electronic calculators.
                        </p>
                    </li>
                    <li>
                    <strong>Beginning the Examination</strong>
                    <p>Only those candidates who are required to write the examination will be allowed in the room 
                        during the examination.</p>
                    </li>
                </ul>
                <button onclick="loadQuestion()" id="startRoundOne" class="btn btn-block btn-danger">Start</button>
            
            </div>
        
            <div class="container col-md-4 durationSelect" id="durationSelect">
                    <h3>Select Time Duration</h3>
                    <select class="form-control btn btn-primary" id="timeSelect">
                        <option id="10min">10 minutes</option>
                        <option id="20min">20 minutes</option>
                        <option id="30min">30 minutes</option>
                    </select>
                    
                    <table class="table text-center">
                        <h4>Point Distribution</h4>
                        <th>Duration</th><th>No. of Questions</th><th>Points</th>
                        <tr>
                            <td>10 minutes</td>
                            <td>50</td>
                            <td>+100</td>
                        </tr>
                        <tr>
                            <td>20 minutes</td>
                            <td>50</td>
                            <td>+50</td>
                        </tr>
                        <tr>
                            <td>30 minutes</td>
                            <td>50</td>
                            <td>+10</td>
                        </tr>
                    </table>
        
                </div>
        
                <div class="container col-md-7" id="showQuestion">
                
                    </div>
                 
            <div class="container col-md-4" id="sideSection">
           
            </div>   
        </section>
        
    </div>
    <!-- footer -->
    <jsp:include page="/WEB-INF/shared/footer.jsp" />
</body>
</html>