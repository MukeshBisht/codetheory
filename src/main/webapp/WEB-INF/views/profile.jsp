<html>
    <head>

    </head>

    <body>
        <!-- header -->
        <jsp:include page="/WEB-INF/shared/header.jsp" />
        
        <!-- page body -->

            <section class="container">
                <div class="text-center cardView col-md-3">
                        <i class="fa fa-user " style="font-size:250px" aria-hidden="true"></i>
                        <label for="username" class="h3">@imsagar</label>
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

                <div class="col-md-8 cardView" style="margin-left:10px">
                   
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
 
                    <div class="form-group">
                        <label path="something">Something</label>
                        <input path="something" name="something" id="something" value="something" class="form-control">                                
                    </div>
            
                    <button class="btn btn-success">save changes</button>
                </div>

            </section>

            <section class="container">
                <div class="col-md-3"></div> 
                
                <div class="col-md-8" data-toggle="collapse" data-target="#accordion">
                    <button class="btn btn-block btn-default"><h4>Contest Participated</h4></button>
                    <table class="table table-hover collapse" id="accordion" >
                      
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
            </section>
        <!-- footer -->
        <jsp:include page="/WEB-INF/shared/footer.jsp" />
    </body>
</html>