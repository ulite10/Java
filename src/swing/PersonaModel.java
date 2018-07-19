package swing;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidades.Cliente;

public class PersonaModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Cliente> clientes;
	private static final int DNI = 0; private static final int NOMBRE = 1; private static final int APELLIDO = 2; private static final int CC = 3; private static final int CA = 4;
	private String[] titulos = {"Dni", "Nombre", "Apellido", "Cuenta Corriente", "Caja ahorros "};
	
	
	
	public PersonaModel(List<Cliente> clientes){
		this.clientes = clientes;
	}
	
	@Override
	public int getRowCount() {
		return clientes.size();
	}

	@Override
	public int getColumnCount() {
		return titulos.length;
	}

	@Override
	public Object getValueAt(int row, int column) {
		Cliente miCliente = clientes.get(row);
		switch(column){
		case DNI: return miCliente.getDni();
		case NOMBRE: return miCliente.getNombre();
		case APELLIDO: return miCliente.getApellido();
		case CC: return miCliente.getCuentaCorriente();
		case CA: return miCliente.getCajaAhorro();
		}
		return null;
	}
	
	public Cliente getCliente(int index){
		return clientes.get(index);
	}
	
	public String getColumnName(int column){
		return titulos[column];
	}
	


}
