<html>
    <head>

    </head>

    <body>
        <!-- header -->
        <jsp:include page="/WEB-INF/shared/header.jsp" />
        
        <!-- page body -->
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@page isELIgnored = "false" %>
    
            <section class="container">
                <div class="text-center cardView col-md-3">
                        <i class="fa fa-user " style="font-size:250px" aria-hidden="true"></i>
                        <label for="username" class="h3">@imsagar</label>
                        <div>

                            <c:forEach items="${cardList.cards}" var="card">
                                <p>${card.name}</p>
                            </c:forEach>

                            
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
                        <div style="margin-left:10px">
                   
                                <div class="form-group">
                                    <label path="username">Username</label>
                                    <input path="username" name="username" id="username" value="@imsagar" class="form-control">                                
                                </div>
            
                                <div class="form-group">
                                        <label path="name">Name</label>
                                        <input path="name" name="name" id="name" value="Sagar Rawat" class="form-control">                                
                                </div>
                
                                <div class="form-group">
                                    <label path="email">Email</label>
                                    <input path="email" name="email" id="email" value="sagarrawat2808@gmail.com" class="form-control">                                
                                </div>
            
                                <div class="form-group">
                                    <label path="something">Something</label>
                                    <input path="something" name="something" id="something" value="something" class="form-control">                                
                                </div>
                                
                                <button class="btn btn-success">save changes</button>
                            </div>
            
                    </div>

                    <div id="Notifications" class="tab-pane fade">
                        <h3>Notifications</h3>
    
                    </div>
    
                    <div id="Participation" class="tab-pane fade">
                        <h3>Participation</h3>
                        <table class="table">
                      
                                <th>Contest Name</th>
                                <th>Contest Rank</th>
                                <th>Points Earned</th>
                                <th>Question Solved</th>
                            
                                <tr>
                                    <td>CodeJam</td>
                                    <td>123</td>
                                    <td>85</td>
                                    <td>15</td>
                                </tr>
        
                                <tr>
                                    <td>CodeJam</td>
                                    <td>123</td>
                                    <td>85</td>
                                    <td>15</td>
                                </tr>
                            
                                <tr>
                                        <td>CodeJam</td>
                                        <td>123</td>
                                        <td>85</td>
                                        <td>15</td>
                                    </tr>
                            </table>
                    </div>

                    <div id="Contribution" class="tab-pane fade">
                        <h3>Contributed to CodeTheory.in</h3>

                    </div>

                    <div id="Security" class="tab-pane fade">
                        <h3>Security Settings</h3>
                        <div class="form-group">

                            <label for="password">Current Password</label>
                                <input class="form-control" type="password"/> <br/>
                            
                            <label for="password">New Password</label>
                                <input class="form-control" type="password"/> <br/>
                            
                            <label for="password">Confirm Password</label>
                                <input class="form-control" type="password"/> <br/>

                            <input class="btn btn-success" type="button" value="change password"/>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>


            </section>

        <!-- footer -->
        <jsp:include page="/WEB-INF/shared/footer.jsp" />
    </body>
</html>