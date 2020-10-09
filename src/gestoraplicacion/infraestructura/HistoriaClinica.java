package gestoraplicacion.infraestructura;
import java.io.Serializable;

import gestoraplicacion.usuarios.Paciente;


public class HistoriaClinica implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7221419680251132944L;
	private String codigo;
	private Paciente paciente;
	private Procedimiento[] procedimientos;
	
	public HistoriaClinica() {
		
	}

	
	public HistoriaClinica(String codigo, Paciente paciente, Procedimiento[] procedimientos) {
		
		this.codigo = codigo;
		this.paciente = paciente;
		this.procedimientos = procedimientos;
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
	public Procedimiento[] getProcedimientos() {
		return procedimientos;
	}
	public void setProcedimientos(Procedimiento[] procedimientos) {
		this.procedimientos = procedimientos;
	}
	
}
