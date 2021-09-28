<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<c:import url="/WEB-INF/jsp/app/menu.jsp"/>

<div class="container">
    <div class="page-header">
        <div style="background-color:DimGray">
            <h1 style="color:white">Ventura HR</h1>
        </div>
    </div>

    <div class="container">
        <div class="page-header">
            <div style="background-color:LightGray">
                <h1 style="color:DimGray">Login</h1>
                <form class="form-inline" action="/acesso/login" method="post">
                    <div class="form-group">
                        <label>Email:</label>
                        <input type="email" class="form-control" placeholder="Entre com o seu email..." name="email">
                    </div>
                    <div class="form-group">
                        <label>Senha:</label>
                        <input type="password" class="form-control" placeholder="Entre com a sua senha..." name="senha">
                    </div>
                    <button type="submit" class="btn btn-default">Login</button>
                </form>
            </div>

</body>
</html>