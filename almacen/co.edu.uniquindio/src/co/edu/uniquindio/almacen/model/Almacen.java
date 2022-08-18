/**
 * 
 */
package co.edu.uniquindio.almacen.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;



/**
 * @author GonzalezHDanielaA
 *
 */
public class Almacen {
	
	
	
	//atributos:
		private String nombre;
		//Listas:
		ArrayList<Producto>listaProductos = new ArrayList<>();
		ArrayList<Cliente>listaClientes = new ArrayList<>();
		ArrayList<Venta>listaVentas = new ArrayList<>();
		ArrayList<DetalleVenta>listaDetalleVentas = new ArrayList<>();
		
		ArrayList<PersonaNatural> listaClienteNatural = new ArrayList<>();
		
		//Constructor1:
		public Almacen(String nombre) 
		{
			this.nombre = nombre;
			inicializarDatosProductos();			
			inicializarDatosCliente();
		}
		//Getters/Setters:
		public String getNombre() {
			return nombre;
		}
		public ArrayList<Cliente> getListaClientes() {
			return listaClientes;
		}
		
		public ArrayList<PersonaNatural> getListaClienteNatural() {
			return listaClienteNatural;
		}
		

		public void setListaClientes(ArrayList<Cliente> listaClientes) {
			this.listaClientes = listaClientes;
		}
		public void setListaClienteNatural(ArrayList<PersonaNatural> listaClientes) {
			this.listaClienteNatural = listaClientes;
		}


		
		public ArrayList<Venta> getListaVentas() {
			return listaVentas;
		}
		public void setListaVentas(ArrayList<Venta> listaVentas) {
			this.listaVentas = listaVentas;
		}
		public ArrayList<DetalleVenta> getListaDetalleVentas() {
			return listaDetalleVentas;
		}
		public void setListaDetalleVentas(ArrayList<DetalleVenta> listaDetalleVentas) {
			this.listaDetalleVentas = listaDetalleVentas;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public ArrayList<Producto> getListaProductos() {
			return listaProductos;
		}
		public void setListaProductos(ArrayList<Producto> listaProductos) {
			this.listaProductos = listaProductos;
		}
		@Override
		public String toString() {
			return "Almacen [nombre=" + nombre + ", listaProductos=" + listaProductos + ", listaClientes=" + listaClientes
					+ ", listaVentas=" + listaVentas + "]";
		}
		
		public void inicializarDatosProductos() {
			
			//Producto producto = new Producto(codigo,nombre,descricion,valorUnitario,cantProductor);
			Producto producto = new Producto();
			producto.setCodigo("1225");
			producto.setNombre("Mariscos");
			producto.setDescricion("Vida útil: 3 días");
			producto.setValorUnitario(2500.0);
			producto.setCantProductos(5);
			getListaProductos().add(producto);
			
			Producto producto1 = new Producto();
			producto1.setCodigo("3121");
			producto1.setNombre("Carne Refrigerada ");
			producto1.setDescricion("De 28 a 41 F°");
			producto1.setValorUnitario(2000.0);
			producto1.setCantProductos(1);
			getListaProductos().add(producto1);

			
			Producto producto2 = new Producto();
			producto2.setCodigo("4231");
			producto2.setNombre("Aceite de Oliva");
			producto2.setDescricion("Producto natural");
			producto2.setValorUnitario(2100.0);
			producto2.setCantProductos(3);
			getListaProductos().add(producto2);

			
			//Producto producto1 = new Producto("222","genaro","muy Maluco",20000.0,5);
			//Producto producto2 = new Producto("333","Pacho","mas o menos",21000.0,5);
		}
		
				
		public void inicializarDatosCliente() {
			Cliente cliente = new Cliente(); 
			cliente.setNombre("Oscar Tulio");
			cliente.setApellido("Orozco");
			cliente.setDireccion("Carrera 14 #3-12");
			cliente.setIdentificacion("1230401254");
			cliente.setTipoIdentificacion("NIT");
			cliente.setTelefono("1234125");
			getListaClientes().add(cliente);
			
			Cliente cliente2 = new PersonaNatural();
			cliente2.setNombre("Martha");
			cliente2.setApellido("Restrepo");
			cliente2.setDireccion("Carrera 14 #3-12");
			cliente2.setIdentificacion("113567234");
			cliente2.setTipoIdentificacion("CC");
			cliente2.setTelefono("1234125");
			
			getListaClientes().add(cliente2);
			
		}
		
		
		//Método CrearCliente
		public Cliente crearCliente(String identificacion,String tipoIdentificacion, String nombre, String apellidos,String direccion,String telefono) {
			Cliente cliente = null;
			// Verificar si el producto existe;
			//cliente =obtenerCliente(identificacion);

			if (cliente == null) {
				cliente = new Cliente();
				cliente.setIdentificacion(identificacion);
				cliente.setTipoIdentificacion(tipoIdentificacion);
				cliente.setNombre(nombre);
				cliente.setApellido(apellidos);
				cliente.setDireccion(direccion);
				cliente.setTelefono(telefono);
				
				getListaClientes().add(cliente);
				return cliente;
			} else {
				return null;
			}

		}
		
		// Método CrearCliente
		public Cliente crearClienteNatural(String identificacion, String tipoIdentificacion, String nombre,
				String apellidos, String direccion, String telefono, String email, LocalDate fechaNacimiento) {
			PersonaNatural cliente = null;
			// Verificar si el producto existe;
			// cliente =obtenerCliente(identificacion);

			if (cliente == null) {
				cliente = new PersonaNatural();
				cliente.setIdentificacion(identificacion);
				cliente.setTipoIdentificacion(tipoIdentificacion);
				cliente.setNombre(nombre);
				cliente.setApellido(apellidos);
				cliente.setDireccion(direccion);
				cliente.setTelefono(telefono);
				cliente.setEmail(email);
				cliente.setFechaNacimiento(fechaNacimiento);

				getListaClienteNatural().add(cliente);
				return cliente;

			} else {
				return null;
			}

		}
		
		public Cliente obtenerCliente(String identificacion) {

			for (Cliente cliente : listaClientes) {

				if (cliente.getIdentificacion() != null && cliente.getIdentificacion().equals(identificacion)) {
					return cliente;
				}
			}
			return null;
		}
		
		public Producto obtenerProducto(String codigo) {
			
			for (Producto producto : listaProductos) {
				if(producto.getCodigo().equals(codigo)) {
					return producto;
				}
			}
			return null;
		}
		

		//Método CrearProducto
		public Producto crearProducto(String codigo, String nombre, String descripcion, double valorProducto,
				int cantProductos) {
			Producto producto = null;
			// Verificar si el producto existe;
			producto = obtenerProducto(codigo);

			if (producto == null) {
				producto = new Producto();
				producto.setCodigo(codigo);
				producto.setNombre(nombre);
				producto.setDescricion(descripcion);
				producto.setValorUnitario(cantProductos);
				producto.setCantProductos(cantProductos);

				getListaProductos().add(producto);
				return producto;

			} else {
				return null;
			}

		}
		
		public boolean eliminarProducto(String codigo) {
			Producto producto = null;
			producto = obtenerProducto(codigo);
			
			if(producto != null) {
				getListaProductos().remove(producto);
				return true;
			}else {
				return false;
			}
			
		}
		
		public boolean eliminarCliente(String identificacion) {
			
			Cliente cliente =null;
			cliente = obtenerCliente(identificacion);
			
			if(cliente != null) {
				getListaClientes().remove(cliente);
				return true;
			}else {
				return false;
			}
			
		}
		
		// Método para actualizar productos
		public boolean actualizarProducto(String codigoActual, String nombre, String descripcion, double valorProducto,
				int cantProductos) {
			Producto producto = null;
			producto = obtenerProducto(codigoActual);

			if (producto != null) {
				producto.setCodigo(codigoActual);
				producto.setNombre(nombre);
				producto.setDescricion(descripcion);
				producto.setValorUnitario(valorProducto);
				producto.setCantProductos(cantProductos);
				return true;
			} else {
				return false;
			}

		}
		
		
		
		// Método para actualizar clientes
		public boolean actualizarCliente(String identificacion, String tipoIdentificacion, String nombre,
				String apellidos, String direccion, String telefono) {
			Cliente cliente = null;

			cliente = obtenerCliente(identificacion);

			if (cliente != null) {
				cliente.setIdentificacion(identificacion);
				cliente.setTipoIdentificacion(tipoIdentificacion);
				cliente.setNombre(nombre);
				cliente.setApellido(apellidos);
				cliente.setDireccion(direccion);
				cliente.setTelefono(telefono);
				return true;
			} else {
				return false;
			}

		}
		
		//VENTA
		
		public Venta crearVenta(String codigoVenta, LocalDate fecha, String codigoProducto, String identificacion,ArrayList<DetalleVenta> detalles) {
			Venta miventa =  new Venta();
			miventa.setIva(0.19);
			double total=0;
			
			for(DetalleVenta detalle: detalles) {
				total+= detalle.getSubTotal();
			}
			
			miventa.setCliente(obtenerCliente(identificacion));
			miventa.setCodigo(codigoVenta);
			miventa.setFecha(fecha);
			miventa.setDetalleVenta1(detalles);
			miventa.setIva(miventa.getIva()*total);
			miventa.setTotal(total+miventa.getIva());
			getListaVentas().add(miventa);			
			return miventa;
		}
			
		
		
		//Crear detalleVenta
		
		public DetalleVenta crearDetalleVenta(int cantidadProductosVendidos, double subTotal, Producto producto) {
			Producto producto1 = null;
			DetalleVenta detalle = null;
			
			
			//Verificar si el producto existe;
			producto = obtenerProducto(producto.getCodigo());
			
			
			if(producto != null) {
				detalle.setProductoVendido(producto);
				
				getListaProductos().add(producto);
				return detalle;
				
			}else 
			{
				return null;
			}
			
		}
		
		//Método CrearProducto
		
		
		
		
}
