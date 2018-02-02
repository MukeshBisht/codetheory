<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored = "false" %>

<html>

<head>

</head>

<body>
    <!-- header -->
    <jsp:include page="/WEB-INF/shared/header.jsp" />
    <!-- page body -->
    <div class="container">
        <div class="cardView text-center" style="margin-bottom:50px">
            <h2 class="text-active">Result</h2>
            <h3 class="text-success"><i class="fa fa-smile-o" style="font-size:30px"></i>You got 30/50</h3>
            <label class="text-primary">Click here to go to next round</label><br/>
            <i class="fa fa-hand-o-right" style="font-size:25px"></i>
            <a class="btn btn-primary" type="button" href="/RoundThree">next round</a>
           
        </div>
        <h3>For Objective Round</h3>
        <div class="cardView" style="margin-bottom:100px">
           <table class="table">
               <thead>
                   <th>S.No</th>
                   <th>Question</th>
                   <th>Correct Answer</th>
                   <th>Your Answer</th>
                   <th>points</th>
               </thead>
               
               <tbody>
                   <tr>
                        <td>1</td>
                        <td>What is Java?</td>
                        <td class="text-success">Java is an OOP language</td>
                        <td class="text-danger">Java is an OBP langauge</td>
                        <td class="text-success">+10</td>
                    </tr>
                   <tr>
                        <td>2</td>
                        <td>What is Java?</td>
                        <td class="text-success">Java is an OOP language</td>
                        <td class="text-danger">Java is an OBP langauge</td>
                        <td class="text-success">+10</td>
                    </tr>
                   <tr>
                        <td>3</td>
                        <td>What is Java?</td>
                        <td class="text-success">Java is an OOP language</td>
                        <td class="text-danger">Java is an OBP langauge</td>
                        <td class="text-danger">0</td>
                    </tr>
                   <tr>
                        <td>4</td>
                        <td>What is Java?</td>
                        <td class="text-success">Java is an OOP language</td>
                        <td class="text-danger">Java is an OBP langauge</td>
                        <td class="text-success">+10</td>
                   </tr>
                   <tr>
                        <td>5</td>
                        <td>What is Java?</td>
                        <td class="text-success">Java is an OOP language</td>
                        <td class="text-danger">not attempted</td>
                        <td class="text-danger">0</td>
                   </tr>
               </tbody>
           </table>
            
        </div>
        <h3>For Coding Round</h3>
        <div class="cardView col-md-12">
            
               <table class="table">
                   <thead>
                       <th>
                           <h3>Your Submitted Solution</h3>
                       </th>
                       <th>
                           <h3>Test cases passed</h3>
                       </th>
                       <th>
                           <h3>Solution Provided to Codethory</h3>
                       </th>
                   </thead>
                   <tr >
                       <td class="text-danger">
                            <p>   #include < stdio.h >
                                    <br/>
                                    <br/>    int main(void) {
                                    <br/>    char name[10];
                                    <br/>    scanf("%s", name);
                                    <br/>    printf("hello, %s\n", name);
                                    <br/>    return 0;
                                    <br/>    }
                                </p>
                         </td>
                         <td class="text-success">
                           <span>first</span>
                             <i class="fa fa-check"></i><br><br>
                            <span>second</span>
                             <i class="fa fa-check"></i><br><br>
                            <span class="text-danger">third</span>
                             <i class="fa fa-close text-danger"></i><br><br>
                            <span class="text-danger">fourth </span>
                             <i class="fa fa-close text-danger"></i><br><br>
                           
                         </td>
                        <td class="text-success">
                       <p>   #include < stdio.h >
                            <br/>
                            <br/>    int main(void) {
                            <br/>    char name[10];
                            <br/>    scanf("%s", name);
                            <br/>    printf("hello, %s\n", name);
                            <br/>    return 0;
                            <br/>    }
                        </p>
                </td>
                 </tr>
            </table>
        </div>
    </div>
    <!-- footer -->
    <jsp:include page="/WEB-INF/shared/footer.jsp" />
</body>

</html>