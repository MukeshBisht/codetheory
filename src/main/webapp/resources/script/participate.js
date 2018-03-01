s=60;
$(document).ready(function () {
    s=s-1;
    
    document.getElementById('day').innerHTML = 10;
    document.getElementById('hour').innerHTML = 23;
    document.getElementById('minute').innerHTML = 55;
    document.getElementById('second').innerHTML = 38;

    contestTimer();
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

function contestTimer() {
    var presentTime = document.getElementById('hour').innerHTML;
    presentTime += ':' + document.getElementById('minute').innerHTML;
    presentTime += ':' + document.getElementById('second').innerHTML;console.log (presentTime);
    var timeArray = presentTime.split(/[:]+/);
    var h = timeArray[0];
    var m = timeArray[1];
    var s = checkSecond((timeArray[1] - 1));
    
    if(s==59)
      m=m-1;
    if (m == 0 && s == 1){
      if (h !=0)
        h -= 1;
      /* some goes code here.... */
    }
    
    document.getElementById('day').innerHTML = '10';
    document.getElementById('hour').innerHTML = h;
    document.getElementById('minute').innerHTML = m;
    document.getElementById('second').innerHTML = s;
    setTimeout(startTimer, 1000);
  }
  
  function checkSecond(sec) {
    if (sec < 10 && sec >= 0) {sec = "0" + sec}; // add zero in front of numbers < 10
    if (sec < 0) {sec = "59"};
    return sec;
  }
  