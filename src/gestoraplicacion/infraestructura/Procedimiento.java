package gestoraplicacion.infraestructura;
import java.io.Serializable;

import basedatos.BDDriver;
import gestoraplicacion.usuarios.Medico;

public class Procedimiento implements Serializable, Actividad{
	/*
	 *Atributos 
	 */
	private static final long serialVersionUID = 7092617778020316714L;
	
	

	private int id;
	private static int totalProcedimientos=BDDriver.procedimientos.size();

	//los tipos de actividades están definidos como constantes en la interfaz Actividad.

	private String tipoActividad;
	private Medico medico;
	private HistoriaClinica historiaClinica;
	private double costo;
	private boolean pazYSalvo=false;
	private Room habitacion;
	private boolean completado=false;
	
	
	
	/*
	 * Constructores
	 */
	public Procedimiento(){
		totalProcedimientos++;
		this.id=totalProcedimientos;
	}
	

	public Procedimiento(String tipoActividad, Medico medico, double costo, Room habitacion) {

		this();
		this.tipoActividad = tipoActividad;
		this.medico = medico;
		this.costo = costo;
		this.habitacion = habitacion;
		BDDriver.procedimientos.add(this);
	}
	
	
	
	
	
	



	/*
	 * Getters y Setters
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcionProcedimiento() {
		return tipoActividad;
	}

	public void setDescripcionProcedimiento(String descripcionProcedimiento) {
		this.tipoActividad = descripcionProcedimiento;
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
	
	
	public String getTipoActividad() {
		return tipoActividad;
	}

	public void setTipoActividad(String tipoActividad) {
		this.tipoActividad = tipoActividad;
	}

	/*
	 * Metodos:
	 * 
	 */
	@Override
	public String toString() {
		return "Tipo " + tipoActividad + " a cargo de: " + medico + ", tiene un valor de: " + costo;
	}
	
	

}
