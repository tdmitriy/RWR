<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/pages/includes/tags.jsp" %>

<div class="row row-centered">
    <div class="col-lg-8 col-centered">
        <div class="group-menu-divider">Skills</div>
        <div class="form-group">
            <div class="input-group-btn" uib-dropdown>
                <button id="dropDownSkills" type="button"
                        class="btn btn-default" uib-dropdown-toggle>
                    {{ skillType.skillName || 'Select from skill types' }} <span class="caret"></span>
                </button>
                <ul class="uib-dropdown-menu" role="menu" aria-labelledby="dropDownSkills">
                    <li role="menuitem" ng-repeat="skill in skillTypes">
                        <a href ng-click="selectedSkillType(skill)">{{ skill.skillName }}</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="form-group" ng-class="{ 'has-error' : seekerForm.skillName.$invalid &&
                         !seekerForm.skillName.$pristine || seekerUpdatable.seekerSkills.length < 1 }">
            <label for="skillName">Skill name:</label>
            <input id="skillName" name="skillName" class="form-control" ng-model="inputFields.skillField"
                   ng-minlength="1" ng-maxlength="10"
                   placeholder="Skill name">
            <%-- validation messages for skills --%>
            <div class="help-block"
                 ng-messages="seekerForm.dateOfAddition.$error"
                 ng-if="seekerForm.skillName.$invalid && !seekerForm.skillName.$pristine ||
                 seekerUpdatable.seekerSkills.length < 1">
                <p ng-if="seekerUpdatable.seekerSkills.length < 1">At least one skill is required.</p>

                <p ng-message="maxlength">Skill name is too long.</p>
            </div>
        </div>
        <div class="form-group" ng-class="{ 'has-error' : seekerForm.skillRating.$invalid &&
                         !seekerForm.skillRating.$pristine || inputFields.skillRatingField < 1 }">
            <label for="skillRating">Skill rating (1-10):</label>
            <input type="number" id="skillRating" name="skillRating" class="form-control"
                   ng-model="inputFields.skillRatingField"
                   max="10"
                   placeholder="Skill rating">

            <div class="help-block"
                 ng-messages="seekerForm.skillRating.$error"
                 ng-if="seekerForm.skillRating.$invalid && !seekerForm.skillRating.$pristine ||
                 inputFields.skillRatingField < 1">
                <p ng-if="inputFields.skillRatingField < 1">Min value is 1.</p>

                <p ng-message="max">Max value is 10.</p>
            </div>
            <br>
            <button type="button" class="btn btn-primary"
                    ng-disabled="seekerForm.skillName.$invalid ||
                    seekerForm.skillRating.$invalid || inputFields.skillRatingField < 1"
                    ng-click="addSkillToSeeker(inputFields.skillField)">
                Add skill
            </button>
        </div>

        <div class="input-group list-item-management">
            <ul class="list-group">
                <li class="list-group-item li-hovered" ng-repeat="seekerSkill in seekerUpdatable.seekerSkills">
                    {{ seekerSkill.skillType.skillName + ' (' + seekerSkill.skillRating + ')' }}
                    <div class="pull-right">
                        <a href ng-click="deleteSkill($index)" class="btn-management-delete-red">
                            <i class="fa fa-times fa-fw pull-right"></i>
                        </a>
                    </div>
                </li>
            </ul>
        </div>

    </div>
</div>