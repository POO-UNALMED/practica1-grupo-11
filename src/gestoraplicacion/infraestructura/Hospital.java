package gestoraplicacion.infraestructura;

public class Hospital {
	private String nit;
	private String nombre;
	private int camasDisponibles;
	private Administrador administrador;
	private Paciente[] pacientes;
	private Medico[] medicos;
	private Room[] habitaciones;

	public String getNit(){
		return nit;
	}

	public void setNit(String nit){
		this.nit = nit;
	}

	public String getNombre(){
		return nombre;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public int getCamasDisponibles(){
		return camasDisponibles;
	}

	public void setCamasDisponibles(int camasDisponibles){
		this.camasDisponibles = camasDisponibles
	}
	
	public Administrador getAdministrador(){
		return administrador;
	}

	public void setAdministrador(Administrador administrador){
		this.administrador = administrador;
	}

	public Paciente[] getPacientes(){
		return pacientes;
	}

	public void setPacientes(Paciente[] pacientes){
		this.pacientes = pacientes;
	}

	public Medico[] getMedicos(){
		return medicos;
	}

	public void setMedicos(Medico[] medicos){
		this.medicos = medicos;
	}

	public Room[] getHabitaciones(){
		return habitaciones;
	}
	public void setHabitaciones(Room[] habitaciones){
		this.habitaciones = habitaciones;
	}
}
