<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	String nomeEmpresa = (String) request.getParameter("empresa");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nova EMpresa</title>
</head>
<body>
	Empresa "<%=nomeEmpresa%>" cadastrada com sucesso!
</body>
</html>