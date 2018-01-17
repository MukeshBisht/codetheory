$(document).ajaxStart(function(){
    $('#loading').show();
    $('#loadmore').hide();
}).ajaxStop(function(){
    $('#loading').hide();
    $('#loadmore').show();
});

var no = 0

function loadCard() {
    $("html, body").animate({ scrollTop: $(document).height()}, 1000);
    $.ajax({
        type: "GET",
        url: "/home/cards/" + no,
        success: function (response) {
            $("#wallpage").before(response);
            no += 2;
            console.log(no);
        }
    });
}
