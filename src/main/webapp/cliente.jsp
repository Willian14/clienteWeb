<%@page import="entity.Cliente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Clientes</title>
<script type="text/javascript">
	function confirmaExclusao(indice){
		if(window.confirm("Tem certeza que deseja exlcuir este Cliente?")){
			location.href="clienteServlet?i="+indice+"&acao=exc";
		}
	}

</script>
</head>
<body>

	<div>
		<%
			Object msg = request.getAttribute("msg");
			Object msgEx = request.getAttribute("msgExc");
			
			if(msg != null){
				String mensagem = (String)msg;
				out.print("<h1>" + mensagem + "</h1>");
			}
			if(msgEx != null){
				String msgExc = msgEx.toString();
				out.print("<h1>" + msgExc + "</h1>");
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
			int i = 0;
			for(Cliente cli : lista){
				out.print("Nome: " + cli.getNome() + "<br/>" + "E-mail: " + cli.getEmail()
				+ "<a href='javascript:confirmaExclusao("+i+")'>excluir</a>"+
				"|<a href='#'>Editar</a>"+ "<br/><br/> ");
				i++;
				//clienteServlet?i=" + i + "&acao=exc' name='linkExcluir'
			}
			
			
		}
	
		
	%>
	
</body>
</html>