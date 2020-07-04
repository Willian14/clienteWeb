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
				
@WebServlet(urlPatterns = { "/cliente.do", "/clienteServlet" })
public class ClienteServlet extends HttpServlet {
	
	private List<Cliente> lista;
	
	public ClienteServlet() {
		System.out.println("Construindo Servlet");
		lista = new ArrayList<Cliente>();
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
		RequestDispatcher rd = req.getRequestDispatcher("cliente.jsp");
		req.setAttribute("lista", lista);
		rd.forward(req, resp);
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		Cliente cli = new Cliente(nome, email);
		lista.add(cli);
		String msg = "Cadastrado com sucesso!";
		RequestDispatcher rd = req.getRequestDispatcher("cliente.jsp");
		req.setAttribute("lista", lista);
		req.setAttribute("msg", msg);
		rd.forward(req, resp);
				
	}
}
