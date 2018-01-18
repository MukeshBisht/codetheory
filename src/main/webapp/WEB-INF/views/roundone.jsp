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
                <a class="btn btn-success" href="#">Submit</a>
              </div>
            </div>

        <section class="container boxShadow col-md-6" id="roundOneSection">
            <div class="instruction" id="roundOneInstruction">
                <h3>Instructions for the Guidance of Candidates During Round One</h3>
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
                </ul>
                
                <ul>
                    <strong>Beginning the Examination</strong>
                    <p>Only those candidates who are required to write the examination will be allowed in the room 
                        during the examination.</p>
                </ul>
            </div>
            <button onclick="loadQuestion()" id="startRoundOne" class="btn btn-danger">Start</button>
            <div class="container-fluid " id="showQuestion">
               
            </div>

        </section>
        
        <section class="container durationSelect boxShadow text-center btn-primary col-md-4" id="durationSelect">
            <h4>Select Time Duration</h4>
            <select class="form-control" id="timeSelect">
                <option id="10min">10 minutes</option>
                <option id="20min">20 minutes</option>
                <option id="30min">30 minutes</option>
            </select>
        </section>
        <section class="container boxShadow sideSection" id="sideSection">
           
        
        </section>
    </div>
    <!-- footer -->
    <jsp:include page="/WEB-INF/shared/footer.jsp" />
</body>
</html>