<%--
  Created by IntelliJ IDEA.
  User: elexu
  Date: 2022/1/26
  Time: 6:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>${agronomit.getName()}</title>
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
        <p class="text-center">Hi, ${user}</p>
    </div>
</div>
<div class="ps-4 dream-nav">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/policymaker">Home</a></li>
            <li class="breadcrumb-item active" aria-current="page">${agronomist.getName()}</li>
        </ol>
    </nav>
</div>
<div class="container">
    <table class="table">
        <thead style="position:sticky; top: 0">
            <tr>
                <th class="header" scope="col">Daily Plan</th>
                <th class="header" scope="col">Deviation</th>
                <th class="header" scope="col">Status</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${dpList}" var="dp">
                <tr>
                    <td><a href="${pageContext.request.contextPath}/policymaker/agronomist/dailyplan/${dp.getDailyplanid()}">${dp.getDate()}</a></td>
                    <td>${dp.getDeviation()}</td>
                    <td>
                        <c:if test="${dp.getStatus() == 1}">
                            <span class="red-dot"></span>
                        </c:if>
                        <c:if test="${dp.getStatus() == 0}">
                            <span class="green-dot"></span>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
