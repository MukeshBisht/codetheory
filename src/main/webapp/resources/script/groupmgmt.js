var log;
$(document).ready(function () {

    $("#quesForm").submit(function(e){
        
        e.preventDefault();
        var url = '/api/challenge/group/mcq/'+ grpid +'/questions/add';
        var id = 0;
        var question = $('#question').val();
        var options = [$('#op1').val(), $('#op2').val(), $('#op3').val(), $('#op4').val()];
        var selected = $('input[name=answer]:checked').val();
        var level = $('#lvl').val();
    
        d = {"id":id,"question":question,"options":options,"selected":selected,"level":level};
        $.ajax({
            type : "POST",
            url : url,          
            dataType: 'json',
            contentType: "application/json",
            data :JSON.stringify(d),
            success : function(data){
                alert("Successfull");
            },
            error : function(data){
                log = data;
            }
        });
    });

    $(function() {
 
        $("#Grid").jsGrid({
             width: "100%",
            filtering: true,
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
                        url : "/api/challenge/group/questions/"+grpid,
                        data :filter,
                        dataType : "JSON"
                    });
                }
            },
     
            fields: [
                { name: "question", type: "text"},
                { name: "options", type: "text", selectedIndex: 0 },
                { type: "control" }
            ]
        });
     
    });
});

function loadQMCQ() {

}

function loadQCode() {

}

function setDefault(id){
    grpid = id;
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