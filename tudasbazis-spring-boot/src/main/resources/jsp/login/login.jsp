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
			Bejelentkezve, mint ${sessionData.user.username} !
			<%@ include file="logoutForm.jsp" %>
		</c:when>
		<c:otherwise>
			Bejelentkez�shez kattints <a href="/login">ide</a>
		</c:otherwise>
	</c:choose>
</body>
</html>