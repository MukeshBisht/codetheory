<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page isELIgnored = "false" %>


<div class="container">
                
    <div class="cardView text-center" >
        <h2 class="text-active">Result</h2>
        <h3 class="text-success">
            You got 
            <span id="points">
                ${marks} out of ${total}
            </span>
        </h3>
        <label class="text-primary">Click here to go to next round</label><br/>
        <i class="fa fa-hand-o-right" style="font-size:25px"></i>
        <a class="btn btn-primary" type="button" href="/RoundThree">next round</a>

    </div>

    <div class="cardView" style="margin-bottom:50px">
        <h2>Summary</h2>
        <table class="table">
            <thead>
                <th>S.No</th>
                <th>Question</th>
                <th>Correct Answer</th>
                <th>Your Answer</th>
            </thead>
                    
        <tbody id="resultBody">
                    
            <c:forEach var="ques" items="${question}" varStatus="status">

                <tr>
        
                    <td>${status.index+1}</td>
                    <td>${ques.question}</td>
                    
                    <td class="text-success">${answer[status.index]}</td>
                    
                    <c:choose>
                        <c:when test = "${ques.selected != -1}">
                            <td class="text-danger">${ques.options[ques.selected]}</td>
                        </c:when>
            
                        <c:otherwise>
                            <td class="text-danger">not attempted</td>
                        </c:otherwise>
                    </c:choose>
                </tr>

            </c:forEach>

            </tbody>
        </table>
    </div>
</div>