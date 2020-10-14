package gestoraplicacion.usuarios;

import java.util.ArrayList;
import java.util.Date;

import basedatos.BDDriver;
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
	private ArrayList<Solicitud> solicitudes= BDDriver.solicitudes; 
	private Hospital hospital= BDDriver.hospitales.get(0);
	//private ArrayList<Solicitud> solicitudesMedico = new ArrayList<Solicitud>();

	public Administrador() {
		super();

	}
	
	

	public Administrador(String nombre, String id, Date fechaNacimiento, String telefono, String direccion,
			String cargo, ArrayList<Solicitud> solicitudesPaciente, ArrayList<Solicitud> solicitudesMedico) {
		super(nombre, id, fechaNacimiento, telefono, direccion);
		this.cargo = cargo;
		this.solicitudes = solicitudesPaciente;
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
	/*
	 * Metodo consultarMedicosDePaciente() es parate de la Funcionalidad de
	 * "consultar lista de medicos que han atendido al paciente"
	 *Ruta de Clases accesadas:Administrador-->Paciente-->HistoriaClinica-->Procedimiento-->Medico.
	 * */

	public void consultarMedicosDePaciente(Paciente paciente) {
		HistoriaClinica historiaClinica = paciente.getHistoriaClinica();
		historiaClinica.medicos();
	}
	
	
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public ArrayList<Solicitud> getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(ArrayList<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
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
	
	
	//Ver detalle solicitud --> Recorrer lisa de solicitudes de la clase administrador y mostrar detalle.
	// bastaba con poner solo el toString en solicitud??? 

	
	

}
