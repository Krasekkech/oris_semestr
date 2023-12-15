<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>firstsemestr login</title>
    <link href="resources/css/login.css" rel="stylesheet">
    <meta charset="utf-8"/>
</head>
<body>
<div class="main__content">
    <h1>Аутентификация</h1>

    <h2 color="red">${message}</h2>

    <form method="post" action="/firstsemestr_war_exploded/usercheck">
        <table>
            <tr>
                <td><label>Логин:</label></td>
                <td><input type="text" name="username" placeholder="введите имя пользователя"></td>
            </tr>
            <tr>
                <td><label>Пароль:</label></td>
                <td><input type="password" name="password"></td>
            </tr>
        </table>
        <div class="btn_div"><input type="submit" value="Вход" class="btn"></div>
    </form>

    <div class="lin">
        <a href="/firstsemestr_war_exploded/regpage">Don't you have an account?</a>
    </div>
</div>
</body>
</html>
