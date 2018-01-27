$("#confirm_password").keyup(function () {
        var pass = $("#password").val().trim();
        var cpass = $("#confirm_password").val().trim();
        if(cpass != ''){
            $("#cpassword_chk").show();
        if (pass != cpass) {
            $("#cpassword_chk").html("<span class='text-danger'>Password didn't matched</span>");
        } else {
            $("#cpassword_chk").html("<span class='text-success'>Password matched</span>");
            validusername = true;
        }
    }else{
        $("#cpassword_chk").hide();
    }
    console.log ("asdfghjk");
});