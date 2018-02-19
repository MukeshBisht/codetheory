<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page isELIgnored = "false" %>
<html>
    <head>

    </head>

    <body>
        <!-- header -->
        <jsp:include page="/WEB-INF/shared/header.jsp" />
        <script src="<c:url value=" /resources/script/profile.js" />"></script>
        
        <!-- page body -->
      
            <section class="container">
                <div class="text-center cardView col-md-3" id="profile">
                        <i class="fa fa-user " style="font-size:250px" aria-hidden="true"></i>
                        <label for="username" class="h3">@${user.username}</label>
                        <div>

                            <label for="Rank" class="text">
                                Rank :<span>SuperUser</span>
                            </label><br/>
                            
                            <label for="Challenge Completed" class="text">
                                Challenge Completed : <span>280</span>
                            </label><br/>
                            
                            <label for="Contest Created" class="text">
                                    Contest Created : <span>10</span>
                            </label><br/>

                            <label for="total points" class="text">
                                Total Points :
                                <span>930</span>
                            </label><br/>
                            
                        </div>
                    </div>


                    
        <div class="row col-md-8" style="margin-left:10px">
            <!-- Question Seciton -->
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
                    <div id="Details" class="tab-pane fade in active">
                        <h3>Personal Details</h3>
                       
                        <form class="form" method="POST" modelAttribute="updateForm" onsubmit="showDialog()" style="margin-left:10px">
                   
                                <div class="form-group">
                                    <label path="username">Username</label>
                                    <input path="username" name="username" id="username" value=${user.username} class="form-control" disabled="true">                                
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
                                    <!-- Dialog box -->                                     
                                 
                                    <div id="white-background">
                                        </div>
                                        <div id="dlgbox">
                                            <div id="dlg-header">Are you Sure?</div>
                                            <div id="dlg-body">
                                                <span>You want to change you personal details!</span>
                                            </div>
                                            <div id="dlg-footer">
                                                <button onclick="dlgOK2()">Confirm</button>
                                                <button onclick="dlgCancel()">Cancel</button>
                                            </div>
                                        </div>
                                    <!-- Dialog box end -->       
                            </form>
            
                    </div>

                    <div id="Notifications" class="tab-pane fade">
                        <h3>Notifications</h3>
    
                    </div>
    
                    <div id="Participation" class="tab-pane fade">
                        <div class="row">
                            <div class="col-xs-12">
                              <div class="box">
                                <div class="box-header">
                                  <h3 class="box-title">Responsive Hover Table</h3>
                                </div>
                                <!-- /.box-header -->
                                <div class="box-body table-responsive no-padding">
                                  <table class="table table-hover">
                                    <tr>
                                      <th>ID</th>
                                      <th>User</th>
                                      <th>Date</th>
                                      <th>Status</th>
                                      <th>Reason</th>
                                    </tr>
                                    <tr>
                                      <td>183</td>
                                      <td>John Doe</td>
                                      <td>11-7-2014</td>
                                      <td><span class="label label-success">Approved</span></td>
                                      <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>
                                    </tr>
                                    <tr>
                                      <td>219</td>
                                      <td>Alexander Pierce</td>
                                      <td>11-7-2014</td>
                                      <td><span class="label label-warning">Pending</span></td>
                                      <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>
                                    </tr>
                                    <tr>
                                      <td>657</td>
                                      <td>Bob Doe</td>
                                      <td>11-7-2014</td>
                                      <td><span class="label label-primary">Approved</span></td>
                                      <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>
                                    </tr>
                                    <tr>
                                      <td>175</td>
                                      <td>Mike Doe</td>
                                      <td>11-7-2014</td>
                                      <td><span class="label label-danger">Denied</span></td>
                                      <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>
                                    </tr>
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

                    <div id="Security" class="tab-pane fade">
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
                               
                            <!-- Dialog box -->                                     
                                 
                                <div id="white-background">
                                    </div>
                                    <div id="dlgbox">
                                        <div id="dlg-header">Are you Sure?</div>
                                        <div id="dlg-body">
                                            <span>You want to change you Password!</span>
                                        </div>
                                        <div id="dlg-footer">
                                            <button onclick="dlgOK()">OK</button>
                                            <button onclick="dlgCancel()">Cancel</button>
                                        </div>
                                    </div>
                                <!-- Dialog box end -->   

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