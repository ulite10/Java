package swing;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidades.Cuentas;

public class CuentasModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Cuentas> cuentas;
	private static final int NROCUENTA = 0;private static final int DNI = 1; private static final int CC = 2; private static final int CA = 3;
	private String[] titulos = {"Numero Cuenta", "DNI Cliente", "Cuenta Corriente", "Caja ahorros "};
	
	
	
	public CuentasModel(List<Cuentas> cuentas){
		this.cuentas = cuentas;
	}
	
	@Override
	public int getRowCount() {
		return cuentas.size();
	}

	@Override
	public int getColumnCount() {
		return titulos.length;
	}

	@Override
	public Object getValueAt(int row, int column) {
		Cuentas miCuenta = cuentas.get(row);
		switch(column){
		case NROCUENTA: return miCuenta.getNumeroCuenta();
		case DNI: return miCuenta.getDniCliente();
		case CC: return miCuenta.getCuentaCorriente();
		case CA: return miCuenta.getCajaAhorros();
		}
		return null;
	}
	
	public Cuentas getCliente(int index){
		return cuentas.get(index);
	}
	
	public String getColumnName(int column){
		return titulos[column];
	}
	


}