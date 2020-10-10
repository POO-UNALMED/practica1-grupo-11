package gestoraplicacion.usuarios;

import java.util.ArrayList;
import java.util.Date;

import gestoraplicacion.infraestructura.HistoriaClinica;
import gestoraplicacion.infraestructura.Room;
import gestoraplicacion.infraestructura.Solicitud;

public class Paciente extends Persona {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2109574389975012203L;
	private String[] patologia;
	private HistoriaClinica historiaClinica;
	private String eps;
	private boolean deAlta;
	private Room habitacion;
	private ArrayList<Solicitud> solicitudes = new ArrayList<Solicitud>();

	public Paciente() {
		super();
	}

	public Paciente(String nombre, String id, Date fechaNacimiento, String telefono, String direccion,
			String[] patologia, HistoriaClinica historiaClinica, String eps, boolean deAlta, Room habitacion) {
		super(nombre, id, fechaNacimiento, telefono, direccion);
		this.patologia = patologia;
		this.historiaClinica = historiaClinica;
		this.eps = eps;
		this.deAlta = deAlta;
		this.habitacion = habitacion;

	}

	/*
	 * Método valorTotalProcedimientos() es parte de Funcionalidad de
	 * "Consultar deudas de un paciente para ver si está a paz y salvo". Este método
	 * accede al atributo historiaClinica de su propia clase Paciente para acceder
	 * al método totalCostos() de la clase HistoriaClinica.
	 * 
	 * 
	 *Ruta de Clases accesadas:Administrador-->Hospital-->Paciente-->HistoriaClinica-->Procedimiento.
	 */
	public double valorTotaldeProcedimientos() {
		return historiaClinica.totalCostos();
	}
	
	

	public HistoriaClinica getHistoriaClinica() {
		return historiaClinica;
	}

	public void setHistoriaClinica(HistoriaClinica historiaClinica) {
		this.historiaClinica = historiaClinica;
	}

	public String getEps() {
		return eps;
	}

	public void setEps(String eps) {
		this.eps = eps;
	}

	public boolean isDeAlta() {
		return deAlta;
	}

	public void setDeAlta(boolean deAlta) {
		this.deAlta = deAlta;
	}

	public Room getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Room habitacion) {
		this.habitacion = habitacion;
	}

	public String[] getPatologia() {
		return patologia;
	}

	public void setPatologia(String[] patologia) {
		this.patologia = patologia;
	}

	public ArrayList<Solicitud> getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(ArrayList<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}

}
