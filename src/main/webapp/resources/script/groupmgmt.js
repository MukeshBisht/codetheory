var log;
$(document).ready(function () {

    $('#grid').on('click', 'a.editor_edit', function (e) {
        e.preventDefault();
        $(".panel-collapse").collapse("show");
        $("html, body").animate({ scrollTop: 0}, 500);
        log = table.row( $(this).parents('tr') ).data();
        $('#qid').val(log.id);
        $('#question').val(log.question);
        $('#op1').val(log.options[0]);
        $('#op2').val(log.options[1]);
        $('#op3').val(log.options[2]);
        $('#op4').val(log.options[3]);
        $('#lvl').val(log.level);
        $('#btnsubmit').html('Update');
        document.qForm.answer[log.selected].checked=true;
    } );

    $('#grid').on('click', 'a.editor_delete', function (e) {
        e.preventDefault();
        log = table.row( $(this).parents('tr') ).data();
        if(confirm("Delete ?")){
        $.ajax({
            type : "POST",
            url : "/api/challenge/group/mcq/questions/delete",          
            dataType: 'json',
            contentType: "application/json",
            data :JSON.stringify(log),
            success : function(data){
                $("#grid").DataTable().ajax.reload();
                alert("Successfull");
            },
            error : function(data){
                log = data;
            }
        });
    }
    } );

    var table = $('#grid').DataTable({
        ajax: "/api/challenge/group/questions/" + grpid,
        columns: [
            { data: "id", visible : false},
            { data: "question" },
            { data: "options.0", orderable : false },
            { data: "options.1", orderable : false },
            { data: "options.2", orderable : false },
            { data: "options.3", orderable : false },
            { data: "level", render: getlvl },
            {
                data: null,
                orderable : false,
                defaultContent: '<a href="#" class="editor_edit glyphicon glyphicon-pencil"></a> | <a href="#" class="editor_delete glyphicon glyphicon-trash"></a>'
            }
        ]
    } );

    $("#quesForm").submit(function(e){
        
        e.preventDefault();
        var url = '/api/challenge/group/mcq/'+ grpid +'/questions/add';
        var id = $('#qid').val();
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
                $("#grid").DataTable().ajax.reload();
                resetForm();
            },
            error : function(data){
                log = data;
            }
        });
    });
});

function getlvl(val, type, row){
    switch(val){
        case 1:
            return "Easy";
        case 2:
            return "Medium";
        case 3:
            return "Hard";
        default:
            return "Undefined";
    }
}

function resetForm(){
    $('#question').val("");
        $('#op1').val("");
        $('#op2').val("");
        $('#op3').val("");
        $('#op4').val("");
        $('#lvl').val("");
        $('#qid').val("-1");       
        $('#btnsubmit').html('Add');
}
