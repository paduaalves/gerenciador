<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="br.com.alura.gerenciador.servlet.Empresa, java.util.List"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>java Standard Taglib</title>
</head>
<body>

	<c:if test="${not empty empresa }">
		Empresa ${empresa.nome} cadastrada com sucesso!
	</c:if>
	
	<br/>

	Lista de empresas:
	<br />

	<ul>
		<c:forEach items="${empresas}" var="empresa">
			<li>${empresa.nome}- <fmt:formatDate
					value="${empresa.dataAbertura}" pattern="dd/MM/yyyy" />
			</li>
		</c:forEach>

	</ul>
</body>
</html>