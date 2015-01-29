
public class Filmes extends Produtos {
	
	private String titulo;
	private int ano;
	

	public Filmes(String genero, boolean locado, boolean reservado, float preco, String titulo, int ano) {
		
		super(genero, locado, reservado, preco);
		setTitulo(titulo);
		setAno(ano);
		
	}



	public String getTitulo() {
		return titulo;
	}




	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		
		do
			
			if (ano > 1900){
				this.ano = ano;
				
			} else {
				
				//Gera mensagem
			}
		while (ano < 1900);
		
	}
	
	
	

}
