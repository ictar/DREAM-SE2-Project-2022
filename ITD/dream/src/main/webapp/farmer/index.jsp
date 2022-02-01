
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
  <button  class="button"><strong>Search</strong></button>
  <button  class="button"><strong>Report</strong></button>
</div>
<div class="text-center pt-3">
  <button  class="button"><strong>Request</strong></button>
  <button  class="button"><strong>Forum</strong></button>
</div>


</body>
</html>