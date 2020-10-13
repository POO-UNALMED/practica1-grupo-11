package gestoraplicacion.infraestructura;
import java.io.Serializable;
import java.util.ArrayList;

import gestoraplicacion.usuarios.Paciente;


public class HistoriaClinica implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7221419680251132944L;
	private String codigo;
	private Paciente paciente;
	private ArrayList<Procedimiento> procedimientos= new ArrayList<Procedimiento>();
	
	public HistoriaClinica() {
		
	}

	
	public HistoriaClinica(String codigo, Paciente paciente, ArrayList<Procedimiento> procedimientos) {
		
		this.codigo = codigo;
		this.paciente = paciente;
		this.procedimientos = procedimientos;
	}
	
	
	/*
	 * M�todo totalCostos() parte de Funcionalidad de
	 * "Consultar deudas de un paciente para ver si est� a paz y salvo". Accede a
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
	
}
