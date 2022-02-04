<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Forum</title>
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
            <li class="breadcrumb-item active" aria-current="page">Forum</li>
        </ol>
    </nav>
</div>

<div class="container">
    <table class="border-4 table-forum">
        <tr>
            <td > Post</td>
            <td  style="background-color: rgba(198,217,188,0.92)"> Farmer</td>
            <td > Create time</td>
        </tr>
    </table>

    <c:forEach items="${postList}" var="PL">
        <table class="border-4 table-forum">
            <tr>
                <td ><a href="${pageContext.request.contextPath}/farmer/post/${PL.getPostid()}"> ${PL.getTitle()}</a></td>
                <td  style="background-color: rgba(198,217,188,0.92)"> ${PL.getFarmer().getName()}</td>
                <td > ${PL.getTime()}</td>
            </tr>

        </table>
    </c:forEach>
</div>
<div class="text-center pt-3">
    <p><strong>Create a new post</strong></p>
    <form  method="post" action="${pageContext.request.contextPath}/farmer/post/*">
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
</html>