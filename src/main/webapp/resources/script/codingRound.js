var question_id = 0;
var current_ques = -1;
var questions = null;

$(document).ready(function(){
    $.ajax({
        type : "GET",
        url : "/codinground/"+roundid+"/question",
        dataType : "json",
        contentType: "application/json",
        success : function (response){
            questions = response;
            nextQuestion();
        }
    });  
});

function nextQuestion(){
    if((questions.length-1)>current_ques){
        current_ques++;
        var ques = questions[current_ques];
        question_id = ques.id;
        $("#problemStatement").html (ques.question);
        $("#details").html(ques.details.replace("\n", '<br />'));
        document.getElementById("qcount").innerText = "["+(current_ques+1)+"/"+questions.length+"]";
        getSavedCode();
    }
}

function prevQuestion(){
    if(current_ques>0){
        current_ques--;
        var ques = questions[current_ques];
        question_id = ques.id;
        $("#problemStatement").html (ques.question);
        $("#details").html(ques.details.replace("\n", '<br />'));
        document.getElementById("qcount").innerText = "["+(current_ques+1)+"/"+questions.length+"]";
        getSavedCode();
    }
}

var test;
function getSavedCode(){
    editor.setValue("Downloading your previous code...");
    $.ajax({
        type : "GET",
        url : "/codinground/"+roundid+"/"+question_id,
        success : function (response){
            editor.setValue(response);
        }
    }); 
    $("#output").html(""); 
}

function runCode() {
    $("#output").html('<i class="fa fa-cog fa-spin fa-3x fa-fw" id="outloading"></i>');
    $('[href="#menu1"]').tab('show');
    var Code = {
        languageid: $('#langid').val(),
        code: editor.getValue(),
        questionid: question_id,
        roundid:roundid
    }

    $.ajax({
        type: "POST",
        dataType: 'json',
        contentType: "application/json",
        crossDomain: true,
        url: "/api/execode",
        data: JSON.stringify(Code),
        success: function (response) {
            var op = '<p class="text-danger"><b>Error</b>     : '+ response.stderr +'</p>';
                op += '<p><b>Compiler</b> : '+ response.compile_output +'</p></br>';
            
            var table = "<table class='table'>";
            var statuses = response.status;
            for (let index = 0; index < statuses.length; index++) {
                table += "<tr><td>Test Case #" + (index+1) + "</td>";
                var color = (statuses[index].id > 3) ? 'red' : 'green';
                table += "<td><font color='"+color+"'>" + statuses[index].description + "</font></td></tr>";
            }
            table += "</table>";
            $("#output").html(op + table);
        },
        error: function () {
            var op = '<p>Error</p>';
            $("#output").html(op);
        }
    });
}

function submitQuestion(){
    
    //showDialog();
    alert(':D');
    // var URL = '/'+contestname+'/'+roundname+'/submit';
    // $.ajax({
    //         type: "POST",
    //         url: URL,
    //         data: JSON.stringify(data),
    //         contentType: "application/json",
    //         success: function(response){
    //                 if (response == '')
    //                     location.reload(true);
    //                 else {
    //                     $('#roundone').hide();
    //                     $('#resultArea').html(response);
    //                 }
    //         }
    // });
}