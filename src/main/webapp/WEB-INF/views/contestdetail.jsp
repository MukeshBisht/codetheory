<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored = "false" %>

<form:form method="POST" >
<div class="form-group col-lg-12">
        <label>Contest Name
            <label>
                <input name="contestname" id="contestname" placeholder="Contest Name" class="form-control" required="true"/>
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

    <div class='col-sm-12'>
        <div class="form-group">
            <label> Orgranization Name </label>
            <input type='text' class="form-control" />
        </div>
    </div>

    <div class='col-sm-12 form-group'>
        <label> Orgranization Type </label>
        <br>
        <select class="form-control">
            <option disabled selected value> -- select an option -- </option>
            <option>School</option>
            <option>Collage</option>
            <option>Individual</option>
            <option>Other</option>
        </select>
    </div>

    <button class="btn btn-success">create contest</button>
</form:form>
    