package gestoraplicacion.infraestructura;
import java.io.Serializable;

import gestoraplicacion.usuarios.Medico;

public class Procedimiento implements Serializable, Actividad{
	/*
	 *Atributos 
	 */
	private static final long serialVersionUID = 7092617778020316714L;
	private String descripcionProcedimiento;
	private Medico medico;
	private HistoriaClinica historiaClinica;
	private double costo;
	private boolean pazYSalvo=false;
	private Room habitacion;
	private boolean completado=false;
	
	/*
	 * Constructores
	 */
	public Procedimiento(){}
	
	public Procedimiento(String descripcionProcedimiento, Medico medico, HistoriaClinica historiaClinica, double costo,Room habitacion) {
		
		this.descripcionProcedimiento = descripcionProcedimiento;
		this.medico = medico;
		this.historiaClinica = historiaClinica;
		this.costo = costo;
		this.habitacion = habitacion;
		
	}


	/*
	 * Getters y Setters
	 */
	public String getTipoProcedimiento() {
		return descripcionProcedimiento;
	}
	public void setTipoProcedimiento(String tipoProcedimiento) {
		this.descripcionProcedimiento = tipoProcedimiento;
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
	
	/*
	 * Metodo getCosto() parte de Funcionalidad de
	 * "Consultar deudas de un paciente para ver si esta a paz y salvo".
	 * 
	 * Ruta de Clases accesadas:Administrador-->Hospital-->Paciente-->HistoriaClinica-->Procedimiento.
	 */
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
	
	/*
	 * Metodos:
	 */
	@Override
	public String toString() {
		return "Tipo " + descripcionProcedimiento + " a cargo de: " + medico + ", tiene un valor de: " + costo;
	}
	
	

}
