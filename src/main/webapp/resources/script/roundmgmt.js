$(document).ready(function () {
    $("#addRoundBtn").on("click", function(e){
        e.preventDefault();
        addRound();
    });

    $("#addRound").on("click", function () {
        $("#addRoundDialog").modal("toggle");
    });

    $("#addChlngBtn").on("click", function () {
        if(round == null){
            alert("Select a Round");
            return;
        }
        $("#addChlngDialog").modal("toggle");
    });

    var grid = $('#grid').DataTable({
        columns: [
            { data: "id", visible : false},
            { data: "question" },
            { data: "level", render: getlvl }
        ],
        lengthMenu: [[5, 10, 15], [5, 10, 15]],
        autoWidth: false
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
    $('#grid tbody').on('click', 'tr', function(){
        $(this).toggleClass('selected');
    });
});

function loadGrpQuestions(select){
    $.ajax({
        type : "GET",
        //url : "/api/challenge/group/questions/" + select.value,
        url : "/api/challenge/group/" + select.value + "/challenges/",
        success : function(dat){
            log = dat.data;
            $("#Qgrid").DataTable().clear().draw();
            $("#Qgrid").DataTable().rows.add(dat.qList).draw();
        },
        error : function(dat){
            log = dat;
        }
    });
}

function removeChallengeFromRound(){
    var questions = [];
    $.each($("#grid").DataTable().rows('.selected').data(), function() {
        questions.push(this['id']);
    });
    if(questions.length < 1){
        alert("Select Challenges to remove");
        return;
    }
    $.ajax({
        //api/contest/round/{roundid}/removeChallenges
        url: '/api/contest/round/'+ round.roundId +'/Challenges',
        contentType: "application/json",
        crossDomain: true,
        type: 'DELETE',
        data: JSON.stringify(questions),
        success: function (response) {      
            round = null;       
            loadRounds();
        }
    });   
}

function AddChallengesToRound(){
    var questions = [];
    $.each($("#Qgrid").DataTable().rows('.selected').data(), function() {
        questions.push(this['id']);
    });
    $.ajax({
        //api/contest/round/{roundid}/addChallenges
        url: '/api/contest/round/'+ round.roundId +'/Challenges',
        contentType: "application/json",
        crossDomain: true,
        type: 'POST',
        data: JSON.stringify(questions),
        success: function (response) {      
            round = null;       
            loadRounds();
        }
    });
}

function loadRoundQuestions(roundID){
    $.ajax({
        type : "GET",
        url : "/api/contest/round/"+ roundID + "/Challenges/",
        success : function(dat){
            log = dat.qList;
            $("#grid").DataTable().clear().draw();
            $("#grid").DataTable().rows.add(dat.qList).draw();
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
    var t = e.attributes['data-type'].value;
    round = { roundId : e.id, contest : contest, name:e.text, type : t };
    loadRoundQuestions(e.id);
    if(t=="Code"){
        $('#codeselect').show();
        $('#mcqselect').hide();
    }
    if(t == "MCQ"){
        $('#mcqselect').show();
        $('#codeselect').hide();
    }
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
        contentType: "application/json",
        data :JSON.stringify(d),
        success : function(data){
            round = null;   
            loadRounds();
        },
        error : function(data){
            log = data;
            alert("eror");
        }
    });
}
