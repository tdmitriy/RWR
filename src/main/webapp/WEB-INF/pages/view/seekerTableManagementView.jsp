<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/pages/includes/tags.jsp" %>

<div class="container-fluid">
    <!-- Page Heading -->
    <div class="row row-centered">
        <div class="col-lg-9 col-centered">
            <h1 class="page-header">
                Seeker management
            </h1>
        </div>
    </div>
    <!-- /.row -->

    <div class="row row-centered">
        <%-- include table for management --%>
        <%@include file="/WEB-INF/pages/includes/angular/tableForManagement.jsp" %>
    </div>
    <!-- /.row -->
</div>
<!-- /.container-fluid -->
