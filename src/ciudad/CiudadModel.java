package ciudad;

public class CiudadModel {
	
	
	int ciudadCod,fk_diocesisCod;
	String ciudadNom;
	
	public CiudadModel(){
		
	}
	
	public CiudadModel(int ciudadCod,int fk_diocesisCod, String ciudadNom){
		
		this.ciudadCod = ciudadCod;
		this.fk_diocesisCod = fk_diocesisCod;
		this.ciudadNom = ciudadNom;
		
	}
	public int getCiudadCod() {
		return ciudadCod;
	}
	public void setCiudadCod(int ciudadCod) {
		this.ciudadCod = ciudadCod;
	}

	public int getFk_diocesisCod() {
		return fk_diocesisCod;
	}
	public void setFk_diocesisCod(int fk_diocesisCod) {
		this.fk_diocesisCod = fk_diocesisCod;
	}
	public String getCiudadNom() {
		return ciudadNom;
	}
	public void setCiudadNom(String ciudadNom) {
		this.ciudadNom = ciudadNom;
	}
	
	public String toString(){
		return ciudadNom;
	}

}
