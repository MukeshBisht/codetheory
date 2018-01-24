<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page isELIgnored = "false" %>
        <html>

        <head>
        </head>

        <body>
            <!-- header -->
            <jsp:include page="/WEB-INF/shared/header.jsp" />
            <script src="<c:url value=" /resources/script/moment.js " />"></script>
            <script src="<c:url value=" /resources/script/bootstrap-datetimepicker.js " />"></script>
            <link rel='stylesheet' href="<c:url value=" /resources/css/bootstrap-datetimepicker.css "/>" type='text/css' media='screen'/>
            <link rel='stylesheet' href="<c:url value=" /resources/css/jsgrid.min.css "/>" type='text/css' media='screen' />
            <link rel='stylesheet' href="<c:url value=" /resources/css/jsgrid-theme.css "/>" type='text/css' media='screen' />
            <script src="<c:url value=" /resources/script/jsgrid.js " />"></script>
            <script type="text/javascript">
                $(function () {
                    $('#starttimepicker').datetimepicker();
                    $('#endtimepicker').datetimepicker();
                });
            </script>

            <section>
            <div class="container cardView">
                <div class="row ">
                    <h3>&nbsp;Create Contest</h3>
                    <p>&nbsp;Host your own contest on CodeTheory.</p><br>
                </div>

                <div class="form-group col-lg-12">
                    <label>Contest Name
                        <label>
                            <input placeholder="Contest Name" class="form-control" required="true" />
                            <div id="uname_response" class="response"></div>
                </div>
                <div class='col-sm-12'>
                    <div class="form-group">
                        <label>Starting
                            <label>
                                <div class='input-group date' id='starttimepicker'>
                                    <input type='text' class="form-control" />
                                    <span class="input-group-addon">
                                        <span class="glyphicon glyphicon-calendar"></span>
                                    </span>
                                </div>
                    </div>
                </div>
                <div class='col-sm-12'>
                    <div class="form-group">
                        <label>Ending
                            <label>
                                <div class='input-group date' id='endtimepicker'>
                                    <input type='text' class="form-control" />
                                    <span class="input-group-addon">
                                        <span class="glyphicon glyphicon-calendar"></span>
                                    </span>
                                </div>
                    </div>
                </div>

                <div class='col-sm-12'>
                        <div class="form-group">
                            <label> Orgranization Name </label>
                             <input type='text' class="form-control" />        
                        </div>
                </div>

                <div class='col-sm-12 form-group'>                                
                    <label> Orgranization Type </label><br>
                    <select class="form-control">
                        <option disabled selected value> -- select an option -- </option>
                        <option>School</option>
                        <option>Collage</option>
                        <option>Individual</option>
                        <option>Other</option>
                    </select>  
                </div>
    
                <button class="btn btn-success">create contest</button><br>
            </div>
            
                <div class="container bmargin">
                    <table class="table">
                        <h3>
                            Contests Created By @username
                        </h3>

                        <th>Contest Name</th>
                        <th>Starting Date</th>
                        <th>Ending Date</th>
                        <th>Status</th>
                        <th>Number of Participants</th>
                        <th></th>
                        <tr>
                            <td>CodeJam</td>
                            <td>20 June 2018</td>
                            <td>30 June 2018</td>
                            <td>Not Started Yet</td>
                            <td>Not Specified</td>
                            <td>
                                <a href="/contest/manage">
                                    <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
                                </a>
                            </td>
                        </tr>

                        <tr>
                            <td>CodeChamp</td>
                            <td>11 March 2018</td>
                            <td>12 March 2018</td>
                            <td>Under Process</td>
                            <td>100</td>
                            <td>
                                <a href="/contest/manage">
                                    <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
                                </a>
                            </td>
                        </tr>

                        <tr>
                            <td>CodeThunder</td>
                            <td>01 Nov 2017</td>
                            <td>02 Nov 2017</td>
                            <td>Finished</td>
                            <td>150</td>
                        </tr>
                        
                        <tr>
                                <td>SnackDown</td>
                                <td>01 June 2017</td>
                                <td>02 June 2017</td>
                                <td>Finished</td>
                                <td>50</td>
                            </tr>

                    </table>
                </div>
            </div>
            </section>
            <!-- footer -->
            <jsp:include page="/WEB-INF/shared/footer.jsp" />
        </body>

        </html>