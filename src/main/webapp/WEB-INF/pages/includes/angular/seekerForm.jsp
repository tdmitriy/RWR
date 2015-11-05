<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/pages/includes/tags.jsp" %>

<div class="col-lg-7 col-centered">
    <h4>
        <a href>
            <i class="fa fa-arrow-left fa-fw"></i>
            Back to management table
        </a>
    </h4>

    <br>

    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">
                <i class="fa fa-user fa-fw"></i> Add Seeker
            </h3>
        </div>
        <div class="panel-body">
            <fieldset>
                <form name="seekerForm" novalidate>
                    <div class="group-menu-divider">First / Last</div>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user fa-fw"></i></span>
                                    <input type="text" name="firstName" class="form-control" placeholder="First Name"
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
                                           required>

                                </div>
                                <%-- validation messages for lastName --%>
                            </div>
                        </div>
                    </div>

                    <div class="group-menu-divider">Date of addition / interview</div>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <div class=" input-group">
                                    <span class="input-group-addon"><i class="fa fa-calendar-o fa-fw"></i></span>
                                    <input name="dateOfAddition" class="form-control"
                                           placeholder="Date of addition">
                                </div>
                                <%-- validation messages for dateOA --%>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <div class=" input-group">
                                    <span class="input-group-addon"><i class="fa fa-calendar-o fa-fw"></i></span>
                                    <input name="dateOfInterview" class="form-control"
                                           placeholder="Date of interview">
                                </div>
                                <%-- validation messages for dateOI --%>
                            </div>
                        </div>
                    </div>

                    <div class="group-menu-divider">Phones / Emails</div>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">

                                <div class=" input-group">
                                    <span class="input-group-addon"><i class="fa fa-phone fa-fw"></i></span>
                                    <input name="phone1" class="form-control"
                                           placeholder="Add new phone">

                                    <div class="input-group-btn">
                                        <button type="button" class="btn btn-default btn-add-contacts">
                                            <i class="fa fa-plus fa-fw"></i>
                                        </button>
                                    </div>
                                </div>
                                <%-- validation messages for Phones --%>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <div class=" input-group">
                                    <span class="input-group-addon"><i class="fa fa-envelope-o fa-fw"></i></span>
                                    <input name="email1" class="form-control"
                                           placeholder="Add new email">

                                    <div class="input-group-btn">
                                        <button type="button" class="btn btn-default btn-add-contacts">
                                            <i class="fa fa-plus fa-fw"></i>
                                        </button>
                                    </div>
                                </div>
                                <%-- validation messages for Emails --%>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="group-menu-divider">Instant message systems (optional)</div>
                        <div class=" input-group">
                            <span class="input-group-addon"><i class="fa fa-comments-o fa-fw"></i></span>
                            <input name="ims1" class="form-control" placeholder="Add new IMS login">

                            <div class="input-group-btn">
                                <button type="button" class="btn btn-default dropdown-toggle dropdown-no-border-radius"
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
                        <%-- validation messages for Ims --%>
                    </div>

                    <div class="form-group">
                        <div class="group-menu-divider">Skills</div>
                        <div class=" input-group">
                            <span class="input-group-addon"><i class="fa fa-comments-o fa-fw"></i></span>
                            <input name="ims1" class="form-control" placeholder="Add new skill">

                            <div class="input-group-btn">
                                <button type="button" class="btn btn-default btn-add-contacts">
                                    <i class="fa fa-plus fa-fw"></i>
                                </button>
                            </div>
                        </div>
                        <%-- validation messages for skills --%>
                    </div>

                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <%-- Save btn --%>
                                <button type="button" name="btn-add-user"
                                        class="btn btn-success btn-block">
                                    <i class="fa fa-check-square-o fa-fw"></i>
                                    Add Seeker
                                </button>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <%-- Reset btn --%>
                                <button type="reset"
                                        name="btnResetUser"
                                        class="btn btn-warning btn-block">
                                    <i class="fa fa-remove fa-fw"></i> Reset
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
<!-- /.col-lg-4 -->