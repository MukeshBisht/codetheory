
function startTimer() {
  var presentTime = document.getElementById('starttimer').innerHTML;
  var timeArray = presentTime.split(/[:]+/);
  var m = timeArray[0];
  var s = checkSecond((timeArray[1] - 1));
  if(s==59){m=m-1}
  
  if (m == 0 && s == 1){
    document.getElementById ('submitRound').click();
  }
  
  document.getElementById('starttimer').innerHTML = m + ":" + s;
  setTimeout(startTimer, 1000);
}

function startTimer(time) {
  var timeArray = time.split(/[:]+/);
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
