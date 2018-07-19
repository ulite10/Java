
package swing;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidades.Cliente;
import modelo.Handler;

/**
 *
 * @author Ulices
 */
public class HomeBanking extends javax.swing.JPanel {

	private JButton Transferencias;
	private JButton botonAltaCuenta;
	private JButton botonAltaCredito;
	private JButton botonBajaCuenta;
	private JButton botonAltaDebito;
	private JButton botonBajaCredito;
	private JButton botonBajaDebito;
	private JButton botonSalir;
	private JTextField textCajaAhorro;
	private JTextField textCredito;
	private JTextField textCuentaCorriente;
	private JTextField textDebito;
	private Handler miHandler;
	private JLabel labelTitulo;

	public void setMiHandler(Handler miHandler) {
		this.miHandler = miHandler;
	}

	public HomeBanking(Handler miHandler) {
		setMiHandler(miHandler);
		initComponents();
	}

	@SuppressWarnings("unchecked")

	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		Transferencias = new JButton();
		textCuentaCorriente = new JTextField();
		textCredito = new JTextField();
		textDebito = new JTextField();
		labelTitulo = new JLabel();
		botonSalir = new JButton();
		textCajaAhorro = new JTextField();
		botonAltaCuenta = new JButton();
		botonBajaCuenta = new JButton();
		botonAltaDebito = new JButton();
		botonAltaCredito = new JButton();
		botonBajaCredito= new JButton();
		botonBajaDebito = new JButton();
		
		
		textDebito.setEditable(false);
		textCajaAhorro.setEditable(false);
		textCredito.setEditable(false);
		textCuentaCorriente.setEditable(false);

		setBackground(new java.awt.Color(204, 255, 255));
		setLayout(new java.awt.GridBagLayout());

		Transferencias.setText("Transferencias");

		add(Transferencias, gridButton(12, 18));

		add(textCajaAhorro, gridText(0, 2));
		add(textCuentaCorriente, gridText(0, 4));
		add(textDebito, gridText(0, 8));
		add(textCredito, gridText(0, 10));

		botonSalir.setText("Salir");
		add(botonSalir, gridButton(12, 20));
		botonSalir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Esta seguro que quiere salir? ") == 0) {
					System.exit(0);
				}

			}
		});
		botonAltaCuenta.setText("Alta Cuentas ");
		add(botonAltaCuenta, gridButton(0, 12));
		botonBajaCuenta.setText("Baja Cuentas");
		add(botonBajaCuenta, gridButton(16, 12));
		botonAltaDebito.setText("Alta T. Debito");
		add(botonAltaDebito, gridButton(0, 14));
		botonAltaCredito.setText("Alta T. Credito");
		add(botonAltaCredito, gridButton(0, 16));
		botonBajaCredito.setText("Baja T. Credito");
		add(botonBajaCredito, gridButton(16, 16));
		botonBajaDebito.setText("Baja T. Debito");
		add(botonBajaDebito, gridButton(16, 14));

		labelTitulo.setFont(new java.awt.Font("Monaco", 0, 24));
		labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		labelTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 13;
		gridBagConstraints.ipadx = 114;
		gridBagConstraints.ipady = 5;
		add(labelTitulo, gridBagConstraints);

	}

	private GridBagConstraints gridText(int x, int y) {

		GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = x;
		gridBagConstraints.gridy = y;
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.ipadx = 150;
		return gridBagConstraints;
	}

	private GridBagConstraints gridButton(int x, int y) {
		GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = x;
		gridBagConstraints.gridy = y;
		return gridBagConstraints;
	}

	private void setListenerAltaCuenta() {
		botonBajaCuenta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

	private void setListenerBajaCuenta() {
		botonAltaCuenta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

	private void setListenerDeb() {
		botonAltaDebito.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

	private void setListenerCred() {
		botonAltaCredito.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

	public void setTitulo(Cliente miCliente) {
		String titulo = "Cliente: " + miCliente.getNombre();
		labelTitulo.setText(titulo);
	}

	public void setTextTarjetas(Cliente miCliente) {
		String noTiene = "Presione el boton para dar de alta ";
		if (miCliente.getTarjetas() == null) {
			textCredito.setText(noTiene);
			textDebito.setText(noTiene);
		} else {
			if (miCliente.getTarjetas().getNumeroTCredito() == 0) {
				String debito = "Nro:" + miCliente.getTarjetas().getNumeroTDebito() + "";
				textDebito.setText(debito);
			} else {
				String credito = "Nro:" + miCliente.getTarjetas().getNumeroTCredito() + "";
				textCredito.setText(credito);
			}

		}
	}

	public void setTextCuentas(Cliente miCliente) {
		String noTiene = "Presione el boton para dar de alta ";
		if (miCliente.getCuentas().getDniCliente() != miCliente.getDni()) {
			textCuentaCorriente.setText(noTiene);
			textCajaAhorro.setText(noTiene);
		} else {
			textCajaAhorro.setText("CA: $ " + miCliente.getCuentas().getCajaAhorros());
			textCuentaCorriente.setText("CC: $ " + miCliente.getCuentas().getCuentaCorriente());
		}
	}

}
