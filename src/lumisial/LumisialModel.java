package lumisial;

public class LumisialModel {
	
	
	String lumisialNom,lumisialDir;
	int lumisialCode,lumisialTel,fk_ciudadCod;				
	
	//metodo constructor
	public LumisialModel(int lumisialCode,String lumisialNom, String lumisialDir,int lumisialTel, int fk_ciudadCod){
		
		this.lumisialCode	= lumisialCode;
		this.lumisialNom			= lumisialNom;
		this.lumisialDir		= lumisialDir;
		this.lumisialTel		= lumisialTel;
		this.fk_ciudadCod		= fk_ciudadCod;
		
		
	}
	
	//segundo metodo constructor
	public LumisialModel(){
		
	}

	public String getLumisialNom() {
		return lumisialNom;
	}

	public void setLumisialNom(String lumisialNom) {
		this.lumisialNom = lumisialNom;
	}

	public int getLumisialCode() {
		return lumisialCode;
	}

	public void setLumisialCode(int lumisialCode) {
		this.lumisialCode = lumisialCode;
	}

	public String getLumisialDir() {
		return lumisialDir;
	}

	public void setLumisialDir(String lumisialDir) {
		this.lumisialDir = lumisialDir;
	}

	public int getLumisialTel() {
		return lumisialTel;
	}

	public void setLumisialTel(int lumisialTel) {
		this.lumisialTel = lumisialTel;
	}

	public int getFk_ciudadCod() {
		return fk_ciudadCod;
	}

	public void setFk_ciudadCod(int fk_ciudadCod) {
		this.fk_ciudadCod = fk_ciudadCod;
	}
	
	public String toString(){
		return lumisialNom;
	}
	
	
	

}
