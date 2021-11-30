<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="cadastraEmpresa" />
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${cadastraEmpresa}" method="post">
		<input type="hidden" name="id" value="${empresa.id}"> <input
			type="hidden" name="acao" value="CadastraEmpresa"> Nome: <input
			type="text" name="nome" value="${empresa.nome}" /> Data Abertura: <input
			type="text" name="dataAbertura"
			value="<fmt:formatDate
					value="${empresa.dataAbertura}" pattern="dd/MM/yyyy" />" />
		<input type="submit">
	</form>
</body>
</html>