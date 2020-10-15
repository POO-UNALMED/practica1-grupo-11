package gestoraplicacion.infraestructura;

import java.io.Serializable;

import basedatos.BDDriver;
import gestoraplicacion.usuarios.Persona;

public class Solicitud implements Serializable,  Actividad{
	
	/*
	 * Atributos
	 */
	private static final long serialVersionUID = -8336027985146111782L;
	private static int cantidadTotal;
	private int codigo;
	private Persona solicitante;
	private Procedimiento solicitud;
	private boolean aprobado=false;
	
	
	/*
	 * Constructores
	 */
	public Solicitud() {
		cantidadTotal++;
		codigo=cantidadTotal;
	};
	
	
	
	private Solicitud(Persona solicitante) {
		this.solicitante = solicitante;
		cantidadTotal++;
		codigo=cantidadTotal;
		BDDriver.solicitudes.add(this);
	}
	
	
	/*
	 * Getters y Setters
	 */
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
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
	
	
	/*
	 * Metodos:
	 */
	
	
	
	/*
	 * Metodo toString sobreescrito para funcionalidad de " Mostrar detalle de solicitud". 
	 * llama toString de la clase procedimiento, imprime detalle de los principales atributos del procedimiento.
	 * 
	 */
	public String toString() {
		return "Codigo: " + codigo + "\nSolicitante: " + solicitante.getNombre() + "\nDetalle procedimiento: " + solicitud + "\nAprobado: " + aprobado;
	}
	
	
	
	/*
	 * En este método se aplica la ligadura dinámica al llamar al método asignarSolicitud() de Persona. 
	 * 
	 */
	public static Solicitud crearActividad(Persona persona) {
		Solicitud solicitud= new Solicitud(persona);
		persona.asignarActividad((Actividad) solicitud);
		
		return solicitud;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
