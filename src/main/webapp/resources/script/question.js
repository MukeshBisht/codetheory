function loadQuestion(){
    $.ajax({
            type: "GET",
            url: "/quiz",
            success: function (response) {
                var question_data = '';
                for ( i=0;i<response.length;i++){
                    question_data += '<h4>'+'Ques '+(i+1)+': '+ response[i].question + '</h4>';
                    question_data += '<div class="radio">' ;
                    question_data += '<label>' + '<input type="radio" name="opt">' + response[i].options[0] + '</label> <br>';
                    question_data += '<label>' + '<input type="radio" name="opt">' + response[i].options[1] + '</label> <br>';
                    question_data += '<label>' + '<input type="radio" name="opt">' + response[i].options[2] + '</label> <br>';
                    question_data += '<label>' + '<input type="radio" name="opt">' + response[i].options[3] + '</label> <br>';
                }
                $('#showQuestion').html(question_data);
                $('#roundOneInstruction').hide();
                $('#startRoundOne').hide();
            }
    });

} 