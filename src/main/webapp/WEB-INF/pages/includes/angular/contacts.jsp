<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/pages/includes/tags.jsp" %>

<div class="group-menu-divider">First / Last</div>
<div class="row">
    <div class="col-lg-6">
        <div class="form-group" ng-class="{ 'has-error' : seekerForm.firstName.$invalid &&
                         !seekerForm.firstName.$pristine}">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-user fa-fw"></i></span>
                <input type="text" name="firstName" class="form-control" placeholder="First Name"
                       ng-pattern="/^[a-zA-Z\u0400-\u04ff]*$/"
                       ng-minlength="2" ng-maxlength="30"
                       ng-model="seeker.firstName" required>
            </div>
            <%-- validation messages for firstName --%>
            <div class="help-block"
                 ng-messages="seekerForm.firstName.$error"
                 ng-if="seekerForm.firstName.$invalid && !seekerForm.firstName.$pristine">
                <p ng-message="required">First Name is required.</p>

                <p ng-message="pattern">First Name must contains only letters.</p>

                <p ng-message="minlength">First Name is too short.</p>

                <p ng-message="maxlength">First Name is too long.</p>
            </div>
        </div>
    </div>
    <div class="col-lg-6">
        <div class="form-group" ng-class="{ 'has-error' : seekerForm.lastName.$invalid &&
                         !seekerForm.lastName.$pristine }">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-user fa-fw"></i></span>
                <input type="text" name="lastName" class="form-control" placeholder="Last Name"
                       ng-pattern="/^[a-zA-Z\u0400-\u04ff]*$/"
                       ng-minlength="2" ng-maxlength="30"
                       ng-model="seeker.lastName" required>
            </div>
            <%-- validation messages for lastName --%>
            <div class="help-block"
                 ng-messages="seekerForm.lastName.$error"
                 ng-if="seekerForm.lastName.$invalid &&
                                                 !seekerForm.lastName.$pristine">
                <p ng-message="required">Last Name is required.</p>

                <p ng-message="pattern">Last Name must contains only letters.</p>

                <p ng-message="minlength">Last Name is too short.</p>

                <p ng-message="maxlength">Last Name is too long.</p>
            </div>
        </div>
    </div>
</div>

<div class="group-menu-divider">Date of addition / interview</div>
<div class="row" ng-controller="formItemsController">
    <div class="col-lg-6">
        <div class="form-group" ng-class="{ 'has-error' : seekerForm.dateOfAddition.$invalid &&
                         !seekerForm.dateOfAddition.$pristine }">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-calendar-o fa-fw"></i></span>
                <input id="dateOfAddition" name="dateOfAddition" type="text" class="form-control"
                       placeholder="Date of addition"
                       ng-model="seeker.dateOfAddition" uib-datepicker-popup="{{ date.format }}"
                       is-open="date.isOpenedDateOfAddition" ng-click="openDateOfAddition($event)"
                       close-text="Close" required/>
            </div>
            <%-- validation messages for dateOA --%>
            <div class="help-block"
                 ng-messages="seekerForm.dateOfAddition.$error"
                 ng-if="seekerForm.dateOfAddition.$invalid &&
                                                 !seekerForm.dateOfAddition.$pristine">
                <p ng-message="required">Date of addition is required.</p>
            </div>
        </div>
    </div>
    <div class="col-lg-6">
        <div class="form-group">
            <div class=" input-group">
                <span class="input-group-addon"><i class="fa fa-calendar-o fa-fw"></i></span>
                <input id="dateOfInterview" name="dateOfInterview" type="text" class="form-control"
                       placeholder="Date of interview"
                       ng-model="seeker.dateOfInterview"
                       uib-datepicker-popup="{{ date.format }}"
                       is-open="date.isOpenedDateOfInterview" ng-click="openDateOfInterview($event)"
                       close-text="Close"/>
            </div>
            <%-- validation messages for dateOI --%>
        </div>
    </div>
</div>

