package co.edu.uniquindio.almacen;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;



import co.edu.uniquindio.almacen.model.Cliente;
import co.edu.uniquindio.almacen.model.DetalleVenta;
import co.edu.uniquindio.almacen.model.PersonaNatural;
import co.edu.uniquindio.almacen.model.Producto;
import co.edu.uniquindio.almacen.model.Venta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class almacenController {

	Aplicacion aplicacion;

	ObservableList<Producto> listaProductosData = FXCollections.observableArrayList();
	ObservableList<Cliente> listaClientesData = FXCollections.observableArrayList();
	ObservableList<Venta> listaVentaData = FXCollections.observableArrayList();
	ObservableList<DetalleVenta> listaDetalleVentaData = FXCollections.observableArrayList();

	Producto productoSelecionado;
	Cliente clienteSelecionado;
	Venta ventaSeleccionada;
	DetalleVenta detalleSeleccionado;

	ArrayList<DetalleVenta> listaDetalleVenta = new ArrayList<>();
	
	ArrayList<Venta> listaVenta = new ArrayList<>();

	@FXML
	private AnchorPane pincipal;
	@FXML
	private TextField txtNombreCli;
	@FXML
	private TextField txtApellidosCli;
	@FXML
	private TextField txtDireccionCli;
	@FXML
	private TextField txtTelefonoCli;

	@FXML
	private TextField txtCodigoVenta;

	@FXML
	private TextField txtIdentificacionClienteVenta;

	@FXML
	private TextField txtCodigoProductoVenta;

	@FXML
	private ComboBox<String> txtTipoIdentificacionCli;

	@FXML
	private TextField txtIdentificacionCli;
	@FXML
	private TextField txtEmailCli;
	@FXML
	private Button btnNuevoCli;
	@FXML
	private Button btnAgregarCli;
	@FXML
	private Button btnActualizarCli;
	@FXML
	private Button btnAgregarProductoVenta;

	@FXML
	private DatePicker txtFechaNacimientoCli;

	@FXML
	private DatePicker txtfechaVenta;

	@FXML
	private Button btnEliminarCli;

	@FXML
	private Button btnGuardarVenta;

	@FXML
	private TableView<Cliente> tblClientes;
	@FXML
	private TableColumn<Cliente, String> columnNombreCli;
	@FXML
	private TableColumn<Cliente, String> columnApellidoCli;
	@FXML
	private TableColumn<Cliente, String> columnIdentificacionCli;
	@FXML
	private TableColumn<Cliente, String> columnTipoIdentificacionCli;
	@FXML
	private TableColumn<Cliente, String> columnDireccionCli;
	@FXML
	private TableColumn<Cliente, String> columnTelefonoCli;

	@FXML
	private TableColumn<PersonaNatural, String> columnEmail;

	@FXML
	private TextField txtNombre;
	@FXML
	private TextField txtDescripcion;
	@FXML
	private TextField txtValorProducto;
	@FXML
	private TextField txtCantidadExistente;
	@FXML
	private TextField txtCodigo;

	@FXML
	private TextField txtcantidadProductoVenta;

	@FXML
	private Button btnActualizar;
	@FXML
	private Button btnNuevo;
	@FXML
	private Button btnAgregar;
	@FXML
	private ComboBox<String> cbxProducto;

	@FXML
	private TableView<Venta> tablaVenta;

	@FXML
	private TableView<DetalleVenta> tablaDetalleVenta;

	@FXML
	private TableView<Producto> tableProductos;
	@FXML
	private TableColumn<Producto, String> columnCodigo;
	@FXML
	private TableColumn<Producto, String> columnDescription;
	@FXML
	private TableColumn<Producto, String> columnNombre;
	@FXML
	private TableColumn<Producto, ?> columnTipoProducto;
	@FXML
	private TableColumn<Producto, Double> columnValorProducto;
	@FXML
	private TableColumn<Producto, Integer> columnCantidadExistente;
	@FXML
	private TableColumn<Venta, String> columnCodigoVenta;

	@FXML
	private TableColumn<Venta, ?> columnIdentificacionClienteVenta;
	@FXML
	private TableColumn<Venta, ?> columnNombreClienteVenta;
	@FXML
	private TableColumn<Venta, String> columnTotalVenta;
	@FXML
	private TableColumn<Venta, String> columnIvaVenta;
	@FXML
	private TableColumn<Venta, LocalDate> columnFechaVenta;
	@FXML
	private TableColumn<DetalleVenta, Integer> columnCantidadProductosDetalle;
	@FXML
	private TableColumn<DetalleVenta, Double> columnSubtotalDetalle;

	@FXML
	private Button btnEliminar;

	@FXML
	void initialize() {
		this.columnCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		this.columnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columnDescription.setCellValueFactory(new PropertyValueFactory<>("descricion"));
		this.columnValorProducto.setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));
		this.columnCantidadExistente.setCellValueFactory(new PropertyValueFactory<>("cantProductos"));

		tableProductos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

			productoSelecionado = newSelection;

			mostrarInformacionProducto(productoSelecionado);

		});
		ObservableList<String> tiposIdentificacion = FXCollections.observableArrayList();
		tiposIdentificacion.addAll("NIT", "CC");
		this.txtTipoIdentificacionCli.setItems(tiposIdentificacion);
		
		this.columnNombreCli.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columnApellidoCli.setCellValueFactory(new PropertyValueFactory<>("apellido"));
		this.columnIdentificacionCli.setCellValueFactory(new PropertyValueFactory<>("identificacion"));
		this.columnTipoIdentificacionCli.setCellValueFactory(new PropertyValueFactory<>("tipoIdentificacion"));
		this.columnDireccionCli.setCellValueFactory(new PropertyValueFactory<>("direccion"));
		this.columnTelefonoCli.setCellValueFactory(new PropertyValueFactory<>("telefono"));
		
		// this.columnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

		tblClientes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

		clienteSelecionado = newSelection;

		mostrarInformacionCliente(clienteSelecionado);

		});

		this.columnCodigoVenta.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		this.columnTotalVenta.setCellValueFactory(new PropertyValueFactory<>("total"));
		this.columnIvaVenta.setCellValueFactory(new PropertyValueFactory<>("iva"));
		this.columnNombreClienteVenta.setCellValueFactory(new PropertyValueFactory<>("cliente"));
		this.columnFechaVenta.setCellValueFactory(new PropertyValueFactory<>("fecha"));

		tablaVenta.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

			ventaSeleccionada = newSelection;

			// mostrarInformacionCliente(clienteSelecionado);

		});

		this.columnSubtotalDetalle.setCellValueFactory(new PropertyValueFactory<>("subTotal"));
		this.columnCantidadProductosDetalle.setCellValueFactory(new PropertyValueFactory<>("cantidadProductosVendidos"));

		tablaDetalleVenta.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

			detalleSeleccionado = newSelection;

			// mostrarInformacionCliente(clienteSelecionado);
		});
	}
	
	// Event Listener on Button[#btnNuevoCli].onAction
	public void mostrarInformacionCliente(Cliente clienteSeleccionado) {
		if (clienteSeleccionado != null) {
			txtNombreCli.setText(clienteSeleccionado.getNombre());
			txtIdentificacionCli.setText(clienteSeleccionado.getIdentificacion());
			txtApellidosCli.setText(clienteSeleccionado.getApellido());
			txtDireccionCli.setText(clienteSeleccionado.getDireccion());
			txtTelefonoCli.setText(clienteSeleccionado.getTelefono());
			txtTipoIdentificacionCli.setValue(clienteSeleccionado.getTipoIdentificacion());

		}

	}

	@FXML
	public void nuevoClienteAction(ActionEvent event) {
		nuevoCliente();
	}
	// Event Listener on Button[#btnAgregarCli].onAction

	@FXML
	public void agregarClienteAction(ActionEvent event) {
		agregarCliente();
	}
	// Event Listener on Button[#btnActualizarCli].onAction

	@FXML
	public void actualizarClienteAction(ActionEvent event) {
		actualizarCliente();
	}
	// Event Listener on Button[#btnEliminarCli].onAction

	@FXML
	public void eliminarClienteAction(ActionEvent event) {
		eliminarCliente();
	}
	// Event Listener on Button[#btnActualizar].onAction

	@FXML
	public void actualizarProductoAction(ActionEvent event) {
		actualizarProducto();
	}
	// Event Listener on Button[#btnNuevo].onAction

	@FXML
	public void nuevoProductoAction(ActionEvent event) {
		nuevoProducto();
	}
	// Event Listener on Button[#btnAgregar].onAction

	@FXML
	public void agregarProductoAction(ActionEvent event) {
		agregarProducto();
	}
	// Event Listener on Button[#btnEliminar].onAction

	@FXML
	public void obtenerTipoIdentificacionAction(ActionEvent event) {
		if (txtTipoIdentificacionCli.getValue().toString().equals("NIT")) {
			//txtEmailCli.setVisible(false);
			txtEmailCli.setEditable(false);
			txtFechaNacimientoCli.setEditable(false);
			//txtFechaNacimientoCli.setVisible(false);
			
		}else {
			txtEmailCli.setEditable(true);
			txtFechaNacimientoCli.setEditable(true);
		}
		
	}

	@FXML
	void obtenerTipoIdentificacionAction1(MouseEvent event) {
		if (txtTipoIdentificacionCli.getValue().equals("NIT")) {
			//txtEmailCli.setVisible(false);
			txtEmailCli.setEditable(false);
			
			//txtFechaNacimientoCli.setVisible(false);
			System.out.println("Entré 2");
		}else {
			txtEmailCli.setVisible(true);
		}
		System.out.println("Entré");
	}
	
	@FXML
    void mouseClickEvent(MouseEvent event) {
		//txtTipoIdentificacionCli.getSelectionModel().getSelectedItem().equals("NIT")
		
		int num= txtTipoIdentificacionCli.getSelectionModel().getSelectedIndex();
		if (num == 1) {
			//txtEmailCli.setVisible(false);
			txtEmailCli.setEditable(false);
			//txtFechaNacimientoCli.setVisible(false);
			System.out.println("Entré 2");
		}else {
			txtEmailCli.setVisible(true);
			txtFechaNacimientoCli.setVisible(true);
		}
		System.out.println("Entré");
    }

	@FXML
	void guardarVenta(ActionEvent event) {
		guardarVenta();
	}

	@FXML
	public void eliminarProductoAction(ActionEvent event) {
		eliminarProducto();
	}

	@FXML
	public void agregarProductoVentaAction(ActionEvent event) {
		agregarProductoDetalleVenta();
	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
		tableProductos.getItems().clear();
		tableProductos.setItems(getListaProductosData());

		tblClientes.getItems().clear();
		tblClientes.setItems(getListaClienteData());

		tablaVenta.getItems().clear();
		tablaVenta.setItems(getListaDetalleVenta());

		tablaDetalleVenta.getItems().clear();
		tablaDetalleVenta.setItems(getListaDetalleVentas());

	}
	
	

	public ObservableList<Producto> getListaProductosData() {

		listaProductosData.addAll(aplicacion.obtenerProductos());

		return listaProductosData;
	}

	public ObservableList<Cliente> getListaClienteData() {

		listaClientesData.addAll(aplicacion.obtenerClientes());
		return listaClientesData;
	}

	public ObservableList<Venta> getListaDetalleVenta() {
		listaVentaData.addAll(aplicacion.obtenerVentas());
		return listaVentaData;
	}

	public ObservableList<DetalleVenta> getListaDetalleVentas() {
		listaDetalleVentaData.addAll(aplicacion.obtenerDetalleVentas());
		return listaDetalleVentaData;
	}

	// CRUD CLIENTES
	public void agregarCliente() {
		// capturar datos de la interfaz:
		String tipoIdentificacion = txtTipoIdentificacionCli.getValue().toString();
		String identificacion = txtIdentificacionCli.getText();
		String nombre = txtNombreCli.getText();
		String apellidos = txtApellidosCli.getText();
		String direccion = txtDireccionCli.getText();
		String telefono = txtTelefonoCli.getText();
		String email = txtEmailCli.getText();
		LocalDate fecha = txtFechaNacimientoCli.getValue();

		if (tipoIdentificacion.equals("NIT")) {
			// validar información capturada:
			if (datosValidosCliente(identificacion, nombre, apellidos, direccion, telefono) == true) {
				// registrar
				Cliente cliente = null;

				// producto =
				// aplicacion.crearProducto(codigo,nombre,descripcion,valorProducto,cantProductos);
				cliente = aplicacion.crearCliente(identificacion, tipoIdentificacion, nombre, apellidos, direccion,
						telefono);

				if (cliente != null) {
					listaClientesData.add(cliente);
					mostrarMensaje("Notificación Cliente", "Cliente registrado", "El Cliente se ha registrado",
							AlertType.INFORMATION);

				} else {
					mostrarMensaje("Notificación Cliente", "Cliente no registrado", "El Cliente no se ha registrado",
							AlertType.INFORMATION);
				}

			}

		} else {
			// validar información capturada:
			if (datosValidosCliente(identificacion, nombre, apellidos, direccion, telefono) == true) {
				// registrar
				Cliente cliente = null;

				// producto =
				// aplicacion.crearProducto(codigo,nombre,descripcion,valorProducto,cantProductos);
				cliente = aplicacion.crearClienteNatural(identificacion, tipoIdentificacion, nombre, apellidos,
						direccion, telefono, email, fecha);

				if (cliente != null) {
					listaClientesData.add(cliente);
					mostrarMensaje("Notificación Cliente", "Cliente registrado", "El Cliente se ha registrado",
							AlertType.INFORMATION);

				} else {
					mostrarMensaje("Notificación Cliente", "Cliente no registrado", "El Cliente no se ha registrado",
							AlertType.INFORMATION);
				}

			}
		}

	}

	// Método para eliminar producto
	public void eliminarCliente() {

		boolean flagClienteEliminado = false;

		if (clienteSelecionado != null) {

			if (mostrarMensajeConfirmacion("Esta seguro de eliminar el cliente?") == true) {

				flagClienteEliminado = aplicacion.eliminarCliente(clienteSelecionado.getIdentificacion());

				if (flagClienteEliminado == true) {

					listaClientesData.remove(clienteSelecionado);
					clienteSelecionado = null;
					tblClientes.getSelectionModel().clearSelection();

					limpiarCampoTextoCliente();
					mostrarMensaje("Notificación Cliente", "Cliente eliminado", "El Cliente se ha eliminado",
							AlertType.INFORMATION);
				} else {
					mostrarMensaje("Notificación Cliente", "Cliente no eliminado", "El Cliente no se ha eliminado",
							AlertType.ERROR);
				}
			}

		} else {
			mostrarMensaje("Notificación Cliente", "Cliente no seleccionado", "Debe seleccionar un ClienteCliente",
					AlertType.WARNING);
		}

	}

	public void nuevoCliente() {

		txtIdentificacionCli.setText("Ingrese la identificación");
		txtNombreCli.setText("Ingrese el nombre del cliente");
		txtApellidosCli.setText("Ingrese los apellidos");
		txtDireccionCli.setText("Ingrese la dirección");
		txtTelefonoCli.setText("Ingrese el teléfono del clietne_");
		txtEmailCli.setText("Ingrese el email si el tipo de id es CC");
	}

	// Método para actualizar un producto
	public void actualizarCliente() {
		try {
			String tipoIdentificacion = txtTipoIdentificacionCli.getValue().toString();
			String identificacion = txtIdentificacionCli.getText();
			String nombre = txtNombreCli.getText();
			String apellidos = txtApellidosCli.getText();
			String direccion = txtDireccionCli.getText();
			String telefono = txtTelefonoCli.getText();

			boolean flagClientectualizado = false;

			if (clienteSelecionado != null) {
				if (datosValidosCliente(identificacion, nombre, apellidos, direccion, telefono) == true) {

					flagClientectualizado = aplicacion.actualizarCliente(clienteSelecionado.getIdentificacion(),
							tipoIdentificacion, nombre, apellidos, direccion, telefono);

					if (flagClientectualizado == true) {
						tblClientes.refresh();
						mostrarMensaje("Notificación Cliente", "Cliente actualizado", "El cliente se ha actualizado",
								AlertType.INFORMATION);
					} else {
						mostrarMensaje("Notificación cliente", "cliente no actualizado",
								"El cliente no se ha actualizado", AlertType.ERROR);
					}
				}

			}
		} catch (NumberFormatException e) {
			mostrarMensaje("Notificación Producto", "Producto no seleccionado", "Debe seleccionar un producto",
					AlertType.WARNING);
			// else {
			// mostrarMensaje("Notificación Producto", "Producto no seleccionado" , "Debe
			// seleccionar un producto", AlertType.WARNING);
			// }

		}

	}

	public boolean datosValidosCliente(String identificacion, String nombre, String apellidos, String direccion,
			String telefono) {
		String mensaje = " ";
		if (identificacion == null || identificacion.equalsIgnoreCase(" ")) {
			mensaje += "Identificación es inválida \n";
		}
		if (nombre == null || nombre.equalsIgnoreCase(" ")) {
			mensaje += "nombre es inválido \n";
		}
		if (apellidos == null || apellidos.equalsIgnoreCase(" ")) {
			mensaje += "apellidos es inválido \n";
		}
		if (direccion == null || direccion.equalsIgnoreCase(" ")) {
			mensaje += "direccion es inválida \n";
		}
		if (telefono == null || telefono.equalsIgnoreCase(" ")) {
			mensaje += "telefono es inválido \n";
		}

		if (mensaje.equalsIgnoreCase(" ")) {
			return true;
		} else {
			// mostrarMensaje("Notificación Producto", "Datos invalidos" ,mensaje,
			// AlertType.WARNING);
			return false;
		}
	}

	// Metodo para limpiar los campos de texto
	public void limpiarCampoTextoCliente() {
		txtIdentificacionCli.setText(" ");
		txtNombreCli.setText(" ");
		txtApellidosCli.setText(" ");
		txtTipoIdentificacionCli.setValue("");
		txtTelefonoCli.setText(" ");
		txtDireccionCli.setText(" ");
	}

	// CRUD PRODUCTOS

	public void mostrarInformacionProducto(Producto productoSelecionado) {
		if (productoSelecionado != null) {
			txtCodigo.setText(productoSelecionado.getCodigo());
			txtNombre.setText(productoSelecionado.getNombre());
			txtDescripcion.setText(productoSelecionado.getDescricion());
			txtValorProducto.setText(productoSelecionado.getValorUnitario() + " ");
			txtCantidadExistente.setText(productoSelecionado.getCantProductos() + " ");
		}

	}

	// Método para agregar un producto:
	// Método para agregar un producto:
	public void agregarProducto() {
		try {
			// capturar datos de la interfaz:
			String codigo = txtCodigo.getText();
			String nombre = txtNombre.getText();
			String descripcion = txtDescripcion.getText();
			double valorProducto = Double.parseDouble(txtValorProducto.getText());
			int cantProductos = Integer.parseInt(txtCantidadExistente.getText());

			// validar información capturada:
			if (datosValidos(codigo, nombre, descripcion, valorProducto, cantProductos) == true) {
				// registrar
				Producto producto = null;

				producto = aplicacion.crearProducto(codigo, nombre, descripcion, valorProducto, cantProductos);

				if (producto != null) {
					listaProductosData.add(producto);
					limpiarCampoTextoProducto();
					mostrarMensaje("Notificación Producto", "Producto registrado", "El producto se ha registrado",
							AlertType.INFORMATION);

				} else {
					mostrarMensaje("Notificación Producto", "Producto no registrado",
							"El producto con" + codigo + " ya se encuentra registrado", AlertType.ERROR);
				}

			}
		} catch (NumberFormatException e) {
			mostrarMensaje("Notificación Producto", "Producto no registrado", "El producto no se logro registrar",
					AlertType.ERROR);
		}

	}

	// Método para eliminar producto
	public void eliminarProducto() {

		boolean flagProductoEliminado = false;

		if (productoSelecionado != null) {

			if (mostrarMensajeConfirmacion("Esta seguro de eliminar el producto?") == true) {

				flagProductoEliminado = aplicacion.eliminarProducto(productoSelecionado.getCodigo());

				if (flagProductoEliminado == true) {
					listaProductosData.remove(productoSelecionado);
					productoSelecionado = null;
					tableProductos.getSelectionModel().clearSelection();
					limpiarCampoTextoProducto();
					mostrarMensaje("Notificación Producto", "Producto eliminado", "El producto se ha eliminado",
							AlertType.INFORMATION);
				} else {
					mostrarMensaje("Notificación Producto", "Producto no eliminado", "El producto no se ha eliminado",
							AlertType.ERROR);
				}
			}

		} else {
			mostrarMensaje("Notificación Producto", "Producto no seleccionado", "Debe seleccionar un producto",
					AlertType.WARNING);
		}

	}

	// Método para mostrar mensajes con ALERT:
	public boolean mostrarMensajeConfirmacion(String mensaje) {
		Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
		alerta.setHeaderText(null);
		alerta.setContentText(mensaje);
		Optional<ButtonType> action = alerta.showAndWait();

		if (action.get() == ButtonType.OK) {
			return true;
		} else {
			return false;
		}
	}

	// Método para actualizar un producto
	public void actualizarProducto() {
		try {
			String codigo = txtCodigo.getText();
			String nombre = txtNombre.getText();
			String descripcion = txtDescripcion.getText();
			double valorProducto = Double.parseDouble(txtValorProducto.getText());
			int cantProductos = Integer.parseInt(txtCantidadExistente.getText());

			boolean flagProductoActualizado = false;

			if (productoSelecionado != null) {

				if (datosValidos(codigo, nombre, descripcion, valorProducto, cantProductos) == true) {

					flagProductoActualizado = aplicacion.actualizarProducto(productoSelecionado.getCodigo(), nombre,
							descripcion, valorProducto, cantProductos);
					
					if (flagProductoActualizado == true) {
						tableProductos.refresh();
						mostrarMensaje("Notificación Producto", "Producto actualizado", "El producto se ha actualizado",
								AlertType.INFORMATION);
					} else {
						mostrarMensaje("Notificación Producto", "Producto no actualizado",
								"El producto no se ha actualizado", AlertType.ERROR);
					}
				}

			}
		} catch (NumberFormatException e) {
			mostrarMensaje("Notificación Producto", "Producto no seleccionado", "Debe seleccionar un producto",
					AlertType.WARNING);
			// else {
			// mostrarMensaje("Notificación Producto", "Producto no seleccionado" , "Debe
			// seleccionar un producto", AlertType.WARNING);
			// }

		}

	}

	// Método para crear un nuevo producto
	public void nuevoProducto() {

		txtCodigo.setText("Ingrese el código  ");
		txtNombre.setText("Ingrese el nombre ");
		txtDescripcion.setText("Ingrese la descripcion ");
		txtValorProducto.setText("Ingrese el valor unitario ");
		txtCantidadExistente.setText("Ingrese la cantidad existente ");

	}

	// Metodo para limpiar los campos de texto
	public void limpiarCampoTextoProducto() {
		txtCodigo.setText(" ");
		txtNombre.setText(" ");
		txtDescripcion.setText(" ");
		txtValorProducto.setText(" ");
		txtCantidadExistente.setText(" ");

	}

	public void limpiarCampoTextoVenta() {
		txtCodigoVenta.setText(" ");

		txtCodigoProductoVenta.setText(" ");
		;
		txtIdentificacionClienteVenta.setText(" ");

	}

	public void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {
		Alert alerta = new Alert(alertType);
		alerta.setTitle(titulo);
		alerta.setHeaderText(header);
		alerta.setContentText(contenido);
		alerta.showAndWait();
	}

	public boolean datosValidos(String codigo, String nombre, String descripcion, double valorProducto,
			int cantProductos) {

		String mensaje = " ";
		if (codigo == null || codigo.equalsIgnoreCase(" ")) {
			mensaje += "El código es invalido  \n ";
		}
		if (nombre == null || nombre.equalsIgnoreCase(" ")) {
			mensaje += "El nombre es invalido  \n ";
		}
		if (descripcion == null || descripcion.equalsIgnoreCase(" ")) {
			mensaje += "la descripción es invalida  \n ";
		}
		if (valorProducto == 0.0) {
			mensaje += "El valor es invalido  \n ";
		}
		if (cantProductos == 0) {
			mensaje += "la cantidad es invalida  \n ";
		}

		if (mensaje.equalsIgnoreCase(" ")) {
			return true;
		} else {
			mostrarMensaje("Notificación Producto", "Datos invalidos", mensaje, AlertType.WARNING);
			return false;
		}
	}

	// VENTA
	public void guardarVenta() {
		try {
			// capturar datos de la interfaz:
			String codigoVenta = txtCodigoVenta.getText();
			LocalDate fecha = txtfechaVenta.getValue();
			String codigoProducto = txtCodigoProductoVenta.getText();
			String identificacion = txtIdentificacionClienteVenta.getText();

			// validar información capturada:
			if (datosValidosVenta(codigoVenta, fecha, codigoProducto, identificacion) == true) {
				// registrar
				Venta venta = null;

				venta = aplicacion.crearVenta(codigoVenta, fecha, codigoProducto, identificacion, listaDetalleVenta);

				// producto =
				// aplicacion.crearProducto(codigo,nombre,descripcion,valorProducto,cantProductos);

				if (venta != null) {
					listaVentaData.add(venta);
					listaDetalleVentaData.addAll(listaDetalleVenta);
					limpiarCampoTextoVenta();
					
					mostrarMensaje("Notificación Venta", "Venta registrada", "La venta se ha registrado",
							AlertType.INFORMATION);

				} else {
					mostrarMensaje("Notificación Venta", "Venta no registrado",
							"El producto con" + codigoVenta + " ya se encuentra registrado", AlertType.ERROR);
				}

			}
		} catch (NumberFormatException e) {
			mostrarMensaje("Notificación Venta", "Venta no registrado", "La Venta no se logro registrar",
					AlertType.ERROR);
		}

	}

	public boolean datosValidosVenta(String codigoVenta, LocalDate fecha, String codigoProducto,
			String identificacionCliente) {
		String mensaje = " ";
		if (codigoVenta == null || codigoVenta.equalsIgnoreCase(" ")) {
			mensaje += "El código es invalido  \n ";
		}
		if (fecha == null) {
			mensaje += "El fecha es invalido  \n ";
		}
		if (codigoProducto == null || codigoProducto.equalsIgnoreCase(" ")) {
			mensaje += "el codigoProducto es invalida  \n ";
		}
		if (identificacionCliente == null || identificacionCliente.equalsIgnoreCase(" ")) {
			mensaje += "la identificacionCliente es invalida  \n ";
		}
		if (mensaje.equalsIgnoreCase(" ")) {
			return true;
		} else {
			mostrarMensaje("Notificación Producto", "Datos invalidos", mensaje, AlertType.WARNING);
			return false;
		}
	}

	public void agregarProductoDetalleVenta() {

		DetalleVenta detalleVenta = new DetalleVenta();
		
		String codigoVenta = txtCodigoVenta.getText();
		LocalDate fecha = txtfechaVenta.getValue();
		String codigoProducto = txtCodigoProductoVenta.getText();
		String identificacion = txtIdentificacionClienteVenta.getText();
		int cantidadProductos = Integer.parseInt(txtcantidadProductoVenta.getText());
		Cliente clienteAgregar = null;
		clienteAgregar = aplicacion.buscarClientePorIdentificacion(identificacion);

		Producto productoAgregar = null;
		productoAgregar = aplicacion.buscarProductoPorCodigo(codigoProducto);

		detalleVenta.setProductoVendido(productoAgregar);
		detalleVenta.setCantidadProductosVendidos(cantidadProductos);
		detalleVenta.setSubTotal(productoAgregar.getValorUnitario() * cantidadProductos);
		listaDetalleVenta.add(detalleVenta);

		mostrarMensaje("Notificación Producto", "Datos correctos", "Se añadió el producto", AlertType.INFORMATION);

	}

}
