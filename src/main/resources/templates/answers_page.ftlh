<!doctype html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h1>Id</h1>
<form action="#" th:action="@{/answers}" th:object="Transactions" method="post">
    <p>Id: <input type="customer_id" th:field="*{id}" /></p>
    <p><input type="submit" value="Submit" /> <input type="reset" value="Reset" />
</form>
<table>
    <tr>
        <th>customer_id</th>
        <th>amount</th>
    </tr>
    <#list trans as transaction>
        <tr>
            <td>${transaction.customer_id}</td>
            <td>${transaction.amount}</td>
        </tr>
    </#list>
</table>
</body>
</html>