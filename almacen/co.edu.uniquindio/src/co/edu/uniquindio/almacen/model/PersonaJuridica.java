/**
 * 
 */
package co.edu.uniquindio.almacen.model;

/**
 * @author GonzalezHDanielaA
 *
 */
public class PersonaJuridica extends Cliente{
	
	
	private String nit;
	private String numeroIdentificacion;
	
	/**
	 * 
	 * @param nombre
	 * @param apellido
	 * @param direccion
	 * @param telefono
	 * @param identificacion
	 * @param nit
	 * @param numeroIdentificacion
	 */
	public PersonaJuridica(String nombre, String apellido, String direccion, String telefono, String identificacion,
			String nit, String numeroIdentificacion, String tipoIdentificacion) {
		super(nombre, apellido, direccion, telefono, identificacion, tipoIdentificacion);
		this.nit = nit;
		this.numeroIdentificacion = numeroIdentificacion;
	}
	/**
	 * @return the nit
	 */
	public String getNit() {
		return nit;
	}
	/**
	 * @param nit the nit to set
	 */
	public void setNit(String nit) {
		this.nit = nit;
	}
	/**
	 * @return the numeroIdentificacion
	 */
	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}
	/**
	 * @param numeroIdentificacion the numeroIdentificacion to set
	 */
	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}
	
	
	

}
