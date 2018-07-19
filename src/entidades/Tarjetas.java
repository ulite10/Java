package entidades;

public class Tarjetas {

	private Cliente miCliente;
	private int numeroTDebito;
	private int numeroTCredito;
	private float tarjetaDebito;
	private float tarjetaCredito;
	
	public Tarjetas(){
		
	}

	@Override
	public String toString() {
		return "Tarjetas [miCliente=(" + miCliente + "), numeroTDebito=" + numeroTDebito + ", numeroTCredito="
				+ numeroTCredito + ", tarjetaDebito=" + tarjetaDebito + ", tarjetaCredito=" + tarjetaCredito + "]";
	}

	public Cliente getMiCliente() {
		return miCliente;
	}

	public void setMiCliente(Cliente miCliente) {
		this.miCliente = miCliente;
	}

	public float getTarjetaDebito() {
		return tarjetaDebito;
	}

	public void setTarjetaDebito(float tarjetaDebito) {
		this.tarjetaDebito = tarjetaDebito;
	}

	public float getTarjetaCredito() {
		return tarjetaCredito;
	}

	public void setTarjetaCredito(float tarjetaCredito) {
		this.tarjetaCredito = tarjetaCredito;
	}

	public int getNumeroTCredito() {
		return numeroTCredito;
	}

	public void setNumeroTCredito(int numeroTCredito) {
		this.numeroTCredito = numeroTCredito;
	}

	public int getNumeroTDebito() {
		return numeroTDebito;
	}

	public void setNumeroTDebito(int numeroTDebito) {
		this.numeroTDebito = numeroTDebito;
	}
	
	
}
