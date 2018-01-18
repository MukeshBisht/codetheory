<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page isELIgnored = "false" %>

        <c:forEach items="${cardList.cards}" var="card">
            <div class="panel panel-default">
                <div class="panel-heading">
                        <b>${card.name}</b>
                    
                    <span class="badge pull-right"><%= (int) (Math.random()*10)%></span>
                </div>
                <div class="panel-body">
                    <p>Starting : ${card.startDate}</p>
                    <p>Languages :
                        <c:forEach items="${card.languages}" var="lang"> ${lang},</c:forEach>
                    </p>
                    <p>Info : ${card.info}</p>
                    <p>Organiser : ${card.organiser}</p>
                    <a role="button" class="btn btn-success" href="competition/${card.comId}">View</a>
                </div>
            </div>
        </c:forEach>