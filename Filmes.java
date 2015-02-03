
public class Filmes extends Produtos {
	
	private String titulo;
	private int ano;
	

	public Filmes(String titulo, String genero, boolean locado, boolean reservado, float preco, int ano) {
		
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
		if (ano > 1900){
			this.ano = ano;
		} else{
			this.ano = 2015;
		}
		
				
		
	}
	
	public String gravarArquivo(){
		
		
		
		return getTitulo() +'-'+ getGenero() +'-'+ isLocado() +'-'+ isReservado() +'-'+ getPreco() +'-'+ getAno();
		
	}
	
	

}
