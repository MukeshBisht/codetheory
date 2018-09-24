<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored = "false" %>

<html>

<head>
</head>

<body>
    <!-- header -->
    <jsp:include page="/WEB-INF/shared/header.jsp" />
    <script src="<c:url value=" /resources/script/jquery-ui.js " />"></script>    
    <script src="<c:url value=" /resources/script/challengegroup.js " />"></script>
    
    <div class="container">
        <div class="row">
            <!-- <div class="alert alert-success" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                    </button>
                Group created</div>
            <div class="alert alert-danger" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                    </button>
                Failed</div> -->
            <h2>Challenges Created by ${user}</h2>
            <br/>
            <!-- Question Seciton -->
            <div class=" col-sm-12">
                <ul class="nav nav-tabs">
                    <li class="active">
                        <a data-toggle="tab" href="#mcq">MCQ Challenges</a>
                    </li>
                    <li>
                        <a data-toggle="tab" href="#code">Coding Challenges</a>
                    </li>
                </ul>
                <div class="tab-content">
                    <div id="mcq" class="tab-pane fade in active">
                        <h3>MCQ Challenges</h3>
                        <br/>
                        <h4>Create New Group</h4>

                        <form method="POST" action="/challenge/group">

                            <div class="col-md-5">
                                <input type="text" id="name" name="name" class="form-control" placeholder="Group Name" required>
                            </div>

                            <div class="col-md-5">
                                <input id="category" name="category" class="form-control" type="text" placeholder="Enter a category" required>
                            </div>

                            <input id="ctype" name="ctype" type="hidden" value="mcq">
                            <span class="input-group-btn">
                                <button class="btn btn-success" type="submit">Add</button>
                            </span>
                        </form>
                        <br/>
                        <h4>Your Challenge Groups</h4>
                        <div class="table-responsive">
                        <table class="table table-bordered table-striped table-hover">
                            <th scope="col">Name</th>
                            <th scope="col">Challenges</th>
                            <th scope="col">Category</th>
                            <th scope="col">Owner</th>
                            <th scope="col"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></th>
                            <tbody>
                                <c:forEach items="${challenge.mcqGroups}" var="g">
                                    <tr class="clickable-row" data-href="/challenge/group/manage/${g.groupId}">
                                        <td>${g.name}</td>
                                        <td>${g.challengeCount}</td>
                                        <td>${g.category}</td>
                                        <td>${g.owner}</td>
                                        <td>
                                            <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    </div>

                    <div id="code" class="tab-pane fade in ">
                        <h3>Coding Challenges</h3>
                        <br/>
                        <h4>Create New Group</h4>

                        <form class="input-group" method="POST" action="/challenge/group">

                            <input type="text" id="name" name="name" class="form-control" placeholder="Group Name" required/>
                            <input id="ctype" name="ctype" type="hidden" value="code" />
                            <span class="input-group-btn">
                                <button class="btn btn-success" type="submit">Add</button>
                            </span>
                        </form>

                        <br/>
                        <h4>Your Challenge Groups</h4>
                        <div class="table-responsive">
                        <table class="table table-bordered table-striped table-hover">
                            <th scope="col">Name</th>
                            <th scope="col">Challenges</th>
                            <th scope="col">Owner</th>
                            <th scope="col"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></th>
                            <c:forEach items="${challenge.codeGroups}" var="g">
                                    <tr class="clickable-row" data-href="/challenge/group/manage/${g.groupId}">
                                        <td>${g.name}</td>
                                        <td>${g.challengeCount}</td>
                                        <td>${g.owner}</td>
                                        <td>
                                            <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
                                        </td>
                                    </tr>
                                </c:forEach>
                        </table>
                    </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
        jQuery(document).ready(function($) {
            $(".clickable-row").click(function() {
             window.location = $(this).data("href");
            });
        });
    </script>
    <!-- footer -->
    <jsp:include page="/WEB-INF/shared/footer.jsp" />
</body>

</html>