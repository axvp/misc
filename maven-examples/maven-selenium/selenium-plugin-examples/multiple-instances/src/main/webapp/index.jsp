<%@page contentType="text/html"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<html>
<head>
<title>Login successfull</title>
</head>
<body>
	<h2>Congratulations you are logged in!</h2>

	<div>Your session id is:</div>
	<div id="session.id" style="font-weight: bold">
		<c:out value="${pageContext.session.id}" />
	</div>
	</br>
	<div>Your principal name is:</div>
	<div id="userPrincipal.name" style="font-weight: bold">
		<c:out value="${pageContext.request.userPrincipal.name}" />
	</div>
</body>
</html>