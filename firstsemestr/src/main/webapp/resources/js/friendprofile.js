window.addEventListener('DOMContentLoaded', pageLoad)

const nameInfo = document.querySelector(".tablename")
const ageInfo = document.querySelector(".tableage")
const birthInfo = document.querySelector(".tablebirthdate")
const usrInfo = document.querySelector(".tableuserinfo")



function pageLoad(event){
    event.preventDefault()
    let a = clientprofile.value.replace("_", " ")
    let pageData = JSON.parse(a)
    const newNameDiv = document.createElement('div');
    newNameDiv.innerText = pageData.name
    nameInfo.appendChild(newNameDiv)
    const newAgeDiv = document.createElement('div');
    newAgeDiv.innerText = pageData.age
    ageInfo.appendChild(newAgeDiv)
    const newBirthDateDiv = document.createElement('div');
    newBirthDateDiv.innerText = pageData.birthdate
    birthInfo.appendChild(newBirthDateDiv)
    const newUserInfoDiv = document.createElement('div')
    newUserInfoDiv.innerText = pageData.userinfo
    usrInfo.appendChild(newUserInfoDiv)
}