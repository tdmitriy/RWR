<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/pages/includes/tags.jsp" %>

<fieldset>
    <form name="searchForm" novalidate>
        <div class="form-group">
            <div class="input-group">
                <input type="text" class="form-control"
                       name="criteria"
                       ng-model="searchKeyword" ng-model-options="{debounce: 300}"
                       placeholder="Search user..." required>
                    <span class="input-group-btn">
                        <%--<button class="btn btn-default" type="button">
                            <i class="fa fa-search fa-fw"></i> search
                        </button>--%>
                        <button class="btn btn-default" ng-click="searchKeyword = null" type="reset">
                            <i class="fa fa-remove fa-fw"></i> clear
                        </button>
                    </span>
            </div>
        </div>
    </form>
</fieldset>