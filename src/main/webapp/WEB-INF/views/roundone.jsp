<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored = "false" %>
<html>
<head>

</head>

<body>
    <!-- header -->
    <jsp:include page="/WEB-INF/shared/header.jsp" />
    <script src="<c:url value=" /resources/script/roundOne.js " />"></script>

    <!-- page body -->
        <section class="boxShadow" id="roundOneSection">
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
            <div id="showQuestion">
               
                          
            </div>

        </section>
        
        <section class="durationSelect boxShadow text-center" id="durationSelect">
            <h4>Select Time Duration</h4>
            <select class="form-control btn-success" id="timeSelect">
                <option id="10min">10 minutes</option>
                <option id="20min">20 minutes</option>
                <option id="30min">30 minutes</option>
            </select>
        </section>

        <section class="timer boxShadow text-center" id="timer">
            <h1 class="starttimer text-active" id="starttimer"></h1>
           
        </section>
        
        <section class="questionOptions boxShadow" id="questionOptions">
            <table class="table">
                <th>S.No.</th>
                <th>A</th>
                <th>B</th>
                <th>C</th>
                <th>D</th>
                <tr>
                    <td>1</td>
                    <td> <input type="radio" name="q1"></td>
                    <td> <input type="radio" name="q1"></td>
                    <td> <input type="radio" name="q1"></td>
                    <td> <input type="radio" name="q1"></td>
                    
                </tr>
                <tr>
                    <td>2</td>
                    <td> <input type="radio" name="q2"></td>
                    <td> <input type="radio" name="q2"></td>
                    <td> <input type="radio" name="q2"></td>
                    <td> <input type="radio" name="q2"></td>
                    
                </tr>
                
            </ta
            </table>
        </section>
    <!-- footer -->
    <jsp:include page="/WEB-INF/shared/footer.jsp" />
</body>
</html>