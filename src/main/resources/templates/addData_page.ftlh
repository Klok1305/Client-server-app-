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
    <form action="/adddata" method="post">
        <input name="customer_id" placeholder="Id клиента">
        <input name="tr_datetime" placeholder="дата">
        <input name="mcc_code" placeholder="mcc код">
        <input name="amount" placeholder="стоимость">
        <input name="tr_type" placeholder="тип транзакции">
        <input name="term_id" placeholder="терм id">
        <input type="submit" value="Add">
    </form>
</div>
</body>
</html>