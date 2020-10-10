package gestoraplicacion.infraestructura;

import java.io.Serializable;
import java.util.ArrayList;

import basedatos.BDDriver;
import gestoraplicacion.usuarios.Administrador;
import gestoraplicacion.usuarios.Medico;
import gestoraplicacion.usuarios.Paciente;

public class Hospital implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8558031300117756825L;
	private String nit;
	private String nombre;
	private int camasDisponibles;
	private ArrayList<Administrador> administradores = BDDriver.administradores;
	private ArrayList<Paciente> pacientes = BDDriver.pacientes;
	private ArrayList<Medico> medicos = BDDriver.medicos;
	private ArrayList<Room> rooms = BDDriver.rooms;

	public Hospital() {

	}

	public Hospital(String nit, String nombre, int camasDisponibles) {
		this.nit = nit;
		this.nombre = nombre;
		this.camasDisponibles = camasDisponibles;

	}

	/*
	 * Método totalCostosPorPaciente() es parte de Funcionalidad de
	 * "Consultar deudas de un paciente para ver si está a paz y salvo". Recorre
	 * todos los pacientes en busca del id, y cuando lo encuentra hace llamado del
	 * método valorTotaldeProcediminetos() de la clase Paciente.
	 * 
	 * Ruta de Clases accesadas:Administrador-->Hospital-->Paciente-->HistoriaClinica-->Procedimiento.
	 */
	public double totalCostosPorPaciente(String id) {
		boolean existePaciente = false;
		Paciente pacienteAux = null;
		for (Paciente p : pacientes) {
			if (p.getId() == id) {
				pacienteAux = p;
				existePaciente = true;
				break;
			}
		}
		if (existePaciente == true) {
			return pacienteAux.valorTotaldeProcedimientos();
		} else {
			System.out.println("Este paciente no se encuentra en nuestra base de datos");
			return 0.0;
		}
	}
	
	

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCamasDisponibles() {
		return camasDisponibles;
	}

	public void setCamasDisponibles(int camasDisponibles) {
		this.camasDisponibles = camasDisponibles;
	}

	public ArrayList<Administrador> getAdministradores() {
		return administradores;
	}

	public void setAdministradores(ArrayList<Administrador> administrador) {
		this.administradores = administrador;
	}

	public ArrayList<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(ArrayList<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public ArrayList<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(ArrayList<Medico> medicos) {
		this.medicos = medicos;
	}

	public ArrayList<Room> getRooms() {
		return rooms;
	}

	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}

}
