/**
 * 
 */
package co.edu.uniquindio.almacen.model;

/**
 * @author GonzalezHDanielaA
 *
 */
public class Producto {
	//Atributos:
		protected String codigo;
		protected String nombre;
		protected String descricion;
		protected double valorUnitario;
		protected int cantProductos;
		//Constructor:
		public Producto(String codigo, String nombre, String descricion, double valorUnitario, int cantProductor) {
			super();
			this.codigo = codigo;
			this.nombre = nombre;
			this.descricion = descricion;
			this.valorUnitario = valorUnitario;
			this.cantProductos = cantProductor;
		}
		public Producto() {
			
		}
		
		public String getCodigo() {
			return codigo;
		}
		public void setCodigo(String codigo) {
			this.codigo = codigo;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getDescricion() {
			return descricion;
		}
		public void setDescricion(String descricion) {
			this.descricion = descricion;
		}
		public double getValorUnitario() {
			return valorUnitario;
		}
		public void setValorUnitario(double valorUnitario) {
			this.valorUnitario = valorUnitario;
		}
		public int getCantProductos() {
			return cantProductos;
		}
		public void setCantProductos(int cantProductos) {
			this.cantProductos = cantProductos;
		}
		//getters/setters:
		@Override
		public String toString() {
			return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", descricion=" + descricion + ", valorUnitario="
					+ valorUnitario + ", cantProductor=" + cantProductos + "]";
		}
}
