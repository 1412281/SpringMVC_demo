<%-- 
Document   : index
Created on : Jun 1, 2017, 3:30:38 PM
Author     : LAMTRAN
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<title>Add new Product</title>
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<link rel='stylesheet'
	href='../webjars/bootstrap/3.2.0/css/bootstrap.min.css'>

</head>

<body>


	<%@include file="authheader.jsp"%>
	
	<div class="container" style="padding-top: 30px;">
		
		<span class="label label-success">${message}</span>
		
		<div class="row">

			<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3"></div>

			<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">

				<c:choose>
					<c:when test="${edit}">
						<form:input type="hidden" path="proID" id="proID"
							class="form-control input-sm" disabled="true"/>
					</c:when>
					<c:otherwise>
						<h2>Add new product</h2>
					</c:otherwise>
				</c:choose>

				<form:form method="POST" modelAttribute="product">

					<form:input type="hidden" path="proID" id="proID" />
					<div class="form-group">
						<label for="ProName">Product Name</label>
						<form:input type="text" class="form-control" id="proName"
							path="proName" placeholder="" />
					</div>
					<div class="form-group">
						<label for="tinyDes">Describe</label>
						<form:input type="text" class="form-control" id="tinyDes"
							path="tinyDes" placeholder="" />
					</div>

					<div class="form-group">
						<label for="price">Price</label>
						<form:input type="number" class="form-control" id="price"
							path="price" placeholder="" />
					</div>
					<div class="form-group">
						<label for="catID">Category</label>
						<form:select class="form-control" id="catID" path="catID">
							<form:option value="1">Sách</form:option>
							<form:option value="2">Điện thoại</form:option>
							<form:option value="3">Máy chụp hình</form:option>
							<form:option value="4">Quần áo - Giày dép</form:option>
							<form:option value="5">Máy tính</form:option>
							<form:option value="6">Đồ trang sức</form:option>
							<form:option value="7">Khác</form:option>
						</form:select>
					</div>
					<div class="form-group">
						<label for="quantity">Quantity</label>
						<form:input type="number" class="form-control" id="quantity"
							path="quantity" placeholder="" />
					</div>
					<c:choose>
						<c:when test="${edit}">
							<input class="btn btn-primary" type="submit" value="Update" />
						</c:when>
						<c:otherwise>
							<input class="btn btn-primary" type="submit" value="Submit" />
						</c:otherwise>
					</c:choose>
					<a class="btn btn-default" href="<c:url value='/' />" role="button">Back</a>
				</form:form>

			</div>

			<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3"></div>

		</div>


	</div>

	<script type="text/javascript" src="../webjars/jquery/2.1.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="../webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>

</body>

</html>