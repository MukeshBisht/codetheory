
start = new Date (parseInt(start));

function startCountdown () {
    
    var time = countdown(start).toString();
    document.getElementById ('countdown').innerHTML = time;
        
    setTimeout(startCountdown, 1000);
}