<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Customer</title>
	
	<! -- reference our style sheet -->
	<link
		type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css"/>
	
</head>

<body>
	List Customers - coming soon ...
	
	<div id="wrapper">
		<h2>CRM - Customer Relationship Manager</h2>
	</div>
	
	<div id="wrapper">
		<div id="content">
		
		<!--  put new button: Add Customer -->
		
		<input
			type="button"
			value="Add Customer"
			onclick="window.location.href='showFormForAdd'; return false;"
			class="add-button"
		/>
		
		
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
			</tr>
			<c:forEach var="tempCustomer" items="${customers}">
				<tr>
					<td>${tempCustomer.firstName}</td>
					<td>${tempCustomer.lastName}</td>
					<td>${tempCustomer.email}</td>
				</tr>
			</c:forEach>
		</table>
		</div>
	</div>
	
	
</body>

</html>