<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../session.jsp" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${sessionData.user.loggedIn}">
			Sikeresen bejelentkezve, mint ${sessionData.user.username} !
			<a href="/logout">Kijelentkezes</a>
		</c:when>
		<c:otherwise>
			Sikertelen bejelentkezes
			<a href="/login">Próbáld újra</a>
		</c:otherwise>
	</c:choose>
</body>
</html>