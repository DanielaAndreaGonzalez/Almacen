module almacen {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	opens co.edu.uniquindio.almacen to javafx.graphics, javafx.fxml;
	opens co.edu.uniquindio.almacen.model to javafx.graphics, javafx.fxml;
	
	exports co.edu.uniquindio.almacen;
    exports co.edu.uniquindio.almacen.model;
}
