<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="br.com.alura.gerenciador.modelo.Empresa, java.util.List"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/entrada?acao=RemoveEmpresa" var="removeEmpresa" />
<c:url value="/entrada?acao=MostraEmpresa" var="mostraEmpresa" />
<c:url value="/formNovaEmpresa.jsp" var="novaEmpresa" />

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

	Total de empresas: ${empresas.size()}  <br/> 
	Lista de empresas:
	<br />

	<ul>
		<c:forEach items="${empresas}" var="empresa">
			<li>${empresa.id} - ${empresa.nome}- <fmt:formatDate
					value="${empresa.dataAbertura}" pattern="dd/MM/yyyy" />
			<a href="${removeEmpresa}&id=${empresa.id}">remover</a>
			<a href="${mostraEmpresa}&id=${empresa.id}">editar</a>
			</li>
		</c:forEach>

	</ul>
	
	<a href="${novaEmpresa}">Cadastrar</a>
	
</body>
</html>