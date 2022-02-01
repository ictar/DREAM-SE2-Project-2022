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
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/farmer/search.jsp">Home</a></li>
            <li class="breadcrumb-item active" aria-current="page">Suggestion</li>
        </ol>
    </nav>
</div>
<div class="container">
    <div class="d-flex align-items-start">
        <div class="nav dream-tab flex-column nav-pills p-3 mt-3" id="v-pills-tab" role="tablist" aria-orientation="vertical">
            <button class="nav-link text-black active" id="v-pills-weather-tab" data-bs-toggle="pill" data-bs-target="#v-pills-weather" type="button" role="tab" aria-controls="v-pills-weather" aria-selected="true">Weather</button>
            <button class="nav-link text-black" id="v-pills-suggest-tab" data-bs-toggle="pill" data-bs-target="#v-pills-suggest" type="button" role="tab" aria-controls="v-pills-suggest" aria-selected="false">Planting Suggestion</button>
        </div>
        <div class="tab-content p-3 mt-3" id="v-pills-tabContent">
            <div class="tab-pane fade show active" id="v-pills-weather" role="tabpanel" aria-labelledby="v-pills-weather-tab">
                <div>
                    <h4 class="text-center">Rainfall</h4>
                    <table class="table">
                        <thead style="position:sticky; top: 0">
                        <tr>
                            <th class="header" scope="col">Classification</th>
                            <th class="header" scope="col">Rainfall Range (mm)</th>
                            <th class="header" scope="col">No. of AWS Stations</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${weather.getRainfall()}" var="rf">
                            <tr>
                                <td>${rf.key}</td>
                                <td>${rf.value.getRange()}</td>
                                <td>${rf.value.getAws_station_count()}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="tab-pane fade" id="v-pills-suggest" role="tabpanel" aria-labelledby="v-pills-suggest-tab">
                <h4>Plant Name: ${plantname}</h4>
                <p>${plantsuggest}</p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
