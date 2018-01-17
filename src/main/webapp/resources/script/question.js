function loadQuestion(){
    $.ajax({
            type: "GET",
            url: "/quiz",
            success: function (response) {
                var question_data = '';
                    question_data += '<h4>'+'Ques 1: '+ response.question + '</h4>';
                    question_data += '<div class="checkbox">' ;
                    question_data += '<label>' + '<input type="checkbox" name="opt">' + response.options[0] + '</label> <br>';
                    question_data += '<label>' + '<input type="checkbox" name="opt">' + response.options[1] + '</label> <br>';
                    question_data += '<label>' + '<input type="checkbox" name="opt">' + response.options[2] + '</label> <br>';
                    question_data += '<label>' + '<input type="checkbox" name="opt">' + response.options[3] + '</label> <br>';
                                    
                $('#showQuestion').html(question_data);

                $('#roundOneInstruction').hide();
                $('#startRoundOne').hide();
            }
    });

} 