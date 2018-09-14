<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page isELIgnored = "false" %>
        <head>
            <script>
                var contestname = "${contestname}";
                var roundname = "${roundName}";
                var start = "${startDate}";
                var end = "${endDate}";
                var timelimit = "${timelimit}"
            </script>
        </head>
        <body>
            <jsp:include page="/WEB-INF/shared/header.jsp" />
            <script src="<c:url value=" /resources/script/roundOne.js " />"></script>
            <div class="container" id="roundone">
                <div class="row">
                    <div class="col-sm-4 text-center">
                        <h2 class="text text-muted">Quiz | ${contestname}</h2>
                    </div>
                    <div class="col-sm-3">
                        <h3 class="text-center btn-danger" id="countdown">
                            
                        </h3>
                    </div>
                    <div class="col-sm-4 text-center" id="submitRoundOne" hidden>                       
                        <a class="btn btn-info" href="#" onclick="showPreview()">Preview</a>
                        <a class="btn btn-success" onclick="showDialog()" id="submitRound">
                            Submit
                        </a>
                    </div>
                    <!-- Dialog box -->                                     
                            <div id="white-background">
                            </div>
                            <div id="dlgbox" class="text-center">
                                <div id="dlg-header" style="padding:10px 0 0 0">Are you Sure?<hr></div>
                                <div id="dlg-body">
                                    <span style="font-size:20px">You want to Submit your answers?</span><br>
                                    <span>
                                        Note : Once answers are submitted, you will not be able to<br>
                                        make any changes in them!
                                    </span>
                                </div>
                                <div id="dlg-footer">
                                    <button class="btn-black" onclick="dlg1OK()" style="padding: 5px">Confirm</button>
                                    <button class="btn-black" onclick="dlgCancel()" style="padding: 5px">Cancel</button>
                                </div>
                            </div>
                        <!-- Dialog box end -->       
                </div>

                <section class="row roundOneSection " id="roundOneSection">
                    <div class="instruction col-md-7 cardView" id="roundOneInstruction">
                        <h3>Instructions for the Guidance of User During Round One</h3>
                        <ul>
                            <li>
                                <strong> Timetable and seating lists</strong>
                                <p>
                                    Please ensure your students are informed of examination dates and locations. Post the details in your class and on your course
                                    website, if applicable.
                                </p>
                            </li>
                            <li>
                                <strong> Permissible and non-permissible aid</strong>
                                <p>
                                    A candidate is permitted to bring the following items to an exam: pen, pencil, drafting instruments, and, if specifically
                                    permitted, electronic calculators.
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

                    <c:choose>
                        <c:when test = "${contestname == 'practice'}">
                            <div class="col-md-4 durationSelect" id="durationSelect">
                                <h3>Select Time Duration</h3>
                                <select class="form-control btn btn-primary" id="timeSelect">
                                    <option id="10min">10 minutes</option>
                                    <option id="20min">20 minutes</option>
                                    <option id="30min">30 minutes</option>
                                </select>
        
                                <table class="table text-center">
                                    <h4>Point Distribution</h4>
                                    <th>Duration</th>
                                    <th>No. of Questions</th>
                                    <th>Points</th>
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
                        </c:when>
                    </c:choose>

                    </div>
                </section>

                <!-- Questions -->
                <section id="questionarea">
                <div class="row">
                    <div class="hidden-xs col-sm-6">
                        <div class="col-lg-12 col-bg" id="showQuestion" hidden>
                        </div>
                    </div>

                    <!-- answer sheet -->
                    <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 col-bg cardView" id="sideSection" hidden>

                    </div>
                 <!-- Modal -->
                 <div class="modal fade" id="previewModal" role="dialog">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="modal-title">Preview</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        &times;
                                    </button>
                                </div>
                                <div class="modal-body" id="previewbody">        
                                         
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="space"></div>
            </section>
           </div>

           <section id="resultArea"></section>
                    
            <jsp:include page="/WEB-INF/shared/footer.jsp" />
        </body>