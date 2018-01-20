function runCode(){
    $.ajax({
            type: "POST",
            url: "api.hackerrank.com/checker/submission.json",
            data : {
                source : document.getElementById('#source').value(),
                lang : document.getElementById('#langSelect').value(),
                testcases : "1",
                api_key : hackerrank|3066960-2269|fa4ad32c0f9ce7b470f11c1c3fd7cb6dd1ba03ac
            },
            success: function (response) {
            }
    });

}