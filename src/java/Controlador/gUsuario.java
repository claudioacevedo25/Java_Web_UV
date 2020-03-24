package Controlador;

import Modelo.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class gUsuario {
    
    Conexion con;

    public gUsuario() {
      con=Conexion.getInstance();
    }
    
    public Usuario buscarUsuario(Usuario user)
    {
       Usuario u = new Usuario();
       con.conectar();
       int nombre = user.getUsuario();
       int contraseña = user.getContraseña();
       try
       {
           Statement s=con.getConnection().createStatement();
           ResultSet r=s.executeQuery("select u.id, u.usuario, u.pass,t.descripcion from usuario u where usuario='"+nombre+"' and pass='"+contraseña+"' and estado=1 inner join TipoUsuario t on u.id_tipoUsuario=t.id");
           while (r.next()) {
               u.setId(r.getInt(1));
               u.setUsuario(r.getInt(2));
               u.setContraseña(r.getInt(3));
               u.setTipoUsuario(r.getString(4));        
           }
           r.close();
        con.desconectar();
       }catch(SQLException e) {  }
       if(u.getUsuario()== -1)  {  return null;  }
       else {  return u;  }       
    }
    
}