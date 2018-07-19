package basics;
import entidades.Cliente;
import entidades.Cuentas;
import exceptions.DAOException;
import modelo.BusinessObject;
import modelo.Handler;
import swing.PanelUsuarios;
import swing.Login;
import swing.MiFrame;
import swing.PanelAlta;
import swing.PanelModificacion;

public class Main {

public static void main(String [] args) {

	/*	Handler cuentas = new Handler();
		Cuentas c =  new Cuentas();
		c.setNumeroCuenta(1);
		c.setCajaAhorros(1);
		c.setCuentaCorriente(1);
		c.setDniCliente(1);
		cuentas.altaCuenta(c);*/
		
		//System.out.println(c);
		iniciarv2();

	}
	
	
	private static void iniciarv2(){
		Handler miCoordinador = new Handler();
		MiFrame prueba = new MiFrame();
		prueba.setCoordinador(miCoordinador);
		miCoordinador.setMiFrame(prueba);
		Login lg = new Login(prueba, true);
		lg.setMiHandler(miCoordinador);
		lg.setVisible(true);
		//prueba.setVisible(true);

	}
	
}
