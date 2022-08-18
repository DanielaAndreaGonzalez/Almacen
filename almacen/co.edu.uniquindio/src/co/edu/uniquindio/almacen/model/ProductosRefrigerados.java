/**
 * 
 */
package co.edu.uniquindio.almacen.model;

/**
 * @author GonzalezHDanielaA
 *
 */
public class ProductosRefrigerados extends Producto{
	
	private String codigoAprobacion;
	private double temperaturaRecomendada;
	
	
/**
 * 
 * @param codigo
 * @param nombre
 * @param descripcion
 * @param valorUnitario
 * @param cantidad
 * @param codigoAprobacion
 * @param temperaturaRecomendada
 */
	public ProductosRefrigerados(String codigo, String nombre, String descripcion, double valorUnitario, int cantidad,
			String codigoAprobacion, double temperaturaRecomendada) {
		super(codigo, nombre, descripcion, valorUnitario, cantidad);
		this.codigoAprobacion = codigoAprobacion;
		this.temperaturaRecomendada = temperaturaRecomendada;
	}

	/**
	 * @return the codigoAprobacion
	 */
	public String getCodigoAprobacion() {
		return codigoAprobacion;
	}

	/**
	 * @param codigoAprobacion the codigoAprobacion to set
	 */
	public void setCodigoAprobacion(String codigoAprobacion) {
		this.codigoAprobacion = codigoAprobacion;
	}

	/**
	 * @return the temperaturaRecomendada
	 */
	public double getTemperaturaRecomendada() {
		return temperaturaRecomendada;
	}

	/**
	 * @param temperaturaRecomendada the temperaturaRecomendada to set
	 */
	public void setTemperaturaRecomendada(double temperaturaRecomendada) {
		this.temperaturaRecomendada = temperaturaRecomendada;
	}
	
	
	
	

}
