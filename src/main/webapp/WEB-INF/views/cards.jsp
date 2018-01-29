<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page isELIgnored = "false" %>

        <c:forEach items="${cardList.cards}" var="card">
            <div class="panel panel-default">
                <div class="panel-heading">
                        <b>${card.name}</b>
                    
                    <span class="badge pull-right">${card.participants}</span>
                </div>
                <div class="panel-body">
                    <p>Starting : ${card.startDate}</p>
                    <p>Tags :
                        <c:forEach items="${card.tags}" var="tag"> ${tag}, </c:forEach>
                    </p>
                    <p>Info : ${card.info}</p>
                    <p>Organiser : ${card.organiser}</p>
                    <a role="button" class="btn btn-success" href="contest/${card.name}">View</a>
                </div>
            </div>
        </c:forEach>