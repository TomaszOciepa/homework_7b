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
        <div class="jumbotron jumbotron-opacity">
            <h1 class="display-4">Podaj element ciągu Fibonacciego. 😎</h1>
            <hr class="my-4">
            <form method="get" action="/fibonacci">

                <div class="form-group">
                    <label for="inputNumber">Podaj liczbę:</label>
                    <input type="text" name="number" id="inputNumber" class="form-control" placeholder="Podaj liczbę" required>
                </div>

                <button type="submit" class="btn btn-primary">Dalej</button>
            </form>
        </div>
    </div>





<footer>&copy; 2018-2019 Tomek Ociepa</footer>
<script src="js/jquery-3.3.1.slim.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>