/**
 * 
 */
package co.edu.uniquindio.almacen.model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author GonzalezHDanielaA
 *
 */
public class Venta {
	
	
	private String codigo;
	private LocalDate fecha;
	private ArrayList<DetalleVenta> detalleVenta;
	private Cliente cliente;
	private double total;
	private double iva;
	
	
	
	public Venta(String codigo, LocalDate fecha, Cliente cliente, double total, double iva) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.detalleVenta = new ArrayList<>();
		this.cliente = cliente;
		this.total = total;
		this.iva = iva;
	}
	
	public Venta() {}

	public String getCodigo() {
		return this.codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	

	/**
	 * @return the detalleVenta
	 */
	public ArrayList<DetalleVenta> getDetalleVenta() {
		return detalleVenta;
	}

	public void setDetalleVenta1(ArrayList<DetalleVenta> detalleVenta) {
		this.detalleVenta = detalleVenta;
	}
	
	/**
	 * @param detalleVenta the detalleVenta to set
	 */
	public void setDetalleVenta(DetalleVenta detalleVenta) {
		this.detalleVenta.add(detalleVenta);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}
	
	

}
