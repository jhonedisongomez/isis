package integrantes;

public class IntegrantesModel {
	
	int cedula,carnet,celular,fk_lumsialCod;
	String nombre1,nombre2,apellido1,apellido2,fechaNac,fk_estadoCivil,ocupacion,genero;
	String[] cargos;
	
	public IntegrantesModel(int cedula,int carnet,int celular,int fk_lumisialCod ,String nombre1,String nombre2,String apellido1,
							String apellido2,String fechaNac,String fk_estadoCivil,String ocupacion,String genero,String[] cargos){
		
		this.cedula				= cedula;
		this.carnet				= carnet;
		this.celular			= celular;
		this.fk_lumsialCod		= fk_lumisialCod;
		this.nombre1			= nombre1;
		this.nombre2			= nombre2;
		this.apellido1			= apellido1;
		this.apellido2			= apellido2;
		this.fechaNac			= fechaNac;
		this.fk_estadoCivil 	= fk_estadoCivil;
		this.ocupacion			= ocupacion;
		this.genero				= genero;
		this.cargos				= cargos;
				
		
	}
	
	public int getFk_lumsialCod() {
		return fk_lumsialCod;
	}

	public void setFk_lumsialCod(int fk_lumsialCod) {
		this.fk_lumsialCod = fk_lumsialCod;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public IntegrantesModel(){
		
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getNombre1() {
		return nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	public String getNombre2() {
		return nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String[] getCargos() {
		return cargos;
	}

	public void setCargos(String[] cargos) {
		this.cargos = cargos;
	}

	public int getCarnet() {
		return carnet;
	}

	public void setCarnet(int carnet) {
		this.carnet = carnet;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public String getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getFk_estadoCivil() {
		return fk_estadoCivil;
	}

	public void setFk_estadoCivil(String fk_estadoCivil) {
		this.fk_estadoCivil = fk_estadoCivil;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	

}
