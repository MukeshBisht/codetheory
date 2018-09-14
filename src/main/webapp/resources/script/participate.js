
$(document).ready(function () {
    startCountdown();
    $.ajax ({
        url : '/contest/'+cname+'/isParticipated',
        type : 'GET',
        success : function(response){
           if (response == true){
               $('#participatebtn').hide();
               $('#part').html('You partcipated in ' + cname);
               
           }
        }
    });

    $('#participatebtn').click( function(){
        startCountdown();
        var URL='/contest/'+cname+'/participate';
        $.ajax ({
            url : URL,
            type : 'GET',
            success : function(response){
                
                if (response == true){
                    $('#participatebtn').hide();
                    $('#part').html('You are now part of '+cname);
                }
                else if (response == false){
                    $('#part').html('Please login first');
                }
            }
        });
    });
});

start = new Date (parseInt(start));

function startCountdown () {
    
    var time = countdown(start).toString();
    document.getElementById ('countdown').innerHTML = time;
        
    setTimeout(startCountdown, 1000);
}