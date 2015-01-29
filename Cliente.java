

public class Cliente {
	
	private String nome;
	private String cpf;
	private float saldo;
	private String telefone;
	
	public Cliente(String nome, String cpf, String telefone) {
		setNome(nome);
		setCpf(cpf);
		setTelefone(telefone);
	
	}
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}	
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



}
