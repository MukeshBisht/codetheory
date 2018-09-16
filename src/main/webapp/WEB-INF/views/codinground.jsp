<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page isELIgnored = "false" %>
        <html>

        <head>
            <script src="<c:url value=" /resources/lib/jquery/jquery.js " />"></script>
            <script src="<c:url value=" /resources/script/codingRound.js " />"></script>
            <script src="<c:url value=" /resources/lib/codemirror/lib/codemirror.js " />"></script>
            <script src="<c:url value=" /resources/lib/codemirror/mode/javascript/javascript.js " />"></script>
            <link rel='stylesheet' href="<c:url value=" /resources/lib/codemirror/lib/codemirror.css "/>" type='text/css' media='screen'/>
            <!-- full screen F11 -->
            <script src="<c:url value=" /resources/lib/codemirror/addon/display/fullscreen.js" />"></script>
            <link rel='stylesheet' href="<c:url value=" /resources/lib/codemirror/addon/display/fullscreen.css "/>" type='text/css' media='screen'/>
            <script src="\resources\lib\codemirror\mode\clike\clike.js"></script>

            <script>
                var contestname = "${contestname}";
                var roundid = "${round.roundId}";
            </script>
        </head>

        <body>
            <!-- header -->
            <jsp:include page="/WEB-INF/shared/header.jsp" />
            <!-- page body -->
            <header>

            </header>
            <div class="container">
                <div class="row">
                    <div class="col-sm-4 text-center">
                        <h2 class="text text-muted">Code | ${round.name}</h2>
                    </div>
                    <div class="col-sm-4">
                        <h2 class="text-center btn-primary" id="starttimer">
                        </h2>
                    </div>
                    <div class="col-sm-4 text-center" id="submitRound" style="padding-top: 20px;">
                        <a class="btn btn-success" onclick="showDialog()" id="submitRound">
                            Submit
                        </a>
                    </div>   
                </div>

                <div class="row text-right">
                    <div class="col-md-12" id="langSelect">
                        <div class='input-group'>
                            <select id="langid" name="language" class="form-control" onclick="setMode(value)">
                                <option value="4" selected="selected">C</option>
                                <option value="10">C++</option>
                                <option value="16">C#</option>
                                <option value="27">Java</option>
                                <option value="29">JavaScript</option>
                                <option value="22">Go(go 1.7.4)</option>
                                <option value="36">Python(cpython 2.7.13)</option>
                                <option value="35">Python3(python 3.5)</option>
                                <option value="38">Ruby(ruby 2.3.3)</option>
                            </select>
                            <span class="input-group-btn">
                                <button onclick="runCode()" class="btn btn-primary" type="button" tabindex="-1">Run&nbsp;
                                    <span class="fa fa-cog" aria-hidden="true"></span>
                                </button>
                            </span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <!-- Question Seciton -->
                    <div class=" col-md-6">
                        <!-- <section class="cardView">
                            <p>
                                <h3>Question</h3>                                
                        </section> -->
                        <ul class="nav nav-tabs">
                            <li class="active">
                                <a data-toggle="tab" href="#home">Problem <span id="qcount">0/0</span></a>
                            </li>
                            <li>
                                <a data-toggle="tab" href="#menu1">Output</a>
                            </li>
                            <li class="nav-item pull-right">
                                <a class="btn btn-sm" onclick="nextQuestion()" type="button">Next</a>
                            </li>
                            <li class="nav-item pull-right">
                               <a class="btn btn-sm" onclick="prevQuestion()" type="button">Prev</a>
                            </li>
  
                        </ul>
                        <div class="tab-content">
                            <div id="home" class="tab-pane fade in active">
                             
                                <h3>Problem</h3>
                                <p id="problemStatement"> </p>

                                 <strong>Example</strong> 
                                <p id="details"></p>
                            </div>
                            <div id="menu1" class="tab-pane fade">
                                <h3>Output</h3>
                                <div id="output">

                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Editor Section -->
                    <section class="col-md-6" id="editor">
                        <!-- <h4>Please Submit Your Solution Below</h4> -->
                        Press F11 to edit in full screen
                        <textarea class="codeMirror" >       
                    </textarea>
                        <script src="<c:url value=" /resources/script/editor.js " />"></script>
                        <!--input type="submit"  value="Submit"  class="btn btn-success" /-->

                    </section>
                </div>
            </div>
        </body>
        <!-- Dialog box -->                                     
                            <div id="white-background">
                            </div>
                            <div id="dlgbox" class="text-center">
                                <div id="dlg-header" style="padding:10px 0 0 0">Are you Sure?<hr></div>
                                <div id="dlg-body">
                                    <span style="font-size:20px">You want to Submit?</span><br>
                                    <span>
                                        Note : Once submitted, you will not be able to<br>
                                        make any changes!
                                    </span>
                                </div>
                                <div id="dlg-footer">
                                    <button class="btn-black" onclick="dlg1OK()" style="padding: 5px">Confirm</button>
                                    <button class="btn-black" onclick="dlgCancel()" style="padding: 5px">Cancel</button>
                                </div>
                            </div>
                        <!-- Dialog box end -->   
        <div class="space"></div>
    <!-- footer -->
    <jsp:include page="/WEB-INF/shared/footer.jsp" />
        </html>