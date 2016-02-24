package ciudad;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import java.util.Vector;

import javax.swing.JOptionPane;

import diocesis.DiocesisModel;
import servicios.ConexionDataBase;
import servicios.ObtenerFecha;

public class CiudadController {
	
	
    ConexionDataBase objConexionDataBase = new ConexionDataBase();
    String nombreUsuario = "jhon";

    ObtenerFecha objObtenerFecha = new ObtenerFecha();
    String fecha = objObtenerFecha.obtenerFecha();


    public boolean buscarCiudad(int ciudadCod){

            boolean find = false;

            try{
                    String querySQL = "select * from ciudad where active = true and ciudadCod = " + ciudadCod;  
                    ResultSet response = objConexionDataBase.executeQuery(querySQL);
                    response.last();

                    int rowsCounter =response.getRow();

                    if(rowsCounter >0){
                            find = true;

                    }
            }catch (Exception e) {

                    JOptionPane.showInternalMessageDialog(null, "PROBLEMA AL MOMENTO DE BUSCAR LA CIUDAD");

            }

            return find;

    }

    public boolean registrarCiudad(int ciudadCod, String ciudadNom, int diocesisCod){


        boolean registro = false;

        try{

            UUID ciudadUUID = UUID.randomUUID();
            String querySQL = "INSERT INTO ciudad (ciudadUUID,ciudadCod,ciudadNom,active,createBy,CreateDT,UpdateBy,UpdateDT,fk_diocesisCod) values ('"
                            + ciudadUUID + "','" + ciudadCod + "','" + ciudadNom + "',true,'" + nombreUsuario +"','" + fecha + "','"
                            + nombreUsuario +"','" + fecha + "','" + diocesisCod + "')"; 


            objConexionDataBase.executeUpdateQuery(querySQL);
            registro = true;


        }catch(Exception e){

            JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR EN LA BASE DE DATOS");

        }

        return registro;

    }

    public CiudadModel loadDataForm(int ciudadCod){

        CiudadModel objCiudadModel = null;
        try {

            String querySQL = "select * from ciudad where active = true and ciudadCod = " + ciudadCod;
            ResultSet response =objConexionDataBase.executeQuery(querySQL);
            while(response.next()){

                String ciudadNom	= response.getString("ciudadNom");
                int diocesisCod		= response.getInt("fk_diocesisCod"); 
                //String get

                objCiudadModel = new CiudadModel(ciudadCod, diocesisCod, ciudadNom);
            }
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }

        return objCiudadModel;
    }


    public Vector<DiocesisModel> loadDataCombo(){

        Vector<DiocesisModel> diocesis = new Vector<DiocesisModel>();
        try {

            DiocesisModel objDiocesisModel = null;
            String querySQL = "select * from diosesis where active = true order by DiosesisNom";
            ResultSet response = objConexionDataBase.executeQuery(querySQL);

            while(response.next()){

                objDiocesisModel = new DiocesisModel();
                objDiocesisModel.setDiocesisNom(response.getString("diosesisNom"));
                objDiocesisModel.setDiocesisCod(response.getInt("diosesisCod"));
                diocesis.add(objDiocesisModel);
            }

        } catch (SQLException e) {
                // TODO Auto-generated catch block
                String respuesta = "error al cargar la base de datos";

        }

        return diocesis;
    }
	
}
