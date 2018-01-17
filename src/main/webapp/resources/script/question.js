
$.ajax({
        type: "GET",
        url: "/quiz",
        success: function (response) {
            var question = response;
            var question_data = '';
            question_data  += '<p> Question 1: ' + response[0] + '<p>';
            $("#question").before(question_data);
            
        }
});

