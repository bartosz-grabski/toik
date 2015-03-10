<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html><body>
<table width="50%" border="1">
	<tr>
		<th>Account Id</th>
		<th>Name</th>
		<th>Last Name</th>
		<th>Balance</th>
		<th>Email</th>
	</tr>
        <c:forEach var="account" items="${accounts}">
        	<tr>
			<td>${account.id}</td>
			<td>${account.firstName}</td>
			<td>${account.lastName}</td>
			<td>${account.balance}</td>
			<td>${account.email}</td>
		</tr>
        </c:forEach>
                 
</table>

</body></html>