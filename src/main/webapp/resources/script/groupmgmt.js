var log;
$(document).ready(function () {

    $('#grid').on('click', 'a.editor_edit', function (e) {
        e.preventDefault();
        $(".panel-collapse").collapse("show");
        $("html, body").animate({ scrollTop: 0}, 500);
        log = table.row( $(this).parents('tr') ).data();
        $('#question').val(log.question);
        $('#op1').val(log.options[0]);
        $('#op2').val(log.options[1]);
        $('#op3').val(log.options[2]);
        $('#op4').val(log.options[3]);
        $('#lvl').val(log.level);
        document.qForm.answer[log.selected].checked=true;
    } );

    $('#grid').on('click', 'a.editor_delete', function (e) {
        e.preventDefault();
        log = table.row( $(this).parents('tr') ).data();
    } );

    var table = $('#grid').DataTable({
        "ajax": "/api/challenge/group/questions/" + grpid,
        "columns": [
            { data: "question" },
            { data: "options.0", orderable : false },
            { data: "options.1", orderable : false },
            { data: "options.2", orderable : false },
            { data: "options.3", orderable : false },
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

});


function resetForm(){
    $('#question').val("");
        $('#op1').val("");
        $('#op2').val("");
        $('#op3').val("");
        $('#op4').val("");
        $('#lvl').val("");
}
