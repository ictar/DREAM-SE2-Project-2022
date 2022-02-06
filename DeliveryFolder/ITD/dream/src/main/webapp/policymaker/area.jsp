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
    <title>${area.getName()}</title>
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
            <li class="breadcrumb-item active" aria-current="page">${area.getName()}</li>
        </ol>
    </nav>
</div>
<div class="text-end pe-5">
    <a class="btn btn-success" role="button" href="${pageContext.request.contextPath}/policymaker/area/performance/${area.getAreaid()}">
        <strong>Update Performance</strong>
    </a>
</div>
<div class="container">
    <div class="d-flex align-items-start">
        <div class="nav dream-tab flex-column nav-pills p-3 mt-3" id="v-pills-tab" role="tablist" aria-orientation="vertical">
            <button class="nav-link text-black active" id="v-pills-weather-tab" data-bs-toggle="pill" data-bs-target="#v-pills-weather" type="button" role="tab" aria-controls="v-pills-weather" aria-selected="true">Weather</button>
            <button class="nav-link text-black" id="v-pills-water-tab" data-bs-toggle="pill" data-bs-target="#v-pills-water" type="button" role="tab" aria-controls="v-pills-water" aria-selected="false">Water Irrigation</button>
            <button class="nav-link text-black" id="v-pills-soil-tab" data-bs-toggle="pill" data-bs-target="#v-pills-soil" type="button" role="tab" aria-controls="v-pills-soil" aria-selected="false">Soil Humidity</button>
            <button class="nav-link text-black" id="v-pills-production-tab" data-bs-toggle="pill" data-bs-target="#v-pills-production" type="button" role="tab" aria-controls="v-pills-production" aria-selected="false">Farmer Production</button>
        </div>
        <div class="tab-content p-3 mt-3" id="v-pills-tabContent">
            <div class="tab-pane fade show active" id="v-pills-weather" role="tabpanel" aria-labelledby="v-pills-weather-tab">
                <img src="${pageContext.request.contextPath}/images/${area.getImage()}">
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
            <div class="tab-pane fade" id="v-pills-water" role="tabpanel" aria-labelledby="v-pills-water-tab">
                <li>Consumption: ${water.getConsumption()}</li>
                <li>Date: ${water.getDate()}</li>
                ${waterList}
            </div>
            <div class="tab-pane fade" id="v-pills-soil" role="tabpanel" aria-labelledby="v-pills-soil-tab">
                <ul>Temperature: ${soil.getTemperature()}</ul>
                <ul>Moisure: ${soil.getMoisture()}</ul>
                <ul>Fertility
                    <li>pH: ${soil.getFertility().getPh()}</li>
                    <li>Electrical Conductivity: ${soil.getFertility().getElectricalConductivity()}</li>
                    <li>Organic Carbon: ${soil.getFertility().getOrganicCarbon()}</li>
                    <li>Nitrogen: ${soil.getFertility().getNitrogen()}</li>
                </ul>
            </div>
            <div class="tab-pane fade" id="v-pills-production" role="tabpanel" aria-labelledby="v-pills-production-tab">
                <table class="table">
                    <thead style="position:sticky; top: 0">
                    <tr>
                        <th class="header" scope="col">Farmer</th>
                        <th class="header" scope="col">Production Type</th>
                        <th class="header" scope="col">Production Amount</th>
                        <th class="header" scope="col">Production Area</th>
                        <th class="header" scope="col">Period</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${productionList}" var="prod">
                        <tr>
                            <td>${prod.getFarmer().getName()}</td>
                            <td>${prod.getType()}</td>
                            <td>${prod.getAmount()}</td>
                            <td>${prod.getAcreage()}</td>
                            <td>${prod.getStarttime()} - ${prod.getEndtime()}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
