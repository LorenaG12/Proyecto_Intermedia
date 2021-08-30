
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
     static String bd="Venta_de_Boletos";
    static String user="root";
    static String pass="root";
    static String url="jdbc:mysql://localhost:3306/"+bd;
    Connection conn= null;
    
    public Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(url, user, pass);
            if(conn!=null){
                System.out.println("excellente conexion");
            }
            
        }catch(Exception e){
            System.out.println("error de conexion"+e.getMessage());
        }
    }
    
    public Connection conectar(){
        return conn;
    }
    public void desconectar() throws Exception{
        conn.close();
    }
}
