package co.edu.uniquindio.almacen;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import co.edu.uniquindio.almacen.model.Almacen;
import co.edu.uniquindio.almacen.model.Cliente;
import co.edu.uniquindio.almacen.model.DetalleVenta;
import co.edu.uniquindio.almacen.model.Producto;
import co.edu.uniquindio.almacen.model.Venta;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Aplicacion extends Application {

	private Stage primaryStage;

	Almacen almacen = new Almacen("Almacen");

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle(" Almacen ");
		mostrarVentanaPrincipal();
	}

	private void mostrarVentanaPrincipal() {

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("view/almacenview.fxml"));

			AnchorPane rootLayout = (AnchorPane) loader.load();
			almacenController almacenController = loader.getController();

			almacenController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public ArrayList<Cliente> obtenerClientes() {
		return almacen.getListaClientes();
	}
	
	public ArrayList<Venta> obtenerVentas() {
		return almacen.getListaVentas();
	}
	
	public ArrayList<DetalleVenta> obtenerDetalleVentas() {
		return almacen.getListaDetalleVentas();
	}

	public Cliente crearCliente(String identificacion, String tipoIdentificacion, String nombre, String apellidos,
			String direccion, String telefono) {
		Cliente cliente = null;
		cliente = almacen.crearCliente(identificacion, tipoIdentificacion, nombre, apellidos, direccion, telefono);
		return cliente;
	}

	public Cliente crearClienteNatural(String identificacion, String tipoIdentificacion, String nombre,
			String apellidos, String direccion, String telefono, String email, LocalDate fechaNacimiento) {
		Cliente cliente = null;
		cliente = almacen.crearClienteNatural(identificacion, tipoIdentificacion, nombre, apellidos, direccion,
				telefono, email, fechaNacimiento);
		return cliente;
	}
	
	public boolean eliminarCliente(String indentificacion) {
		return almacen.eliminarCliente(indentificacion);
	}
	
	public boolean actualizarCliente(String identificacion, String tipoIdentificacion, String nombre, String apellidos,
			String direccion, String telefono) {

		return almacen.actualizarCliente(identificacion, tipoIdentificacion, nombre, apellidos, direccion, telefono);
	}

	//Productos

	public ArrayList<Producto> obtenerProductos() {
		return almacen.getListaProductos();
	}

	public Producto crearProducto(String codigo, String nombre, String descripcion, double valorProducto,
			int cantProductos) {
		Producto producto = null;
		producto = almacen.crearProducto(codigo, nombre, descripcion, valorProducto, cantProductos);
		return producto;
	}

	public boolean eliminarProducto(String codigo) {

		return almacen.eliminarProducto(codigo);
	}

	public boolean actualizarProducto(String codigoActual,String nombre, String descripcion, double valorProducto, int canProductos) {
		return almacen.actualizarProducto(codigoActual, nombre, descripcion, valorProducto, canProductos);
	}
	
	
	
	//Ventas
	
	public Venta crearVenta(String codigoVenta,LocalDate fecha,String codigoProducto,String identificacion,ArrayList<DetalleVenta> detalles) {
		Venta venta1 = null;
		
		venta1 = almacen.crearVenta(codigoVenta, fecha, codigoProducto, identificacion, detalles);
		return venta1;
	}
	
	
	public DetalleVenta crearDetalleVenta(int cantidadProductosVendidos, double subTotal, Producto producto) {
		DetalleVenta venta = null;		
		venta = almacen.crearDetalleVenta(cantidadProductosVendidos, subTotal, producto);
		return venta;
	}
	
	public Producto buscarProductoPorCodigo(String codigo) {
		return almacen.obtenerProducto(codigo);
	}
	public Cliente buscarClientePorIdentificacion(String identificacion) {
		return almacen.obtenerCliente(identificacion);
	}
	

}
