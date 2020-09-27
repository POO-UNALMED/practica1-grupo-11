package gestoraplicacion.usuarios;

import java.util.Date;

import gestoraplicacion.infraestructura.Solicitud;

public class Administrador extends Persona {
	
	private String cargo;
	private Solicitud[] solicitudesPaciente;
	private Solicitud[] solicitudesMedico;
	
	
	public Administrador() {
		super();
		
	}
	
	

	public Administrador(String nombre, String id, Date fechaNacimiento, String telefono, String direccion,
			String cargo, Solicitud[] solicitudesPaciente, Solicitud[] solicitudesMedico) {
		super(nombre, id, fechaNacimiento, telefono, direccion);
		this.cargo = cargo;
		this.solicitudesPaciente = solicitudesPaciente;
		this.solicitudesMedico = solicitudesMedico;
	}



	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Solicitud[] getSolicitudesPaciente() {
		return solicitudesPaciente;
	}
	public void setSolicitudesPaciente(Solicitud[] solicitudesPaciente) {
		this.solicitudesPaciente = solicitudesPaciente;
	}
	public Solicitud[] getSolicitudesMedico() {
		return solicitudesMedico;
	}
	public void setSolicitudesMedico(Solicitud[] solicitudesMedico) {
		this.solicitudesMedico = solicitudesMedico;
	}
	
	
	
	

}
