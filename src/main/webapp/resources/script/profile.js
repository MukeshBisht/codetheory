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


$(document).ready(function () {

    getContestDetail();

});

        function getContestDetail (){
            
            $.ajax ({
                url : '/contest/participation',
                type : 'GET',
                success: function(response){
                    setContestDetail (response);
                }
            });
        }

function setContestDetail( data ){
    var html = '';
    for (i=0; i<data.length; i++){
        var url = '/contest/' + data[i].contestname;
        var status = getStatus (data[i].status);
        console.log (data[i].status);
        html += '<tr>';
        html += '<td>' + data[i].contestname + '</td>';
        html += '<td>' + data[i].orgName + '</td>';
        html += '<td>' + status + '</td>';
        html += '<td><a href=' + url +' style="text-decoration:none"><i class="fa fa-binoculars"></i> view</a></td>';
        html += '<td> <i class = "fa fa-close" id="'+data[i].contestname+'" onclick="remove(id)" style="color:red"></i></td>'
        html += '</tr>';
    }
    $("#participationData").html(html);
    
        function getStatus (status){
            
            if (status == 'NOTSTARTED')
                return '<span class="label label-active">Not Started</span>';
            else if (status == 'RUNNING')
                return '<span class="label label-primary">Currently Running</span>';
            else 
                return '<span class="label label-success">Finished</span>';
        }
}

var con ;
function removeContest (){
    var contestname = coname;
    var URL = '/contest/'+contestname+'/remove';
    $.ajax({
        url : URL,
        type : 'GET',
        success : function (){
            getContestDetail();
        }
    });
}

function remove (contestname){
    showDialog();
    coname = contestname;
}