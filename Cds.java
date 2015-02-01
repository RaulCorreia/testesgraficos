
public class Cds extends Produtos{
	
	String nomeBanda;
	String album;
	

	public Cds(String nomeBanda, String album, String genero, boolean locado, boolean reservado, float preco) {
		super(genero, locado, reservado, preco);
		setNomeBanda(nomeBanda);
		setAlbum(album);
	}
	

	public String getNomeBanda() {
		return nomeBanda;
	}

	public void setNomeBanda(String nomeBanda) {
		this.nomeBanda = nomeBanda;
	}


	public String getAlbum() {
		return album;
	}


	public void setAlbum(String album) {
		this.album = album;
	}
	
	
	public String gravarArquivo(){
		
		
		return getNomeBanda() +'-'+ getAlbum() +'-'+ getGenero() +'-'+ isLocado() +'-'+ isReservado() +'-'+ getPreco();
		
	}
	
	
	

}
