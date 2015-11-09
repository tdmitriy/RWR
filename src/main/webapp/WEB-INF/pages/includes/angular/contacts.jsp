<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/pages/includes/tags.jsp" %>

<div class="group-menu-divider">First / Last</div>
<div class="row">
    <div class="col-lg-6">
        <div class="form-group">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-user fa-fw"></i></span>
                <input type="text" name="firstName" class="form-control" placeholder="First Name"
                       ng-pattern="/^[a-zA-Z\u0400-\u04ff]*$/"
                       ng-minlength="2" ng-maxlength="30"
                       ng-model="seeker.firstName"
                       required>
            </div>
            <%-- validation messages for firstName --%>
        </div>
    </div>
    <div class="col-lg-6">
        <div class="form-group">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-user fa-fw"></i></span>
                <input type="text" name="lastName" class="form-control" placeholder="Last Name"
                       ng-pattern="/^[a-zA-Z\u0400-\u04ff]*$/"
                       ng-minlength="2" ng-maxlength="30"
                       ng-model="seeker.lastName" required>

            </div>
            <%-- validation messages for lastName --%>
        </div>
    </div>
</div>

<div class="group-menu-divider">Date of addition / interview</div>
<div class="row">
    <div class="col-lg-6">
        <div class="form-group">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-calendar-o fa-fw"></i></span>
                <input id="dateOfAddition" name="dateOfAddition" type="text" class="form-control"
                       placeholder="Date of addition"
                       ng-model="seeker.dateOfAddition"
                       uib-datepicker-popup="{{ date.format }}" ng-model="date.dateOfAddition"
                       is-open="date.isOpenedDateOfAddition" ng-click="openDateOfAddition($event)"
                       close-text="Close"/>
            </div>
            <%-- validation messages for dateOA --%>
        </div>
    </div>
    <div class="col-lg-6">
        <div class="form-group">
            <div class=" input-group">
                <span class="input-group-addon"><i class="fa fa-calendar-o fa-fw"></i></span>
                <input id="dateOfInterview" name="dateOfInterview" type="text" class="form-control"
                       placeholder="Date of interview"
                       ng-model="seeker.dateOfInterview"
                       uib-datepicker-popup="{{ date.format }}" ng-model="date.dateOfInterview"
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
        <div class="form-group">
            <div class=" input-group">
                <span class="input-group-addon"><i class="fa fa-phone fa-fw"></i></span>
                <input name="phone1" class="form-control" ng-model="inputFields.phoneField"
                       placeholder="Add new phone">

                <div class="input-group-btn">
                    <button type="button" class="btn btn-default btn-add-contacts"
                            ng-click="addPhoneToSeeker(inputFields.phoneField)">
                        <i class="fa fa-plus fa-fw"></i>
                    </button>
                </div>

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
            <%-- validation messages for Phones --%>
        </div>
    </div>

    <%-- Emails --%>
    <div class="col-lg-6">
        <div class="form-group">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-envelope-o fa-fw"></i></span>
                <input name="email1" class="form-control" ng-model="inputFields.emailField"
                       placeholder="Add new email">

                <div class="input-group-btn">
                    <button type="button" class="btn btn-default btn-add-contacts"
                            ng-click="addEmailToSeeker(inputFields.emailField)">
                        <i class="fa fa-plus fa-fw"></i>
                    </button>
                </div>
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
            <%-- validation messages for Emails --%>
        </div>
    </div>
</div>

<%-- IMS --%>
<div class="row row-centered">
    <div class="col-lg-8 col-centered">
        <div class="form-group">
            <div class="group-menu-divider">Instant message systems (optional)</div>
            <div class=" input-group">
                <span class="input-group-addon"><i class="fa fa-comments-o fa-fw"></i></span>
                <input name="ims" class="form-control" ng-model="inputFields.imsField"
                       placeholder="Add new IMS login">

                <div class="input-group-btn">
                    <button type="button"
                            class="btn btn-default dropdown-toggle dropdown-no-border-radius"
                            data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false"> Select type
                        <span class="caret"></span>
                        <span class="sr-only">Toggle Dropdown</span>
                    </button>
                    <ul class="dropdown-menu dropdown-menu-right">
                        <li><a href="#">IMS</a></li>
                        <li><a href="#">MSN</a></li>
                        <li><a href="#">Jabber</a></li>
                    </ul>
                    <button type="button" class="btn btn-default btn-add-contacts">
                        <i class="fa fa-plus fa-fw"></i>
                    </button>
                </div>
            </div>
            <div class="input-group list-item-management">
                <ul class="list-group">
                    <li class="list-group-item li-hovered" ng-repeat="seekerIms in seeker.contacts.seekerIms">
                        {{ seekerIms }}

                        <a href class="btn-management-delete-red">
                            <i class="fa fa-times fa-fw pull-right"></i>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
        <%-- validation messages for Ims --%>
    </div>
</div>