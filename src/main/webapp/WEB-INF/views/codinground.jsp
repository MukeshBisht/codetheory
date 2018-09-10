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
                var round = "${round}";
                var roundid = "${roundid}";
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
                        <h1>code round</h1>
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
                                <a data-toggle="tab" href="#home">Problem</a>
                            </li>
                            <li>
                                <a data-toggle="tab" href="#menu1">Output</a>
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
                        <textarea class="codeMirror" >       
                    </textarea>
                        <script src="<c:url value=" /resources/script/editor.js " />"></script>
                        <!--input type="submit"  value="Submit"  class="btn btn-success" /-->

                    </section>
                </div>
            </div>
        </body>
        <div class="space"></div>
    <!-- footer -->
    <jsp:include page="/WEB-INF/shared/footer.jsp" />
        </html>