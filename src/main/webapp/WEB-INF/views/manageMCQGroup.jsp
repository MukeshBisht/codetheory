<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page isELIgnored = "false" %>

        <html>

        <head>
            <script type="text/javascript">
                var grpid = ${grpid};
            </script>
        </head>

        <body>
            <!-- header -->
            <jsp:include page="/WEB-INF/shared/header.jsp" />
            <script src="<c:url value=" /resources/script/groupmgmt.js " />"></script>
            <script src="<c:url value=" /resources/script/jsgrid.js " />"></script>
            <link rel='stylesheet' href="<c:url value=" /resources/css/jsgrid.css "/>" type='text/css' media='screen' />
            <link rel='stylesheet' href="<c:url value=" /resources/css/jsgrid-theme.css "/>" type='text/css' media='screen' />
            <!-- page body -->
            <div class="container body-content">
                <h3>MCQ Group : ${grpname}</h3>
                <div class="row">
                    <form id="quesForm" method="POST">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div>
                                    <div class="form-group col-md-12">
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                Question
                                            </span>
                                            <input id="question" type="text" placeholder="Your Question goes here" class="form-control" required/>
                                        </div>
                                    </div>
                                    <div class="form-group col-lg-6">
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                Option1
                                                <input value="0" type="radio" required name="answer" />
                                            </span>
                                            <input id="op1" type="text" placeholder="Answer option 1" class="form-control" required/>
                                        </div>
                                    </div>

                                    <div class="form-group col-lg-6">
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                Option2
                                                <input value="1" type="radio" required name="answer" />
                                            </span>
                                            <input id="op2" type="text" placeholder="Answer option 2" class="form-control" required/>
                                        </div>
                                    </div>

                                    <div class="form-group col-lg-6">
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                Option3
                                                <input value="2" type="radio" required name="answer" />
                                            </span>
                                            <input id="op3" type="text" placeholder="Answer option 3" class="form-control" required/>
                                        </div>
                                    </div>

                                    <div class="form-group col-lg-6">
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                Option4
                                                <input value="3" type="radio" required name="answer" />
                                            </span>
                                            <input id="op4" type="text" placeholder="Answer option 4" class="form-control" required/>
                                        </div>
                                    </div>
                                    <div class="form-group col-lg-6">
                                        <select id="lvl" class="form-control" required>
                                            <option value="1">Easy</option>
                                            <option value="2">Medium</option>
                                            <option value="3">Hard</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-lg-6">
                                        <button class="btn btn-primary  btn-block pull-right" type="submit" >Add</button>
                                        <!-- onclick="addQuestion(${grpid})" -->
                                    </div>

                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="row">
                    <div id="Grid"></div>
                </div>
                <div>
                </div>
            </div>
            <!-- footer -->
            <jsp:include page="/WEB-INF/shared/footer.jsp" />
        </body>

        </html>