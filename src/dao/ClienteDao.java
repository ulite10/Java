package dao;

import java.sql.SQLException;
import java.util.ArrayList;

//import java.util.Collection;

import entidades.Cliente;
import exceptions.DAOException;

public interface ClienteDao {

	public void insertarCliente(Cliente c) throws DAOException;
	public void eliminarClientecondni(int dni) throws DAOException;
	public void updateCuentascliente(int dni, float ahorro, float corriente) throws DAOException;
	public Cliente obtenerClientecondni(int dni) throws DAOException;
	public ArrayList<Cliente> obtenerTodos() throws DAOException;
	
}
