package basics;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableManager {
	public void crearTablausuario() throws SQLException {
		Connection conexion = DBManager.getInstance().getConnection();
		String sql = "ALTER TABLE clientes ADD numeroCuenta INTEGER";
		
		try {
		Statement s = conexion.createStatement();
		s.executeUpdate(sql);
		conexion.commit();
		System.out.println("se creo la tabla correctamente");
		} catch (SQLException e){
			throw new SQLException("Problema al crear la table", e);
		} finally {
			DBManager.getInstance().cerrarConexion(conexion);
		}
		
	}
	
	public void crearTablaCuentas() throws SQLException {
		Connection conexion = DBManager.getInstance().getConnection();
		String sql = "CREATE TABLE cuentas ( id INTEGER IDENTITY, numeroCuenta VARCHAR(256), dni INTEGER, cajaahorro FLOAT, cuentacorriente FLOAT)";
		try {
		Statement s = conexion.createStatement();
		s.execute(sql);
		conexion.commit();
		System.out.println("se creo la tabla correctamente");
		} catch (SQLException e){
			throw new SQLException("Problema al crear la table", e);
		} finally {
			DBManager.getInstance().cerrarConexion(conexion);
		}
		
	}
	
	public void crearTablaTarjetas() throws SQLException {
		Connection conexion = DBManager.getInstance().getConnection();
		String sql = "CREATE TABLE tarjetas ( id INTEGER IDENTITY, dni INTEGER, numTarjetaCredito INTEGER, numTarjetaDebito INTEGER, debito FLOAT, credito FLOAT)";
		
		try {
		Statement s = conexion.createStatement();
		s.execute(sql);
		conexion.commit();
		System.out.println("se creo la tabla correctamente");
		} catch (SQLException e){
			throw new SQLException("Problema al crear la table", e);
		} finally {
			DBManager.getInstance().cerrarConexion(conexion);
		}
		
	}
	
}
