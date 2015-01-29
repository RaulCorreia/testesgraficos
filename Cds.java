
public class Cds extends Produtos{
	
	String nomeBanda;
	String album;
	

	public Cds(String genero, boolean locado, boolean reservado, float preco, String nomeBanda, String album) {
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
	
	
	
	
	

}
