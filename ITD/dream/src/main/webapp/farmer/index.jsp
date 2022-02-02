
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
    <p class="text-center">Hi, ${user}</p>
  </div>
</div>

<div class="text-center pt-3">
  <a href="${pageContext.request.contextPath}/farmer/search" style="text-decoration : none;"><button  class="button button1"><strong>Search</strong></button></a>
  <a href="./farmer/report.jsp" style="text-decoration : none;"><button  class="button button1"><strong>Report</strong></button></a>
</div>
<div class="text-center pt-3">
  <a href="./farmer/request.jsp" style="text-decoration : none;"><button  class="button button1"><strong>Request</strong></button></a>
  <a href="./farmer/forum.jsp" style="text-decoration : none;"><button  class="button button1"><strong>Forum</strong></button></a>
</div>


</body>
</html>