var data;
function loadQuestion(){
    $.ajax({
            type: "GET",
            url: "/quiz",
            success: function (response) {
                data = response;
                var question_data = '';
                for (j=0;j<25;j++)
                for ( i=0;i<response.length;i++){
                    question_data += '<a hre="#" onclick="getQuestion(id)" id="'+(i+1);
                    question_data += '" id="questionList" style="color:black;text-decoration:none;cursor:pointer"><br>';
                    question_data += (i+1)+ ' : '+response[i].question +'</h4>';
                   
               }
                             
                $('#showQuestion').html(question_data);
                $('#roundOneInstruction').hide();
                $('#startRoundOne').hide();
                $('#durationSelect').hide();
                $('#submitRoundOne').show();
                document.getElementById('sideSection').style.display='block';
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

/**
    This Method will Build the Sidebar (table) which contain serial number of the question 
    with four options. 
    It takes 1 parameter which is the NUMBER OF QUESTIONS we get as the JSON response
**/

function buildOptionSideBar(index){
    var option = '';
    option += '<div class="radio">';
    
        option += '<h3>'+ data[index].question +'</h3>';
       
        for (j=0; j<4; j++){  
            option += '<input class="radio" type="radio" name = "question' +(index+1) +'">';      
            option += '<p>'+ data[index].options[j]+'</p>';
        }
    
    option += '</div>';

    if (index  != 0){
        option += '<button class="btn btn-success sideSectionButton" ';
        option += 'onclick="buildOptionSideBar('+(index-1)+')" id="prev">prev</button>';
    } else{
        option += '<button class="btn btn-success sideSectionButton" disabled>prev</button> ';
    }
     
    if (index != data.length-1){
        option += '<button class="btn btn-success sideSectionButton" ';
        option += 'onclick="buildOptionSideBar('+(index+1)+')"id="next">next</button>';
    } else{
        option += '<button class="btn btn-success sideSectionButton" disabled>next</button> ';
    }

    document.getElementById('sideSection').innerHTML = option;
   
}


/*
 *
 * 
 */

 function getQuestion(quesId) {
    var index = quesId-1;
    buildOptionSideBar(index);
 }