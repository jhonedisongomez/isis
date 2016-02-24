package diocesis;

public class DiocesisModel {
	
	
	int diocesisCod, fk_paisCod;
	String diocesisNom;
	
	public DiocesisModel(){
		
	}
	
	public DiocesisModel(int diocesisCod,String diocesisNom,int fk_paisCod){
		
		this.diocesisCod = diocesisCod;
		this.diocesisNom = diocesisNom;
		this.fk_paisCod = fk_paisCod;
		
	}

	public int getDiocesisCod() {
		return diocesisCod;
	}

	public void setDiocesisCod(int diocesisCod) {
		this.diocesisCod = diocesisCod;
	}

	public int getFk_paisCod() {
		return fk_paisCod;
	}

	public void setFk_paisCod(int fk_paisCod) {
		this.fk_paisCod = fk_paisCod;
	}

	public String getDiocesisNom() {
		return diocesisNom;
	}

	public void setDiocesisNom(String diocesisNom) {
		this.diocesisNom = diocesisNom;
	}

	public String toString(){
		return diocesisNom;
	}
	

}
