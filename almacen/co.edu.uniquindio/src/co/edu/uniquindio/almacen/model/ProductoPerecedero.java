/**
 * 
 */
package co.edu.uniquindio.almacen.model;

import java.util.Date;

/**
 * @author GonzalezHDanielaA
 *
 */
public class ProductoPerecedero extends Producto{
	
	private Date fechaVencimiento;
	
	/**
	 * 
	 * @param codigo
	 * @param nombre
	 * @param descripcion
	 * @param valorUnitario
	 * @param cantidad
	 * @param fechaVencimiento
	 */

	public ProductoPerecedero(String codigo, String nombre, String descripcion, double valorUnitario, int cantidad,
			Date fechaVencimiento) {
		super(codigo, nombre, descripcion, valorUnitario, cantidad);
		this.fechaVencimiento = fechaVencimiento;
	}

	/**
	 * @return the fechaVencimiento
	 */
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	/**
	 * @param fechaVencimiento the fechaVencimiento to set
	 */
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	
	
	
	
	

}
