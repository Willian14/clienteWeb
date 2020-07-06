package service;

import java.util.ArrayList;
import java.util.List;

import entity.Cliente;

public class GerenciadorDeLista {

	private static List<Cliente> lista;
	private Cliente c;
	
	public GerenciadorDeLista() {
		lista = new ArrayList<Cliente>();
	}
	
	/*public void Salvar(Cliente cli,int id,String acao) {
		if( acao.equals("edit")) {
			Alterar(cli, id);
		}else {
			adicionar(cli);
		}
	}*/
	
	public void adicionar(Cliente cli) {
		lista.add(cli);
	}
	
	public List<Cliente> getLista(){
		return lista;
	} 
	
	public void excluir(int i) {
		lista.remove(i);
	}
	
	public Cliente buscarPorId(int id) {
		return c = lista.get(id);
	}
	
	public void alterar(Cliente cli,int id) {
		lista.get(id).setNome(cli.getNome());
		lista.get(id).setEmail(cli.getEmail());
	}
	
}
