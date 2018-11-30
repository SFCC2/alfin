package dao2;
import java.sql.*;

public class Conexion {
	
	private static Connection CONEXION=null;
	public static Connection getConnection() throws SQLException{
		   if(CONEXION == null){
			   try {
			     Class.forName("com.mysql.jdbc.Driver").newInstance();
                             //Integracion Log4J
			   } catch (ClassNotFoundException e) {
				throw new SQLException(e);
			   } catch (InstantiationException e) {
                               //Integracion Log4J
				   	throw new SQLException(e);
			   } catch (IllegalAccessException e) {
                               //Integracion Log4J
				   	throw new SQLException(e);
			   }

			  try {
			    CONEXION = DriverManager.getConnection("jdbc:mysql://localhost:3306/USA_BD","root", "");
                            // aqui se contecta
     			  } catch (SQLException e) {
			     throw new SQLException(e);
			  }

				
		   }
		   return CONEXION;
	}
	
	public static void closeConnection()  throws SQLException{
		 try {
			 if(CONEXION!=null){
				 CONEXION.close();
				 CONEXION=null;
			 }
			 
			} catch (SQLException e) {
				//Integracion Log4J
				throw new SQLException(e);
			}
		    
	}
	

}
