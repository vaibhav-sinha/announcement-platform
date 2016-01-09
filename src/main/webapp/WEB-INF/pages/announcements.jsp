<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<html ng-app="AnnouncementApp">
<head>
	<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/zapstitch.css" rel="stylesheet">
	<script src="${pageContext.request.contextPath}/resources/js/angular.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/announcements.js"></script>
    <script>
        var loadAnnouncementUrl = "<c:url value="/" />";
    </script>
</head>
<body class="center" ng-controller="AnnouncementController">
        <div class="bottom-details col-xs-8 center" ng-repeat="announcement in announcements">
            <h3 class="title-no-bg center">{{announcement.heading}}</h3>
            <div class="center thin col-xs-12">{{announcement.summary}}</div>
            <div>{{announcement.description}}</div>
        </div>
<button ng-click="loadAnnouncements()">Get More</button>
</body>
</html>