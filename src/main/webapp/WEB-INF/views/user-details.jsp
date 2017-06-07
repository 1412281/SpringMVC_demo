<%-- 
    Document   : index
    Created on : Jun 1, 2017, 3:30:38 PM
    Author     : LAMTRAN
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>

<head>
<title>Manager View</title>
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<link rel='stylesheet'
	href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>

</head>

<body>
	<%@include file="authheader.jsp"%>

	<div class="container" style="padding-top: 30px;">
		
		<div class="row">
			
			<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
				
			</div>
			
			<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
				
				
				<div class="panel panel-info">
					  <div class="panel-heading">
							<h3 class="panel-title">Information</h3>
					  </div>
					  <div class="panel-body">
							
							<span class="label label-info">Full name:</span>
							<span> ${user.fullname}</span>
							<br>
							<span class="label label-info">Email:</span>
							<span> ${user.email}</span>
							<br>
							<span class="label label-info">Username:</span>
							<span> ${user.username}</span>
							<br>

					  </div>
				</div>
				
				
			</div>
			
			<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
				
			</div>
			
		</div>
				
	</div>
	<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>

</body>

</html>