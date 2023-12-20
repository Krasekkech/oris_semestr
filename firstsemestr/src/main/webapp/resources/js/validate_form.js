function validate() {
    let password = pwd.value;
    let password1 = pwd1.value;

    if (password !== password1) {
        //alert('Пароли не совпадают!');
        let d = document.getElementById('error');
        d.innerHTML = '<span style="color:red">Пароли не совпадают!</span>';
        return false;
    }
    return true;
}
function validatePassword(input) {
    if (input.value.length < 8) {
        input.setCustomValidity("Слишком короткий пароль, маловато будет");
    }
    else {
        input.setCustomValidity("");
    }
}


