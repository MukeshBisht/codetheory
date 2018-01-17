$(document).ready(function () {
    $("#uname").change(function () {
        console.log("hit");
        var uname = $("#uname").val().trim();
        if (uname != '') {
            $("#uname_response").show();
            $.ajax({
                url: '/register/available/' + uname,
                type: 'GET',
                success: function (response) {
                    if (response > 0) {
                        $("#uname_response").html("<span class='not-exists'>* Username Already in use.</span>");
                    } else {
                        $("#uname_response").html("<span class='exists'>Available.</span>");
                    }
                }
            });
        } else {
            $("#uname_response").hide();
        }
    });
});