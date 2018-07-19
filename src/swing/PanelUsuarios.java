package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import modelo.Handler;

public class PanelUsuarios extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected javax.swing.JButton botonEliminar;
	protected javax.swing.JButton botonModificar;
    protected JTable listaUsuarios;
    protected javax.swing.JPanel panelGeneral;
    protected javax.swing.JScrollPane panelUsuarios;
    protected javax.swing.JLabel titulo;
    protected Handler miHandler;
    
    public void setMiCoordinador(Handler miCoordinador){
    	this.miHandler = miCoordinador;
    }
    

    public PanelUsuarios(Handler miCoordinador) {
    	setMiCoordinador(miCoordinador);
    	initComponents();
    }
    
                          
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;
        panelGeneral = new JPanel();
        botonModificar = new JButton();
        botonEliminar = new JButton();
        panelUsuarios = new JScrollPane();
        listaUsuarios = new JTable(new PersonaModel(miHandler.mostrarTodos()));
        titulo = new JLabel();
        
        setLayout(new java.awt.GridBagLayout());

        panelGeneral.setLayout(new javax.swing.BoxLayout(panelGeneral, javax.swing.BoxLayout.LINE_AXIS));

        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.ipady = 250;
        add(panelGeneral, gridBagConstraints);

        
        
        botonModificar.setText("Modificar");
        setBotonModificar();
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 36;
        gridBagConstraints.gridy = 7;
        add(botonModificar, gridBagConstraints);

        botonEliminar.setText("Eliminar");
        setBotonEliminar();
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        add(botonEliminar, gridBagConstraints);

        listaUsuarios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        panelUsuarios.setViewportView(listaUsuarios);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.ipadx = 140;
        gridBagConstraints.ipady = 40;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 0, 0);
        add(panelUsuarios, gridBagConstraints);

        titulo.setFont(new java.awt.Font("Lucida Grande", 0, 18)); 
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Usuarios");
        titulo.setToolTipText("");
        titulo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx =  17;
        gridBagConstraints.gridy = 0;
        add(titulo, gridBagConstraints);

    }        
    
    protected void setBotonEliminar(){
    	botonEliminar.addActionListener(new ActionListener() {

    		@Override
    		public void actionPerformed(ActionEvent e) {
    			try {
    				miHandler.eliminarPersona(miHandler.mostrarTodos().get(listaUsuarios.getSelectedRow()).getDni());
    			} catch (ArrayIndexOutOfBoundsException e1) {
    				miHandler.mostrarError("Seleccione una opcion ");
    			}

    		}
    	});
    }
    
    protected void setBotonModificar(){
    	 botonModificar.addActionListener(new ActionListener() {
 			
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				try {
 					PanelUsuarios.this.miHandler.mostarMiPanelModifica(miHandler.mostrarTodos().get(listaUsuarios.getSelectedRow()));
 				} catch (ArrayIndexOutOfBoundsException e1) {
 					miHandler.mostrarError("Seleccione una opcion ");
 				}
 			}
 		});
    }

}
