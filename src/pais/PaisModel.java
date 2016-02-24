package pais;


public class PaisModel {
	
	int paisCod;
	String paisNom;
	
	public PaisModel(int paisCod, String paisNom){
		
		this.paisCod	= paisCod;
		this.paisNom	= paisNom;
				
		
	}
	
	public PaisModel(){
		
	}
	
	
	public int getPaisCod() {
		return paisCod;
	}

	public void setPaisCod(int paisCod) {
		this.paisCod = paisCod;
	}

	public String getPaisNom() {
		return paisNom;
	}

	public void setPaisNom(String paisNom) {
		this.paisNom = paisNom;
	}

	@Override
	public String toString() {
		return paisNom;
	}
		

}
