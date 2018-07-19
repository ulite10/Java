package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTable;

import entidades.Cuentas;
import modelo.Handler;

public class PanelCuentas extends PanelUsuarios{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PanelCuentas(Handler miCoordinador) {
		super(miCoordinador);
		listaUsuarios = new JTable(new CuentasModel(miCoordinador.mostrarCuentas()));
		panelUsuarios.setViewportView(listaUsuarios);
		titulo.setText("Cuentas");
	}
	
	@Override
	protected void setBotonEliminar() {
		// TODO Auto-generated method stub
		botonEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				miHandler.bajaCuenta(miHandler.mostrarCuentas().get(listaUsuarios.getSelectedRow()).getNumeroCuenta());
				
			}
		});
	}
	
	@Override
	protected void setBotonModificar() {
		// TODO Auto-generated method stub
		botonModificar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
