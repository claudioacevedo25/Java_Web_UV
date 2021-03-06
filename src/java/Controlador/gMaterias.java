package controlador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Modelo.Materia;

public class gMaterias {
    
    Conexion con;

    public gMaterias() {
      con=Conexion.getInstance();
    }
        public void cargarMateria(Materia m)
    {
        try
        {
         con.conectar();
        PreparedStatement ps=con.getConnection().prepareStatement("insert into materia values (?,1)");
        ps.setString(1, m.getNombre());
        ps.executeUpdate();
        con.desconectar();
        }catch(SQLException e){}
    }
    public ArrayList<Materia> listarMaterias() 
    {
        ArrayList<Materia> vec=new ArrayList<Materia>();
        
        try
        {   
           con.conectar();
           Statement st=con.getConnection().createStatement();
           ResultSet r=st.executeQuery("select * from materia where estado=1");
           while(r.next())
           {
               Materia m=new Materia();
               m.setId(r.getInt(1));
               m.setNombre(r.getString(2));
               vec.add(m);
           }
           r.close();
           con.desconectar();
        }catch(SQLException e)  { System.out.println("Error de conexion");  }
        
        return vec;
    }
    public void eliminarMateria(int idMateria)
    {
        try{
           con.conectar();
           PreparedStatement ps=con.getConnection().prepareStatement("update materia set estado=0 where id=?");
           ps.setInt(1, idMateria);
           ps.executeUpdate();
           con.desconectar();
        }catch(SQLException ex) { }
    }
    public void actualizarMateria(Materia m)  
    {
        try
        {           
            con.conectar();
           PreparedStatement ps=con.getConnection().prepareStatement("update  materia set nombre=? where id=? ");
           ps.setString(1, m.getNombre()); 
           ps.setInt(2, m.getId());
           
           ps.executeUpdate();
           con.desconectar();
        }
        catch(SQLException ex){ }
    }
        public Materia obtenerMateria(int id)
    {
        Materia m=new Materia();
        try
        {
            con.conectar();
        Statement s=con.getConnection().createStatement();
        ResultSet r=s.executeQuery("SELECT top 1 id, nombre from materia where estado=1 and id="+id);
            while(r.next())
            {                
                m.setId(r.getInt("id"));
                m.setNombre(r.getString("nombre"));                                     
            }
        r.close();
        con.desconectar();
        }
        catch(SQLException ex){ }
        return m;
    }
        
    
}
