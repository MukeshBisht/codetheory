<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page isELIgnored = "false" %>
        <html>

        <head>
        </head>

        <body>
            <!-- header -->
            <jsp:include page="/WEB-INF/shared/header.jsp" />
            <script src="<c:url value=" /resources/script/moment.js " />"></script>
            <script src="<c:url value=" /resources/script/bootstrap-datetimepicker.js " />"></script>
            <link rel='stylesheet' href="<c:url value=" /resources/css/bootstrap-datetimepicker.css "/>" type='text/css' media='screen'/>
            <link rel='stylesheet' href="<c:url value=" /resources/css/jsgrid.min.css "/>" type='text/css' media='screen' />
            <link rel='stylesheet' href="<c:url value=" /resources/css/jsgrid-theme.css "/>" type='text/css' media='screen' />
            <script src="<c:url value=" /resources/script/jsgrid.js " />"></script>
            <script type="text/javascript">
                $(function () {
                    $('#starttimepicker').datetimepicker();
                    $('#endtimepicker').datetimepicker();
                });
            </script>
<script>
        var clients = [
            { "Name": "Otto Clay", "Age": 25, "Country": 1, "Address": "Ap #897-1459 Quam Avenue", "Married": false },
            { "Name": "Connor Johnston", "Age": 45, "Country": 2, "Address": "Ap #370-4647 Dis Av.", "Married": true },
            { "Name": "Lacey Hess", "Age": 29, "Country": 3, "Address": "Ap #365-8835 Integer St.", "Married": false },
            { "Name": "Timothy Henson", "Age": 56, "Country": 1, "Address": "911-5143 Luctus Ave", "Married": true },
            { "Name": "Ramona Benton", "Age": 32, "Country": 3, "Address": "Ap #614-689 Vehicula Street", "Married": false }
        ];
     
        var countries = [
            { Name: "", Id: 0 },
            { Name: "United States", Id: 1 },
            { Name: "Canada", Id: 2 },
            { Name: "United Kingdom", Id: 3 }
        ];
     
        $("#jsGrid").jsGrid({
            width: "100%",
            height: "400px",
     
            inserting: true,
            editing: true,
            sorting: true,
            paging: true,
     
            data: clients,
     
            fields: [
                { name: "Name", type: "text", width: 150, validate: "required" },
                { name: "Age", type: "number", width: 50 },
                { name: "Address", type: "text", width: 200 },
                { name: "Country", type: "select", items: countries, valueField: "Id", textField: "Name" },
                { name: "Married", type: "checkbox", title: "Is Married", sorting: false },
                { type: "control" }
            ]
        });
    </script>
            <div class="container">
                <div class="row">
                    <h3>Create Contest</h3>
                    <p>Host your own contest on CodeTheory.</p>
                </div>

                <div class="form-group col-lg-12">
                    <label>Contest Name
                        <label>
                            <input placeholder="Contest Name" class="form-control" required="true" />
                            <div id="uname_response" class="response"></div>
                </div>
                <div class='col-sm-12'>
                    <div class="form-group">
                        <label>Starting
                            <label>
                                <div class='input-group date' id='starttimepicker'>
                                    <input type='text' class="form-control" />
                                    <span class="input-group-addon">
                                        <span class="glyphicon glyphicon-calendar"></span>
                                    </span>
                                </div>
                    </div>
                </div>
                <div class='col-sm-12'>
                    <div class="form-group">
                        <label>Ending
                            <label>
                                <div class='input-group date' id='endtimepicker'>
                                    <input type='text' class="form-control" />
                                    <span class="input-group-addon">
                                        <span class="glyphicon glyphicon-calendar"></span>
                                    </span>
                                </div>
                    </div>
                </div>

            </div>
            <!-- footer -->
            <jsp:include page="/WEB-INF/shared/footer.jsp" />
        </body>

        </html>