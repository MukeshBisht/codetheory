<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page isELIgnored = "false" %>
<html>
    <head>

    </head>

    <body>
        <!-- header -->
        <jsp:include page="/WEB-INF/shared/header.jsp" />
        <script src="<c:url value=" /resources/script/profile.js" />"></script>

        <script type="text/javascript">
            $(document).ready(function() {
                $('#cgrid').DataTable();
            } );
            con = ["a","b"]; 
        </script>
        <script src="<c:url value=" /resources/lib/datatables/js/jquery.dataTables.js " />"></script>
        <script src="<c:url value=" /resources/lib/datatables/js/dataTables.bootstrap.js " />"></script>
        <link rel='stylesheet' href="<c:url value=" /resources/lib/datatables/css/dataTables.bootstrap.css "/>" type='text/css' media='screen'/>

        
        <!-- page body -->
      
            <section class="container">
                <div class="text-center cardView col-md-3" id="profile">
                        <i class="fa fa-user " style="font-size:200px" aria-hidden="true"></i><br>
                        <label for="username" class="text">@${user.username}</label><hr/>
                        <div>

                            <label for="Rank" class="text">
                                Rank :<span>None</span>
                            </label><br/>
                            
                            <label for="Challenge Completed" class="text">
                                Challenge Completed : <span>0</span>
                            </label><br/>
                            
                            <label for="Contest Created" class="text">
                                    Contest Created : <span>0</span>
                            </label><br/>

                            <label for="total points" class="text">
                                Total Points :
                                <span>0</span>
                            </label><br/>
                            
                        </div>
                    </div>


                    
        <div class="row col-md-8" style="margin-left:10px;background:#fff">
            
            <div>
                <ul class="nav nav-tabs">
                    <li class="active">
                        <a data-toggle="tab" href="#Details">Details</a>
                    </li>
                    
                    <li>
                        <a data-toggle="tab" href="#Notifications">Notifications</a>
                    </li>
                    
                    <li>
                        <a data-toggle="tab" href="#Participation">Participation</a>
                    </li>
                    <li>
                    <a data-toggle="tab" href="#Contribution">Contribution</a>
                </li>
                    <li>
                        <a data-toggle="tab" href="#Security">Security</a>
                    </li>
                </ul>
                <div class="tab-content">
                    <div id="Details" class="tab-pane fade in active cardView">
                        <h3>Personal Details</h3>
                       
                        <form class="form" method="POST" modelAttribute="updateForm" onsubmit="showDialog()" style="margin-left:10px">
                   
                                <div class="form-group">
                                    <label path="username">Username</label>
                                    <input path="username" name="username" id="username" value=${user.username} class="form-control" disabled="true" style="cursor:pointer">                                
                                </div>
            
                                <div class="form-group">
                                        <label path="name">Name</label>
                                        <input path="name" name="name" id="name" value=${user.name} class="form-control">                                
                                </div>
                
                                <div class="form-group">
                                    <label path="email">Email</label>
                                    <input path="email" name="email" id="email" value=${user.email} class="form-control">                                
                                </div>
            
                                <button class="btn btn-success">save changes</button>
                                    <!-- Dialog box                
                                        
                                        <div id="white-background">
                                        </div>
                                        <div id="dlgbox">
                                            <div id="dlg-header">Are you Sure?</div>
                                            <div id="dlg-body">
                                                <span>You want to change you personal details!</span>
                                            </div>
                                            <div id="dlg-footer">
                                                <button class="btn-black" onclick="dlgOK2()">Confirm</button>
                                                <button class="btn-black" onclick="dlgCancel()">Cancel</button>
                                            </div>
                                        </div>
                                       Dialog box end -->       
                                                              
                            </form>
            
                    </div>

                    <div id="Notifications" class="tab-pane fade">
                        <h3>Notifications</h3>
    
                    </div>
    
                    <div id="Participation" class="tab-pane fade cardView">
                        <div class="row">
                            <div class="col-xs-12">
                              <div class="box">
                                <div class="box-header">
                                  <h4 class="box-title">Contests You Participated In</h4>
                                </div>
                                <!-- /.box-header -->
                                <div class="box-body table-responsive no-padding">
                                  <table id="cgrid" class="table table-hover">
                                    <thead>
                                        <th>Contest</th>
                                        <th>Organiztion</th>
                                        <th>Status</th>
                                        <th>Visit</th>
                                        <th></th>
                                    </thead>

                                    <tbody>
                                        <c:forEach var="contest" items="${contestList}">
                                            <tr id = ${contest.contestname}>
                                                <td>${contest.contestname}</td>
                                                <td>${contest.orgName}</td>
                                                <td>${contest.status}</td>
                                                <td><a href='/contest/${contest.contestname}' style="text-decoration:none"><i class="fa fa-binoculars"></i> view</a></td>
                                                <td> <i class = "fa fa-close" onclick="remove('${contest.contestname}')" style="color:red"></i></td>
                                            </tr>
                                        </c:forEach>
                                     </tbody>
                                    </table>
                                    <!-- Dialog box -->                                     
                                    <div id="white-background">
                                    </div>
                                    <div id="dlgbox">
                                        <div id="dlg-header" class="text-center">Are you Sure?<hr></div>
                                          <div id="dlg-body" style="font-size:18px;padding-top:0">
                                              <span>
                                                    You no longer will be the part of this Contest!
                                              </span>
                                          </div>
                                          <div id="dlg-footer">
                                              <button class="btn-black" onclick="dlgOK3()" style="padding: 5px">Confirm</button>
                                              <button class="btn-black" onclick="dlgCancel()" style="padding: 5px">Cancel</button>
                                          </div>
                                        </div>
                                        
                                        <!-- Dialog box end -->     
                                    </table>

                                    </div>
                                <!-- /.box-body -->
                              </div>
                              <!-- /.box -->
                            </div>
                          </div>                   
                         </div>

                    <div id="Contribution" class="tab-pane fade">
                        <h3>Contributed to CodeTheory.in</h3>

                    </div>

                    <div id="Security" class="tab-pane fade cardView">
                        <h3>Security Settings</h3>
                        <form class="form-group" method="POST" action="/user/profile/changePass">

                            <label for="password">Current Password</label>
                                <input class="form-control" id="password" name="password" type="password" required="true"/> <br/>
                            
                            <label for="password">New Password</label>
                                <input class="form-control" id="newpassword" name="newpassword" type="password" required="true"/> <br/>
                            
                            <label for="password">Confirm Password</label>
                                <input class="form-control" id="cnewpassword" type="password" required="true"/> <br/>
                                <div id="cpassword_chk" class="response"></div> 
                                
                            <button class="btn btn-success" onclick="showDialog()">change password</button>

                        </form>
                    </div>
                </div>
            </div>
        </div>


            </section>

        <!-- footer -->
        <jsp:include page="/WEB-INF/shared/footer.jsp" />
    </body>
</html>