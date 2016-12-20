<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
	<title>Login</title>
	<link rel="stylesheet" href="site/cssTest/styles.css">
	
</head>
	
<body onload='document.loginForm.username.focus();'>
	<jsp:include page="../views/header.jsp" />
	<div id="container">
		
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
		
		<form name='loginForm' action="<c:url value='/login' />" method='POST'>
		
			<label for="name">Username:</label>
			
				<input type="name" name='username' placeholder="E-mail">
			
			<label for="username">Password:</label>
			
				<input type="password" name='password' placeholder="Mot de Passe">
			
			<div id="lower">
			
				<input name="submit" type="submit" value="submit" />
			
			</div>
		
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
		
	</div>
	
</body>
</html>