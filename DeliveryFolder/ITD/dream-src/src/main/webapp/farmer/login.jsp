<%--
  Created by IntelliJ IDEA.
  User: elexu
  Date: 2022/1/21
  Time: 4:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/basic.css" rel="stylesheet">

<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.bundle.min.js"></script>
<title>Login</title>
</head>
<body>
<div class="row mt-0 pt-5 dream-header">
    <div class="col-sm-7 text-end">
        <h1>Data-dRiven PrEdictive FArMing</h1>
        <p class="text-secondary text-right">Telengana</p>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-sm mt-5 p-5">
            <img src="../images/farmer.jpeg" class="img-thumbnail border-0">
        </div>
        <div class="col-sm">
            <h2 class="text-center p-5">Farmer</h2>
            <form action="${pageContext.request.contextPath}/farmer/Login" method="POST">
                <div class="input-group">
                    <input type="tel" class="form-control mt-2 border-secondary" id="phonenumber" placeholder="Phone Number" name="phonenumber" required>
                </div>
                <div class="input-group">
                    <input type="password" class="form-control mt-2 border-secondary" id="pwd" placeholder="Password" name="pwd" required>
                </div>
                <div class="text-center pt-3">
                    <button type="submit" class="btn border-0 dream-btn"><strong>Login</strong></button>
                </div>
                <p class="text-danger">${errorMsgLog}</p>
            </form>
        </div>
        <div class="col-sm"></div>
    </div>

    <div class="row m-5 p-5">
        <p class="text-center">Don't have an account?  <a href="./register.jsp">Sign Up</a></p>
    </div>
</div>
</body>
</html>
