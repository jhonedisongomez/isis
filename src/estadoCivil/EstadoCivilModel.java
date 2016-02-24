package estadoCivil;

public class EstadoCivilModel {
	
	
	String estadoCivilCod,estadoCivilDesc;
	
	public EstadoCivilModel(String estadoCivilCod,String estadoCivilDesc){
		
		
		this.estadoCivilCod = estadoCivilCod;
		this.estadoCivilDesc = estadoCivilDesc;
	}

	public EstadoCivilModel() {
		// TODO Auto-generated constructor stub
	}

	public String getEstadoCivilCod() {
		return estadoCivilCod;
	}

	public void setEstadoCivilCod(String estadoCivilCod) {
		this.estadoCivilCod = estadoCivilCod;
	}

	public String getEstadoCivilDesc() {
		return estadoCivilDesc;
	}

	public void setEstadoCivilDesc(String estadoCivilDesc) {
		this.estadoCivilDesc = estadoCivilDesc;
	}
	
	
	public String toString(){
		return estadoCivilDesc;
	}

}
