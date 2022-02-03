<%--
  Created by IntelliJ IDEA.
  User: elexu
  Date: 2022/1/28
  Time: 3:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Performance Update</title>
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
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/policymaker/area/${area.getName()}?id=${area.getAreaid()}">${area.getName()}</a></li>
            <li class="breadcrumb-item active" aria-current="page">Performance</li>
        </ol>
    </nav>
</div>
<div class="container">
    <form action="${pageContext.request.contextPath}/policymaker/area/performance/${area.getName()}" method="POST">
        <table class="table">
            <thead style="position:sticky; top: 0">
            <tr>
                <th class="header" scope="col">Farmer</th>
                <th class="header" scope="col">Performance</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${farmerList}" var="farmer">
                <tr>
                    <td>${farmer.getName()}</td>
                    <td>
                        <input type="number" class="mt-2 border-secondary" placeholder="${farmer.getPerformance()}" name="performance_${farmer.getFarmerid()}" required>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="text-center pt-3">
            <button type="submit" class="btn border-0 dream-btn"><strong>Submit</strong></button>
        </div>
        <div>
            <p>${errMsg}</p>
        </div>
    </form>
</div>
</body>
</html>
