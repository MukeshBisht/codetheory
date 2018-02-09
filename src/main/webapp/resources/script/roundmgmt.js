$(function () {
    $("#addRound").on("click", function () {
        $("#addRoundDialog").modal("toggle");
    });

    $("#addRoundBtn").submit(function(e){
        debugger;
        e.preventDefault();
        var url = '/api/contest/round';
        var id = $('#roundId').val();
        var roundName = $('#roundName').val();
        var type = $('#roundType').val();
        var len = $('#roundLen').val();
    
        d = {"contest":chlng, "roundId":id,"name":roundName,"length":len,"type":type};
        $.ajax({
            type : "POST",
            url : url,          
            dataType: 'json',
            contentType: "application/json",
            data :JSON.stringify(d),
            success : function(data){
                alert("Successfull");
                resetAddRound();
            },
            error : function(data){
                log = data;
            }
        });
    });
});


function resetAddRound(){

}