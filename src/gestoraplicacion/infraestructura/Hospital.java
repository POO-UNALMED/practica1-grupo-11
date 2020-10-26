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
	private static final int habitacionesTotales = 25;
	private Administrador administrador;
	private ArrayList<Paciente> pacientes = BDDriver.getPacientes();
	private ArrayList<Medico> medicos = BDDriver.medicos;
	private ArrayList<Room> rooms = BDDriver.rooms;

	/*
	 * Constructores
	 */

	public Hospital(String nombre) {
		nit = 123456789;
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


	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
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

	public static int getHabitacionesTotales() {
		return habitacionesTotales;
	}

	// =========================================================================
	// =========================================================================
	public String detallesHospital() {
		return "Nombre del hospital: " + this.getNombre() + "\n\n" + "Nombre del administrador: "
				+ this.getAdministrador().getNombre() + "\n" + "Habitaciones totales: "+getHabitacionesTotales()+"\n\n"
				+"Habitaciones desocupadas: "+this.habitacionesDisponibles()+"\n\n"
				+"Cantidad de pacientes en el sistema: "+this.pacientes.size()+"\n\n"
				+"Detalle de medicos: \n"+this.detalleMedicos();
	}
	
	public int habitacionesDisponibles() {
		int count=0;
		for(Room room:rooms) {
			if(room.isOcupado()==false) {
				count++;
			}
		}
		return count;
	}
	
	//Detalle de las habitaciones y su disponibilidad. 
	public String detalleHabitaciones() {
		String detalle="Id    Habitacion            Numero#\n"
			     + "===== ================ ================\n";
		for(Room room:rooms) {
			detalle+=room.getCodigo()+"   "+room.isOcupado()+"\n";
	}
	return detalle;
		
	}
	
	public String detalleMedicos() {
		String detalle="Id    Nombre            Especialidad\n"
				     + "===== ================ ================\n";
		for(Medico medico:medicos) {
			detalle+=medico.getId()+"   "+medico.getNombre()+"           "+medico.getEspecialidad()+"\n";
		}
		return detalle;
	}
	
	// metodo sobrecargado para detalle medicos por especialidad (Se podria usar para mostrar una lista especifica de medicos para aprobar solicitud)
	public String detalleMedicos(String tipoActividad) {
		String detalle="Id    Nombre            Especialidad\n"
				     + "===== ================ ================\n";
		for(Medico medico:medicos) {
			if (medico.getEspecialidad()==tipoActividad) {
				detalle+=medico.getId()+"   "+medico.getNombre()+"           "+medico.getEspecialidad()+"\n";
			}
			
		}
		return detalle;
	}
	
	

	// ==========================================================================
	// ==========================================================================

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
	 * accesadas:Administrador-->Hospital-->Paciente-->HistoriaClinica-->
	 * Procedimiento.
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
