package gestoraplicacion.infraestructura;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

import basedatos.BDDriver;
import gestoraplicacion.usuarios.Administrador;
import gestoraplicacion.usuarios.Medico;
import gestoraplicacion.usuarios.Paciente;
import gestoraplicacion.usuarios.Persona;

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
	 * M�todo totalCostosPorPaciente() es parte de Funcionalidad de
	 * "Consultar deudas de un paciente para ver si est� a paz y salvo". Recorre
	 * todos los pacientes en busca del id, y cuando lo encuentra hace llamado del
	 * m�todo valorTotaldeProcediminetos() de la clase Paciente.
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
	
	/*
	 * Obtener historial retorna el numero de de pacientes y doctores,
	 * Luego retorna una lista de pacientes, cada paciente tiene asociada una lista de doctores
	 * y una lista de doctores, cada doctor tiene asociada una lista de pacientes,
	 * ademas una lista de habitaciones con sus pacientes
	 */
	public ReporteHistorial obtenerHistorial() {
		ReporteHistorial reporte = new ReporteHistorial();
		for(Paciente paciente: pacientes) {
			// TODO obtener los medicos de cada paciente
			ListaUnoAMuchos<Paciente, Medico> pacientesMedicos = new ListaUnoAMuchos(paciente, pacienteListaMedicos);
			reporte.getPacientesMedicos().add(pacientesMedicos);
		}
		
		for(Medico medico: medicos) {
			// TODO obtener los pacientes de cada medico
			ListaUnoAMuchos<Medico, Paciente> medicoPacientes = new ListaUnoAMuchos(medico, pacientesLista);
			reporte.getMedicoPacientes().add(medicoPacientes);
		}
		reporte.setNumPacientes(reporte.getPacientesMedicos().size());
		reporte.setNumDoctores(reporte.getMedicoPacientes().size());
		reporte.setHabitaciones(rooms);
		return reporte; 
	}

}

class ListaUnoAMuchos<E, T extends Persona> {
	private E persona;
	private LinkedList<T> personas;
	
	public ListaUnoAMuchos(E persona, LinkedList<T> personas) {
		this.persona = persona;
		this.personas = personas;
	}

	public E getPersona() {
		return persona;
	}

	public void setPersona(E persona) {
		this.persona = persona;
	}

	public LinkedList<T> getPersonas() {
		return personas;
	}

	public void setPersonas(LinkedList<T> personas) {
		this.personas = personas;
	}
	
	

}

class ReporteHistorial {
	private int numPacientes;
	private int numDoctores;
	private ArrayList<ListaUnoAMuchos<Paciente, Medico>> pacientesMedicos;
	private ArrayList<ListaUnoAMuchos<Medico, Paciente>> medicoPacientes;
	private ArrayList<Room> habitaciones;
	
	public ReporteHistorial() {
		pacientesMedicos = new ArrayList<ListaUnoAMuchos<Paciente,Medico>>();
		medicoPacientes = new ArrayList<ListaUnoAMuchos<Medico,Paciente>>();
		habitaciones = new ArrayList<Room>();
	}
	
	public int getNumPacientes() {
		return numPacientes;
	}
	public void setNumPacientes(int numPacientes) {
		this.numPacientes = numPacientes;
	}
	public int getNumDoctores() {
		return numDoctores;
	}
	public void setNumDoctores(int numDoctores) {
		this.numDoctores = numDoctores;
	}
	public ArrayList<ListaUnoAMuchos<Paciente, Medico>> getPacientesMedicos() {
		return pacientesMedicos;
	}
	public void setPacientesMedicos(ArrayList<ListaUnoAMuchos<Paciente, Medico>> pacientesMedicos) {
		this.pacientesMedicos = pacientesMedicos;
	}
	public ArrayList<ListaUnoAMuchos<Medico, Paciente>> getMedicoPacientes() {
		return medicoPacientes;
	}
	public void setMedicoPacientes(ArrayList<ListaUnoAMuchos<Medico, Paciente>> medicoPacientes) {
		this.medicoPacientes = medicoPacientes;
	}

	public ArrayList<Room> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(ArrayList<Room> habitaciones) {
		this.habitaciones = habitaciones;
	}

	
	
}
