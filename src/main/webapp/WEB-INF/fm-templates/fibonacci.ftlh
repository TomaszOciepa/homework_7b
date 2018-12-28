<html>
<head>
    <meta charset="UTF-8">
    <title>JBusters</title>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

</head>
<body>
<div class="container">
    <div class="jumbotron">
        <h1 class="display-4">Wybrałeś: ${last.getElement()}</h1>
        <h2>Element ${last.getElement()} wynosi: ${last.getResult()}</h2>
        <hr class="my-4">
        <p>.</p>
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Nr Elementu</th>
                <th scope="col">Wynik</th>
            </tr>
            </thead>
            <tbody>
            <#list fibo as f>
                <tr>
                    <td>${f.getElement()}</td>
                    <td>${f.getResult()}</td>
                </tr>
            </#list>


            </tbody>
        </table>
    </div>

</div>


<footer>&copy; 2018-2019 Tomek Ociepa</footer>
<script src="js/jquery-3.3.1.slim.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>