
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
            <li class="breadcrumb-item active" aria-current="page">Request</li>
        </ol>
    </nav>
</div>

<div class="container">
    <div class="d-flex align-items-start">
        <div class="nav dream-tab flex-column nav-pills p-3 mt-3 col-2" id="v-pills-tab" role="tablist" aria-orientation="vertical">
            <c:forEach items="${problemList}" var="PL"  begin="0" end="0">
                <button class="nav-link text-black active" id="problem-${PL.getProblemid()}-tab" data-bs-toggle="pill" data-bs-target="#problem-${PL.getProblemid()}" type="button" role="tab" aria-controls="problem-${PL.getProblemid()}" aria-selected="true">${PL.getTitle()}</button>
            </c:forEach>
            <c:forEach items="${problemList}" var="PL"  begin="1">
                <button class="nav-link text-black" id="problem-${PL.getProblemid()}-tab" data-bs-toggle="pill" data-bs-target="#problem-${PL.getProblemid()}" type="button" role="tab" aria-controls="problem-${PL.getProblemid()}" aria-selected="false">${PL.getTitle()}</button>
            </c:forEach>
        </div>
        <div class="tab-content p-3 px-5 mt-3 col-10" id="v-pills-tabContent">
            <c:forEach items="${problemList}"   var="PL"  begin="0" end="0" >
            <div class="tab-pane fade show active" id="problem-${PL.getProblemid()}" role="tabpanel" aria-labelledby="problem-${PL.getProblemid()}">
                <fieldset disabled>
                    <div class="mb-3">
                        <label for="title_${PL.getProblemid()}" class="col-2">Title:</label>
                        <input type="text" id="title_${PL.getProblemid()}" value="${PL.getTitle()}" class="col-6">
                    </div>
                    <div class="mb-3">
                        <label for="content_${PL.getProblemid()}" class="col-2">Content:</label>
                        <input type="text" id="content_${PL.getProblemid()}" class="col-6" value="${PL.getRequest()}">
                    </div>
                    <div class="mb-3">
                        <label for="reqtime_${PL.getProblemid()}" class="col-2">Request Time:</label>
                        <input type="text" id="reqtime_${PL.getProblemid()}" value="${PL.getRequesttime()}" class="col-6">
                    </div>
                    <div class="mb-3">
                        <label for="answer_${PL.getProblemid()}" class="col-2">Answer:</label>
                        <input type="text" id="answer_${PL.getProblemid()}" value="${PL.getAnswer()}" class="col-6">
                    </div>
                    <div class="mb-3">
                        <label for="anstime_${PL.getProblemid()}" class="col-2">Request Time:</label>
                        <input type="text" id="anstime_${PL.getProblemid()}" class="col-6" value="${PL.getAnswertime()}">
                    </div>
                </fieldset>
                <form  method="post" action="${pageContext.request.contextPath}/farmer/request/feedback">
                    <input type="hidden" id="problemid" name="problemid" value="${PL.getProblemid()}">
                    <div class="mb-3">
                        <label for="feedback" class="col-2">Feedback: </label>
                        <input type="number" id="feedback" class="col-6" name="feedback" value="${PL.getFeedback()}">
                    </div>
                    <div class="text-center pt-3">
                        <button type="submit" class="btn border-0 dream-btn"><strong>Submit</strong></button>
                    </div>
                </form>
            </div>
            </c:forEach>
            <c:forEach items="${problemList}"   var="PL"  begin="1" >
                <div class="tab-pane fade " id="problem-${PL.getProblemid()}" role="tabpanel"  aria-labelledby="problem-${PL.getProblemid()}-tab">
                    <fieldset disabled>
                        <div class="mb-3">
                            <label for="title_${PL.getProblemid()}" class="col-2">Title:</label>
                            <input type="text" id="title_${PL.getProblemid()}" class="col-6" value="${PL.getTitle()}">
                        </div>
                        <div class="mb-3">
                            <label for="content_${PL.getProblemid()}" class="col-2">Content:</label>
                            <input type="text" id="content_${PL.getProblemid()}" class="col-6" value="${PL.getRequest()}">
                        </div>
                        <div class="mb-3">
                            <label for="reqtime_${PL.getProblemid()}" class="col-2">Request Time:</label>
                            <input type="text" id="reqtime_${PL.getProblemid()}" class="col-6" value="${PL.getRequesttime()}">
                        </div>
                        <div class="mb-3">
                            <label for="answer_${PL.getProblemid()}" class="col-2">Answer:</label>
                            <input type="text" id="answer_${PL.getProblemid()}" class="col-6" value="${PL.getAnswer()}">
                        </div>
                        <div class="mb-3">
                            <label for="anstime_${PL.getProblemid()}" class="col-2">Request Time:</label>
                            <input type="text" id="anstime_${PL.getProblemid()}" class="col-6" value="${PL.getAnswertime()}">
                        </div>
                    </fieldset>
                    <form  method="post" action="${pageContext.request.contextPath}/farmer/request/feedback">
                        <input type="hidden" id="problemid" name="problemid" value="${PL.getProblemid()}">
                        <div class="mb-3">
                            <label for="feedback" class="col-2">Feedback: </label>
                            <input type="number" id="feedback" class="col-6" name="feedback" value="${PL.getFeedback()}">
                        </div>
                        <div class="text-center pt-3">
                            <button type="submit" class="btn border-0 dream-btn"><strong>Submit</strong></button>
                        </div>
                    </form>
                </div>
            </c:forEach>
        </div>
        <p>${errMsg}</p>
    </div>
    <div class="pt-2">
    <a href="${pageContext.request.contextPath}/farmer/request/create" style="text-decoration : none;"><button  class="button button1"><strong>Create</strong></button></a>
    </div>
</div>
</body>
</html>