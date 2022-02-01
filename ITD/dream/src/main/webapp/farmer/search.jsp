<%--
  Created by IntelliJ IDEA.
  User: elexu
  Date: 2022/1/30
  Time: 10:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <!--<script async defer src="https://maps.googleapis.com/maps/api/js?key=YourAPI&callback=initMap"></script>-->
    <title>Search</title>
</head>
<body>
<div class="row mt-0 pt-5 dream-header">
    <div class="col-sm-7 text-end">
        <h1>Data-dRiven PrEdictive FArMing</h1>
        <p class="text-secondary text-right">Telengana</p>
    </div>
    <div class="col-sm-5 mt-5">
        <p class="text-center">Hi, ${user}</p>
    </div>
</div>
<div class="ps-4 dream-nav">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/farmer">Home</a></li>
            <li class="breadcrumb-item active" aria-current="page">Search</li>
        </ol>
    </nav>
</div>
<div class="container">
    <form action="${pageContext.request.contextPath}/farmer/search" method="POST">
        <div class="input-group">
            <input type="text" class="form-control mt-2 border-secondary" id="location" placeholder="Email" name="location" required>
        </div>
        <div class="input-group">
            <select class="form-select" id="prodct" name="productiontype">
                <option selected>Choose interested production</option>
                <c:forEach items="${productList}" var="product">
                    <option value="${product}">${product}</option>
                </c:forEach>
            </select>
        </div>
        <div class="text-center pt-3">
            <button type="submit" class="btn border-0 dream-btn"><strong>Submit</strong></button>
        </div>
        <p class="text-danger">${errorMsg}</p>
    </form>
</div>
<script>
    function getLocation() {
        // try HTML5 geolocation
        if(navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function (position) {

            }, function(){
                handleLocationError(true)
            })
        } else {
            // Browser doesn't support Geolocation
            handleLocationError(false);
        }
    }

    function handleLocationError(browserHasGeolocation) {

    }
</script>
</body>
</html>
