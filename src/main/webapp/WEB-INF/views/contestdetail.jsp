<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored = "false" %>


<script src="<c:url value=" /resources/script/moment.js " />"></script>
<script src="<c:url value=" /resources/script/bootstrap-datetimepicker.js " />"></script>
<link rel='stylesheet' href="<c:url value=" /resources/css/bootstrap-datetimepicker.css "/>" type='text/css' media='screen'/>

<script type="text/javascript">
    var validcontest = false;
    $(function () {
        $('#starttimepicker').datetimepicker({
            //format : "YYYY-MM-DD HH:mm:ss"
            minDate:new Date()
        });
        $('#endtimepicker').datetimepicker({
            //format : "YYYY-MM-DD HH:mm:ss"
        });
        $("#starttimepicker").on("dp.change", function (e) {
            $('#endtimepicker').data("DateTimePicker").minDate(e.date);
        });

        $(".clickable-row").click(function(){
            window.location = $(this).data("href");
        });
        
        $("#contestname").keyup(function () {
            var cname = $("#contestname").val().trim();
            if (cname != '') {
                $("#cname_response").show();
                $.ajax({
                    url: '/api/contest/available/' + cname,
                    type: 'GET',
                    success: function (response) {
                        if (response > 0) {
                            $("#cname_response").html("<span class='text-danger'>* Contest name Already in use</span>");
                        } else {
                            $("#cname_response").html("<span class='text-success'>Available</span>");
                            validcontest = true;
                        }
                    }
                });
            } else {
                $("#uname_response").hide();
            }
        });

    });
</script>

<form:form method="POST" action="${action}" modelAttribute="contest">
<c:if test="${not update}">
    <div class="form-group col-lg-12">
        <form:label path="contestname">Contest Name</form:label>
        <form:input path="contestname" name="contestname" id="contestname" placeholder="Contest Name" class="form-control" required="true"/>
        <div id="cname_response" class="response"></div>
    </div>
</div>
</c:if>
<c:if test="${update}">
        <form:input type="hidden" path="contestname" name="contestname" id="contestname" placeholder="Contest Name" class="form-control" required="true"/>
</c:if>

    <div class="form-group col-lg-12">
        <label class="checkbox-inline">
            <form:checkbox path="isOpen" id="isopen" class="checkbox"/><strong>Contest is open for practice</strong>
        </label>

        <label class="checkbox-inline">
            <form:checkbox path="hasTimeLimit" id="hastimetimit" class="checkbox"/><strong> Rounds in this contest has time limits</strong>
        </label>
    </div>

    <div class='col-sm-12'>
        <div class="form-group">
                <form:label path="startDate">Starting</form:label>
                    <div class='input-group date'>
                        <form:input type='text' id='starttimepicker' path="startDate" class="form-control" required="true"/>
                        <span class="input-group-addon">
                            <span class="glyphicon glyphicon-calendar"></span>
                        </span>
                    </div>
        </div>
    </div>
    <div class='col-sm-12'>
        <div class="form-group">
                <form:label path="endDate">Ending</form:label>
                    <div class='input-group date'>
                        <form:input path="endDate" id='endtimepicker' type='text' class="form-control" required="true"/>
                        <span class="input-group-addon">
                            <span class="glyphicon glyphicon-calendar"></span>
                        </span>
                    </div>
        </div>
    </div>

    <div class='col-sm-12'>
        <div class="form-group">
            <form:label path="orgName">Orgranization Name</form:label>
            <form:input path="orgName" type='text' placeholder="Orgranization Name" class="form-control" required="true"/>
        </div>
    </div>

    
    <div class='col-sm-12'>
        <div class="form-group">
            <form:label path="info">Short Description</form:label>
            <form:input path="info" type='text' placeholder="describe your contest" class="form-control" required="true"/>
        </div>
    </div>


    <div class='col-sm-12 form-group'>
        <form:label path="orgType" required="true">Orgranization Type</form:label>
        <!-- <br> -->
        <form:select path="orgType" class="form-control">
            <option disabled selected value> -- select an option -- </option>
            <form:options items="${orgs}" itemLabel="name"/>
        </form:select>
    </div>
       
    <button type="submit" class="btn btn-success pull-right">
    <c:if test="${not update}">
       Create
    </c:if>
    <c:if test="${update}">
        Update 
    </c:if>
</button>
</form:form>