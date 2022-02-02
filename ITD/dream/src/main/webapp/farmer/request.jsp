
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Request</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/basic.css" rel="stylesheet">

    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
    <style>
        .button {
            border: none;
            color: white;
            padding: 16px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            transition-duration: 0.4s;
            cursor: pointer;
        }

        .button1 {
            background-color: white;
            color: black;
            border: 2px solid #4CAF50;
        }

        .button1:hover {
            background-color: #4CAF50;
            color: white;
        }
    </style>
</head>

<body>
<div class="mt-0 p-5 text-black dream-header">
    <div class="col-sm-7 text-end">
        <h1>Data-dRiven PrEdictive FArMing</h1>
        <p class="text-secondary text-right">Telengana</p>
    </div>
    <div class="col-sm-5 mt-5">
        <p class="text-center">Hi, ${farmer.getName()}</p>
    </div>
</div>

<div class="ps-4 dream-nav">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/farmer">Home</a></li>
            <li class="breadcrumb-item active" aria-current="page">Request</li>
        </ol>
    </nav>
</div>


<div class="text-center pt-3">
    <div class="nav dream-tab flex-column nav-pills p-3 mt-3" id="v-pills-tab" role="tablist" aria-orientation="vertical">
    <c:forEach items="${ProblemService.getProblemTitle()}" var="rf">
        <button class="nav-link text-black active" id="problem-1" data-bs-toggle="pill" data-bs-target="#v-pills-weather" type="button" role="tab" aria-controls="v-pills-weather" aria-selected="true">${Title}</button>
    </c:forEach>
    </div>


    <c:forEach items="${weather.getRainfall()}" var="rf">
        <tr>
            <td>${rf.key}</td>
            <td>${rf.value.getRange()}</td>
            <td>${rf.value.getAws_station_count()}</td>
        </tr>
    </c:forEach>

    <div class="text-start pt-3">
        <a href="./newRequest.jsp" style="text-decoration : none;"><button  class="button button1"><strong>Create</strong></button></a>
    </div>

</div>



</body>
</html>