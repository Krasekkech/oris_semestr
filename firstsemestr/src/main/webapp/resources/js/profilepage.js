const addButton = document.querySelector(".btn")
const tableInfo = document.querySelector(".maininfo")
const regInfo = document.querySelector(".reginfo")

addButton.addEventListener("click", infoRedactor)

function infoRedactor(event){
    event.preventDefault();
    console.log("w")
    tableInfo.style.display="none"
    regInfo.style.display="block"
}



function sendResult(){
    let birthdatedata = birthdate.value;
    let agedata = age.value
    let namedata = namee.value
    let iddata = id.value
    const xhr = new XMLHttpRequest();
    xhr.open("post","/firstsemestr_war_exploded/profile",true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    const data = "id=" + iddata + "&name=" + namedata + "&age=" + agedata + "&birthdate=" + birthdatedata
    xhr.send(data);
    localStorage.setItem('проверка',data)
}

window.onunload = async function(){

}