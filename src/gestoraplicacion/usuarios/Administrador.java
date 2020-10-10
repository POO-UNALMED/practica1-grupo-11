package gestoraplicacion.usuarios;

import java.util.ArrayList;
import java.util.Date;

import gestoraplicacion.infraestructura.Hospital;
import gestoraplicacion.infraestructura.Solicitud;

public class Administrador extends Persona {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6389465017650662973L;
	private String cargo;
	private ArrayList<Solicitud> solicitudesPaciente= new ArrayList<Solicitud>();
	private Hospital hospital;
	//private Solicitud[] solicitudesMedico;

	public Administrador() {
		super();

	}

	public Administrador(String nombre, String id, Date fechaNacimiento, String telefono, String direccion,
			String cargo, ArrayList<Solicitud> solicitudesPaciente) {
		super(nombre, id, fechaNacimiento, telefono, direccion);
		this.cargo = cargo;
		this.solicitudesPaciente = solicitudesPaciente;
		//this.solicitudesMedico = solicitudesMedico;
	}
	
	
	/*
	 * Método consultarDeudasDePaciente() es parte de Funcionalidad de
	 * "Consultar deudas de un paciente para ver si está a paz y salvo".
	 * 
	 *Ruta de Clases accesadas:Administrador-->Hospital-->Paciente-->HistoriaClinica-->Procedimiento.
	 */
	public double consultarDeudasDePaciente(String id) {
		return hospital.totalCostosPorPaciente(id);
	}
	
	
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public ArrayList<Solicitud> getSolicitudesPaciente() {
		return solicitudesPaciente;
	}

	public void setSolicitudesPaciente(ArrayList<Solicitud> solicitudesPaciente) {
		this.solicitudesPaciente = solicitudesPaciente;
	}

//	public Solicitud[] getSolicitudesMedico() {
//		return solicitudesMedico;
//	}
//
//	public void setSolicitudesMedico(Solicitud[] solicitudesMedico) {
//		this.solicitudesMedico = solicitudesMedico;
//	}

}
