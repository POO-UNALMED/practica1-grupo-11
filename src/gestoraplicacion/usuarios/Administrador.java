package gestoraplicacion.usuarios;

import java.util.ArrayList;
import java.util.Date;

import gestoraplicacion.infraestructura.HistoriaClinica;
import gestoraplicacion.infraestructura.Hospital;
import gestoraplicacion.infraestructura.Procedimiento;
import gestoraplicacion.infraestructura.Room;
import gestoraplicacion.infraestructura.Solicitud;

import gestoraplicacion.usuarios.*;

public class Administrador extends Persona {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6389465017650662973L;
	private String cargo;
	private ArrayList<Solicitud> solicitudesPaciente= new ArrayList<Solicitud>();
	private Hospital hospital;
	private ArrayList<Solicitud> solicitudesMedico = new ArrayList<Solicitud>();

	public Administrador() {
		super();

	}

	public Administrador(String nombre, String id, Date fechaNacimiento, String telefono, String direccion,
			String cargo, ArrayList<Solicitud> solicitudesPaciente, ArrayList<Solicitud> solicitudesMedico) {
		super(nombre, id, fechaNacimiento, telefono, direccion);
		this.cargo = cargo;
		this.solicitudesPaciente = solicitudesPaciente;
		//this.solicitudesMedico = solicitudesMedico;
	}
	
	
	/*
	 * M�todo consultarDeudasDePaciente() es parte de Funcionalidad de
	 * "Consultar deudas de un paciente para ver si est� a paz y salvo".
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
	
	/*
	 * Crea una nueva solicitud y la agregamos a una lista de elementos dependiendo
	 * si el solicitante es un paciente o un doctor.
	 */
	public Solicitud crearSolicitud(String codigo, Persona solicitante, Procedimiento procedimiento, boolean aprobado) {
		Solicitud solicitud =  new Solicitud(codigo, solicitante, procedimiento, aprobado);
		if (Paciente.class.isInstance(solicitante)) {
			solicitudesPaciente.add(solicitud);
		} else if (Medico.class.isInstance(solicitante)) {
			solicitudesMedico.add(solicitud);
		}
		return solicitud;
		
	}

}
