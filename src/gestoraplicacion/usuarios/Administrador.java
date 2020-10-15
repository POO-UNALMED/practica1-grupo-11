package gestoraplicacion.usuarios;

import java.util.ArrayList;

import basedatos.BDDriver;
import gestoraplicacion.infraestructura.Actividad;
import gestoraplicacion.infraestructura.HistoriaClinica;
import gestoraplicacion.infraestructura.Hospital;
import gestoraplicacion.infraestructura.Solicitud;

public class Administrador extends Persona {

	/*
	 * Atributos
	 */
	private static final long serialVersionUID = 6389465017650662973L;
	private String cargo;
	private ArrayList<Solicitud> solicitudes = BDDriver.solicitudes;
	private Hospital hospital = BDDriver.hospitales.get(0);

	/*
	 * Constructores
	 */
	public Administrador() {
		super();

	}

	public Administrador(String nombre, int id) {
		super(nombre, id);
		// this.solicitudesMedico = solicitudesMedico;
	}

	
	/*
	 * Getters y Setters
	 */
	
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public ArrayList<Solicitud> getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(ArrayList<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}

	
	/*
	 * Metodos:
	 */
	
	
	/*
	 * Ver detalle solicitud --> Recorrer lisa de solicitudes de la clase
	 * administrador y mostrar detalle de cada solicitud. llama metodo toString de
	 * la clase solicitud. Imprime en detalle el valor de los atributos de cada
	 * solicitud.
	 * 
	 */
	public void detalleSolicitud() {
		for (Solicitud elemento : solicitudes) {
			System.out.println(elemento);
		}
	}

	/*
	 * Metodo consultarDeudasDePaciente() es parte de Funcionalidad de
	 * "Consultar deudas de un paciente para ver si esta a paz y salvo".
	 * 
	 * Ruta de Clases
	 * accesadas:Administrador-->Hospital-->Paciente-->HistoriaClinica-->
	 * Procedimiento.
	 */
	public double consultarDeudasDePaciente(int id) {
		return hospital.totalCostosPorPaciente(id);
	}

	/* Método Crear solicitud() */

	public Solicitud crearActividad(int idPaciente) {
		Paciente pacienteAux = null;

		for (Paciente p : hospital.getPacientes()) {
			if (p.getId() == idPaciente) {
				pacienteAux = p;
				break;
			}

		}
		if (pacienteAux.equals(null)) {
			System.out.println("El paciente con la identificacion ingresada no existe");
			return null;
		} else {
			return Solicitud.crearActividad(pacienteAux);
		}

	}

	/*
	 * Hay ligadura dinamica
	 * 
	 */
	@Override
	public void asignarActividad(Actividad actividad) {
		solicitudes.add((Solicitud) actividad);
	}

	/*
	 * Metodo consultarMedicosDePaciente() es parate de la Funcionalidad de
	 * "consultar lista de medicos que han atendido al paciente" Ruta de Clases
	 * accesadas:Administrador-->Paciente-->HistoriaClinica-->Procedimiento-->
	 * Medico.
	 */

	public void consultarMedicosDePaciente(Paciente paciente) {
		HistoriaClinica historiaClinica = paciente.getHistoriaClinica();
		historiaClinica.medicos();
	}

}
