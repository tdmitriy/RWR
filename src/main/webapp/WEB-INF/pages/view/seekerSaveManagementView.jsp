<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/pages/includes/tags.jsp" %>

<div class="container-fluid">
    <!-- Page Heading -->
    <div class="row row-centered">
        <div class="col-lg-9 col-centered">
            <h1 class="page-header">
                Add new seeker
            </h1>
        </div>
    </div>
    <!-- /.row -->

    <div class="row row-centered">
        <%-- include error form --%>
        <%--<%@include file="/WEB-INF/pages/includes/angular/errorForm.jsp" %>--%>

        <%-- include table for management --%>
        <%@include file="/WEB-INF/pages/includes/angular/seekerForm.jsp" %>
        <%-- include seeker form --%>
    </div>
    <!-- /.row -->
</div>
<!-- /.container-fluid -->
