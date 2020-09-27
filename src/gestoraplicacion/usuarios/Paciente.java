package gestoraplicacion.usuarios;
import java.util.Date;

import gestoraplicacion.infraestructura.HistoriaClinica;
import gestoraplicacion.infraestructura.Room;
import gestoraplicacion.infraestructura.Solicitud;

public class Paciente extends Persona {
	private String[] patologia;
	private HistoriaClinica historiaClinica;
	private String eps;
	private boolean deAlta;
	private Room habitacion;
	private Solicitud[] solicitudes;
	
	
	public Paciente(){
		super();
	}
		
	
	public Paciente(String nombre, String id, Date fechaNacimiento, String telefono, String direccion,
			String[] patologia, HistoriaClinica historiaClinica, String eps, boolean deAlta, Room habitacion,
			Solicitud[] solicitudes) {
		super(nombre, id, fechaNacimiento, telefono, direccion);
		this.patologia = patologia;
		this.historiaClinica = historiaClinica;
		this.eps = eps;
		this.deAlta = deAlta;
		this.habitacion = habitacion;
		this.solicitudes = solicitudes;
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
	
	
	public Solicitud[] getSolicitudes() {
		return solicitudes;
	}
	public void setSolicitudes(Solicitud[] solicitudes) {
		this.solicitudes = solicitudes;
	}
	
	

	

}
