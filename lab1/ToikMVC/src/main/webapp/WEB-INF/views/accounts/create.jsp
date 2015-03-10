<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html><body>
	<form:form modelAttribute="account" action="create" method="post">
		<fieldset>
			<legend>Account Fields</legend>
			<p>
				<form:label for="firstName" path="firstName">First name</form:label>
				<br/>
				<form:input path="firstName" />
				<form:errors path="firstName" cssStyle="color:red"/>					
			</p>
                   

			<p>
				<form:label for="lastName" path="lastName">Last name</form:label>
				<br/>
				<form:input path="lastName" />
				<form:errors path="lastName" cssStyle="color:red"/>					
			</p>
			
			<p>
				<form:label for="balance" path="balance">balance</form:label>
				<br/>
				<form:input path="balance" />
				<form:errors path="balance" cssStyle="color:red"/>					
			</p>
			
			<p>
				<form:label for="email" path="email">email</form:label>
				<br/>
				<form:input path="email" />	
				<form:errors path="email" cssStyle="color:red"/>				
			</p>
			
			<p>
			        <input type="submit"  value="Create account"/>
			</p>
		</fieldset>
	</form:form>
</body></html>
