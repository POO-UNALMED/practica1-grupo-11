package gestoraplicacion.infraestructura;
import gestoraplicacion.usuarios.Medico;

public class Procedimiento {
	private String tipoProcedimiento;
	private Medico medico;
	private HistoriaClinica historiaClinica;
	private double costo;
	private boolean pazYSalvo;
	private Room habitacion;
	private boolean completado;
	
	
	public String getTipoProcedimiento() {
		return tipoProcedimiento;
	}
	public void setTipoProcedimiento(String tipoProcedimiento) {
		this.tipoProcedimiento = tipoProcedimiento;
	}
	
	
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	
	public HistoriaClinica getHistoriaClinica() {
		return historiaClinica;
	}
	public void setHistoriaClinica(HistoriaClinica historiaClinica) {
		this.historiaClinica = historiaClinica;
	}
	
	
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	
	public boolean isPazYSalvo() {
		return pazYSalvo;
	}
	public void setPazYSalvo(boolean pazYSalvo) {
		this.pazYSalvo = pazYSalvo;
	}
	
	
	public Room getHabitacion() {
		return habitacion;
	}
	public void setHabitacion(Room habitacion) {
		this.habitacion = habitacion;
	}
	
	
	public boolean isCompletado() {
		return completado;
	}
	public void setCompletado(boolean completado) {
		this.completado = completado;
	}
	
	
	
	

}
