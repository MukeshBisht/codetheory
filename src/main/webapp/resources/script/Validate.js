//login validation 
function validate(){

    if(document.f.username.value == "" && document.f.password.value == ""){
        document.f.username.focus();
        return false;
    }
    if(document.f.username.value == ""){
        document.f.username.focus();
        return false;
    }
    if(document.f.password.value == ""){
        document.f.password.focus();
        return false;
    }
}