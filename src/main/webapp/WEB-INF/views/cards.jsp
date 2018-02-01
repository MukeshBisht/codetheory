<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page isELIgnored = "false" %>

        <c:forEach items="${cardList.cards}" var="card">
            <div class="panel panel-info ">
                <div class="panel-heading " id="cardHeading">
                        <b>${card.name}</b>
                    
                    <span class="badge pull-right" id="notificationBadge">${card.participants}</span>
                </div>
                <div class="panel-body cardView">
                    <p>
                        <strong>Starting :</strong> 
                        ${card.startDate}
                    </p>
                    <p>
                        <strong>Tags :</strong>
                        <c:forEach items="${card.tags}" var="tag"> ${tag}, </c:forEach>
                    </p>
                    <p>
                        <strong>Info : </strong>
                        ${card.info}
                    </p>
                    <p>
                        <strong>Organiser :</strong>
                         ${card.organiser}
                    </p>
                    <a role="button" class="btn btn-default" href="contest/${card.name}" 
                        style="width:15%;color:rgb(11, 111, 141)"><strong>View</strong></a>
                </div>
            </div>
        </c:forEach>