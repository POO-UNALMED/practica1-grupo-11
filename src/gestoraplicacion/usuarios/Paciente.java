package gestoraplicacion.usuarios;
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
