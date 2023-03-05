<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Products CRUD</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Product -->
		
			<input type="button" value="Add Product"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Product Id</th>
					<th>Product Name</th>
					<th>Product Type</th>
					<th>Product Price</th>
				</tr>
				
				<!-- loop over and print our products -->
				<c:forEach var="tempProduct" items="${products}">
				
					<!-- construct an "update" link with product id -->
					<c:url var="updateLink" value="/product/showFormForUpdate">
						<c:param name="productId" value="${tempProduct.productId}" />
					</c:url>					

					<!-- construct an "delete" link with product id -->
					<c:url var="deleteLink" value="/product/delete">
						<c:param name="productId" value="${tempProduct.productId}" />
					</c:url>					
					
					<tr>
						<td> ${tempProduct.productId} </td>
						<td> ${tempProduct.productName} </td>
						<td> ${tempProduct.productType} </td>
						<td> ${tempProduct.price} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this product?'))) return false">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>
