<%--
  Created by IntelliJ IDEA.
  User: elexu
  Date: 2022/2/1
  Time: 3:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${dailyplan.getTitle()}</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/basic.css" rel="stylesheet">

    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="row mt-0 pt-5 dream-header">
    <div class="col-sm-7 text-end">
        <h1>Data-dRiven PrEdictive FArMing</h1>
        <p class="text-secondary text-right">Telengana</p>
    </div>
    <div class="col-sm-5 mt-5">
        <p class="text-end">Hi, ${user}</p>
    </div>
</div>
<div class="ps-4 dream-nav">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/policymaker">Home</a></li>
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/policymaker/agronomist/${agronomist.getName()}?id=${agronomist.getAgronomistid()}">${agronomist.getName()}</a></li>
            <li class="breadcrumb-item active" aria-current="page">${agronomist.getName()}</li>
        </ol>
    </nav>
</div>
<div class="container">
<form>
    <fieldset disabled>
        <legend>${dailyplan.getTitle()}</legend>
        <label>Date: ${dailyplan.getDate()}</label>
        <label>Farmer: ${dailyplan.getFarmer()}</label>
        <div class="mb-3">
            <label for="dpcontent" class="form-label">Content</label>
            <input type="text" id="dpcontent" class="form-control" placeholder="${dailyplan.getContent()}">
        </div>
        <div class="mb-3">
            <label for="dpdeviation" class="form-label">Deviation</label>
            <input type="text" id="dpdeviation" class="form-control" placeholder="${dailyplan.getDeviation()}">
        </div>
        <label>Status: ${dailyplan.getStatus()}</label>
    </fieldset>

</form>
</div>
</body>
</html>
