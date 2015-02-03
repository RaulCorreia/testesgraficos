

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
		
		if(cpf.isEmpty() == false){
			this.cpf = cpf;
		} else{
			cpf = "00000000000";
		}
		
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		if (saldo > 0){
			this.saldo = saldo;
		} else{
			this.saldo = 0;
		}
		
	}	
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		if(telefone.isEmpty() == false){
			this.telefone = telefone;
		}else{
			this.telefone = "0000000000";
		}
		
	}
	
	public String gravarArquivo(){
		
		
		return getNome() +'-'+ getCpf() +'-'+ getTelefone() +'-'+ getSaldo() + '-' + getEndereco();
		
	}



}
