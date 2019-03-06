<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">

<head>
<title>:: Lucid Hospital :: Form Validation</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta name="description" content="Lucid Bootstrap 4.1.1 Admin Template">
<meta name="author" content="WrapTheme, design by: ThemeMakker.com">

<link rel="icon" href="favicon.ico" type="image/x-icon">
<!-- VENDOR CSS -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/font-awesome.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/bootstrap-multiselect.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/parsley.css">

<!-- MAIN CSS -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/main.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/color_skins.css">
</head>
<body class="theme-cyan">

<!-- Page Loader -->
<div class="page-loader-wrapper">
    <div class="loader">
        <div class="m-t-30"><img src="<%=request.getContextPath()%>/adminResources/image/logo-icon.svg" width="48" height="48" alt="Lucid"></div>
        <p>Please wait...</p>        
    </div>
</div>
<!-- Overlay For Sidebars -->

<div id="wrapper">

   
    <jsp:include page="header.jsp"></jsp:include>
    <jsp:include page="menu.jsp"></jsp:include>
    
    
    
    <div id="main-content">
        <div class="container-fluid">
            <div class="block-header">
                <div class="row">
                    <div class="col-lg-6 col-md-8 col-sm-12">
                        <h2><a href="javascript:void(0);" class="btn btn-xs btn-link btn-toggle-fullwidth"><i class="fa fa-arrow-left"></i></a> Manage Reply</h2>
                        <ul class="breadcrumb">
                            <li class="breadcrumb-item"><a href="index.html"><i class="icon-home"></i></a></li>                            
                            <li class="breadcrumb-item">Manage Reply</li>
                            <li class="breadcrumb-item active">Add Reply</li>
                        </ul>
                    </div>            
                    <div class="col-lg-6 col-md-4 col-sm-12 text-right">
                        <div class="bh_chart hidden-xs">
                            <div class="float-left m-r-15">
                                <small>Visitors</small>
                                <h6 class="mb-0 mt-1"><i class="icon-user"></i> 1,784</h6>
                            </div>
                            <span class="bh_visitors float-right">2,5,1,8,3,6,7,5</span>
                        </div>
                        <div class="bh_chart hidden-sm">
                            <div class="float-left m-r-15">
                                <small>Visits</small>
                                <h6 class="mb-0 mt-1"><i class="icon-globe"></i> 325</h6>
                            </div>
                            <span class="bh_visits float-right">10,8,9,3,5,8,5</span>
                        </div>
                        <div class="bh_chart hidden-sm">
                            <div class="float-left m-r-15">
                                <small>Chats</small>
                                <h6 class="mb-0 mt-1"><i class="icon-bubbles"></i> 13</h6>
                            </div>
                            <span class="bh_chats float-right">1,8,5,6,2,4,3,2</span>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row clearfix">
                <div class="col-md-12">
                    <div class="card">
                        <div class="header">
                            <h2>Reply Details</h2>
                        </div>
                        
 			<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
 			<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
                        <div class="body">
                            <f:form id="basic-form" method="post"  action="insertReply" modelAttribute="complaintVO" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label>Complaint Subject</label>
                                    <f:input type="text" class="form-control" path="complaintSubject"  readonly="readonly"/>
                                </div>
                                
                                <div class="form-group">
                                    <label>Complaint Description</label>
                                    <f:textarea class="form-control" rows="5" cols="30" path="complaintDescription" readonly="readonly"></f:textarea>
                                </div>
                                <div class="form-group">
                                    <label>Reply</label>
                                       <div>
                                          <f:textarea path="reply" required="required" class="form-control" rows="5"></f:textarea>                                                           
                                       
                                               <f:hidden path="id"/>
                                               <f:hidden path="complaintFileName"/>
                                               <f:hidden path="complaintFilePath"/>
                                               <f:hidden path="loginVO.loginId"/>
                                               <f:hidden path="status"/>
                                               <f:hidden path="complaintDate"/>
                                               <f:hidden path="complaintStatus"/>
                                        </div>
                                 </div>
                                
                                <f:hidden path="id"/>
                                <br>
                                <button type="submit" class="btn btn-primary">Save</button>
                                <button type="reset" class="btn btn-primary">Reset</button>
                            </f:form>
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

<script src="<%=request.getContextPath()%>/adminResources/js/bootstrap-multiselect.js"></script>
<script src="<%=request.getContextPath()%>/adminResources/js/parsley.min.js"></script>
    
<script src="<%=request.getContextPath()%>/adminResources/js/mainscripts.bundle.js"></script>
<script>
    $(function() {
        // validation needs name of the element
        $('#food').multiselect();

        // initialize after multiselect
        $('#basic-form').parsley();
    });
    </script>
</body>
</html>

    