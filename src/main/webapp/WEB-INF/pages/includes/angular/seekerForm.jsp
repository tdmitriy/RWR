<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/pages/includes/tags.jsp" %>

<div class="col-lg-6 col-centered">
    <h4>
        <a href ng-click="backToTable()">
            <i class="fa fa-arrow-left fa-fw"></i>
            Back to management table
        </a>
    </h4>

    <br>

    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">
                <i class="fa fa-user fa-fw"></i> {{ editableMode ? 'Edit Seeker' : 'Add Seeker' }}
            </h3>
        </div>
        <div class="panel-body">
            <%-- include error form --%>
            <%@include file="/WEB-INF/pages/includes/angular/errorForm.jsp" %>

            <fieldset>
                <form name="seekerForm" novalidate>

                    <%@include file="/WEB-INF/pages/includes/angular/contacts.jsp" %>

                    <%@include file="/WEB-INF/pages/includes/angular/skills.jsp" %>

                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <%-- Save btn --%>
                                <button type="button" name="btnAddSeeker"
                                        ng-click="saveSeeker(seekerUpdatable)"
                                        ng-disabled="seekerForm.$invalid || seekerUpdatable.seekerSkills.length < 1"
                                        ng-class="{'btn btn-success btn-block' : !editableMode,
                                        'btn btn-primary btn-block' : editableMode}">
                                    <i class="fa fa-check-square-o fa-fw"></i>
                                    {{ editableMode ? 'Edit Seeker' : 'Add Seeker' }}
                                </button>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <%-- Reset btn --%>
                                <button type="reset"
                                        name="btnResetSeeker"
                                        ng-click="editableMode ? backToTable() : resetSeekerModel()"
                                        class="btn btn-warning btn-block">
                                    <i class="fa fa-remove fa-fw"></i> {{ editableMode ? 'Cancel' : 'Reset' }}
                                </button>
                            </div>
                        </div>
                    </div>
                    <%-- /.row --%>
                </form>
            </fieldset>
        </div>
        <%-- /.panel-body --%>
    </div>
    <%-- /.panel --%>
</div>
<!-- /.col-lg-6 -->