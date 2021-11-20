<!DOCTYPE html>
<%@page import="br.com.alura.gerenciador.servlet.Empresa"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<c:if test="${not empty empresa }">
		Empresa ${empresa.nome} cadastrada com sucesso!
	</c:if>
	<c:if test="${empty empresa }">
		Nenhuma Empresa cadastrada
	</c:if>	

</body>
</html>