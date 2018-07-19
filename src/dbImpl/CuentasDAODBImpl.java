package dbImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import basics.DBManager;
import dao.CuentasDao;
import entidades.Cliente;
import entidades.Cuentas;
import exceptions.DAOException;

public class CuentasDAODBImpl implements CuentasDao {

	//ClienteDAODBImpl clienteDAO = new ClienteDAODBImpl();
	
	@Override
	public void crearCuenta(Cuentas c) throws DAOException {
		String sql = "INSERT INTO cuentas (numeroCuenta, dni, cajaahorro, cuentacorriente) VALUES ('" + c.getNumeroCuenta() + "', '" + c.getDniCliente() + "', '" + c.getCajaAhorros() + "', '"+ c.getCuentaCorriente() +"')";
		Connection c1 = null;
		try {
			c1 = DBManager.getInstance().getConnection();
			Statement s = c1.createStatement();
			s.executeUpdate(sql);
			c1.commit();
		} catch (SQLException e) {
				throw new DAOException("Problema al insertar ", e);
		} finally{
				DBManager.getInstance().cerrarConexion(c1);
		}
	}

	@Override
	public void eliminarCuenta(int numeroCuenta) throws DAOException {
		Connection c = null;
		try {
			String sql = "DELETE FROM cuentas WHERE numeroCuenta = '" + numeroCuenta + "'";
			c = DBManager.getInstance().getConnection();
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {
				throw new DAOException("Problema al eliminar cuenta ",e);
		} finally{
			DBManager.getInstance().cerrarConexion(c);
		}		
	}

	@Override
	public void updateCuentas(int numeroCuenta, float ahorro, float corriente) throws DAOException {
		String sql = "UPDATE cuentas SET cajaahorro = '" + ahorro + "', cuentacorriente = '" + corriente + "' WHERE numeroCuenta = '" + numeroCuenta + "'";
		Connection c = null;
		try {
			c = DBManager.getInstance().getConnection();
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {
			throw new DAOException("Problema al hacer update ", e);
		}finally{
			DBManager.getInstance().cerrarConexion(c);
		}		
	}

	@Override
	public Cuentas obtenerCuenta(int numeroCuenta) throws DAOException {
		String sql = "SELECT * FROM cuentas WHERE numeroCuenta = '" + numeroCuenta + "'";
		Cuentas cuenta = new Cuentas();
		Connection c = null;
		try {
		c = DBManager.getInstance().getConnection();
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery(sql);
			if(rs.next()) {
				int rsnumeroCuenta = rs.getInt("numeroCuenta");
				float rscuentacorriente = rs.getInt("cuentacorriente");
				float rscajaahorro = rs.getFloat("cajaahorro");
				int rsdni = rs.getInt("dni");
				cuenta.setNumeroCuenta(rsnumeroCuenta);
				cuenta.setDniCliente(rsdni);
				cuenta.setCuentaCorriente(rscuentacorriente);
				cuenta.setCajaAhorros(rscajaahorro);
			}
		} catch (SQLException e) {
			throw new DAOException("Problema al obtener cliente ", e);
		} finally{
			DBManager.getInstance().cerrarConexion(c);
		}

		return cuenta;
	}

	@Override
	public ArrayList<Cuentas> obtenerCuentas() throws DAOException {
		ArrayList<Cuentas> cuentas = new ArrayList<>();
		Connection c = null;
		try{
			Cuentas retorna = null;
			String sql = "SELECT * FROM cuentas";
			c = DBManager.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				int rsnumeroCuenta = rs.getInt("numeroCuenta");
				float rscuentacorriente = rs.getInt("cuentacorriente");
				float rscajaahorro = rs.getFloat("cajaahorro");
				int rsdni = rs.getInt("dni");
				retorna = new Cuentas();
				retorna.setNumeroCuenta(rsnumeroCuenta);
				retorna.setDniCliente(rsdni);
				retorna.setCuentaCorriente(rscuentacorriente);
				retorna.setCajaAhorros(rscajaahorro);
				cuentas.add(retorna);
			}
			return(cuentas);
		} catch(SQLException ex){
			throw new DAOException("Error de SQL ", ex);
		} finally {
			DBManager.getInstance().cerrarConexion(c);
		}
	}

	public Cuentas obtenerCuentaConDni(int dni) throws DAOException {
		String sql = "SELECT * FROM cuentas WHERE dni = '" + dni + "'";
		Cuentas cuenta = new Cuentas();
		Connection c = null;
		try {
		c = DBManager.getInstance().getConnection();
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery(sql);
			if(rs.next()) {
				int rsnumeroCuenta = rs.getInt("numeroCuenta");
				float rscuentacorriente = rs.getInt("cuentacorriente");
				float rscajaahorro = rs.getFloat("cajaahorro");
				int rsdni = rs.getInt("dni");
				cuenta.setNumeroCuenta(rsnumeroCuenta);
				cuenta.setDniCliente(rsdni);
				cuenta.setCuentaCorriente(rscuentacorriente);
				cuenta.setCajaAhorros(rscajaahorro);
			}
		} catch (SQLException e) {
			throw new DAOException("Problema al obtener cliente ", e);
		} finally{
			DBManager.getInstance().cerrarConexion(c);
		}

		return cuenta;
	}

}
