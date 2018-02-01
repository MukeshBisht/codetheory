$(document).ready(function () {
    $(function() {
 
        $("#Grid").jsGrid({
            // height: "50%",
             width: "100%",
     
            filtering: true,
            editing: true,
            sorting: true,
            paging: true,
            autoload: true,
     
            pageSize: 15,
            pageButtonCount: 5,
            deleteConfirm: "Do you really want to delete the client?",
     
            controller: {
                loadData : function(filter){
                    return $.ajax({
                        type: "GET",
                        url : "/api/challenge/group/questions/2",
                        data :filter,
                        dataType : "JSON"
                    });
                }
            },
     
            fields: [
                { name: "question", type: "text"},
                { name: "options", type: "text"},
                { name: "Age", type: "number"},
                { name: "Address", type: "text"},
                { type: "control" }
            ]
        });
     
    });
});

function loadQMCQ() {

}

function loadQCode() {

}


function addQuestion(grpid) {
    var id = 0;
    var question = $('#question').val();
    var options = [$('#op1').val(), $('#op2').val(), $('#op3').val(), $('#op4').val()];
    var selected = $('input[name=answer]:checked').val();
    var level = $('#lvl').val();

    d = {"id":id,"question":question,"options":options,"selected":selected,"level":level};
    $.ajax({
        url: '/api/challenge/group/mcq/'+ grpid +'/questions/add',
        dataType: 'json',
        contentType: "application/json",
        type: 'POST',
        crossDomain: true,
        data: JSON.stringify(d),
        success: function (response) {
        }
    });
}

function editQuestion(e) {

}

function deleteQuestion(e) {
    if (confirm('Are you sure?')) {
        // $.ajax({ url: '/Players/Delete', data: { id: e.data.id }, method: 'POST' })
        //     .done(function () {
        //         grid.reload();
        //     })
        //     .fail(function () {
        //         alert('Failed to delete.');
        //     });
    }
}