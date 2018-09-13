<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<body>
<h2>Student Registration Form </h2>

<form:form action="processForm" modelAttribute="student">
	First name: <form:input path="firstName" />
	<br><br>
	Last name: <form:input path="lastName" />
	<br><br>
	Country
	<form:select path="country">
		<form:options items="${student.countryOptions}" />
	</form:select>
	<br><br>
	Favorite Language:
	<br><br>
	Java <form:radiobutton path="favoriteLanguage" value="Java" />
	C <form:radiobutton path="favoriteLanguage" value="C" />
	ObjC <form:radiobutton path="favoriteLanguage" value="ObjC" />
	C++ <form:radiobutton path="favoriteLanguage" value="C++" />
	
	<br><br>
	
	
	Operating Systems:
	
	Linux <form:checkbox path="operationSystems" value="Linux" />
	Mac <form:checkbox path="operationSystems" value="Mac" />
	Windows <form:checkbox path="operationSystems" value="Windows" />
	
	<br><br>
	<input type="submit" value="Submit" />

</form:form>



</body>

</html>