<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<body>

The student is confirmed: ${student.firstName} ${student.lastName}
<br>
Country:  ${student.country}
<br>
Favorite Language: ${student.favoriteLanguage} 
<br>
Operation Systems: 

<ul>
	<c:forEach var="temp" items="${student.operationSystems}">
		<li>${temp}</li>
	</c:forEach>
</ul>


<br>

</body>
</html>