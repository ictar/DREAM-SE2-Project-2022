<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 2022/2/2
  Time: 5:22 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

    <style>
        #left{ position:absolute; top:0; left:80px; width:580px; height:100%; background-color:#CCCCCC}
        #right{margin-left:750px;width:200px;height:5%;right:100px; background-color:#CCCCCC}
    </style>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/basic.css" rel="stylesheet">

    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap.bundle.min.js"></script>
    <title>report</title>
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
            <li class="breadcrumb-item active" aria-current="page">Report</li>
        </ol>
    </nav>
</div>
<div class="container p-5">
    <form action="${pageContext.request.contextPath}/farmer/report" method="POST">

        <div class="input-group">
            <select class="form-select" id="prodct" name="productiontype">
                <option selected>Choose type of planting</option>
                <c:forEach items="${productList}" var="product">
                    <option value="${product}">${product}</option>
                </c:forEach>
            </select>
        </div>
        <div class="input-group">
            <input type="text" class="form-control mt-2 border-secondary" id="amount" placeholder="Enter Amount" name="amount" required>
        </div>

        <div class="input-group">
            <input type="text" class="form-control mt-2 border-secondary" id="acreage" placeholder="Enter acreage of planting" name="acreage" required>
        </div>

        <div class="row pt-3">
            <div class="col-lg-3">
                <input type="date" id="starttime" name="starttime" placeholder="Choose start time">
            </div>
            <div class="col-lg-3">
                <input type="date" id="endtime" name="endtime" placeholder="Choose end time">
            </div>
        </div>

        <div class="text-center pt-3">
            <button type="submit" class="btn border-0 dream-fm-btn"><strong>Submit</strong></button>
        </div>
        <p class="text-danger">${errorMsg}</p>
    </form>
</div>
</body>
</html>