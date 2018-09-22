<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page isELIgnored = "false" %>

<html >
    <head>
                       
    </head>

    <body>
        
        <!--  Header  -->
        <jsp:include page="/WEB-INF/shared/header.jsp" />
        <!-- <script src="<c:url value=" /resources/script/contests.js " />"></script> -->
        <script type="text/javascript">
            $(document).ready(function() {
                $('#cgrid').DataTable();
            } );
            con = ["a","b"]; 
        </script>
        <script src="<c:url value=" /resources/lib/datatables/js/jquery.dataTables.js " />"></script>
            <script src="<c:url value=" /resources/lib/datatables/js/dataTables.bootstrap.js " />"></script>
            <link rel='stylesheet' href="<c:url value=" /resources/lib/datatables/css/dataTables.bootstrap.css "/>" type='text/css' media='screen'/>
        <section id="contestHeader" class="container cardView">
            <div class ="col-md-2">
              
            </div>
            <div class="text-center col-md-7"> 
                <h2 class="text text-default">PARTICPATE, COMPETE AND HAPPY LEARNING...</h2>
            </div>
            
        </section>
        
        <section class="container">

            <div class="col-md-2 cardView ">
                <h2 class="text text-default">Categories</h2>

                <ul class="list-group text-primary">
                    <li class="list-group-item" href="#">
                        Java SE
                        <span class="badge">
                            100
                        </span>
                    </li>

                    <li class="list-group-item" href="#">
                        Python 3.5
                        <span class="badge">
                            50
                        </span>
                    </li>

                    <li class="list-group-item" href="#">
                        C++14
                        <span class="badge">
                            34
                        </span>
                    </li>


                    <li class="list-group-item" href="#">
                        Others
                        <span class="badge">
                            23
                        </span>
                    </li>
                </ul>

            </div>

            <div class="col-md-10 ">
                 <table id="cgrid" class="table table-hover contest_table" style="background:white; text-align:center">
                    <thead class="cardView">
                        <th>S.no</th>
                        <th>Name</th>
                        <th>Category</th>
                        <th>Starting</th>
                        <th>Ending</th>
                        <th>contest</th>
                        <th>#Participants</th>
                        <th>visit</th>
                    </thead>

                    <tbody class="cardView" id="contests_body">
                        <c:forEach var="contest" items="${contestList}" varStatus="status">

                            <tr class="cardView">

                                <td>${status.index + 1}</td>
                                <td>${contest.contestname}</td>
                                <td>Computer Science</td>
                                <td>${contest.startDate}</td>
                                <td>${contest.endDate}</td>
                                <td><c:if test="${contest.isOpen}">
                                        Practice
                                    </c:if>
                                    <c:if test="${not contest.isOpen}">
                                        Competition 
                                    </c:if></td>
                                <td>${participants[status.index]}</td>
                                <td style="text-decoration: none"><a href="/contest/${contest.contestname}"><i class="fa fa-binoculars"></i></a></td>
                            </tr>

                        </c:forEach>
                    </tbody>
                </table> 
            </div>

          <!--  <div class="col-md-2 cardView" id="shareContest">
                <p class="text-active" style="font-size:15px;font-weight:bold">
                    Invite your friends to CodeTheory
                </p>

                <div>
                    <button class="btn btn-primary">
                        <i class="fa fa-facebook fa"></i>
                    </button>

                    <button class="btn btn-danger">
                        <i class="fa fa-google-plus fa"></i>
                    </button>

                    <button class="btn btn-primary">
                        <i class="fa fa-twitter fa"></i>
                    </button>
                    
                </div>
                
                <div style="margin-top:10px">
                    <p class="text-active text-center" style="font-size:15px;font-weight:bold">
                        invite them via email
                        <input class="form-control" type="text" placeholder="">
                        <button class="btn btn-primary btn-sm" style="margin-top:4px">send</button>
                    </p>
                </div>
                    
            </div> -->

        </section>
        <!-- footer -->
        <jsp:include page="/WEB-INF/shared/footer.jsp" />
    </body>
</html>
