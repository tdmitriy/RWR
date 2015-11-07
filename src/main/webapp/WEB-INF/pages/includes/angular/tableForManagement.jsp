<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/pages/includes/tags.jsp" %>

<div class="col-lg-9 col-centered">
    <div class="panel panel-default">
        <div class="panel-heading clearfix">
            <h3 class="panel-title pull-left"><i class="fa fa-table fa-fw"></i> Table</h3>

            <div class="refresh-table pull-left">
                <button class="btn btn-primary btn-xs"
                        title="Refresh table">
                    <i class="fa fa-refresh fa-fw"></i>
                </button>
            </div>

            <div class="btn-group pull-right">
                <div class="btn-group-xs">
                    <button class="btn btn-success btn-xs ng-fade"
                            title="Add new seeker">
                        <i class="fa fa-plus fa-fw"></i>
                        Add new seeker
                    </button>
                </div>
            </div>
        </div>

        <div class="panel-body">

            <%-- include search form --%>
            <%@include file="/WEB-INF/pages/includes/angular/searchForm.jsp" %>

            <%-- include loading spinner --%>

            <%--<div class="alert alert-info ng-fade">
                <i class="fa fa-database"></i> No users found
            </div>--%>

            <div class="table-responsive" ng-controller="pageableController">
                <table class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>First name</th>
                        <th>Last name</th>
                        <th>Date of addition</th>
                        <th>Top skill#1</th>
                        <th>Top skill#2</th>
                        <th>Top skill#3</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="seeker in seekersPageable.collection">
                        <td>{{ seeker.firstName }}</td>
                        <td>{{ seeker.lastName }}</td>
                        <td>{{ seeker.dateOfAddition }}</td>
                        <td>
                            {{ seeker.seekerSkills[0].skillType.skillName || 'Not Set' }}
                            <span ng-show="seeker.seekerSkills[0].skillRating !== undefined">
                                {{ '(' + seeker.seekerSkills[0].skillRating + ')' }}
                            </span>

                        </td>
                        <td>
                            {{ seeker.seekerSkills[1].skillType.skillName || 'Not Set' }}
                            <span ng-show="seeker.seekerSkills[1].skillRating !== undefined">
                                {{ '(' + seeker.seekerSkills[1].skillRating + ')' }}
                            </span>
                        </td>
                        <td>
                            {{ seeker.seekerSkills[2].skillType.skillName || 'Not Set' }}
                            <span ng-show="seeker.seekerSkills[2].skillRating !== undefined">
                                {{ '(' + seeker.seekerSkills[2].skillRating + ')' }}
                            </span>
                        </td>
                        <td class="text-center">
                            <button type="button" class="btn btn-danger btn-xs"
                                    title="Delete">
                                <i class="fa fa-trash-o fa-fw"></i>
                            </button>
                            <button type="button" class="btn btn-primary btn-xs"
                                    title="Edit">
                                <i class="fa fa-pencil fa-fw"></i>
                            </button>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <div class="text-center">
                    <uib-pagination total-items="page.maxTotalItems" ng-model="page.currentPage"
                                    items-per-page="page.itemsPerPage" ng-change="pageChanged()"
                                    max-size="page.maxSize" class="pagination-sm"
                                    boundary-links="true"></uib-pagination>
                </div>
            </div>
            <!-- /.table-responsive -->
        </div>
        <!-- /.panel-body -->
    </div>
    <!-- /.panel panel-default -->
</div>
<!-- /.col-lg-9 -->