<div class="group-menu-divider">Phones / Emails</div>
<div class="row">

    <%-- Phones --%>
    <div class="col-lg-6">
        <div class="form-group" ng-class="{ 'has-error' : seekerForm.seekerPhone.$invalid &&
                         !seekerForm.seekerPhone.$pristine || seeker.contacts.seekerPhones.length < 1 }">
            <div class=" input-group">
                <span class="input-group-addon"><i class="fa fa-phone fa-fw"></i></span>
                <input name="seekerPhone" class="form-control" ng-model="inputFields.phoneField"
                       ng-maxlength="15"
                       placeholder="Add new phone">

                <div class="input-group-btn">
                    <button type="button" class="btn btn-default btn-add-contacts"
                            ng-click="addPhoneToSeeker(inputFields.phoneField)">
                        <i class="fa fa-plus fa-fw"></i>
                    </button>
                </div>

            </div>

            <%-- validation messages for phone --%>
            <div class="help-block"
                 ng-messages="seekerForm.seekerPhone.$error"
                 ng-if="seekerForm.seekerPhone.$invalid && !seekerForm.seekerPhone.$pristine ||
                 seeker.contacts.seekerPhones.length < 1">
                <p>At least one phone number is required.</p>

                <p ng-message="maxlength">Phone number is too long.</p>
            </div>

            <div class="input-group list-item-management">
                <ul class="list-group">
                    <li class="list-group-item li-hovered"
                        ng-repeat="seekerPhone in seeker.contacts.seekerPhones">
                        {{ seekerPhone.phoneNumber }}
                        <a href class="btn-management-delete-red" ng-click="deletePhone($index)">
                            <i class="fa fa-times fa-fw pull-right"></i>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <%-- Emails --%>
    <div class="col-lg-6">
        <div class="form-group" ng-class="{ 'has-error' : seekerForm.seekerEmail.$invalid &&
                         !seekerForm.seekerEmail.$pristine || seeker.contacts.seekerEmails.length < 1 }">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-envelope-o fa-fw"></i></span>
                <input name="seekerEmail" class="form-control" ng-model="inputFields.emailField"
                       min-length="5"
                       placeholder="Add new email">

                <div class="input-group-btn">
                    <button type="button" class="btn btn-default btn-add-contacts"
                            ng-click="addEmailToSeeker(inputFields.emailField)">
                        <i class="fa fa-plus fa-fw"></i>
                    </button>
                </div>
            </div>
            <%-- validation messages for Emails --%>
            <div class="help-block"
                 ng-messages="seekerForm.seekerPhone.$error"
                 ng-if="seekerForm.seekerEmail.$invalid && !seekerForm.seekerEmail.$pristine ||
                 seeker.contacts.seekerEmails.length < 1">
                <p>At least one email is required.</p>

                <p ng-message="minlength">Email is too short.</p>
            </div>

            <div class="input-group list-item-management">
                <ul class="list-group">
                    <li class="list-group-item li-hovered" ng-repeat="seekerEmail in seeker.contacts.seekerEmails">
                        {{ seekerEmail.email }}
                        <a href class="btn-management-delete-red" ng-click="deleteEmail($index)">
                            <i class="fa fa-times fa-fw pull-right"></i>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>

<%-- IMS --%>
<div class="row row-centered" ng-controller="formItemsController">
    <div class="col-lg-8 col-centered">
        <div class="form-group">
            <div class="group-menu-divider">Instant message systems (optional)</div>
            <div class=" input-group">
                <span class="input-group-addon"><i class="fa fa-comments-o fa-fw"></i></span>
                <input name="seekerImsLogin" class="form-control" ng-model="inputFields.imsField"
                       placeholder="Add new IMS login">

                <div class="input-group-btn" uib-dropdown>
                    <button id="dropDownIms" type="button"
                            class="btn btn-default dropdown-toggle dropdown-no-border-radius"
                            uib-dropdown-toggle>
                        {{ imsType.typeName || 'Select type' }} <span class="caret"></span>
                    </button>
                    <ul class="uib-dropdown-menu" role="menu" aria-labelledby="dropDownIms">
                        <li role="menuitem" ng-repeat="ims in imsTypes">
                            <a href ng-click="selectedImsType(ims)">{{ ims.typeName }}</a>
                        </li>
                    </ul>
                    <button type="button" class="btn btn-default btn-add-contacts"
                            ng-click="addImsToSeeker(inputFields.imsField)">
                        <i class="fa fa-plus fa-fw"></i>
                    </button>
                </div>
            </div>
            <div class="input-group list-item-management">
                <ul class="list-group">
                    <li class="list-group-item li-hovered" ng-repeat="seekerIms in seeker.contacts.seekerIms">
                        {{ seekerIms.imsType.typeName + ': ' + seekerIms.imsLogin }}

                        <a href class="btn-management-delete-red" ng-click="deleteIms($index)">
                            <i class="fa fa-times fa-fw pull-right"></i>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
        <%-- validation messages for Ims --%>
    </div>
</div>