package modelo;

import java.util.ArrayList;
import java.util.List;

import dbImpl.ClienteDAODBImpl;
import dbImpl.CuentasDAODBImpl;
import entidades.Cliente;
import entidades.Cuentas;
import exceptions.DAOException;
import exceptions.LoginException;
import exceptions.BusinessObjectException;
import exceptions.CuentaException;
import exceptions.UsuarioException;

public class BusinessObject {
	private ClienteDAODBImpl clienteDao;
	private CuentasDAODBImpl cuentasDao;
	private final String PASS = "admin";
	
	public BusinessObject(ClienteDAODBImpl clienteDao, CuentasDAODBImpl cuentasDao){
		setClienteDao(clienteDao);
		setCuentasDao(cuentasDao);
	}
	
	private void setClienteDao(ClienteDAODBImpl clienteDao){
		this.clienteDao = clienteDao;
	}
	private void setCuentasDao(CuentasDAODBImpl cuentasDao){
		this.cuentasDao = cuentasDao;
	}
	
	public Cliente consultaUsuarios(int dni) throws BusinessObjectException{
		Cliente miCliente = new Cliente();
		miCliente = null;
		try {
			miCliente = clienteDao.obtenerClientecondni(dni);
		} catch (DAOException e) {
			throw new BusinessObjectException("Hubo un problema en la base de datos, intente mas tarde, por ahi se resuelve solo (? " , e);
		}
		return miCliente;
	}
	
	public void eliminacionUsuario(int dni) throws BusinessObjectException, UsuarioException{
		try {
			if(clienteDao.obtenerClientecondni(dni).getApellido() != null){
				clienteDao.eliminarClientecondni(dni);
			} else {
				throw new UsuarioException("No se ha encontrado el usuario");
			}
		} catch (DAOException e) {
			throw new BusinessObjectException("Hubo un problema en la base de datos, intente mas tarde, por ahi se resuelve solo (? " , e);
		}
	}
	
	public void altaUsuario(Cliente miCliente) throws BusinessObjectException, UsuarioException{
		try {
			if(clienteDao.obtenerClientecondni(miCliente.getDni()).getNombre() == null){
				clienteDao.insertarCliente(miCliente);
			} else
				throw new UsuarioException("El usuario ya existe en la base de datos ");
		} catch (DAOException e) {
			throw new BusinessObjectException("Hubo un problema en la base de datos, intente mas tarde, por ahi se resuelve solo (? " , e);
		}
	}
	
	public List<Cliente> mostrarTodosUsuarios() throws BusinessObjectException{
		
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		try {
			listaClientes.addAll(clienteDao.obtenerTodos());
		} catch (DAOException e) {
			throw new BusinessObjectException("Hubo un problema en la base de datos, intente mas tarde, por ahi se resuelve solo (? " , e);
		}
		return listaClientes;
	}
	
	public void modificar(float CA, float CC, int dni) throws BusinessObjectException{
		try {
			clienteDao.updateCuentascliente(dni, CA, CC);
		} catch (DAOException e) {
			throw new BusinessObjectException("Hubo un problema en la base de datos, intente mas tarde, por ahi se resuelve solo (? " , e);
			
		}
	}
	
	public void modifCC(int dni, int numeroCuenta) throws BusinessObjectException{
		try {
			clienteDao.updateCuenta(numeroCuenta, dni);
		} catch (DAOException e) {
			throw new BusinessObjectException("Hubo un problema en la base de datos, intente mas tarde, por ahi se resuelve solo (? " , e);
		}
	}
	
	
								//////////////////////////////////////////////////////////////////////////
								///////////////////////////// CUENTAS ////////////////////////////////////
								//////////////////////////////////////////////////////////////////////////

	
	public void altaCuenta(Cuentas miCuenta) throws CuentaException, BusinessObjectException{
		try {
			if(cuentasDao.obtenerCuenta(miCuenta.getNumeroCuenta()).getNumeroCuenta() == 0){
				cuentasDao.crearCuenta(miCuenta);
			} else
				throw new CuentaException("La cuenta ya existe en la base de datos");
		} catch (DAOException e) {
			throw new BusinessObjectException("Hubo un problema en la base de datos, intente mas tarde, por ahi se resuelve solo (? " , e);
		}
	}
	
	
	public Cuentas consultarCuenta(int numeroCuenta) throws BusinessObjectException{
		Cuentas cuentaConsulta = new Cuentas();
		cuentaConsulta = null;
		try{
			cuentaConsulta = cuentasDao.obtenerCuenta(numeroCuenta);
		} catch(DAOException e){
			throw new BusinessObjectException("Hubo un problema en la base de datos, intente mas tarde, por ahi se resuelve solo (? " , e);
		}
		return cuentaConsulta;
	}
	
	public void eliminarCuenta(int numeroCuenta) throws BusinessObjectException, CuentaException{
		try {
			if(cuentasDao.obtenerCuenta(numeroCuenta).getNumeroCuenta() != 0){
				cuentasDao.eliminarCuenta(numeroCuenta);
			} else {
				throw new CuentaException("No se ha encontrado la cuenta buscada!");
			}
		} catch (DAOException e) {
			throw new BusinessObjectException("Hubo un problema en la base de datos, intente mas tarde, por ahi se resuelve solo (? " , e);
		}
		
	}
	
	public List<Cuentas> mostrarTodasCuentas() throws BusinessObjectException{
		
		List<Cuentas> listaCuentass = new ArrayList<Cuentas>();
		try {
			listaCuentass.addAll(cuentasDao.obtenerCuentas());
		} catch (DAOException e) {
			throw new BusinessObjectException("Hubo un problema en la base de datos, intente mas tarde, por ahi se resuelve solo (? " , e);
		}
		return listaCuentass;
	}
	
	public void modificarCuenta(int numeroCuenta, float cc, float ca){
		
	}

	public boolean validarLogin(int index, String pass) throws LoginException, BusinessObjectException {
		boolean caso = false;
		if(index==1){
			if(pass.equals(PASS)){		
				caso = true;
			} else
				throw new LoginException("Login incorrecto, verifique su contraseña o dni ");
		} else{
			int dni = Integer.parseInt(pass);
			if(consultaUsuarios(dni).getNombre()== null){
				throw new LoginException("Login incorrecto, su dni no aparece en la base de datos ");
			} else
				caso = true;
		}
		return caso;
	}
	
}
