package gestoraplicacion.infraestructura;

import java.io.Serializable;

import gestoraplicacion.usuarios.Persona;

public class Solicitud implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8336027985146111782L;
	private String codigo;
	private Persona solicitante;
	private Procedimiento solicitud;
	private boolean aprobado;
	
	public Solicitud() {};
	
	public Solicitud(String codigo, Persona solicitante, Procedimiento solicitud, boolean aprobado) {
		this.codigo = codigo;
		this.solicitante = solicitante;
		this.solicitud = solicitud;
		this.aprobado = aprobado;
	}



	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Persona getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(Persona solicitante) {
		this.solicitante = solicitante;
	}
	public Procedimiento getSolicitud() {
		return solicitud;
	}
	public void setSolicitud(Procedimiento solicitud) {
		this.solicitud = solicitud;
	}
	public boolean isAprobado() {
		return aprobado;
	}
	public void setAprobado(boolean aprobado) {
		this.aprobado = aprobado;
	}
	
	
}
