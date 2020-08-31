package clienteweb;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Cliente;
import service.GerenciadorDeLista;
				
@WebServlet(urlPatterns = { "/cliente.do", "/clienteServlet" })
public class ClienteServlet extends HttpServlet {
	
	GerenciadorDeLista gerenciador = new GerenciadorDeLista();
	
	public ClienteServlet() {
		System.out.println("Construindo Servlet");
		//lista = new ArrayList<Cliente>();
		
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("inicializando....");
		super.init();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Chamando Service");
		super.service(req, resp);
	}
	
	@Override
	public void destroy() {
		System.out.println("Destruindo o Servlet");
		super.destroy();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cliente cli = null;;
		
		
		//Capturando dados da requisição
		String acao = req.getParameter("acao");
		String parametroI = req.getParameter("i");
		//Declarando variável i 
		Integer i = null;
		
		if(parametroI != null && parametroI != "") {
			i = Integer.parseInt(parametroI);
		}
		
		if(acao != null && acao != "") {
			if(acao.equals("exc")) {
				gerenciador.excluir(i);
				String msgExc = "Cliente excluído com sucesso!";
				i = null;
				req.setAttribute("msgExc", msgExc);
			}else if(acao.equals("edit")) {
				 cli = gerenciador.buscarPorId(i);
				
			}
		}
		
		List<Cliente> lista = gerenciador.getLista();
		RequestDispatcher rd = req.getRequestDispatcher("cliente.jsp");
		req.setAttribute("lista",lista);
		req.setAttribute("idCli", i);
		req.setAttribute("cliente", cli);
		rd.forward(req, resp);
		/*String indice = req.getParameter("i");
		String acao = req.getParameter("acao");
		Cliente cli = new Cliente();
		Integer i = null;
		if(indice!=null && indice!="" && acao != null && acao != "" ) {
			i = (Integer.parseInt(indice));
			if(acao.equals("exc")) {
				gerenciador.excluir(i);
				req.setAttribute("msgExc", "Cliente excluido com sucesso!");
			}else if(acao.equals("edit")) {
				cli = gerenciador.buscarPorId(i);
			}
		}
		
		
		RequestDispatcher rd = req.getRequestDispatcher("cliente.jsp");
		req.setAttribute("cliente", cli);
		req.setAttribute("i", i);
		req.setAttribute("lista",gerenciador.getLista() );
		rd.forward(req, resp);*/
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Capturando os dados que foram digitados na tela
		 
		
		String strId = req.getParameter("id");
		Integer id = null;
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		
		//Adicionando cliente na lista
		Cliente cli = new Cliente();
		Cliente cliVazio = new Cliente();
		cliVazio.setNome("");
		cliVazio.setEmail("");
		
		if(nome != null && email != null) {
			
			cli.setEmail(email);
			cli.setNome(nome);
			if(strId != "" && !(strId.equals("null"))) {
				id = Integer.parseInt(strId);
				gerenciador.alterar(cli, id);
			}else {
				gerenciador.adicionar(cli);
			}
			
		}
		
		
				
		
		//Criando mensagem de adicionado com sucesso
		String msgAdd = "Cliente salvo com sucesso!";
		
		//Chamando o arquivo jsp e adicionando o objeto cliente e a lista para serem carregados na página
		RequestDispatcher rd = req.getRequestDispatcher("cliente.jsp");
		req.setAttribute("lista", gerenciador.getLista());
		req.setAttribute("msgAdd", msgAdd);
		req.setAttribute("cliente", cliVazio);
		rd.forward(req, resp);
		
		/*String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String id = req.getParameter("id");
		
		Cliente cli = new Cliente();
		if(id != null && id != " ") {
			Integer indice = Integer.parseInt(id);
			gerenciador.alterar(cli,indice);
		}else {
			gerenciador.adicionar(cli);
		}
		String msg = "Cadastrado com sucesso!";
		RequestDispatcher rd = req.getRequestDispatcher("cliente.jsp");
		req.setAttribute("lista", gerenciador.getLista());
		req.setAttribute("msg", msg);
		rd.forward(req, resp);*/
				
	}
}
