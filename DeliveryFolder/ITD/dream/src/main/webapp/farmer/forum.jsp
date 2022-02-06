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
    <div class="row">
        <table class="table">
            <thead>
                <tr>
                    <td> Comments</td>
                    <td> Titles</td>
                    <td> Latest comment time</td>
                    <td> Farmer</td>
                </tr>
            </thead>
            <tbody>
        <c:forEach items="${postList}" var="PL">
                <tr>
                    <td>
                        <c:if test="${PL.getComments() != null}">${PL.getComments().size()}</c:if>
                        <c:if test="${PL.getComments() == null}">0</c:if>
                    </td>
                    <td ><a href="${pageContext.request.contextPath}/farmer/forum/post/${PL.getPostid()}"> ${PL.getTitle()}</a></td>
                    <td>
                        <c:if test="${PL.getComments() != null && !PL.getComments().isEmpty()}">${PL.getComments().get(PL.getComments().size()-1).getTime()}</c:if>
                        <c:if test="${PL.getComments() == null || PL.getComments().isEmpty()}">--</c:if>
                    </td>
                    <td> ${PL.getFarmer().getName()}</td>
                </tr>
        </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="row pt-3">
        <p><strong>Create a new post</strong></p>
        <form  method="post" action="${pageContext.request.contextPath}/farmer/forum/post">
            <div class="row p-3">
                <div class="col-sm-1">
                    <label for="title" class="col-form-label">Title</label>
                </div>
                <div class="col-lg-5">
                    <input placeholder="Enter title of Post" type="text" id="title" name="title" class="form-control">
                </div>
            </div>

            <div class="row p-3">
                <div class="col-sm-1">
                    <label for="content" class="col-form-label">Content</label>
                </div>
                <div class="col-lg-5">
                    <textarea rows=5 placeholder="Enter content of Post" id="content" name="content" class="form-control"></textarea>
                </div>
            </div>
            <div class="p-3">
                <button type="submit" class="btn border-0 dream-btn"><strong>Submit</strong></button>
            </div>
        </form>
    </div>
</div>

</body>
</html>