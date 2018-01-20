<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored = "false" %>
<html>
<head>

        <script src="<c:url value=" /resources/lib/codemirror/lib/codemirror.js " />"></script>
        <script src="<c:url value=" /resources/lib/codemirror/mode/javascript/clike.js " />"></script>
  
        <link rel='stylesheet' href="<c:url value=" /resources/lib/codemirror/lib/codemirror.css "/>" type='text/css' media='screen' />
        <script src="\resources\lib\codemirror\mode\clike\clike.js"></script>
                

</head>

<body >
    <!-- header -->
    <jsp:include page="/WEB-INF/shared/header.jsp" />
    <!-- page body -->
    <header>
        <h1>Welcome to Round 3</h1>
    </header>
    <!-- Question Seciton -->
    <section class="container cardView">
       <p><h3>Question</a></h3>  Taxis of Kharagpur are famous for making sharp turns. You are given the coordinates where a particular taxi was on a 2-D planes at N different moments: (x1, y1), (x2, y2), ..., (xN, yN). In between these coordinates, the taxi moves on a straight line. A turn at the i-th (2 ≤ i ≤ N-1) coordinate is said to be a sharp turn if the angle by which it turns at Point B = (xi, yi) when going from coordinates A = (xi-1, yi-1) to C = (xi+1, yi+1) via (xi, yi) is greater than 45 degrees. ie. suppose you extend the line segment AB further till a point D, then the angle DBC would be greater than 45 degrees.</p>
        <p>You have to identify whether the taxi made a sharp turn somewhere or not (Please look at Output section for details). If it made a sharp turn, also identify whether it is possible to change the coordinates at one of the N moments to make sure that the taxi doesn't make any sharp turn. Note that all the N pairs of coordinates (including the new coordinates) should be integers and distinct and should have their x and y coordinates at least 0 and at most 50.</p>


    </section>

   <!-- Editor Section -->
   <section class="container" id="editor">                  
        <h4>Please Submit Your Solution Below</h4>      
        <textarea class="codeMirror col-md">
        
        </textarea>
            <script src="<c:url value=" /resources/script/editor.js " />"></script>

       
        
        <!--input type="submit"  value="Submit"  class="btn btn-success" /-->
        
    </section>
    <div class="container cardView" id="langSelect">
        <label for="edit-language">Language:</label>
        <select name="language"  class="form-control" onclick = "setMode(value)" ><option value="1" selected="selected">C</option><option value="2">C++</option><option value="3">C#</option><option value="4">Go(go 1.7.4)</option><option value="5">Java</option><option value="6">JavaScript</option><option value="7">Kotlin(kotlin 1.0.6)</option><option value="8">PHP(php 7.1.0)</option><option value="9">Python(cpython 2.7.13)</option><option value="10">Python3(python  3.5)</option><option value="11">Ruby(ruby 2.3.3)</option></select>
        <br>  <a input type="button" class="btn btn-primary" >Run&nbsp;<i class="fa fa-cog"></i></a>
    </div>
</body>
</html>