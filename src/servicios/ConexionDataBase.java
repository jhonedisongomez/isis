package servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// realiza la conexion a la base de datos permitiendo realizar consultas o modificaciones
 
public class ConexionDataBase
{
    /**
     * Variable que define el tipo de base de datos a conectar, puede tomar
     * los valores: MySQL, SQLServer, Oracle, Access,postgres
     */

    private  Connection conexion;
    private  Statement estatuto;

    // Nombre del usuario de la base de datos
    
    private  String nombreUsuario= "root";

    // Contrasena de la base de datos
     
    private  String contrasena= "Colombia2013";
    private String nombreBaseDatos="diosesis";
    
    
    // Metodo encargado de efectuar la conexion
     
    public  void conectar()  {
        String nombreDriver = null;
        String url = null;
     
      //nombreDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
        nombreDriver = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/"+nombreBaseDatos;
        //url = "jdbc:oracle:thin:@localhost:1521:XE";
        //"jdbc:oracle:thin:@" + servidor + ":" + puerto + ":" + sid;
        //"jdbc:oracle:thin:@localhost:1521:XE"
        		//"jdbc:oracle:oci:@localhost1521:PRUEBA";
        		//"jdbc:mysql://localhost:3306/"+nombreBaseDatos;  
        		//"jdbc:postgresql://localhost:5432/nombreBaseDatos;
        
        try {
            Class.forName(nombreDriver).newInstance();
            conexion = DriverManager.getConnection(url,nombreUsuario,contrasena);
            estatuto = conexion.createStatement();
        } 
        catch (IllegalAccessException e)       {
            System.err.println(e.getMessage());
        } 
        catch (InstantiationException e) {
            System.err.println(e.getMessage());
        } 
        
        catch (ClassNotFoundException e){
            System.err.println(e.getMessage());
        } 
        
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    // Metodo encargado de cerrar la conexion
     
    public  void desconectar(){
        try{
            estatuto.close();
            conexion.close();
        } 
        catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Metodo para ejecutar consultas de tipo INSERT, UPDATE, DELETE
     * @param querySQL String consulta en SQL
     */
    
    public  void executeUpdateQuery(String querySQL) {
        try     {
            conectar();
            estatuto.executeUpdate(querySQL);
            //desconectar();
        } 
        catch (SQLException e)        {
            System.err.println(e.getMessage());
        }
    }
     

    /**
     * Metodo para ejecutar consultas de tipo SELECT
     * @param querySQL String consulta en SQL
     * @return ResultSet con los valores encontrados
     */
    public  ResultSet executeQuery(String querySQL) {
        try{
            conectar();
            return estatuto.executeQuery(querySQL);
        } 
        catch (SQLException e){
        	
            System.err.println(e.getErrorCode());
        }
        return null;
    }
}