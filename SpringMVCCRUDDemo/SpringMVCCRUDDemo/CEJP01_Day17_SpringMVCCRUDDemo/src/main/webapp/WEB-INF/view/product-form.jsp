<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Save Product</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Products CRUD</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Product</h3>
	
		<form:form action="saveProduct" modelAttribute="product" method="POST">

			<!-- need to associate this data with product id -->
			<form:hidden path="productId" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Product name:</label></td>
						<td><form:input path="productName" /></td>
					</tr>
				
					<tr>
						<td><label>Product type:</label></td>
						<td><form:input path="productType" /></td>
					</tr>

					<tr>
						<td><label>Product Price:</label></td>
						<td><form:input path="price" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/product/list">Back to List</a>
		</p>
	
	</div>
</body>
</html>