package gestoraplicacion.infraestructura;
import java.io.Serializable;
import java.util.ArrayList;

import basedatos.BDDriver;
import gestoraplicacion.usuarios.Paciente;


public class HistoriaClinica implements Serializable{
	
	/*
	 *Atributos 
	 */
	private static final long serialVersionUID = 7221419680251132944L;
	private String codigo;
	private Paciente paciente;
	private ArrayList<Procedimiento> procedimientos= new ArrayList<Procedimiento>();
	
	/*
	 * Constructores
	 */
	public HistoriaClinica() {
		BDDriver.historiasClinicas.add(this);
	}

	public HistoriaClinica(String codigo, Paciente paciente) {
		
		this.codigo = codigo;
		this.paciente = paciente;
		BDDriver.historiasClinicas.add(this);
	}
	
	
	/*
	 * Getters y Setters
	 */
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public ArrayList<Procedimiento> getProcedimientos() {
		return procedimientos;
	}
	public void setProcedimientos(ArrayList<Procedimiento> procedimientos) {
		this.procedimientos = procedimientos;
	}
	
	
	/*
	 * Metodos
	 */
	
	/*
	 * Método totalCostos() parte de Funcionalidad de
	 * "Consultar deudas de un paciente para ver si está a paz y salvo". Accede a
	 * los procedimientos que tiene asignada la HistoriaClinica de determinado
	 * paciente y suma el total de los costos de cada procedimiento
	 * 
	 * Ruta de Clases accesadas:Administrador-->Hospital-->Paciente-->HistoriaClinica-->Procedimiento.
	 * 
	 */
	public double totalCostos() {
		double total=0;
		for(Procedimiento proced:procedimientos) {
			total+=proced.getCosto();
		}
		return total;
	}
	
	/*
	 * Metodo medico() parte de la funcionalidad de
	 * "Consultar lista de medicos que han atendido al paciente". Accede a 
	 * los procedimientos que tiene asignada la HistoriaClinica de determinado 
	 * paciente y muetra el Medico asociado en cada procedimiento.
	 * 
	 * Ruta de Clases accesadas:Administrador-->Paciente-->HistoriaClinica-->Procedimiento-->Medico.
	 */
	
	public void medicos() {
		for(Procedimiento proced:procedimientos) {
			System.out.println(proced.getMedico());
		}
	}
	
}
