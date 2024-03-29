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

	<div class="container" style="padding-top: 30px;">
		<sec:authorize access="hasRole('MANAGER')">
			<a class="btn btn-primary" href="<c:url value='/addProduct' />"
				role="button">Add new product</a>
		</sec:authorize>

		<h3>Manager: ${manager}</h3>
		<h1>Products List</h1>
		<div class="row">
			<div class="col-md-10">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>TinyDes</th>
							<th>Price</th>
							<th>Quantity</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="product">
							<tr>
								<td>${product.proID}</td>
								<td>${product.proName}</td>
								<td>${product.tinyDes}</td>
								<td>${product.price}</td>
								<td>${product.quantity}</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>

</body>

</html>