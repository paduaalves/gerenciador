<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/novaEmpresa" var="novaEmpresa" />
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${novaEmpresa}" method="post">
		<input type="hidden" name="id" value="${empresa.id}"> Nome: <input
			type="text" name="nome" value="${empresa.nome}" /> <input
			type="submit"> Data Abertura: <input type="text"
			name="dataAbertura"
			value="<fmt:formatDate
					value="${empresa.dataAbertura}" pattern="dd/MM/yyyy" />" />
		<input type="submit">
	</form>
</body>
</html>