<%--
  Created by IntelliJ IDEA.
  Whom: elexu
  Date: 2022/1/21
  Time: 4:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  import="in.dream.ejb.models.Area"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="../css/basic.css" rel="stylesheet">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<title>Register</title>
</head>
<body>
<div class="mt-0 p-5 text-black dream-header">
  <h1>Data-dRiven PrEdictive FArMing</h1>
  <p class="text-center text-secondary">Telengana</p>
</div>

<div class="container">
  <div class="row">
    <div class="col-sm mt-5 p-5">
      <img src="../images/agronomist.png" class="img-thumbnail border-0">
    </div>
    <div class="col-sm">
      <h2 class="text-center p-5">Agronomist</h2>
      <form action="${pageContext.request.contextPath}/agronomist/Register" method="POST">
        <div class="input-group">
          <input type="text" class="form-control mt-2 border-secondary" id="name" placeholder="Name" name="name">
        </div>
        <div class="input-group">
          <input type="email" class="form-control mt-2 border-secondary" id="email" placeholder="Email" name="email">
        </div>
        <div class="input-group">
          <input type="password" class="form-control mt-2 border-secondary" id="pwd" placeholder="Password" name="pwd">
          <div class="input-group-append">
            <span class="help-block">At least 8 alphanumeric characters, 2 numeric characters.</span>
          </div>
        </div>
        <div class="">
          <select class="form-select" id="area" name="area">
            <option selected>response area</option>
            <c:forEach items="${areaList}" var="area">
              <option value="${area.getAreaid()}">${area.getName()}</option>
            </c:forEach>
          </select>
        </div>
        <div class="checkbox text-secondary">
          <label><input type="checkbox" name="acc_privacy"> Accept <a>Privacy Statement</a></label>
        </div>
        <div class="checkbox text-secondary">
          <label><input type="checkbox" name="acc_terms"> Accept <a>Terms and Conditions</a></label>
        </div>
        <div class="text-center pt-3">
          <button type="submit" class="btn border-0 dream-btn"><strong>Create An Account</strong></button>
        </div>
      <div><p>${errorMsgReg}</p></div>

      </form>
    </div>
    <div class="col-sm"></div>
  </div>

  <div class="row m-5 p-5">
    <p class="text-center">Already have an account?  <a href="./login.jsp">Sign In</a></p>
  </div>
</div>
</body>
</html>
