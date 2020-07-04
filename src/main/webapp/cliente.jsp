<%@page import="entity.Cliente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div>
		<%
			Object msg = request.getAttribute("msg");
			
			if(msg != null){
				String mensagem = (String)msg;
				out.print("<h1>" + mensagem + "</h1>");
			}
		
		%>
	</div>

	<h1>Cadastro de Cliente</h1>
	<form method="post" action="clienteServlet">
		<label>Nome</label><br/>
		<input type="text" name="nome"/><br/><br/>
		<label>email</label><br/>
		<input type="text" name="email"/><br/>
		<input type="submit" value="salvar"/>
	</form>
	
	<%
		List<Cliente> lista = (List<Cliente>) request.getAttribute("lista");
		
		if(lista != null){
			for(Cliente cli : lista){
				out.print("Nome: " + cli.getNome() + "<br/>" + "E-mail: " + cli.getEmail() + "<br/><br/> ");
			}
		}
	
		
	%>
	
</body>
</html>