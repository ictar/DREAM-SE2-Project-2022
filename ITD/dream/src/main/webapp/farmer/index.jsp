
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
    .button1 {
      background-color: white;
      color: black;
      border: 2px solid #4CAF50;
      padding: 16px 32px;
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
  <a href="${pageContext.request.contextPath}/farmer/report.jsp" style="text-decoration : none;"><button  class="button button1"><strong>Report</strong></button></a>
</div>
<<<<<<< HEAD
<div class="container">
  <div class="row p-5">
    <div class="col-3"></div>
    <div class="col-3 text-center">
        <a href="${pageContext.request.contextPath}/farmer/search" style="text-decoration : none;">
          <button  class="btn-lg button1"><strong>Search</strong></button>
        </a>
    </div>
    <div class="col-3 text-center">
        <a href="${pageContext.request.contextPath}/farmer/report" style="text-decoration : none;">
          <button  class="btn-lg button1"><strong>Report</strong></button>
        </a>
      </div>
    <div class="col-3"></div>
  </div>
  <div class="row p-2">
    <div class="col-3"></div>
    <div class="col-3 text-center">
        <a href="${pageContext.request.contextPath}/farmer/request" style="text-decoration : none;">
          <button  class="btn-lg button1"><strong>Request</strong></button>
        </a>
    </div>
    <div class="col-3 text-center">
        <a href="${pageContext.request.contextPath}/farmer/post.jsp" style="text-decoration : none;">
          <button  class="btn-lg button1"><strong>Forum</strong></button>
        </a>
    </div>
    <div class="col-3"></div>
  </div>
</body>
</html>