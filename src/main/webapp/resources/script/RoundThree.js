
$(document).ready(function(){
    $.ajax({
        type : "GET",
        url : "/code",
        dataType : "json",
        contentType: "application/json",
        success : function (response){

            $("#problemStatement").html (response[0].question);
            $("#details").html(response[0].details);
            var str = '<thead><th>s.no</th> <th>input</th> <th>output</th></thead>';
            str += '<tbody>'
            var sno = 0;
            response[0].tests.forEach(element => {
                str += '<tr><td> #'+ (++sno) +'</td>';
                str += '<td>' + element.input + '</td>';
                str += '<td>' + element.output + '</td></tr>';
            });
            str += '</tbody>'
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
         //   console.log(response);
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