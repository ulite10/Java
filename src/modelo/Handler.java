package modelo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import dbImpl.ClienteDAODBImpl;
import dbImpl.CuentasDAODBImpl;
import entidades.Cliente;
import entidades.Cuentas;
import exceptions.BusinessObjectException;
import exceptions.CuentaException;
import exceptions.LoginException;
import exceptions.UsuarioException;
import swing.*;

public class Handler {
	private BusinessObject businessObject;
	private MiFrame miFrame;
	private int dniCliente;

	public Handler(){
		ClienteDAODBImpl clienteDao = new ClienteDAODBImpl();
		CuentasDAODBImpl cuentasDao = new CuentasDAODBImpl();
		BusinessObject miLogica = new BusinessObject(clienteDao,cuentasDao);
		setBusinessObject(miLogica);
	}
	
	
	public void setBusinessObject(BusinessObject businessObject) {
		this.businessObject = businessObject;
	}
	
	public void setMiFrame(MiFrame miFrame){
		this.miFrame = miFrame;
	}
	
	
	
	
	/////////////////////////////////////////////////////////////////
	
	
	public void mostarMiPanelModifica(Cliente miCliente){
		PanelModificacion miPanelModificacion = new PanelModificacion();
		miPanelModificacion.setHandler(this);
		miPanelModificacion.editarCliente(miCliente);
		miFrame.setPanel(miPanelModificacion);
	}
	
	public void mostarMiPanelTodos(){
		PanelUsuarios miLista = new PanelUsuarios(this);
		miFrame.setPanel(miLista);

	}
	
	public void mostrarPanelCuentas(){
		PanelCuentas cuentas = new PanelCuentas(this);
		miFrame.setPanel(cuentas);
	}
	
	public void mostrarPanelAltaCuentas(){
		PanelAltaCuentas altaCuentas = new PanelAltaCuentas();
		altaCuentas.setHandler(this);
		miFrame.setPanel(altaCuentas);
	}
	
	public void mostarMiPanelAlta(){
		PanelAlta miPanelAlta = new PanelAlta();
		miPanelAlta.setHandler(this);
		miFrame.setPanel(miPanelAlta);
	}

	
	public Cliente buscarPersona(int dni){
		Cliente cliente = null;
		try {
			cliente = businessObject.consultaUsuarios(dni);
		} catch (BusinessObjectException e) {
			mostrarError(e.getMessage());
		}
		return cliente;
	}
	
	public void eliminarPersona(int dni){
		try {
			businessObject.eliminacionUsuario(dni);
			mostarMiPanelTodos();
		} catch (BusinessObjectException e) {
			mostrarError(e.getMessage());
			e.printStackTrace();
		} catch(UsuarioException e2){
			mostrarError(e2.getMessage());
		}
	}
	
	public void modificarPersona(float CA, float CC, int dni){
		try {
			businessObject.modificar(CA,CC,dni);
			mostarMiPanelTodos();
		} catch (BusinessObjectException e) {
			mostrarError(e.getMessage());
			e.printStackTrace();
		}
	}

	
	public void altaPersona(Cliente miCliente){
		 try {
			businessObject.altaUsuario(miCliente);
			mostrarSucces("Se ha dado de alta al usuario " + miCliente.getNombre());
			if(JOptionPane.showConfirmDialog(null, "Quiere seguir ingresando usuarios?") == 1){
				mostarMiPanelTodos();
			} else
				mostarMiPanelAlta();
		} catch (BusinessObjectException e) {
			mostrarError(e.getMessage());
		} catch(UsuarioException e2){
			mostrarError(e2.getMessage());
			mostarMiPanelAlta();
		}
	}
	
	public List<Cliente> mostrarTodos(){
		List<Cliente> miLista = new ArrayList<Cliente>();
		try {
			miLista.addAll(businessObject.mostrarTodosUsuarios());
		} catch (BusinessObjectException e) {
			mostrarError(e.getMessage());
			e.printStackTrace();
		}
		return miLista;
	}
	
	public List<Cuentas> mostrarCuentas(){
		List<Cuentas> miLista = new ArrayList<Cuentas>();
		try {
			miLista.addAll(businessObject.mostrarTodasCuentas());
		} catch (BusinessObjectException e) {
			mostrarError(e.getMessage());
			e.printStackTrace();
		}
		return miLista;
	}
	
	public void bajaCuenta(int numeroCuenta){
		
		try {
			businessObject.eliminarCuenta(numeroCuenta);
		} catch (CuentaException e) {
			mostrarError(e.getMessage());
		} catch (BusinessObjectException e) {
			mostrarError(e.getMessage());
		}
		
	}
	
	public void altaCuenta(Cuentas miCuenta){
		try {
			businessObject.altaCuenta(miCuenta);
		} catch (BusinessObjectException e) {
			e.printStackTrace();
		} catch (CuentaException e) {
			mostrarError(e.getMessage());
			mostrarHomeBanking();
		}
	}
	
	public void mostrarHomeBanking(){
		HomeBanking hb = new HomeBanking(this);
		hb.setTitulo(buscarPersona(getDniCliente()));
		hb.setTextTarjetas(buscarPersona(getDniCliente()));
		hb.setTextCuentas(buscarPersona(getDniCliente()));
		miFrame.setPanel(hb);	
	
	}
	
	public boolean validarLogin(int index, String pass) {
		boolean caso = false;
		try {
			caso = businessObject.validarLogin(index, pass);
			mostrarSucces("Login Exitoso");	
			if(index == 2){
				miFrame.setMenuUsuario();
				setDniCliente(Integer.parseInt(pass));
				miFrame.setVisible(true);
			} else {
				miFrame.setMenuAdmin();
				miFrame.setVisible(true);
			}
		} catch (LoginException e) {
			mostrarError(e.getMessage());
		} catch (BusinessObjectException e) {
			e.printStackTrace();
		}
		return caso;
	}
	
	public void setCuenta(int dni, int numeroCuenta){
		try {
			businessObject.modifCC(dni, numeroCuenta);
		} catch (BusinessObjectException e) {
			mostrarError(e.getMessage());
		}
	}
	
	public void mostrarError(String error){
		JOptionPane.showMessageDialog(null,error,"Error",JOptionPane.ERROR_MESSAGE);
	}
	public void mostrarSucces(String exito){
		JOptionPane.showMessageDialog(null,exito,"Exito",JOptionPane.INFORMATION_MESSAGE);
	}


	public int getDniCliente() {
		return dniCliente;
	}


	public void setDniCliente(int dniCliente) {
		this.dniCliente = dniCliente;
	}


	
	
}
