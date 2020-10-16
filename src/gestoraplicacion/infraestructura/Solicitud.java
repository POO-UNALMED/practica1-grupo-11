package gestoraplicacion.infraestructura;

import java.io.Serializable;

import basedatos.BDDriver;
import gestoraplicacion.usuarios.Paciente;
import gestoraplicacion.usuarios.Persona;

public class Solicitud implements Serializable, Actividad {

	/*
	 * Atributos
	 */
	private static final long serialVersionUID = -8336027985146111782L;
	private static int cantidadTotal;
	private int codigo;
	private Persona solicitante;
	private Procedimiento solicitud;
	private boolean aprobado = false;

	/*
	 * Constructores
	 */
	public Solicitud() {
		cantidadTotal++;
		this.codigo = cantidadTotal;
		BDDriver.solicitudes.add(this);
	}
	
	
	private Solicitud(Persona solicitante) {
		this.solicitante = solicitante;
		cantidadTotal++;
		this.codigo = cantidadTotal;
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
	 * Metodo toString sobreescrito para funcionalidad de
	 * " Mostrar detalle de solicitud". llama toString de la clase procedimiento,
	 * imprime detalle de los principales atributos del procedimiento.
	 * 
	 */
	public String toString() {
		return "Codigo: " + codigo + "\nSolicitante: " + solicitante.getNombre() + "\nDetalle procedimiento: "
				+ solicitud + "\nAprobado: " + aprobado;
	}

	/*
	 * En este metodo se aplica la ligadura din�mica al llamar al metodo
	 * asignarSolicitud() de Persona. Es un metodo estatico de fabrica que se
	 * encarga de crear una Solicitud accediendo a su propio constructor. Ademas
	 * tambien asigna a la persona que se paso como parametro, la solicitud mediante
	 * el metodo heredado de Persona asignarActividad();
	 * 
	 */
	
	public static Solicitud crearSolicitud(Persona persona) {
		Solicitud solicitud = new Solicitud(persona);
		persona.agregarActividad((Actividad) solicitud);
		

		return solicitud;
	}

}
