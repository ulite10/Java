package dbImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import basics.DBManager;
import dao.ClienteDao;
import entidades.Cliente;
import exceptions.DAOException;

public class ClienteDAODBImpl implements ClienteDao{
	
	CuentasDAODBImpl cuentasDao = new CuentasDAODBImpl();

	@Override
	public void eliminarClientecondni(int dni) throws DAOException  {
		Connection c = null;
		try {
			c = DBManager.getInstance().getConnection();
			String sql = "DELETE FROM clientes WHERE dni = '" + dni + "'";
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {
				throw new DAOException("Problema al cargar el cliente ",e);
		} finally{
			DBManager.getInstance().cerrarConexion(c);
		}
	}


	@Override
	public Cliente obtenerClientecondni(int dni) throws DAOException {
		String sql = "SELECT * FROM clientes WHERE dni = '" + dni + "'";
		Cliente cliente = new Cliente();
		Connection c = null;
		try {
			c = DBManager.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			if(rs.next()) {
				String rsnombre = rs.getString("nombre");
				String rsapellido = rs.getString("apellido");
				int rsdni = rs.getInt("dni");
				float rscuentacorriente = rs.getInt("cuentacorriente");
				float rscajaahorro = rs.getFloat("cajaahorro");
				cliente.setNombre(rsnombre);
				cliente.setApellido(rsapellido);
				cliente.setDni(rsdni);
				cliente.setCuentaCorriente(rscuentacorriente);
				cliente.setCajaAhorro(rscajaahorro);
				cliente.setCuentas(cuentasDao.obtenerCuentaConDni(rsdni));
			}
		} catch (SQLException e) {
			throw new DAOException("Problema al obtener cliente ", e);
		} finally{
			DBManager.getInstance().cerrarConexion(c);
		}

		return cliente;
	}

	@Override
	
	public void insertarCliente(Cliente cliente) throws DAOException {
		String sql = "INSERT INTO clientes (nombre, apellido, dni, cajaahorro, cuentacorriente) VALUES ('" + cliente.getNombre() + "', '" + cliente.getApellido() + "', '" + cliente.getDni() + "', '" + cliente.getCajaAhorro() + "', '"+ cliente.getCuentaCorriente() + "')";
		Connection c = null;
		try {
			c = DBManager.getInstance().getConnection();
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {
				throw new DAOException("Problema al insertar ", e);
		} finally{
				DBManager.getInstance().cerrarConexion(c);
		}
	
	}
	
	public void updateCuentascliente(int dni, float ahorro, float corriente) throws DAOException {
		String sql = "UPDATE clientes SET cajaahorro = '" + ahorro + "', cuentacorriente = '" + corriente + "' WHERE dni = '" + dni + "'";
		Connection c = null;
		try {
			c = DBManager.getInstance().getConnection();
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {
			throw new DAOException("Problema al cargar las cuentas ", e);
		}finally{
			DBManager.getInstance().cerrarConexion(c);
		}
	}
	
	public void updateCuenta(int numeroCuenta, int dni) throws DAOException{
		String sql = "UPDATE clientes SET numeroCuenta = '" + numeroCuenta + "' WHERE dni = '" + dni + "' ";
		Connection c = null;
		try {
			c = DBManager.getInstance().getConnection();
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {
			throw new DAOException("Problema al cargar las cuentas ", e);
		}finally{
			DBManager.getInstance().cerrarConexion(c);
		}
	}
	public ArrayList<Cliente> obtenerTodos() throws DAOException {
		ArrayList<Cliente> clientes = new ArrayList<>();
		Connection c = null;
		try{
			Cliente retorna = null;
			String sql = "SELECT * FROM clientes";
			c = DBManager.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				String rsnombre = rs.getString("nombre");
				String rsapellido = rs.getString("apellido");
				int rsdni = rs.getInt("dni");
				float rscuentacorriente = rs.getInt("cuentacorriente");
				float rscajaahorro = rs.getFloat("cajaahorro");
				retorna = new Cliente();
				retorna.setNombre(rsnombre);
				retorna.setApellido(rsapellido);
				retorna.setDni(rsdni);
				retorna.setCuentaCorriente(rscuentacorriente);
				retorna.setCajaAhorro(rscajaahorro);
				clientes.add(retorna);
			}
			return(clientes);
		} catch(SQLException ex){
			throw new DAOException("Error de SQL ", ex);
		} finally {
			DBManager.getInstance().cerrarConexion(c);
		}
		
		
	}
	

	
}

