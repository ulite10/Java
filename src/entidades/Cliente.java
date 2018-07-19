package entidades;

public class Cliente {
	private String nombre;
	private String apellido;
	private int dni;
	private float cuentaCorriente;
	private float cajaAhorro;
	private Cuentas cuentas;
	private Tarjetas tarjetas;
	

	public Cliente() {
	
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public float getCuentaCorriente() {
		return cuentaCorriente;
		}
	public void setCuentaCorriente(float cuentaCorriente) {
		this.cuentaCorriente = cuentaCorriente;
	}
	
	public float getCajaAhorro() {
		return cajaAhorro;
		}
	
	public void setCajaAhorro(float cajaAhorros) {
		this.cajaAhorro = cajaAhorros;
	}
	@Override
	public String toString() {
		return "Nombre=" + nombre + " - Apellido=" + apellido
				+ " - Dni=" + dni + " - Cuentacorriente=" + cuentaCorriente
				+ " - Cajaahorro=" + cajaAhorro ;
	}

	public Tarjetas getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(Tarjetas tarjetas) {
		this.tarjetas = tarjetas;
	}

	public Cuentas getCuentas() {
		return cuentas;
	}

	public void setCuentas(Cuentas cuentas) {
		this.cuentas = cuentas;
	}
	
	
}
