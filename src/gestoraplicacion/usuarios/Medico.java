package gestoraplicacion.usuarios;

import java.util.Date;

import gestoraplicacion.infraestructura.Hospital;
import gestoraplicacion.infraestructura.Procedimiento;
import gestoraplicacion.infraestructura.Solicitud;

public class Medico extends Persona{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6361786807611231845L;
	private int especialidad;
	private boolean[] horario;
	private Procedimiento[] procedAsignados;
	private Hospital hospital;
	private Solicitud[] estadoSolicitudes;
	private int estadoCuenta;
	
	
	public Medico() {
		super();
		
	}
	
	
	public Medico(String nombre, String id, Date fechaNacimiento, String telefono, String direccion, int especialidad,
			boolean[] horario, Procedimiento[] procedAsignados, Hospital hospital, Solicitud[] estadoSolicitudes,
			int estadoCuenta) {
		super(nombre, id, fechaNacimiento, telefono, direccion);
		this.especialidad = especialidad;
		this.horario = horario;
		this.procedAsignados = procedAsignados;
		this.hospital = hospital;
		this.estadoSolicitudes = estadoSolicitudes;
		this.estadoCuenta = estadoCuenta;
	}


	public int getEspecialidad() {
		return especialidad;
	}


	public void setEspecialidad(int especialidad) {
		this.especialidad = especialidad;
	}


	public boolean[] getHorario() {
		return horario;
	}


	public void setHorario(boolean[] horario) {
		this.horario = horario;
	}


	public Procedimiento[] getProcedAsignados() {
		return procedAsignados;
	}


	public void setProcedAsignados(Procedimiento[] procedAsignados) {
		this.procedAsignados = procedAsignados;
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
		this.estadoSolicitudes = estadoSolicitudes;
	}


	public int getEstadoCuenta() {
		return estadoCuenta;
	}


	public void setEstadoCuenta(int estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}
	
	
}
