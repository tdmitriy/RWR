<%@include file="/WEB-INF/pages/includes/tags.jsp" %>

<div class="container-fluid">
    <!-- Page Heading -->
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">
                Seeker management
            </h1>
        </div>
    </div>
    <!-- /.row -->

    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><i class="fa fa-users fa-fw"></i> Seeker Panel</h3>
                </div>
                <div class="panel-body">
                    <%-- include error form --%>
                    <%--<%@include file="/WEB-INF/pages/includes/angular/errorForm.jsp" %>--%>
                    <div class="row">
                        <%-- include table for management --%>
                        <%@include file="/WEB-INF/pages/includes/angular/tableForManagement.jsp" %>
                        <%-- include seeker form --%>
                        <%@include file="/WEB-INF/pages/includes/angular/seekerForm.jsp" %>
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /.panel-body -->
            </div>
            <!-- /.panel panel-default -->
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
</div>
<!-- /.container-fluid -->
