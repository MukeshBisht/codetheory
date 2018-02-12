$(document).ready(function () {
    $("#addRoundBtn").on("click", function(e){
        e.preventDefault();
        addRound();
    });

    $("#addRound").on("click", function () {
        $("#addRoundDialog").modal("toggle");
    });

    $("#addChlngBtn").on("click", function () {
        $("#addChlngDialog").modal("toggle");
    });

    var grid = $('#grid').DataTable({
        
    });
    var Qgrid = $('#Qgrid').DataTable({
        columns: [
            { data: "id", visible : false},
            { data: "question" },
            { data: "level", render: getlvl }
        ],
        lengthMenu: [[5, 10, 15], [5, 10, 15]],
        autoWidth: false
    });
    $('#Qgrid tbody').on('click', 'tr', function(){
        $(this).toggleClass('selected');
    });

});

function loadGrpQuestions(select){
    $.ajax({
        type : "GET",
        url : "/api/challenge/group/questions/" + select.value,
        success : function(dat){
            log = dat.data;
            $("#Qgrid").DataTable().clear().draw();
            $("#Qgrid").DataTable().rows.add(dat.data).draw();
        },
        error : function(dat){
            log = dat;
        }
    });
}

function getlvl(val, type, row){
    switch(val){
        case 1:
            return "Easy";
        case 2:
            return "Medium";
        case 3:
            return "Hard";
        default:
            return "Undefined";
    }
}

var round;
function changeRound(e){
    $(".list-group .list-group-item").removeClass("active");
    e.classList.add("active");
    log = e;
    round = { roundId : e.id, contest : contest, name:e.text, type : log.attributes['data-type'].value };
}

function deleteRound(){
    if(round == null){
        alert("Select a Round");
        return;
    }
    if(confirm("Delete Round?")){
        $.ajax({
            url: '/api/contest/round',
            contentType: "application/json",
            crossDomain: true,
            type: 'DELETE',
            data: JSON.stringify(round),
            success: function (response) {        
                round = null;       
                loadRounds();
            }
        });
    }
}

function addRound(){   
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
            $("#addRoundDialog").modal("toggle");
            resetAddRound();
            loadRounds();
        },
        error : function(data){
            log = data;
            alert("eror");
        }
    });
}

function resetAddRound(){

}