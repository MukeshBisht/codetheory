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

function nameValidator (name) {
    re = '';
    return re.test (name);
}

function usernameValidator (username){
    re = '';
    return re.test (username);
}

function contestNameValidator (cname){
    re = '';
    return re.test (cname);
}
