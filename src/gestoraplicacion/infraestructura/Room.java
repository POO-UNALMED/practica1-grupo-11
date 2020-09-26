package gestoraplicacion.infraestructura;

import gestoraplicacion.usuarios.Paciente;

public class Room {
	private String codigo;
	private Paciente paciente;
	private boolean ocupado;
	private Procedimiento procedimiento;
	private String inventario[];
	
	public Room() {}
	
	public Room(String codigo, Paciente paciente, boolean ocupado, Procedimiento procedimiento, String[] inventario) {
		this.codigo = codigo;
		this.paciente = paciente;
		this.ocupado = ocupado;
		this.procedimiento = procedimiento;
		this.inventario = inventario;
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
	public boolean isOcupado() {
		return ocupado;
	}
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	public Procedimiento getProcedimiento() {
		return procedimiento;
	}
	public void setProcedimiento(Procedimiento procedimiento) {
		this.procedimiento = procedimiento;
	}
	public String[] getInventario() {
		return inventario;
	}
	public void setInventario(String[] inventario) {
		this.inventario = inventario;
	}
	

}
