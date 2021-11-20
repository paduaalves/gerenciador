<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/novaEmpresa" var="novaEmpresa" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${novaEmpresa}" method="post">
		Nome: <input type="text" name="nome" /> <input type="submit">
		Data Abertura: <input type="text" name="dataAbertura" /> <input
			type="submit">
	</form>
</body>
</html>