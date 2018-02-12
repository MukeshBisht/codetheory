
//var grpid = ${ grpid };
/*var dat = [
    {
        id: 1,
        level:2,
        question: "program to rewrite the input string with 'hello, ' prefix",
        details: "Write a simple program to rewrite the input string with 'hello, ' prefix added in output \neg. \ninput : world \noutput : hello, world",
        tests: [{
            id: 1,
            input: "world",
            output: "hello world",
            points:10
        },
        {
            id: 2,
            input: "sam",
            output: "hello sam",
            points:20
        }
        ]
    },
    {
        id: 15,
        level:1,
        question: "program to rewrite the input string with 'hello, ' prefix",
        details: "Write a simple program to rewrite the input string with 'hello, ' prefix added in output \neg. \ninput : world \noutput : hello, world",
        tests: [{
            id: 3,
            input: "world",
            output: "hello world",
            points:10
        },
        {
            id: 4,
            input: "sam",
            output: "hello sam",
            points:20
        }
        ]
    }];
*/
var dat;

function format(d) {
    // `d` is the original data object for the row
    var t = '<table class="table"><thead><tr><th>Input</th><th>Output</th><th>Points</th><th><button class="btn btn-success">Add</button></th></tr></thead>';
    d.tests.forEach(test => {
        t += '<tr> <td>' + test.input + '</td> <td>' + test.output + '</td> <td>' + test.points + '</td>';
        t += '<td><a href="#" class="editor_edit glyphicon glyphicon-pencil"></a> | <a href="#" class="editor_delete glyphicon glyphicon-trash"></a></td>';
        t += '</tr>';
    });
    t += '</table>';
    return t;
}

$(document).ready(function () {


    var table = $('#grid').DataTable({
    
        ajax : "/code",
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
        $('#qid').val(log.id);
        $('#question').val(log.question);
        $('#description').val(log.details);
        $('#lvl').val(log.level);
        $('#input').val(log.tests[0].input);
        $('#output').val(log.tests[0].output);
        $('#btnsubmit').html('Update');
    } );
});

function resetForm() {
    $('#question').val("");
    $('#description').val("");
    $('#lvl').val("");
    $('#qid').val("-1");
    $('#input').val("");
    $('#output').val("");
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

        var id = 123;//$('#qid').val();
        var question = $('#codequestion').val();
        var description = $('#description').val();
        var level = $('#codelvl').val();
        var input = $('#testinput').val();
        var output = $('#testoutput').val();

        var test = [{"id": 1, "input":input, "output":output, "points":10}];
        var data = {"id":id ,"level":level, "question":question,"details":description, tests : test};

    $.ajax({
        url: '/api/challenge/group/code/question/add',
        type: 'POST',
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function () {
            console.log("done");
        }
    });
}