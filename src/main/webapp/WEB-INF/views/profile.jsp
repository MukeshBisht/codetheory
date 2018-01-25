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
                            </label>
                            
                            <label for="Challenge Completed" class="text">
                                Challenge Completed : <span>280</span>
                            </label>
                            
                            <label for="Contest Created" class="text">
                                    Contest Created : <span>10</span>
                            </label><br>

                            <label for="total points" class="text">
                                 Total Points: <span>930</span>
                            </label>
                            
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
            
                    <button class="btn btn-success">save changes</button>
                </div>

            </section>
        <!-- footer -->
        <jsp:include page="/WEB-INF/shared/footer.jsp" />
    </body>
</html>