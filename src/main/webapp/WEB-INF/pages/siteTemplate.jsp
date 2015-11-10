<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/pages/includes/tags.jsp" %>

<%-- Libs/dependences --%>
<c:url var="styles_css" value="/build/css/styles.css"/>

<%-- JS --%>
<c:url var="libs_js" value="/build/js/libs.js"/>
<c:url var="angular_rwr_app_js" value="/build/js/angular-rwr-app.js"/>

<!DOCTYPE html>
<html lang="en" ng-app="RwrApp">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Redwerk Recruiting</title>

    <link rel="stylesheet" href="${styles_css}">

</head>

<body>
<div id="wrapper">
    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="${indexURL}">Redwerk Recruiting</a>
        </div>
    </nav>

    <div id="page-wrapper" ng-view>
        <!-- views will be injected here -->
    </div>
    <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->

<%-- include scripts to footer to increase page loading --%>
<script src="${libs_js}"></script>
<script src="${angular_rwr_app_js}"></script>

</body>

</html>