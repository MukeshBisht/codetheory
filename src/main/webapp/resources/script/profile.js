$(function(){
    $("#cnewpassword").keyup(function () {
        var pass = $("#newpassword").val().trim();
        var cpass = $("#cnewpassword").val().trim();
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


function removeContest (){
    var contestname = coname;
    var URL = '/contest/'+contestname+'/remove';
    $.ajax({
        url : URL,
        type : 'GET',
        success : function (){
            $("#" + contestname).remove();
        }
    });
}

function remove (contestname){
    showDialog();
    coname = contestname;
}