<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/pages/includes/tags.jsp" %>

<div class="row row-centered">
    <div class="col-lg-8 col-centered">
        <div class="form-group">
            <div class="group-menu-divider">Skills</div>
            <div class=" input-group">
                <span class="input-group-addon"><i class="fa fa-check-circle fa-fw"></i></span>
                <input name="skillField" class="form-control" placeholder="Add new skill"
                       ng-model="inputFields.skillField">

                <div class="input-group-btn">
                    <button type="button"
                            class="btn btn-default dropdown-toggle dropdown-no-border-radius"
                            data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false"> Select skill
                        <span class="caret"></span>
                        <span class="sr-only">Toggle Dropdown</span>
                    </button>
                    <ul class="dropdown-menu dropdown-menu-right">
                        <li><a href="#">Java</a></li>
                        <li><a href="#">C#</a></li>
                        <li><a href="#">Python</a></li>
                    </ul>
                    <button type="button" class="btn btn-default btn-add-contacts">
                        <i class="fa fa-plus fa-fw"></i>
                    </button>
                </div>
            </div>
            <div class="input-group list-item-management">
                <ul class="list-group">
                    <li class="list-group-item li-hovered" ng-repeat="seekerSkill in seeker.seekerSkills">
                        {{ seekerSkill }}
                        <div class="pull-right">
                            <uib-rating ng-model="seekerSkill.skillRating || rate.rateDefault" max="rate.rateMax"
                                        readonly="rate.isReadonly"
                                        state-on="'glyphicon-ok-sign'"
                                        state-off="'glyphicon-ok-circle'"
                                        aria-labelledby="default-rating">

                            </uib-rating>
                            <b>(<i>Rating:</i> {{ seekerSkill.skillRating }})</b>
                            <a href class="btn-management-delete-red">
                                <i class="fa fa-times fa-fw pull-right"></i>
                            </a>
                        </div>
                    </li>
                </ul>
            </div>
            <%-- validation messages for skills --%>
        </div>
    </div>
</div>