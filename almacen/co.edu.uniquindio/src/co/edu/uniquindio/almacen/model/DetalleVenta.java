/**
 * 
 */
package co.edu.uniquindio.almacen.model;

/**
 * @author GonzalezHDanielaA
 *
 */
public class DetalleVenta {
	
	private  int cantidadProductosVendidos;
	private double subTotal;
	private Producto productoVendido;
	/**
	 * @return the cantidadProductosVendidos
	 */
	public int getCantidadProductosVendidos() {
		return cantidadProductosVendidos;
	}
	/**
	 * @param cantidadProductosVendidos the cantidadProductosVendidos to set
	 */
	public void setCantidadProductosVendidos(int cantidadProductosVendidos) {
		this.cantidadProductosVendidos = cantidadProductosVendidos;
	}
	/**
	 * @return the subTotal
	 */
	public double getSubTotal() {
		return subTotal;
	}
	/**
	 * @param subTotal the subTotal to set
	 */
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	/**
	 * @return the productoVendido
	 */
	public Producto getProductoVendido() {
		return productoVendido;
	}
	/**
	 * @param productoVendido the productoVendido to set
	 */
	public void setProductoVendido(Producto productoVendido) {
		this.productoVendido = productoVendido;
	}
	
	@Override
	public String toString() {
		return "DetalleVenta [cantidadProductosVendidos=" + cantidadProductosVendidos + ", subTotal=" + subTotal
				+ ", productoVendido=" + productoVendido + "]";
	}
	
	
	
	
	

}
