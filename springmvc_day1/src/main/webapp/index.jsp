<html>
<body>
<h2>Hello World!</h2>
<a href="/hello?username=zhangsan&password=123">点</a>

<form id="user" action="/userGet" method="post">
    username:<input id="username" name="username" type="text"><br>
    password:<input id="password" name="password" type="password"><br>
    age:<input id="age" name="age" type="text"><br>
    birthday:<input id="birthday" name="birthday" type="text"><br>

    account:<input id="account" name="List[0].account" type="text"><br>
    money:<input id="money" name="List[0].money" type="text"><br>

    <hr>

    account:<input id="account1" name="Map['one'].account" type="text"><br>
    money:<input id="money1" name="Map['one'].money" type="text">

    <input type="submit">
</form>
</body>
</html>
