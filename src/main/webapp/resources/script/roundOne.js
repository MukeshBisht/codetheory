var num = 0;
function loadQuestion(){
    $.ajax({
            type: "GET",
            url: "/quiz",
            success: function (response) {

                var question_data = '';
                num = response.length;
                for ( i=0;i<response.length;i++){
                    question_data += '<div class="container-fluid">';
                    question_data += '<button data-target="#question'+(i+1)+'"' ;
                    question_data += 'class="btn btn-default questionButton" data-toggle="collapse">Question '+(i+1)+'</button>';
                    question_data += '<div class="collapse" style="background:lightgrey;" id="question'+(i+1)+'">';
                    question_data += '<h4>'+ response[i].question + '</h4>';
                    question_data += '<div class="radio">' ;
                    
                    for (j=0; j<4; j++){
                        question_data += '<label>' + '<input type="radio" name="opt'+j+'">' + response[i].options[j] + '</label> <br>';
                    }
                    question_data += '</div></div><br>';
               }
                question_data += '<input class="btn btn-success" type="submit">';
                
                $('#showQuestion').html(question_data);
                $('#roundOneInstruction').hide();
                $('#startRoundOne').hide();
                $('#durationSelect').hide();
                document.getElementById('sideSection').style.display='block';
                buildOptionSideBar(num);          // defination of this function is given below
            }
            
    });

    
    var time = $('.durationSelect option:selected').val();
    var t;
    if (time == "10 minutes")
        t = 10;
    else if (time == "20 minutes") {
        t = 20; 
    } else {
        t=30;
    }
    document.getElementById('starttimer').innerHTML = +t + ":" + 00;
    startTimer();                               // defination of this function is present in the file, timer.js
    
}

/**
    This Method will Build the Sidebar (table) which contain serial number of the question 
    with four options. 
    It takes 1 parameter which is the NUMBER OF QUESTIONS we get as the JSON response
**/

function buildOptionSideBar(num){
    var table = '';
    table += '<table class="table">';
    table += '<th> s.no. </th> <th> A </th> <th> B </th> <th> C </th> <th> D </th>';
    for (i=1; i<=num; i++){
        table += '<tr>';
        table += '<td>'+ i + '</td>';
        for (j=1; j<=4; j++)
            table += '<td> <input type="radio" name="ques'+i+'"></td>';
    }
    document.getElementById('optionSidebar').innerHTML = table;
   
}