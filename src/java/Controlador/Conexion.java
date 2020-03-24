
package Controlador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion
{
    private static Conexion con;
    private Connection c;
    
    private Conexion( )
    {    
    
    }    
        public static Conexion getInstance()
        {
            if(con == null)
            {
                con =new Conexion();
            }
            return con;
        }
        public void conectar()   
        {
            try
            {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            c=DriverManager.getConnection("jdbc:sqlserver://DESKTOP-HUPD7H9\\SQLSERVER:53013;databaseName=UV6","sa","1347awhy");
            }
            catch(SQLException ex)  {   }
            catch(ClassNotFoundException ex) {  }
            catch(InstantiationException ex) {  }
            catch(IllegalAccessException ex) {  }
        }
        public Connection getConnection()
        {
            return c;
        }
        public void desconectar()
        {
            try 
            {
                c.close();
            } 
            catch (SQLException ex)   {   }
        }
}