/**
 * 
 */
package co.edu.uniquindio.almacen.model;

import java.util.Date;

/**
 * @author GonzalezHDanielaA
 *
 */
public class ProductosEnvasados extends Producto {
	
	private Date fechaEnvasado;
	private double pesoEnvase;
	private PAIS paisOrigen;
	
	
/**
 * 
 * @param codigo
 * @param nombre
 * @param descripcion
 * @param valorUnitario
 * @param cantidad
 * @param fechaEnvasado
 * @param pesoEnvase
 * @param paisOrigen
 */
	public ProductosEnvasados(String codigo, String nombre, String descripcion, double valorUnitario, int cantidad,
			Date fechaEnvasado, double pesoEnvase, PAIS paisOrigen) {
		super(codigo, nombre, descripcion, valorUnitario, cantidad);
		this.fechaEnvasado = fechaEnvasado;
		this.pesoEnvase = pesoEnvase;
		this.paisOrigen = paisOrigen;
	}

	/**
	 * @return the fechaEnvasado
	 */
	public Date getFechaEnvasado() {
		return fechaEnvasado;
	}

	/**
	 * @param fechaEnvasado the fechaEnvasado to set
	 */
	public void setFechaEnvasado(Date fechaEnvasado) {
		this.fechaEnvasado = fechaEnvasado;
	}

	/**
	 * @return the pesoEnvase
	 */
	public double getPesoEnvase() {
		return pesoEnvase;
	}

	/**
	 * @param pesoEnvase the pesoEnvase to set
	 */
	public void setPesoEnvase(double pesoEnvase) {
		this.pesoEnvase = pesoEnvase;
	}

	/**
	 * @return the paisOrigen
	 */
	public PAIS getPaisOrigen() {
		return paisOrigen;
	}

	/**
	 * @param paisOrigen the paisOrigen to set
	 */
	public void setPaisOrigen(PAIS paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	
	
	
	
	
	
	

}
