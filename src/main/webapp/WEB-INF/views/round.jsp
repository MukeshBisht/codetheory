<script type="text/javascript">  
    $(function () {
        $("#addRound").on("click", function () {
            $("#addRoundDialog").modal("toggle");
        });
    });
</script>

<body>
    <div class="container">
        <h2>Rounds &nbsp;&nbsp;
            <a href="#" id="addRound" class="glyphicon glyphicon-plus-sign"></a>
        </h2>
        <br/>
        <div class="col-md-3">
            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon">
                        Round 1
                    </span>
                    <input id="op4" type="text" placeholder="" class="form-control" required/>
                </div>
            </div>
        </div>
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
<div id="addRoundDialog" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="input-group">
                <span class="input-group-addon">Name</span>
                <input id="op2" type="text" placeholder="Round Name" class="form-control" required/>
            </div>
            <div class="input-group">
                <span class="input-group-addon">Type</span>
                <select class="form-control" required>
                    <option>MCQ</option>
                    <option>Code</option>
                </select>
            </div>
            <div class="input-group">
                <span class="input-group-addon">
                    Length
                </span>
                <input id="op2" type="number" placeholder="Round Time" class="form-control" required/>
                <span class="input-group-addon">Min</span>
            </div>
            <button class="btn btn-block btn-success">Add</button>
        </div>
    </div>
</div>
<!-- end Add Round Dialog -->