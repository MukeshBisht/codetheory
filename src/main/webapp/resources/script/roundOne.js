var data;
function loadQuestion(){
    $.ajax({
            type: "GET",
            url: "/quiz",
            success: function (response) {
                data = response;
                var question_data = '';
                for ( i=0;i<response.length;i++){
                    question_data += '<a hre="#" onclick="getQuestion(id)" id="'+(i+1);
                    question_data += '" id="questionList" style="color:black;text-decoration:none;cursor:pointer"><br>';
                    question_data +=  (i+1)+ ' : '+response[i].question +'';              
               }                            
                $('#showQuestion').html(question_data);
                $('#roundOneInstruction').hide();
                $('#startRoundOne').hide();
                $('#durationSelect').hide();
                $('#submitRoundOne').show();
                $('#showQuestion').show();
                $('#starttimer').show();
                $('#sideSection').show();
                buildOptionSideBar(0);
            }
    });

    
    var time = $('#timeSelect option:selected').val();
    var t;
    if (time == "10 minutes")
        t = 10;
    else if (time == "20 minutes") {
        t = 20; 
    } else {
        t=30;
    }
    document.getElementById('starttimer').innerHTML = +t + ":" + 00;
    startTimer();                
}

function buildOptionSideBar(index) {
    var option = '';
    option += '<div class="">';
    option += '<h3>' + data[index].question + '</h3>';
    // <!--Radio group-->
    for (j = 0; j < 4; j++) {
        option += '<div class=" form-group cardView">';
        option += '<input name="' + index + '" type="radio" class="with-gap " id="' + j + '">';
        option += '<label for="' + j + '">' + data[index].options[j] + '</label>';
        option += '</div>';
    }
    option += '</div>';

    if (index != 0) {
        option += '<button class="btn btn-success sideSectionButton" ';
        option += 'onclick="buildOptionSideBar(' + (index - 1) + ')" id="prev">prev</button>';
    } else {
        option += '<button class="btn btn-success sideSectionButton" disabled>prev</button> ';
    }

    if (index != data.length - 1) {
        option += '<button class="btn btn-success sideSectionButton" ';
        option += 'onclick="buildOptionSideBar(' + (index + 1) + ')"id="next">next</button>';
    } else {
        option += '<button class="btn btn-success sideSectionButton" disabled>next</button> ';
    }

    document.getElementById('sideSection').innerHTML = option;
}

function getQuestion(quesId) {
    var index = quesId-1;
    buildOptionSideBar(index);
 }

 
function showPreview() {  
    var modal = '';
    for (i = 0; i < data.length; i++) {
        var j = i+1;
        modal += '<span class="label lb-lg ';
        //if(data[i] is marked)
        // modal += 'label-success">';
        //else
        modal += 'label-default" onclick="getQuestion('+j+')">';
        modal += j +'</span>';
        document.getElementById('previewbody').innerHTML = modal;
    }
    $("#previewModal").modal("toggle");
}