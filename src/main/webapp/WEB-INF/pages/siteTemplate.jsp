<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/pages/includes/tags.jsp" %>

<%-- Libs/dependences --%>
<c:url var="font_awesome_css" value="/libs/font-awesome/css/font-awesome.min.css"/>
<c:url var="bootstrap_css" value="/libs/css/bootstrap.min.css"/>
<c:url var="angular_loading_bar_css" value="/libs/css/angular-loading-bar.css"/>
<c:url var="angular_ui_notification_css" value="/libs/css/angular-ui-notification.min.css"/>
<c:url var="custom_css" value="/css/custom.css"/>

<%-- JS --%>
<c:url var="jquery_js" value="/libs/jquery.min.js"/>
<c:url var="bootstrap_js" value="/libs/bootstrap.min.js"/>
<c:url var="angular_js" value="/libs/angular.min.js"/>
<c:url var="angular_route_js" value="/libs/dependencies/angular-route.min.js"/>
<c:url var="angular_modal_js" value="/libs/dependencies/angular-modal-service.min.js"/>
<c:url var="angular_loading_bar_js" value="/libs/dependencies/angular-loading-bar.min.js"/>
<c:url var="angular_notification_js" value="/libs/dependencies/angular-ui-notification.min.js"/>
<c:url var="angular_messages_js" value="/libs/dependencies/angular-messages.min.js"/>
<c:url var="angular_animate_js" value="/libs/dependencies/angular-animate.min.js"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Redwerk Recruiting</title>

    <link rel="stylesheet" href="${bootstrap_css}">
    <link rel="stylesheet" href="${angular_loading_bar_css}">
    <link rel="stylesheet" href="${angular_ui_notification_css}">
    <link rel="stylesheet" href="${font_awesome_css}">
    <link rel="stylesheet" href="${custom_css}">

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

    <div id="page-wrapper">
        <%@include file="/WEB-INF/pages/view/seekerSaveManagementView.jsp" %>
    </div>
    <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->

<%-- include scripts to footer to increase page loading --%>

<!-- jQuery -->
<script src="${jquery_js}"></script>

<!-- Bootstrap Core JS -->
<script src="${bootstrap_js}"></script>

<!-- AngularJS, AngularRoute, Modal, LoadingBar -->
<script src="${angular_js}"></script>
<script src="${angular_animate_js}"></script>
<script src="${angular_route_js}"></script>
<script src="${angular_modal_js}"></script>
<script src="${angular_loading_bar_js}"></script>
<script src="${angular_notification_js}"></script>
<script src="${angular_messages_js}"></script>

</body>

</html>