//username check
var validusername = false;
$(document).ready(function () {
    $("#username").change(function () {
        console.log("hit");
        var uname = $("#username").val().trim();
        if (uname != '') {
            $("#uname_response").show();
            $.ajax({
                url: 'api/user/available/' + uname,
                type: 'GET',
                success: function (response) {
                    if (response > 0) {
                        $("#uname_response").html("<span class='not-exists'>* Username Already in use.</span>");
                    } else {
                        $("#uname_response").html("<span class='exists'>Available.</span>");
                        validusername = true;
                    }
                }
            });
        } else {
            $("#uname_response").hide();
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