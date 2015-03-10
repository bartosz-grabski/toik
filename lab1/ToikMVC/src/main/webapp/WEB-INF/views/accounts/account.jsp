<%@ page session="false"%>
<html>
<head>
<title>Account Information</title>
</head>
<body>
	<h1>Account Information</h1>
	<br>
	<table border="1">
		<tr>
			<th>Account Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Balance</th>
			<th>Email</th>
		</tr>

		<tr>
			<td>${account.id}</td>
			<td>${account.firstName}</td>
			<td>${account.lastName}</td>
			<td>${account.balance}</td>
			<td>${account.email}</td>
		</tr>
	</table>
	<a href="${pageContext.request.contextPath}/accounts">Accounts Manager</a>
</body>
</html>


