<%--
  Created by IntelliJ IDEA.
  User: elexu
  Date: 2022/1/26
  Time: 3:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Home</title>
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
<div class="row mt-0 p-5 dream-header">
    <div class="col-sm-8 text-end">
        <h1>Data-dRiven PrEdictive FArMing</h1>
        <p class="text-secondary text-right">Telengana</p>
    </div>
    <div class="col-sm-4 mt-5">
        <p class="text-end">Hi, ${user}</p>
    </div>
</div>
<div class="container">
    <div class="row pt-5">
        <div class="col-sm">
            <img src="${pageContext.request.contextPath}/images/areas/telegana.jpg" width="718" height="612" usemap="#featuresMap" id="mapImage" alt="click to access area"/>
            <map name="featuresMap">
                <c:forEach items="${areaList}" var="area">
                    <area shape="poly" coords="${area.getCoords()}" href="${pageContext.request.contextPath}/policymaker/area/${area.getName()}"/>
                </c:forEach>
            </map>
        </div>
        <div class="col-sm">
            <h4 class="text-secondary">Agronomist</h4>
            <div class="list-group list-group-flush">
                <c:forEach items="${agList}" var="agronomist">
                    <a class="list-group-item list-group-item-light list-group-item-action" href="${pageContext.request.contextPath}/agronomist/${agronomist.getName()}?id=${agronomist.getAgronomistid()}">${agronomist.getName()}</a>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
</body>
</html>
