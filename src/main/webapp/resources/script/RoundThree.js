
$(document).ready(function(){
    $.ajax({
        type : "GET",
        url : "/roundThree/code/question",
        dataType : "json",
        contentType: "application/json",
        success : function (response){

            $("#problemStatement").html (response.question);
            $("#details").html(response.details);
            $("#testcase").html (str);
        }
    });  
});


function runCode() {
    $("#output").html('<i class="fa fa-cog fa-spin fa-3x fa-fw" id="outloading"></i>');
    $('[href="#menu1"]').tab('show');
    var Code = {
        languageid: $('#langid').val(),
        code: editor.getValue()
    }

    $.ajax({
        type: "POST",
        dataType: 'json',
        contentType: "application/json",
        crossDomain: true,
        url: "/api/execode",
        data: JSON.stringify(Code),
        success: function (response) {
            var op = '<p><b>Output</b>    : '+ response.stdout +'</p>';
               op += '<p class="text-danger"><b>Error</b>     : '+ response.stderr +'</p>';
               op += '<p><b>Test</b>      : '+ response.status.description +'</p>';
               op += '<p><b>Compiler</b> : '+ response.compile_output +'</p>';
            
            $("#output").html(op);
        },
        error: function () {
            var op = '<p>Error</p>';
            $("#output").html(op);
        }
    });
}