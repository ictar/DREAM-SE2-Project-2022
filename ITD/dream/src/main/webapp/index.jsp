<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="./css/basic.css" rel="stylesheet">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

    <title>DREAM</title>
</head>
<body>
<div class="mt-0 p-5 text-black dream-header">
    <h1>Data-dRiven PrEdictive FArMing</h1>
    <p class="text-center text-secondary">Telengana</p>
</div>

<div class="container pt-5">
    <div class="card-group">
        <div class="card border-0 p-5">
            <a href="./policymaker/login.jsp">
                <img alt="click to access functions of policy maker" src="./images/policymaker.png" class="card-img-top">
            </a>
            <div class="card-body">
                <h3 class="card-title text-center">Policy Maker</h3>
                <p class="card-text text-center p-4">Don't have an account?  <a href="./policymaker/register.jsp">Sign Up</a></p>
            </div>
        </div>
        <div class="card border-0 p-5">
            <a href="./farmer/login.jsp">
                <img alt="click to access functions of farmer" src="./images/farmer.jpeg" class="card-img-top">
            </a>
            <div class="card-body">
                <h3 class="card-title text-center">Farmer</h3>
                <p class="card-text text-center p-4">Don't have an account?  <a href="./farmer/register.jsp">Sign Up</a></p>
            </div>
        </div>
        <div class="card border-0 p-5">
            <a href="./agronomist/login.jsp">
                <img alt="click to access functions of agronomist" src="./images/agronomist.png" class="card-img-top">
            </a>
            <div class="card-body">
                <h3 class="card-title text-center">Agronomist</h3>
                <p class="card-text text-center p-4">Don't have an account?  <a href="./agronomist/register.jsp">Sign Up</a></p>
            </div>
        </div>
    </div>
</div>
</body>
</html>