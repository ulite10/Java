package basics;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import exceptions.DBException;
import exceptions.DMException;


public class DBManager {
	

	private static DBManager dbInstance;
	
	private DBManager(){}
	
	public static DBManager getInstance(){
		if(dbInstance==null){
			dbInstance = new DBManager();
		}
		return dbInstance;
	}
	
	public  Connection getConnection() throws DBException {
		Connection conexion = null;
		try{
			if (conexion == null){
				final String DB_DRIVER = "org.hsqldb.jdbcDriver";
				final String DB_URL = "jdbc:hsqldb:file:sql/testdb;shutdown=true;hsqldb.default_table_type=cached";
				final String DB_USERNAME = "sa";
				final String DB_PASSWORD = "";
				Class.forName(DB_DRIVER);
				conexion =  DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
				System.out.println("conexion exitosa");
			}
		}
		catch(ClassNotFoundException | SQLException ex){
			 
			 throw new DBException("Error de sql ", ex);
			 
		}
		return conexion;
	}
	
	public void cerrarConexion(Connection conexion){
		try {
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
