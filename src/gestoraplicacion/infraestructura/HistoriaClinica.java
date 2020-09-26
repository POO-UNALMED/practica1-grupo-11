package gestoraplicacion.infraestructura;
import gestoraplicacion.usuarios.Paciente;


public class HistoriaClinica {
	
	private String codigo;
	private Paciente paciente;
	private Procedimiento[] procedimientos;
	
	public HistoriaClinica() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public HistoriaClinica(String codigo, Paciente paciente, Procedimiento[] procedimientos) {
		super();
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
