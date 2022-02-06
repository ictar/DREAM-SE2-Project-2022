<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/policymaker/agronomist/${agronomist.getAgronomistid()}">${agronomist.getName()}</a></li>
            <li class="breadcrumb-item active" aria-current="page">${dailyplan.getTitle()}</li>
        </ol>
    </nav>
</div>
<div class="container">
<form>
    <fieldset disabled>
        <legend>${dailyplan.getTitle()}</legend>
        <div class="mb-3">
            <label for="dpdate" class="col-2">Date: </label>
            <span id="dpdate" class="col-6">${dailyplan.getDate()}</span>
        </div>
        <div class="mb-3">
            <label for="dpfarmers" class="col-2">Farmer:</label>
            <span id="dpfarmers" class="col-6">
            <c:forEach items="${dailyplan.getFarmers()}" var="farmer">
                ${farmer.getName()};
            </c:forEach>
            </span>
        </div>
        <div class="mb-3">
            <label for="dpcontent" class="col-2">Content</label>
            <textarea rows="5" id="dpcontent" class="col-6">${dailyplan.getContent()}</textarea>
        </div>
        <div class="mb-3">
            <label for="dpdeviation" class="col-2">Deviation</label>
            <textarea rows="5" id="dpdeviation" class="col-6">${dailyplan.getDeviation()}</textarea>
        </div>
        <div class="mb-3">
            <label class="col-2">Status:</label>
                <c:if test="${dailyplan.getStatus() == 1}">
                    <span class="red-dot"></span>
                </c:if>
                <c:if test="${ddailyplan.getStatus() == 0}">
                    <span class="green-dot"></span>
                </c:if>
        </div>

    </fieldset>

</form>
</div>
</body>
</html>
