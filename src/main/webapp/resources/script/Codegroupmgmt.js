
//var grpid = ${ grpid };
var dat;

function format(d) {
    // `d` is the original data object for the row
    var t = '<table class="table"><thead><tr><th>Input</th><th>Output</th><th>Points</th></tr></thead>';
    d.tests.forEach(test => {
        t += '<tr> <td>' + test.input + '</td> <td>' + test.output + '</td> <td>' + test.points + '</td></tr>';
    });
    t += '</table>';
    return t;
}

$(document).ready(function () {


    var table = $('#grid').DataTable({
    
        ajax : "/code/" + grpid,
        columns : [
            { data: "id", visible: false },
            { data: "question" },
            { data: "details", orderable : false },
            {
                className : 'details',
                orderable : false,
                data : null,
                defaultContent : '<span class="glyphicon glyphicon-fire"></span>'
            },
            {
                data: null,
                orderable: false,
                defaultContent: '<a href="#" class="editor_edit glyphicon glyphicon-pencil"></a> | <a href="#" class="editor_delete glyphicon glyphicon-trash"></a>'
            }
        ]
    });

    // Add event listener for opening and closing details
    // https://datatables.net/examples/api/row_details.html
    $('#grid tbody').on('click', 'td.details', function () {
        var tr = $(this).closest('tr');
        var row = table.row(tr);

        if (row.child.isShown()) {
            // This row is already open - close it
            row.child.hide();
            tr.removeClass('shown');
        }
        else {
            // Open this row
            row.child(format(row.data())).show();
            tr.addClass('shown');
        }
    });

    
    $('#grid').on('click', 'a.editor_edit', function (e) {
        e.preventDefault();
        $(".panel-collapse").collapse("show");
        $("html, body").animate({ scrollTop: 0}, 500);
        log = table.row( $(this).parents('tr') ).data();

        resetForm();
        
        $('#qid').val(log.id);
        $('#question').val(log.question);
        $('#description').val(log.details);
        $('#lvl').val(log.level);
        
        // test case
        
        for (i=1; i<log.tests.length; i++)
            addMoreTest();

        for (i=1; i<=counter; i++){
            $('#t'+i).find('#input').val(log.tests[i-1].input);
            $('#t'+i).find('#output').val(log.tests[i-1].output);
            $('#t'+i).find('#points').val(log.tests[i-1].points);
        }
        
        $('#btnsubmit').html('Update');

    } );
    
    
    $('#grid').on('click', 'a.editor_delete', function (e) {
        e.preventDefault();
        log = table.row( $(this).parents('tr') ).data();
        if(confirm("Delete ?")){
            $.ajax({
                type : "POST",
                url : "/api/challenge/group/code/question/delete",          
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
});

function resetForm() {
    $('#question').val("");
    $('#description').val("");
    $('#lvl').val("");
    $('#qid').val("-1");

    //test case
    var c = counter;
    for (i=1; i<=c; i++){
        removeTest();
    }
    
    $('#t1').find('#input').val("");
    $('#t1').find('#output').val("");
    $('#t1').find('#points').val("");

    $('#btnsubmit').html('Add');
}

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

function addCodeQuestion (){

        var id = $('#qid').val();
        var question = $('#question').val();
        var description = $('#description').val();
        var level = $('#lvl').val();
        
        // test cases

        var test = [];

        for (i=1; i<=counter; i++){
            test.push({
                id : i,
                input : $('#t'+i).find('#input').val(),
                output : $('#t'+i).find('#output').val(),
                points : $('#t'+i).find('#points').val()
            });
        }

        var data = {"id":id ,"level":level, "question":question,"details":description, tests : test};

    $.ajax({
        url: '/api/challenge/group/code/' + grpid + '/question/add',
        type: 'POST',
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function () {
            alert('successful');
            resetForm();
            $("#grid").DataTable().ajax.reload();
        }
    });
}

var counter = 1;

function addMoreTest(){
    counter++;
    $('#removeTest').show();

    var div = '<div id=t'+counter+'>';
    div += $('#t1').html();    
    div += '</div>'
    
    $('#testcase').append(div);
}

function removeTest (){
    if (counter == 1)
        return;
    if (counter == 2)
       $('#removeTest').hide();
    
    $('#t'+counter).remove();
    counter--;
}
