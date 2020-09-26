package gestoraplicacion.usuarios;

import gestoraplicacion.infraestructura.Solicitud;

public class Administrador extends Persona {
	
	private String cargo;
	private Solicitud[] solicitudesPaciente;
	private Solicitud[] solicitudesMedico;
	
	
	public Administrador() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Administrador(String cargo, Solicitud[] solicitudesPaciente, Solicitud[] solicitudesMedico) {
		super();
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
