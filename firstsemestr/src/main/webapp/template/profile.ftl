<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/html">
<head>
    <link rel="stylesheet" href="resources/css/profile.css">
    <title>firstsemestr profile</title>
    <meta charset="utf-8"/>
</head>
<body>
<header>
    <div class="header__content">
        <nav class="header__navigationbar">
            <ul class="header__logo">
                <li class="header__list-logo">Bf</li>
            </ul>
        </nav>
    </div>
</header>
<main>
    <div class="main__content">
        <table width="100%" class="main__table-content">
            <tr><td class="main__avatar-td-table" rowspan="2" width="100"><img src="resources/images/no-avatar.png" alt="аватарка"></td>
                <td class="main__info-td-table"> <table width="100%" class="main__container-info-td-table">
                        <table class="maininfo">
                        <tr><td>Имя</td> <td>${clientname!""}</td></tr>
                            <tr><td>Возраст</td> <td></td></tr>
                        <tr><td>Дата рождения</td> <td></td></tr>
                            <tr><td><button class="btn">+</button></td></tr>
                            </table>
                        <table class="reginfo" style="display: none">
                        <form >
<#--                            method="post" action="/firstsemestr_war_exploded/profile"-->
                            <tr><td>Имя</td> <td><input type="text" id="namee" name="namee" value="${clientname!""}"></td></tr>
                            <tr><td>id</td> <td><input type="text" id="id" name="id" value="${clientid!""}"></td></tr>
                            <tr><td>Возраст</td> <td><input type="checkbox" id="age1" name="age1" placeholder=""></td></tr>
                            <tr><td>Возраст</td> <td><input type="text" id="age" name="age" placeholder=""></td></tr>
                            <tr><td>Дата Рождения</td> <td><input type="text" id="birthdate" name="birthdate" placeholder="ДД.ММ.ГГГГ" ></td></tr>
                            <tr><td><button onclick="sendResult()">+</button></td></tr>
                        </form></table>
                    </table></td></tr>
            <tr><td>
                    <table>
                        <tr><td>id</td> <td>${clientid!""}</td></tr>
                        <tr><td>Друзбя</td></tr></table>
                </td></tr>
        </table>
    </div>
    <script src="resources/js/profilepage.js"></script>
</main>
</body>
</html>
