<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">

<head>
<title>Fairy Tales</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<!-- VENDOR CSS -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/font-awesome.min.css">

<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/dataTables.fixedcolumns.bootstrap4.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/dataTables.fixedheader.bootstrap4.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/sweetalert.css"/>

<!-- MAIN CSS -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/main.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/color_skins.css">
<style>
    td.details-control {
    background: url('<%=request.getContextPath()%>/adminResources/images/details_open.png') no-repeat center center;
    cursor: pointer;
}
    tr.shown td.details-control {
        background: url('<%=request.getContextPath()%>/adminResources/images/details_close.png') no-repeat center center;
    }
</style>
</head>
<body class="theme-cyan">

<!-- Page Loader
<div class="page-loader-wrapper">
    <div class="loader">
        <div class="m-t-30"><img src="<%=request.getContextPath()%>/adminResources/images/logo-icon.svg" width="48" height="48" alt="Lucid"></div>
        <p>Please wait...</p>        
    </div>
</div>
Overlay For Sidebars -->

<div id="wrapper">

    
    
    
    <jsp:include page="header.jsp"></jsp:include>

    
    <jsp:include page="menu.jsp"></jsp:include>
    
    

    <div id="main-content">
        <div class="container-fluid">
            <div class="block-header">
                <div class="row">
                    <div class="col-lg-6 col-md-8 col-sm-12">
                        <h2><a href="javascript:void(0);" class="btn btn-xs btn-link btn-toggle-fullwidth">
                        <i class="fa fa-arrow-left"></i></a> View Feedback</h2>
                        <ul class="breadcrumb">
                            <li class="breadcrumb-item"><a href="index.jsp"><i class="icon-home"></i></a></li>                            
                            <li class="breadcrumb-item">Manage Feedback</li>
                            <li class="breadcrumb-item active">View Feedback</li>
                        </ul>
                    </div>            
                        </div>
            </div>
            
            <div class="row clearfix">
                <div class="col-lg-12">
                    <div class="card">
                        <div class="header">
                            <h2>View Feedback	</h2>                            
                        </div>
                        
	<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
                        <div class="body">
                            <table class="table table-bordered table-striped table-hover dataTable js-exportable">
                                <thead>
                                    <tr>
                                        <th>No</th>
                                        <th>Feedback</th>
                                        <th>Rating</th>
                                    </tr>
                                </thead>
                                <c:forEach items="${feedbackList}" var="i" varStatus="j">
                                <tbody>
                                 <tr>
                                     	<td>${j.count}</td>
                                        <td>${i.feedBack}</td>
                                        <td>${i.rating}</td>
                                       
                                     </tr>
                                </tbody>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

                    </div>
    </div>
    
</div>

<!-- Javascript -->
<script src="<%=request.getContextPath()%>/adminResources/js/libscripts.bundle.js"></script>    
<script src="<%=request.getContextPath()%>/adminResources/js/vendorscripts.bundle.js"></script>

<script src="<%=request.getContextPath()%>/adminResources/js/datatablescripts.bundle.js"></script>
<script src="<%=request.getContextPath()%>/adminResources/js/dataTables.buttons.min.js"></script>
<script src="<%=request.getContextPath()%>/adminResources/js/buttons.bootstrap4.min.js"></script>
<script src="<%=request.getContextPath()%>/adminResources/js/buttons.colVis.min.js"></script>
<script src="<%=request.getContextPath()%>/adminResources/js/buttons.html5.min.js"></script>
<script src="<%=request.getContextPath()%>/adminResources/js/buttons.print.min.js"></script>

<script src="<%=request.getContextPath()%>/adminResources/js/sweetalert.min.js"></script> <!-- SweetAlert Plugin Js --> 


<script src="<%=request.getContextPath()%>/adminResources/js/mainscripts.bundle.js"></script>
<script src="<%=request.getContextPath()%>/adminResources/js/jquery-datatable.js"></script>
</body>
</html>
