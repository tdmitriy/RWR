<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/pages/includes/tags.jsp" %>

<fieldset>
    <form name="searchForm" novalidate>
        <div class="form-group">
            <div class="input-group">
                <input type="text" class="form-control"
                       name="criteria"
                       placeholder="Search user..." required>
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button">
                            <i class="fa fa-search fa-fw"></i> search
                        </button>
                        <button class="btn btn-default" type="reset">
                            <i class="fa fa-remove fa-fw"></i> clear
                        </button>
                    </span>
            </div>
            <%-- validation messages --%>
            <%--<div class="help-block"
                 ng-messages="searchForm.criteria.$error"
                 ng-show="searchForm.criteria.$invalid &&
                                                 !searchForm.criteria.$pristine">
                <p ng-message="required">Search criteria is required.</p>

                <p ng-message="maxlength">Your search criteria is too long.</p>
            </div>--%>
        </div>
    </form>
</fieldset>