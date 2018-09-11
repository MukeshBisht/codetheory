<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored = "false" %>

<div class="container body-content">
    <h3>CodeChamp Preview</h3>

    <table class="table table-hover">
            <tr>
                <th>S.no.</th>
                <th>Round Name</th>
                <th>Starting Time</th>
                <th>Ending Time</th>
                <th></th>
                <th></th>
            </tr>
            <tbody id="contestData">
                <c:forEach items="${rounds}" var="round" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${round.name}</td>
                        <td>${round.startDate}</td>
                        <td>${round.endDate}</td>
                        <td>X</td>
                    </tr>
                </c:forEach>
            </tbody>

            </table>




</div>