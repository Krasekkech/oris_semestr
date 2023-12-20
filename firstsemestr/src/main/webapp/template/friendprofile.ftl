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
                            <tr><td>Имя</td> <td class="tablename"></td></tr>
                            <tr><td>Возраст</td> <td class="tableage"></td></tr>
                            <tr><td>Дата Рождения</td> <td class="tablebirthdate"></td></tr>
                            <tr class="tr_userinfo"><td>Пожелания</td> <td class="tableuserinfo"></td></tr>
                        </table>
                    </table></td></tr>
            <tr><td>
                    <table>
                        <input type="text" id="clientprofile" name="clientprofile" style="display: none" maxlength="524288" value=${friendprofile!""}>
                        </table>
                </td></tr>
        </table>
    </div>
    <script src="resources/js/friendprofile.js"></script>
</main>
</body>
</html>
