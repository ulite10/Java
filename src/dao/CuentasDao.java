package dao;

import java.util.ArrayList;

import entidades.Cliente;
import entidades.Cuentas;
import exceptions.DAOException;

public interface CuentasDao {

	public void crearCuenta(Cuentas c) throws DAOException;
	public void eliminarCuenta(int numeroCuenta) throws DAOException;
	public void updateCuentas(int numeroCuenta, float ahorro, float corriente) throws DAOException;
	public Cuentas obtenerCuenta(int numeroCuenta) throws DAOException;
	public ArrayList<Cuentas> obtenerCuentas() throws DAOException;
}
