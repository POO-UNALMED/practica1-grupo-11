package gestoraplicacion.usuarios;

import java.io.Serializable;
import java.util.Date;

public class Persona implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -735928645591952061L;
	private String nombre;
	private String id;
	private Date fechaNacimiento;
	private String telefono;
	private String direccion;

	
	
	public Persona() {}
	
	public Persona(String nombre, String id, Date fechaNacimiento, String telefono, String direccion) {
		this.nombre = nombre;
		this.id = id;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
}
