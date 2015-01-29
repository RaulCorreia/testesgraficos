
public class Produtos {
	
	private String genero;
	private boolean locado;
	private boolean reservado;
	private float preco;
	
	
	public Produtos(String genero, boolean locado, boolean reservado, float preco) {
		
		setGenero(genero);
		setLocado(locado);
		setReservado(reservado);
		setPreco(preco);
		
		
	}


	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}


	public boolean isLocado() {
		return locado;
	}

	public void setLocado(boolean locado) {
		this.locado = locado;
	}

	public boolean isReservado() {
		return reservado;
	}

	public void setReservado(boolean reservado) {
		this.reservado = reservado;
	}

	public float getPreco() {		
		return preco;
	}

	public void setPreco(float preco) {
		do{
			
			if(preco > 0){
				
				this.preco = preco;
				
			} else{
				
				//mensagem
			}
			
		} while(preco < 0);
		
	}
	
	
	
	

}
