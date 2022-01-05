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
    <table>
        <tr>
            <th>customer_id</th>
            <th>Модуль</th>
            <th>Сколько встречался</th>
        </tr>
        <#list trans as transaction>
            <tr>
                <td>${transaction.customer_id}</td>
                <td>${transaction.abs}</td>
                <td>${transaction.n}</td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>