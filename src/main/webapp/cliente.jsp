<%@page import="entity.Cliente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Clientes</title>

<script type="text/javascript">
	function confirma(i) {
		if (window.confirm("Tem certeza que deseja excluir o cliente?")) {
			location.href="clienteServlet?i=" + i + "&acao=exc";
		}
	}
	function editar(i){
		location.href="clienteServlet?i=" + i + "&acao=edit";
	}
</script>
</head>
<body>
	

			
		
		
	


	<h1>Cadastro de Cleintes</h1>
	
	<form method="post" action="clienteServlet">
		<div>
			${requestScope.msgAdd}
			${requestScope.msgExc}
			
	</div>
		<input type=hidden value="${requestScope.idCli}" name="id" /><br /> <label>Nome: </label><br />
		<input type="text" value="${requestScope.cliente.nome}" name="nome" /><br /> <label>Email:</label><br />
		<input type="text" value="${requestScope.cliente.email }" name="email" /><br />
		<br /> <input type="submit" value="Salvar" name="btSalvar" /><br />
		<br />


	</form>
	<table border="1px>">
		<tr>
			<th>Nome</th>
			<th>E-mail</th>
			<th>Ação</th>
		</tr>
<c:set var="i" value="0"/>		
<c:forEach items="${requestScope.lista}" var="c">
		
			<tr>
				<td>${c.nome}</td>
				<td>${c.email}</td>
				<td><a href="javascript:confirma(${i})">Excluir</a>
			||<a href="javascript:editar(${i})">Editar</a></td>
			
			</tr>
		<c:set var="i" value="${i+1}"/>
</c:forEach>
	
	</table>


</body>
</html>