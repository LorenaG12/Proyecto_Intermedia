
package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Cliente;

public class ClienteDao {
    Conexion     conn;
    public ClienteDao(Conexion conn){
        this.conn=conn;
    }
    public boolean insertar(Cliente  user){
        String sql="insert into cliente values(?,?,?,?)";
        try{
            PreparedStatement ps=conn.conectar().prepareStatement(sql);
            ps.setInt(1,user.getId() );
            ps.setString(2, user.getNombre());
            ps.setString(3, user.getApellido());
            ps.setInt(4, user.getEdad());
            ps.executeUpdate();
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public List<Cliente> consultarAll(){
        String sql="select * from cliente ";
        try{
            //sentecia preparada **** el objeto tiene la coneccion aun no iniciada*****con la cadena estatica de sql
            PreparedStatement ps=conn.conectar().prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            List<Cliente> Lista = new LinkedList<>();
            Cliente user;
            while(rs.next()){
                user= new Cliente(rs.getInt("id"));
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("Apellido"));
                user.setEdad(rs.getInt("edad"));
                Lista.add(user);
            }
            return Lista;
            
        }catch(Exception e){
            return null;
        }
    }
    
    public boolean delete(int id){
        String sql="delete from cliente where id = ? ";
       try{
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
           
            
            return true;
            
        }catch(Exception e){
            return false;
        }
       
    }
    
    public List<Cliente> selectById(int id){
        String sql="select * from cliente where id = ? ";
        try{
            //sentecia preparada **** el objeto tiene la coneccion aun no iniciada*****con la cadena estatica de sql
            PreparedStatement ps=conn.conectar().prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            Cliente user;
            List<Cliente> Lista = new LinkedList<>();
            
            
            
            while(rs.next()){
                user= new Cliente(rs.getInt("id"));
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("Apellido"));
                user.setEdad(rs.getInt("edad"));
                Lista.add(user);
            }
            return Lista;
            
        }catch(Exception e){
            return null;
        }
    }
    public boolean update(Cliente user){
        String sql="update Cliente set nombre = ? , apellido = ?, edad = ? where id = ? ";
       try{
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
           
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getApellido());
            ps.setInt(3, user.getEdad());
            ps.setInt(4, user.getId());
            ps.executeUpdate();
           
            
            return true;
            
        }catch(Exception e){
            return false;
        }
       
    }
}
