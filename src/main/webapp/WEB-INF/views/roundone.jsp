<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page isELIgnored = "false" %>

        <body>
            <jsp:include page="/WEB-INF/shared/header.jsp" />
            <script src="<c:url value=" /resources/script/roundOne.js " />"></script>
            <div class="container">
                <div class="row">
                    <div class="col-sm-4 text-center">
                        <h1>Round 1</h1>
                    </div>
                    <div class="col-sm-4">
                        <h2 class="text-center btn-primary" id="starttimer">
                        </h2>
                    </div>
                    <div class="col-sm-4 text-center" id="submitRoundOne" hidden>
                        <a class="btn btn-lg btn-success" href="/RoundThree" onclick="alert('submit round 1')">Submit</a>
                    </div>
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
                    </div>
                </section>

                <!-- Questions -->
                <div class="row">
                    <div class="hidden-xs col-sm-6">
                        <div class="col-lg-12 col-bg" id="showQuestion" hidden>
                        </div>
                    </div>

                    <!-- answer sheet -->
                    <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 col-bg cardView" id="sideSection" hidden>

                    </div>

                </div>
                <div class="space"></div>
                <jsp:include page="/WEB-INF/shared/footer.jsp" />
        </body>