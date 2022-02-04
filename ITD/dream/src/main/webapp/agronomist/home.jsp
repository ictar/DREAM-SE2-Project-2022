<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 2022/2/3
  Time: 7:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>${agronomist.getName()}</title>
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
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/agronomist/Home">Home</a></li>
            <li class="breadcrumb-item active" aria-current="page">${agronomist.getName()}</li>
        </ol>
    </nav>
</div>

<div class="container">
    <div class="d-flex align-items-start">
        <div class="nav dream-tab flex-column nav-pills p-3 mt-3" id="v-pills-tab" role="tablist" aria-orientation="vertical">
            <button class="nav-link text-black active" id="v-pills-location-tab" data-bs-toggle="pill" data-bs-target="#v-pills-location" type="button" role="tab" aria-controls="v-pills-location" aria-selected="true">Location</button>
            <button class="nav-link text-black" id="v-pills-weather-tab" data-bs-toggle="pill" data-bs-target="#v-pills-weather" type="button" role="tab" aria-controls="v-pills-weather" aria-selected="false">Weather</button>
            <button class="nav-link text-black" id="v-pills-water-tab" data-bs-toggle="pill" data-bs-target="#v-pills-water" type="button" role="tab" aria-controls="v-pills-water" aria-selected="false">Water Irrigation</button>
            <button class="nav-link text-black" id="v-pills-soil-tab" data-bs-toggle="pill" data-bs-target="#v-pills-soil" type="button" role="tab" aria-controls="v-pills-soil" aria-selected="false">Soil Humidity</button>
            <button class="nav-link text-black" id="v-pills-information-tab" data-bs-toggle="pill" data-bs-target="#v-pills-information" type="tab" role="tab" aria-controls="v-pills-information" aria-selected="false">Farmer Information</button>
            <button class="nav-link text-black" id="v-pills-dailyplan-tab" data-bs-toggle="pill" data-bs-target="#v-pills-dailyplan" type="tab" role="tab" aria-controls="v-pills-dailyplan" aria-selected="false">Daily Plan</button>
        </div>


        <div class="tab-content p-3 mt-3" id="v-pills-tabContent">

            <!--location-->
            <div class="tab-pane fade show active" id="v-pills-location" role="tabpanel" aria-labelledby="v-pills-location-tab">
                <img src="${pageContext.request.contextPath}/images/${area.getImage()}">

            </div>

            <!--weather-->
            <div class="tab-pane fade" id="v-pills-weather" role="tabpanel" aria-labelledby="v-pills-weather-tab">
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

            <!--water-->
            <div class="tab-pane fade" id="v-pills-water" role="tabpanel" aria-labelledby="v-pills-water-tab">
                <li>Consumption: ${water.getConsumption()}</li>
                <li>Date: ${water.getDate()}</li>
                ${waterList}
            </div>

            <!--soil-->
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

            <!--information-->
            <div class="tab-pane fade" id="v-pills-information" role="tabpanel" aria-labelledby="v-pills-information-tab">
                <table class="table">
                    <thead style="position:sticky; top: 0">
                    <tr>
                        <th class="header" scope="col">Farmer</th>
                        <th class="header" scope="col">Last Visit</th>
                        <th class="header" scope="col">Performance</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${FarmerPerformance}" var="fm">
                        <tr>
                            <td>${fm.getName()}</td>
                            <c:if test="${fm.getDailyplans() != null && !fm.getDailyplans().isEmpty()}">
                                <td>${fm.getDailyplans().get(0).getDate()}</td>
                            </c:if>
                            <c:if test="${fm.getDailyplans() == null || fm.getDailyplans().isEmpty()}">
                                <td>--</td>
                            </c:if>
                            <td>${fm.getPerformance()}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

            <!--dailyplan-->
            <div class="tab-pane fade" id="v-pills-dailyplan" role="tabpanel" aria-labelledby="v-pills-dailyplan-tab">
                <table class="table">
                    <thead style="position:sticky; top: 0">
                    <tr>
                        <th class="header" scope="col">Daily Plan</th>
                        <th class="header" scope="col">Deviation</th>
                        <th class="header" scope="col">Status</th>
                        <th class="header" scope="col">Management</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${Dailyplan}" var="DP">
                        <tr>
                            <td>${DP.getDailyPlanlist()}</td>
                            <td>${DP.getDeviation()}</td>
                            <td>${DP.getStatus()}</td>
                            <td>${DP.Management()}</td>
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


