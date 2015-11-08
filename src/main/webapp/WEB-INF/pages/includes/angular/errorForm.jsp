<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/pages/includes/tags.jsp" %>

<div class="alert alert-danger alert-dismissible ng-fade" role="alert" ng-show="isError()">
    <button type="button" class="close" ng-click="resetErrors()" aria-label="Close">
        <span aria-hidden="true">&times;</span>
    </button>

    <h5><i class="fa fa-exclamation-circle"></i> {{ getErrors().title }}</h5>
    <ul>
        <li ng-repeat="errorMessage in getErrors().messages">
            {{ errorMessage }}
        </li>
    </ul>
</div>