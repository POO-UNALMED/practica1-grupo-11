package gestoraplicacion.infraestructura;

import java.io.Serializable;
import java.util.ArrayList;

import basedatos.BDDriver;
import gestoraplicacion.usuarios.Administrador;
import gestoraplicacion.usuarios.Medico;
import gestoraplicacion.usuarios.Paciente;




public class Hospital implements Serializable {

	/*
	 * Atributos
	 */
	private static final long serialVersionUID = 8558031300117756825L;
	private final int nit;
	private String nombre;
	private static final int camasDisponibles = 15;
	private Administrador administrador;
	private ArrayList<Paciente> pacientes = BDDriver.pacientes;
	private ArrayList<Medico> medicos = BDDriver.medicos;
	private ArrayList<Room> rooms = BDDriver.rooms;

	/*
	 * Constructores
	 */

	public Hospital(String nombre) {
		nit=123456789;
		this.nombre = nombre;
		BDDriver.hospitales.add(this);

	}
	
	/*
	 * Getters y Setters
	 */

	public int getNit() {
		return nit;
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


	public Administrador getAdministradores() {
		return administrador;
	}

	public void setAdministradores(Administrador administrador) {
		this.administrador = administrador;
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

	
	/*
	 * Metodos
	 */

	
	
	/*
	 * Metodo totalCostosPorPaciente() es parte de Funcionalidad de
	 * "Consultar deudas de un paciente para ver si esta a paz y salvo". Recorre
	 * todos los pacientes en busca del id, y cuando lo encuentra hace llamado del
	 * metodo valorTotaldeProcediminetos() de la clase Paciente.
	 * 
	 * Ruta de Clases
	 * accesadas:Administrador-->Hospital-->Paciente-->HistoriaClinica-->Procedimiento.
	 */
	
	
	
	public double totalCostosPorPaciente(int id) {
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
	
	


}



