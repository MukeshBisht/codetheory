function loadQuestion(){
    $.ajax({
            type: "GET",
            url: "/quiz",
            success: function (response) {
                var question_data = '';
                for ( i=0;i<response.length;i++){
                    question_data += '<h4>'+'Ques '+(i+1)+': '+ response[i].question + '</h4>';
                    question_data += '<div class="radio">' ;
                    question_data += '<label>' + '<input type="radio" name="opt'+i+'">' + response[i].options[0] + '</label> <br>';
                    question_data += '<label>' + '<input type="radio" name="opt'+i+'">' + response[i].options[1] + '</label> <br>';
                    question_data += '<label>' + '<input type="radio" name="opt'+i+'">' + response[i].options[2] + '</label> <br>';
                    question_data += '<label>' + '<input type="radio" name="opt'+i+'">' + response[i].options[3] + '</label> <br>';
             
               }question_data += '<input class="btn btn-success" type="submit">';
                
               $('#showQuestion').html(question_data);
                $('#roundOneInstruction').hide();
                $('#startRoundOne').hide();
                $('#durationSelect').hide();
                document.getElementById('timer').style.display='block';
                document.getElementById('questionOptions').style.display='block';
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
    document.getElementById('starttimer').innerHTML = t + ":" + 00;
    startTimer();

} 