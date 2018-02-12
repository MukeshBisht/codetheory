<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored = "false" %>

<body> 
    <script type="text/javascript">
        var chlng="${cname}";    
    </script>
    <div class="container">
        <h2>Rounds &nbsp;&nbsp;
            <a href="#" id="addRound" class="glyphicon glyphicon-plus-sign"></a>
        </h2>
        <br/>

        <c:forEach items="${rounds}" var="round">
        <div class="col-md-3">
            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon">
                        ${round.name}
                    </span>
                    <input id="op4" type="text" placeholder="" class="form-control" required/>
                </div>
            </div>
        </div>
        </c:forEach>


        <div class="col-md-9">
            <div class="table-responsive">
                <table id="grid" class="table table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Question</th>
                            <th>Level</th>
                            <th>
                                <span class="glyphicon glyphicon-cog"></span>
                            </th>
                        </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</body>


<!-- Add Round Dialog -->
<form id="addRoundDialog" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">Add Round</h4>
            </div>
            <input type="hidden" id="roundId"/>
            <div class="input-group">
                <span class="input-group-addon">Name</span>
                <input id="roundName" type="text" placeholder="Round Name" class="form-control" required/>
            </div>
            <div class="input-group">
                <span class="input-group-addon">Type</span>
                <select id="roundType" class="form-control" required>
                    <option value="0">MCQ</option>
                    <option value="1">Code</option>
                </select>
            </div>
            <div class="input-group">
                <span class="input-group-addon">
                    Length
                </span>
                <input id="roundLen" type="number" placeholder="Round Time" class="form-control" required/>
                <span class="input-group-addon">Min</span>
            </div>
            <button id="addRoundBtn" type="submit" class="btn btn-block btn-success">Add</button>
        </div>
    </div>
</form>
<!-- end Add Round Dialog -->