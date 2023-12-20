window.addEventListener('DOMContentLoaded', pageLoad)

const addButton = document.querySelector(".btn")
const tableInfo = document.querySelector(".maininfo")
const regInfo = document.querySelector(".reginfo")
const nameInfo = document.querySelector(".tablename")
const ageInfo = document.querySelector(".tableage")
const birthInfo = document.querySelector(".tablebirthdate")
const usrInfo = document.querySelector(".tableuserinfo")
const friends = document.querySelector(".friends")

addButton.addEventListener("click", infoRedactor)
friends.addEventListener("click", ice)


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
    let userinfodata = userinfo.value
    let usernamedata = clientusername.value
    const data = "username=" + usernamedata + "&name=" + namedata + "&age=" + agedata + "&birthdate=" + birthdatedata + "&userinfo=" + userinfodata
    const xhr = new XMLHttpRequest();
    xhr.open("post","/firstsemestr_war_exploded/profile");
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send(data);
}

function pageLoad(event){
    event.preventDefault()
    let a = clientprofile.value.replace("_", " ")
    let pageData = JSON.parse(a)
    const newNameDiv = document.createElement('div')
    newNameDiv.innerText = pageData.name
    nameInfo.appendChild(newNameDiv)
    const newAgeDiv = document.createElement('div')
    newAgeDiv.innerText = pageData.age
    ageInfo.appendChild(newAgeDiv)
    const newBirthDateDiv = document.createElement('div');
    newBirthDateDiv.innerText = pageData.birthdate
    birthInfo.appendChild(newBirthDateDiv)
    const newUserInfoDiv = document.createElement('div')
    newUserInfoDiv.innerText = pageData.userinfo
    usrInfo.appendChild(newUserInfoDiv)
    let p = clientfriends.value
    let pData = JSON.parse(p)
    let len = pData.length
    for (let i = 0; i < len; i++) {
        const newDiv = document.createElement('div')
        newDiv.classList.add('friend_div')
        friends.appendChild(newDiv)
        const newList = document.createElement('li')
        newList.innerText = pData[i].friendusername
        newDiv.appendChild(newList)
        const newBtn = document.createElement('button')
        newBtn.classList.add("profile_btn")
        newBtn.innerText = 'Выбрать'
        newBtn.setAttribute('value', pData[i].friendusername)
        newBtn.setAttribute('id', 'newbtn')
        newDiv.appendChild(newBtn)

    }

}



function friendsAdd() {
    let friendsearchdata = friendsearch.value
    let usernamedata = clientusername.value
    const x = new XMLHttpRequest();
    x.open("post","/firstsemestr_war_exploded/friendprofile");
    x.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    const data = "username=" + usernamedata + "&friendusername=" + friendsearchdata
    x.send(data);
    const newDiv = document.createElement('div')
    newDiv.classList.add('friend_div')
    friends.appendChild(newDiv)
    const newList = document.createElement('li')
    newList.innerText = friendsearchdata
    newDiv.appendChild(newList)
    const newBtn = document.createElement('button')
    newBtn.classList.add("profile_btn")
    newBtn.innerText = 'Выбрать'
    newBtn.setAttribute('value', friendsearchdata)
    newBtn.setAttribute('id', 'newbtn')
    newDiv.appendChild(newBtn)

}

function ice(event){
    const friendDiv = document.querySelector('.friend_div')
    const newL = document.createElement('a')
    newL.setAttribute('href', '/firstsemestr_war_exploded/friendsprofile' )
    newL.innerText = 'перейти на профиль'
    friendDiv.appendChild(newL)
    let usernamedata = event.target.value
    const x = new XMLHttpRequest();
    x.open("post","/firstsemestr_war_exploded/friendsprofile");
    x.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    const data = "friendusername=" + usernamedata
    x.send(data);
}



