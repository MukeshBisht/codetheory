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
                    data[i].selected = -1;           
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
    document.getElementById('starttimer').innerHTML = t + ":" + 00;
    startTimer();
}

function buildOptionSideBar(index) {
    if(index < 0) return;
    var option = '';
    option += '<div class="">';
    option += '<h3>' + data[index].question + '</h3>';
    // <!--Radio group-->
    
    for (j = 0; j < 4; j++) {
        option += '<div class=" form-group cardView">';
        if (data[index].selected == j)
            option += '<input name="op" type="radio" class="with-gap" onclick="changeColor('+(index+1)+','+j+')" checked>';
        else
            option += '<input name="op" type="radio" class="with-gap" onclick="changeColor('+(index+1)+','+j+')">';
        option += '<label for="' + j + '">' + data[index].options[j] + '</label>';
        option += '</div>';
    }
    option += '</div>';
    option +='<nav><ul class="pager">';

    var p = index;
    if(index==0)
        p = -2;
    option += '<li class="previous"  onclick="buildOptionSideBar('+ (p-1) +')" id="prev"><a href="#">Previous</a></li>';
    p = index;
    if(index == data.length - 1)
        p = -2;
    option += '<li class="next" onclick="buildOptionSideBar('+ (p+1) +')" id="prev"><a href="#" >Next</a></li>';
    option += '</ul></nav>';

    document.getElementById('sideSection').innerHTML = option;
}

function getQuestion(quesId) {
    var index = quesId-1;
    buildOptionSideBar(index);
 }

 
function showPreview() {  
    var modal = '';
    var count=0;
    for (i = 0; i < data.length; i++) {
        var j = i+1;
        count++;
        if(count==11){
            count = 0;
            modal += '<br/><br/>';
        }
        modal += '<span class="label lb-lg ';
        if(data[i].selected > 0){
          modal += 'label-success" ';
        }
        else {
            modal += 'label-default" ';
        }
        modal += 'onclick="getQuestion('+j+')">';
        modal += j +'</span>';
        document.getElementById('previewbody').innerHTML = modal;
    }
    $("#previewModal").modal("toggle");
}

function changeColor (i , j){
    var change = document.getElementById (i);
    change.style.color = "green";
    data[i-1].selected = j;
}

/*
    submitQuestion 
 */


function submitQuestion(){
    
    showDialog();

    $.ajax({
            type: "POST",
            url: "/RoundOne/submit",
            data: JSON.stringify(data),
            contentType: "application/json",
            success: function(response){
                $('#roundone').hide();
                $('#resultArea').html(response);
            }
    });
}