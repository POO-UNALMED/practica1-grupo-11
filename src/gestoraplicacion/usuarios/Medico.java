package gestoraplicacion.usuarios;

public class Medico extends Persona{
	private int especialidad;
	private boolean[] horario;
	private Procedimiento[] procedAsignados;
	private Hospital hospital;
	private Solicitud[] estadoSolicitudes;
	private int estadoCuenta;
	
	
	public Medico() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getEspecialidad() {
		return especialidad;
	}

	public void setEspecial(int especialidad) {
		this.especialidad = especialidad;
	}

	public boolean[] getHorario() {
		return horario;
	}

	public void setHorario(boolean[] horario) {
		this.horario = horario;
	}

	public Procedimiento[] getProcedAsignados() {
		return procedAsignadas;
	}
	
	public void setProcedAsignados(Procedimiento[] procedAsignadas) {
		this.procedAsignadas = procedAsignadas;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Solicitud[] getEstadoSolicitudes() {
		return estadoSolicitudes;
	}

	public void setEstadoSolicitudes(Solicitud[] estadoSolicitudes) {
		this.estadoSolicitues = estadoSolicitudes;
	}

	public int getEstadoCuenta() {
		return estadoCuenta;
	}

	public void setEstadoCuenta(int estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}
}
