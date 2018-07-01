
package Clases;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class conectar {
    private static Connection conec;
    private static final String driver="com.mysql.jdbc.Driver";
   private static final String usuario="root";
   private static final String password="";
  private static final String url="jdbc:mysql://localhost:3307/prueba"; 
  
  public conectar(){
  conec = null;
  try{
   Class.forName(driver);
  conec = (Connection)DriverManager.getConnection(url, usuario, password);
      if (conec != null) {
      JOptionPane.showMessageDialog(null,"Coneccion establecida");
      }
  }catch(ClassNotFoundException | SQLException e){
    JOptionPane.showMessageDialog(null,"Error al conectar"+e);
  }
  }
  public Connection getConnection(){
      return conec;
  }
  public void deconectar(){
  conec= null;
      if (conec == null) {
     JOptionPane.showMessageDialog(null,"Coneccion terminada");      
      }
  }


}
