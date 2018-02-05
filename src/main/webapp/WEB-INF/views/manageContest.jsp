<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored = "false" %>
<html>

<head></head>

<body>
    <!-- header -->
    <jsp:include page="/WEB-INF/shared/header.jsp" />
    <script src="<c:url value=" /resources/script/ContestMgmt.js " />"></script>
    <script src="<c:url value=" /resources/script/jquery-ui.js " />"></script>
    <link rel='stylesheet' href="<c:url value=" /resources/css/jquery-ui.css "/>" type='text/css' />
    <script src="<c:url value=" /resources/lib/datatables/js/dataTables.bootstrap.js " />"></script>
    <link rel='stylesheet' href="<c:url value=" /resources/lib/datatables/css/dataTables.bootstrap.css "/>" type='text/css' media='screen'/>

    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <h3>${contest}</h3>
                <input type="hidden" id="contestName" value="${contest}" />
                <p>
                    <a href="/contest/${contest}" target="_blank">www.codetheory.com/contest/${contest}</a>
                </p>
            </div>
        </div>
        <div class="row">
            <!-- Question Seciton -->
            <div class=" col-sm-12">
                <ul class="nav nav-tabs">
                    <li>
                        <a data-toggle="tab" href="#Details">Details</a>
                    </li>
                    <li>
                        <a data-toggle="tab" href="#Customization">Customization</a>
                    </li>
                    <li class="active">
                        <a data-toggle="tab" href="#Content">Content</a>
                    </li>
                    <li>
                        <a data-toggle="tab" href="#Moderators">Moderators</a>
                    </li>
                    <li>
                        <a data-toggle="tab" href="#Notifications">Notifications</a>
                    </li>
                    <li>
                        <a data-toggle="tab" href="#Advance">Advance</a>
                    </li>
                </ul>
                <div class="tab-content">
                    <div id="Details" class="tab-pane fade ">
                        <h3>Contest Details</h3>
                        <p>Edit contest details</p>
                        <jsp:include page="/contest/update/${contest}" />
                    </div>

                    <div id="Customization" class="tab-pane fade">
                        <h3>Landing Page Customization</h3>
                        <p>Change content on landing page</p>
                    </div>

                    <div id="Content" class="tab-pane fade in active">
                        <jsp:include page="/WEB-INF/views/round.jsp" />
                    </div>

                    <div id="Moderators" class="tab-pane fade">
                        <h3>Moderators</h3>
                        <p>Users with moderator access can edit this contest</p>
                        <div class="input-group">
                            <span class="input-group-addon">Add Moderator </span>
                            <input type="text" id="modselect" class="form-control" placeholder="Username eg. john12">
                            <span class="input-group-btn">
                                <button class="btn btn-default" onclick="addModerator()" type="button">Add</button>
                            </span>
                        </div>
                        <br/>
                        <h4>Current Moderators</h4>
                        <table id="modtab" class="table table-striped table-dark">
                            <th scope="col">User</th>
                            <th scope="col">Role</th>
                            <th scope="col">Action</th>
                            <tbody>
                            </tbody>
                        </table>
                        <i class="fa fa-cog fa-spin fa-3x fa-fw" id="outloading"></i>
                    </div>

                    <div id="Notifications" class="tab-pane fade">
                        <h3>Notifications Settings</h3>
                        <p>Notification to send to the user when they signup for this contest</p>
                    </div>

                    <div id="Advance" class="tab-pane fade">
                        <h3>Advance Settings</h3>
                    </div>
                </div>
            </div>
        </div>



        <!-- footer -->
        <jsp:include page="/WEB-INF/shared/footer.jsp" />
    </div>
</body>

</html>