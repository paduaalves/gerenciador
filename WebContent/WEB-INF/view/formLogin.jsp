<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="entrada" />
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${entrada}" method="post">
		<input type="hidden" name="acao" value="Login"> 
		Login: 
		<input type="text" name="login"/>
		<br/> 
		Senha:
		<input type="password" name="senha" />
		<input type="submit">
	</form>
</body>
</html>