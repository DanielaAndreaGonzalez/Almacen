/**
 * 
 */
package co.edu.uniquindio.almacen.model;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author GonzalezHDanielaA
 *
 */
public class PersonaNatural extends Cliente{
	
	private String email;
	private LocalDate fechaNacimiento;
	
	/**
	 * 
	 * 	@param nombre
	 * 	@param apellido
	 * @param direccion
	 * @param telefono
	 * @param identificacion
	 * @param email
	 * @param fechaNacimiento
	 */
	public PersonaNatural(String nombre, String apellido, String direccion, String telefono, String identificacion,
			String email, LocalDate fechaNacimiento, String tipoIdentificacion) {
		super(nombre, apellido, direccion, telefono, identificacion, tipoIdentificacion );
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public PersonaNatural () {}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the fechaNacimiento
	 */
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
}
