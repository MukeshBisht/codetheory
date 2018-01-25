<html>

<head></head>

<body>

    <!-- header -->
    <jsp:include page="/WEB-INF/shared/header.jsp" />

    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <h3>CodeJam</h3>
                <p>
                    <a href="/contest/codejam2018" target="_blank">www.codetheory.com/contest/codejam2018</a>
                </p>
            </div>
        </div>
        <div class="row">
            <!-- Question Seciton -->
            <div class=" col-sm-12">
                <ul class="nav nav-tabs">
                    <li class="active">
                        <a data-toggle="tab" href="#Details">Details</a>
                    </li>
                    <li>
                        <a data-toggle="tab" href="#Customization">Customization</a>
                    </li>
                    <li>
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
                    <div id="Details" class="tab-pane fade in active">
                        <h3>Contest Details</h3>

                    </div>

                    <div id="Customization" class="tab-pane fade">
                        <h3>Landing Page Customization</h3>

                    </div>

                    <div id="Content" class="tab-pane fade">
                        <h3>Manage Contest Content</h3>

                    </div>

                    <div id="Moderators" class="tab-pane fade">
                        <h3>Moderators</h3>

                    </div>

                    <div id="Notifications" class="tab-pane fade">
                        <h3>Notifications Settings</h3>

                    </div>

                    <div id="Advance" class="tab-pane fade">
                        <h3>Advance Settings</h3>

                    </div>
                </div>
            </div>
        </div>
        <!-- footer -->
        <jsp:include page="/WEB-INF/shared/footer.jsp" />
</body>

</html>