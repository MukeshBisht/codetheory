s=60;
$(document).ready(function () {
    s=s-1;
    startTimer('05:12:'+s);
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

        var URL='/contest/'+cname+'/participate';
        $.ajax ({
            url : URL,
            type : 'GET',
            success : function(response){
                
                if (response == true){
                    $('#participatebtn').hide();
                    $('#part').html('You are now part of abcd');
                }
                else if (response == false){
                    $('#part').html('Please login first');
                }
            }
        });
    });
});