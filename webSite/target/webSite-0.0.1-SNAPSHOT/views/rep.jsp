<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="margin-left: 50px;">liste des Candidatures</h1>

	<table style="border: 1px solid;">
		<tr>
		<th>Nom </th>
		<th>Prenom </th>
		<th>Adresse</th>
		</tr>
		<c:forEach var="l" items="${list}">

			<tr>
				<td><c:out value="${l.nom}" /></td>
				<td><c:out value="${l.prenom}" /></td>
				<td><c:out value="${l.adresse}" /></td>
			</tr>


		</c:forEach>
	</table>
	
	
	
	
</body>
</html>