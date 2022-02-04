<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create Request</title>
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
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/farmer">Home</a></li>
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/farmer/request/">Request</a></li>
            <li class="breadcrumb-item active" aria-current="page">Create a new Request</li>
        </ol>
    </nav>
</div>

<div class="text-center pt-3">
    <form  method="post" action="${pageContext.request.contextPath}/farmer/newRequest">
        <div class="text-center pt-3">
            <p style="display:inline">&ensp;&emsp;Title</p>
            <textarea style="display:inline" name="title" placeholder="title" id="title" rows="1" cols="80">Enter Title</textarea>
        </div>
        <div class="text-center pt-3">
            <p style="display:inline">Content</p>
            <textarea name="content" placeholder="content" id="content" rows="6" cols="80" onpropertychange="if(this.scrollHeight>80) this.style.posHeight=this.scrollHeight+5">Enter Content</textarea>
        </div>
        <div class="text-center pt-3">
            <button type="submit" class="btn border-0 dream-btn"><strong>Submit</strong></button>
        </div>
    </form>
</div>
</body>
