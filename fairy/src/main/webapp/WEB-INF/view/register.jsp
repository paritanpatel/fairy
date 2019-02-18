<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">

<head>
<title>:: Lucid Hospital :: Login</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta name="description" content="Lucid Bootstrap 4.1.1 Admin Template">
<meta name="author" content="WrapTheme, design by: ThemeMakker.com">

<link rel="icon" href="favicon.ico" type="image/x-icon">
<!-- VENDOR CSS -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/font-awesome.min.css">

<!-- MAIN CSS -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/main.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/color_skins.css">
</head>

<body class="theme-cyan">
	<!-- WRAPPER -->
	<div id="wrapper">
		<div class="vertical-align-wrap">
			<div class="vertical-align-middle auth-main">
				<div class="auth-box">
                    <div class="top">
                        <img src="<%=request.getContextPath()%>/adminResources/image/logo-white.svg" alt="Lucid">
                    </div>
					<div class="card">
                        <div class="header">
                            <p class="lead">Login to your account</p>
                        </div>
                        <div class="body">
                        <%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
                            <f:form class="form-auth-small" action="registerInsert" method="post" modelAttribute="RegisterVO">
                                
                                <div class="form-group">
                                    <label for="signin-email" class="control-label sr-only">First Name</label>
                                    <f:input type="text" path="firstName" class="form-control" id="signin-email"  placeholder="First Name"/>
                                </div>
                                
                                <div class="form-group">
                                    <label for="signin-email" class="control-label sr-only">Last Name</label>
                                    <f:input type="text" path="lastName" class="form-control" id="signin-email"  placeholder="Last Name"/>
                                </div>
                                
                                <div class="form-group">
                                    <label for="signin-email" class="control-label sr-only">Email</label>
                                    <f:input type="email" path="loginVO.username" class="form-control" id="signin-email"  placeholder="User Name"/>
                                </div>
                                
                                
                                <div class="form-group">
                                    <label for="signin-password" class="control-label sr-only">Password</label>
                                    <f:input type="password" path="loginVO.password" class="form-control" id="signin-password"  placeholder="password"/>
                                </div>
                                <div class="form-group clearfix">
                                    <label class="fancy-checkbox element-left">
                                        <input type="checkbox">
                                        <span>Remember me</span>
                                    </label>								
                                </div>
                                <button type="submit" class="btn btn-primary btn-lg btn-block">LOGIN</button>
                                <div class="bottom">
                                    <span class="helper-text m-b-10"><i class="fa fa-lock"></i> <a href="page-forgot-password.html">Forgot password?</a></span>
                                    <span>Don't have an account? <a href="register.html">Register</a></span>
                                </div>
                            </f:form>
                        </div>
                    </div>
				</div>
			</div>
		</div>
	</div>
	<!-- END WRAPPER -->
</body>
</html>
    