//username check
var validusername = false;
$(function(){
$("#username").keyup(function () {
    var uname = $("#username").val().trim();
    if (uname != '') {
        $("#uname_response").show();
        $.ajax({
            url: 'api/user/available/' + uname,
            type: 'GET',
            success: function (response) {
                if (response > 0) {
                    $("#uname_response").html("<span class='text-danger'>* Username Already in use</span>");
                } else {
                    $("#uname_response").html("<span class='text-success'>Available</span>");
                    validusername = true;
                }
            }
        });
    } else {
        $("#uname_response").hide();
    }
});

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
    });
});
//registration validation
function validate(){
    if(!validusername){
        document.f.username.focus();
        return false;
    }
    if(document.f.username.value == ""){
        document.f.username.focus();
        return false;
    }
    if(document.f.password.value == ""){
        document.f.password.focus();
        return false;
    }
    if(document.f.cpassword.value == ""){
        document.f.cpassword.focus();
        return false;
    }
    if(document.f.name.value == ""){
        document.f.name.focus();
        return false;
    }
    if(document.f.email.value == ""){
        document.f.email.focus();
        return false;
    }
}