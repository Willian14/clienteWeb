package entity;

public class Cliente {
	private String nome;
	private String email;
	
	public Cliente() {
		
	}
	
	public Cliente(String nome,String email) {
		this.nome = nome;
		this.email = email;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", email=" + email + "]";
	}
	
	
	
}
