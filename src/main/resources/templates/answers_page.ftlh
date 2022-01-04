<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<div>
    <form action="/answer" method="post">
        <input name="ID" placeholder="Id клиента">
        <input type="submit" value="Answer me">
    </form>
    <table>
        <tr>
            <th>Максимальная транзакция</th>
            <th>Самый частый модуль</th>
            <th>Сколько модуля</th>
        </tr>
        <#list nums as n>
            <tr>
                <td>${n.get(0)}</td>
                <td>${n.get(1)}</td>
                <td>${n.get(2)}</td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>