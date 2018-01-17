<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored = "false" %>
<html>
<head>

</head>

<body>
    <!-- header -->
    <jsp:include page="/WEB-INF/shared/header.jsp" />
    <script src="<c:url value=" /resources/script/question.js " />"></script>

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
            <button onclick="loadQuestion()" id="startRoundOne" class="btn btn-success">Start</button>
            <div id="showQuestion">
               
                          
            </div>

        </section>
        
    <!-- footer -->
    <jsp:include page="/WEB-INF/shared/footer.jsp" />
</body>
</html>