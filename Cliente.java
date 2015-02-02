

public class Cliente {
	
	private String nome;
	private String cpf;
	private float saldo;
	private String telefone;
	private String endereco;
	
	public Cliente (){}
	
	public Cliente(String nome, String cpf, String telefone, String endereco) {
		setNome(nome);
		setCpf(cpf);
		setTelefone(telefone);
		setEndereco(endereco);
	
	}
	
	
	
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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
	
	public String gravarArquivo(){
		
		
		return getNome() +'-'+ getCpf() +'-'+ getTelefone() +'-'+ getSaldo() + '-' + getEndereco();
		
	}



}
