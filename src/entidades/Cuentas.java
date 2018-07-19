package entidades;

public class Cuentas {
	
	private int numeroCuenta;
	private float cuentaCorriente;
	private float cajaAhorros;
	private int dniCliente;
	
	public Cuentas(){
		
	}

	public float getCuentaCorriente() {
		return cuentaCorriente;
	}


	public void setCuentaCorriente(float cuentaCorriente) {
		this.cuentaCorriente = cuentaCorriente;
	}


	public float getCajaAhorros() {
		return cajaAhorros;
	}


	public void setCajaAhorros(float cajaAhorros) {
		this.cajaAhorros = cajaAhorros;
	}


	public int getNumeroCuenta() {
		return numeroCuenta;
	}


	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	
	@Override
	public String toString() {
		return "Cuentas [Dni Cliente =" + dniCliente + ", numeroCuenta=" + numeroCuenta + ", cuentaCorriente="
				+ cuentaCorriente + ", cajaAhorros=" + cajaAhorros + "]";
	}

	public int getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(int dniCliente) {
		this.dniCliente = dniCliente;
	}

}
