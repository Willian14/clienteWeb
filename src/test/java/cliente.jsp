<%@page import="entity.Cliente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Clientes</title>
<%
	Integer i = 0;
    Cliente c;
    Integer idCli = null;;
%>
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

	<%
		//capturando dados da requisição	
		List<Cliente> lista = (List<Cliente>) request.getAttribute("lista");
		c = (Cliente)request.getAttribute("cliente");//capturado como object para não ter problema na conversão caso venha nulo
		String msgAdd = (String) request.getAttribute("msgAdd");
		String msgExc = (String) request.getAttribute("msgExc");
		Object idObj = request.getAttribute("idCli");//capturado como object para não ter problema na conversão caso venha nulo
		/*if(cObj != null && cObj != ""){
			c = (Cliente)cObj;
			
		}else{
			
		}*/
			
		
		if(idObj != null && idObj != ""){
			idCli = (Integer)idObj;
		}
	%>


	<h1>Cadastro de Cleintes</h1>
	
	<form method="post" action="clienteServlet">
		<div>
			<%if (msgAdd != null && msgAdd != ""){%>
				<h1><%=msgAdd%></h1>
			<%}%>
			
			<%if(msgExc != null && msgExc != ""){%>
				<h1><%=msgExc%></h1>
			<%}%>
		</div>
		<input type=hidden value="<%=idCli %>" name="id" /><br /> <label>Nome: </label><br />
		<input type="text" value="<%=c.getNome() %>" name="nome" /><br /> <label>Email:</label><br />
		<input type="text" value="<%=c.getEmail() %>" name="email" /><br />
		<br /> <input type="submit" value="Salvar" name="btSalvar" /><br />
		<br />


	</form>
	<table border="1px>">
		<tr>
			<th>Nome</th>
			<th>E-mail</th>
			<th>Ação</th>
		</tr>
	<%if(lista != null){%>
		<%for (Cliente cliente : lista) {%>
		
			<tr>
				<td><%=cliente.getNome() %></td>
				<td><%=cliente.getEmail() %></td>
				<td><a href="javascript:confirma(<%=i%>)">Excluir</a>
			||<a href="javascript:editar(<%=i%>)">Editar</a></td>
			
			</tr>
		
			
			<%i++;%>
		<%}
		
	}%>
	
	</table>


</body>
</html>