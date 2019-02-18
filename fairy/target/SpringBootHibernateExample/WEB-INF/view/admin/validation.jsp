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
                        <h2><a href="javascript:void(0);" class="btn btn-xs btn-link btn-toggle-fullwidth"><i class="fa fa-arrow-left"></i></a> Form Validation</h2>
                        <ul class="breadcrumb">
                            <li class="breadcrumb-item"><a href="index.html"><i class="icon-home"></i></a></li>                            
                            <li class="breadcrumb-item">Forms</li>
                            <li class="breadcrumb-item active">Form Validation</li>
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
                            <h2>Basic Validation</h2>
                        </div>
                        <div class="body">
                            <form id="basic-form" method="post" novalidate>
                                <div class="form-group">
                                    <label>Text Input</label>
                                    <input type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Email Input</label>
                                    <input type="email" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Text Area</label>
                                    <textarea class="form-control" rows="5" cols="30" required></textarea>
                                </div>
                                <div class="form-group">
                                    <label>Checkbox</label>
                                    <br/>
                                    <label class="fancy-checkbox">
                                        <input type="checkbox" name="checkbox" required data-parsley-errors-container="#error-checkbox">
                                        <span>Option 1</span>
                                    </label>
                                    <label class="fancy-checkbox">
                                        <input type="checkbox" name="checkbox">
                                        <span>Option 2</span>
                                    </label>
                                    <label class="fancy-checkbox">
                                        <input type="checkbox" name="checkbox">
                                        <span>Option 3</span>
                                    </label>
                                    <p id="error-checkbox"></p>
                                </div>
                                <div class="form-group">
                                    <label>Radio Button</label>
                                    <br />
                                    <label class="fancy-radio">
                                        <input type="radio" name="gender" value="male" required data-parsley-errors-container="#error-radio">
                                        <span><i></i>Male</span>
                                    </label>
                                    <label class="fancy-radio">
                                        <input type="radio" name="gender" value="female">
                                        <span><i></i>Female</span>
                                    </label>
                                    <p id="error-radio"></p>
                                </div>
                                <div class="form-group">
                                    <label for="food">Multiselect</label>
                                    <br/>
                                    <select id="food" name="food[]" class="multiselect multiselect-custom" multiple="multiple" data-parsley-required data-parsley-trigger-after-failure="change" data-parsley-errors-container="#error-multiselect">
                                        <option value="cheese">Cheese</option>
                                        <option value="tomatoes">Tomatoes</option>
                                        <option value="mozarella">Mozzarella</option>
                                        <option value="mushrooms">Mushrooms</option>
                                        <option value="pepperoni">Pepperoni</option>
                                        <option value="onions">Onions</option>
                                    </select>
                                    <p id="error-multiselect"></p>
                                </div>
                                <br>
                                <button type="submit" class="btn btn-primary">Validate</button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="card">
                        <div class="header">
                            <h2>Advanced Validation</h2>
                        </div>
                        <div class="body">
                            <form id="advanced-form" data-parsley-validate novalidate>
                                <div class="form-group">
                                    <label for="text-input1">Min. 8 Characters</label>
                                    <input type="text" id="text-input1" class="form-control" required data-parsley-minlength="8">
                                </div>
                                <div class="form-group">
                                    <label for="text-input2">Between 5-10 Characters</label>
                                    <input type="text" id="text-input2" class="form-control" required data-parsley-length="[5,10]">
                                </div>
                                <div class="form-group">
                                    <label for="text-input3">Min. Number ( >= 5 )</label>
                                    <input type="text" id="text-input3" class="form-control" required data-parsley-min="5">
                                </div>
                                <div class="form-group">
                                    <label for="text-input4">Between 20-30</label>
                                    <input type="text" id="text-input4" class="form-control" required data-parsley-range="[20,30]">
                                </div>
                                <div class="form-group">
                                    <label>Select Min. 2 Options</label>
                                    <br />
                                    <label class="control-inline fancy-checkbox">
                                        <input type="checkbox" name="checkbox2" required data-parsley-mincheck="2" data-parsley-errors-container="#error-checkbox2">
                                        <span>Option 1</span>
                                    </label>
                                    <label class="control-inline fancy-checkbox">
                                        <input type="checkbox" name="checkbox2">
                                        <span>Option 2</span>
                                    </label>
                                    <label class="control-inline fancy-checkbox">
                                        <input type="checkbox" name="checkbox2">
                                        <span>Option 3</span>
                                    </label>
                                    <p id="error-checkbox2"></p>
                                </div>
                                <div class="form-group">
                                    <label>Select Between 1-2 Options</label>
                                    <br />
                                    <label class="control-inline fancy-checkbox">
                                        <input type="checkbox" name="checkbox3" required data-parsley-check="[1,2]" data-parsley-errors-container="#error-checkbox3">
                                        <span>Option 1</span>
                                    </label>
                                    <label class="control-inline fancy-checkbox">
                                        <input type="checkbox" name="checkbox3">
                                        <span>Option 2</span>
                                    </label>
                                    <label class="control-inline fancy-checkbox">
                                        <input type="checkbox" name="checkbox3">
                                        <span>Option 3</span>
                                    </label>
                                    <p id="error-checkbox3"></p>
                                </div>
                                <br/>
                                <button type="submit" class="btn btn-primary">Validate</button>
                            </form>
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

    