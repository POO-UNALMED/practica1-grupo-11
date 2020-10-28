package gestoraplicacion.usuarios;

import java.util.ArrayList;
import java.util.Optional;

import basedatos.BDDriver;
import gestoraplicacion.infraestructura.Actividad;
import gestoraplicacion.infraestructura.HistoriaClinica;
import gestoraplicacion.infraestructura.Hospital;
import gestoraplicacion.infraestructura.Procedimiento;
import gestoraplicacion.infraestructura.Room;
import gestoraplicacion.infraestructura.Solicitud;

public class Administrador extends Persona {

	/*
	 * Atributos
	 */
	private static final long serialVersionUID = 6389465017650662973L;
	private String cargo;
	private ArrayList<Solicitud> solicitudes = BDDriver.solicitudes;
	private Hospital hospital;

	/*
	 * Constructores
	 */

	public Administrador(String nombre) {
		super(nombre);
		BDDriver.administradores.add(this);
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

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	// =========================================================================
	// =========================================================================

	// Metodo que muestra la informacion basica del hospital, como su nombre, el
	// nombre del administrador,
	// Numero de habitaciones, numero de habitaciones disponibles, numero de
	// pacientes en el sistema.
	public String detallesHospital() {
		return this.getHospital().detallesHospital();
	}

	// Metodo que ingresa un nuevo paciente al sistema (crea un objeto paciente)
	public Paciente ingresarPaciente(String nombre) {
		Persona paciente = new Paciente(nombre);
		HistoriaClinica historiaClinica = new HistoriaClinica((Paciente) paciente);
		((Paciente) paciente).setHistoriaClinica(historiaClinica);
		return (Paciente) paciente;
	}
	/* Metodo que crea una nueva solicitud */

	public Solicitud crearSolicitud(int idPaciente, String tipoActividad) {
		Paciente pacienteAux = null;

		// Este for busca si el paciente existe
		for (Paciente p : hospital.getPacientes()) {
			if (p.getId() == idPaciente) {
				pacienteAux = p;
				break;
			}

		}
		if (pacienteAux == null) {
			System.out.println("El paciente con la identificacion ingresada no existe");
			return null;

		} else {
			Solicitud nuevaSolicitud = Solicitud.crearSolicitud(pacienteAux);
			nuevaSolicitud.setTipoActividad(tipoActividad);
			this.agregarActividad(nuevaSolicitud);
			return nuevaSolicitud;
		}
	}

	/*
	 * Hay ligadura dinamica e implementa el metodo abstracto heredado.
	 * 
	 */
	@Override
	public void agregarActividad(Actividad actividad) {
		solicitudes.add((Solicitud) actividad);
	}

	// Metodo que retorna una lista con el nombre y el id del paciente.
	public String detalleSimplePacientes() {
		String detalle = "";
		for (Paciente paciente : this.hospital.getPacientes()) {
			detalle += paciente.getNombre() + "           " + paciente.getId() + "\n";
		}
		if (detalle.length() == 0) {
			return "NOMBRE               ID\n" + "==============      ========\n" + "No hay pacientes en el sistema";
		} else {

			return "NOMBRE               ID\n" + "==============      ========\n" + detalle;
		}
	}

	// Consulta y retorna el paciente segun su id.
	public Paciente consultarPacienteByID(int id) {
		Paciente paciente = null;
		for (Paciente p : this.hospital.getPacientes()) {
			if (p.getId() == id) {
				paciente = p;
			}
		}
		return paciente;
	}

	public String detalleTipoActividad() {
		String actividades = "TIPO DE PROCEDIMEINTOS POSIBLES\n" + "=================================\n";
		for (Medico m : this.hospital.getMedicos()) {
			actividades += m.getEspecialidad() + "\n";
		}
		if (this.hospital.getPacientes().size() == 0) {
			return "TIPO DE PROCEDIMIENTOS POSIBLES\n" + "=================================\n"
					+ "No puede elegir ningun tipo procedimiento porque no hay pacientes\n";
		} else {
			return actividades;
		}
	}

	// ==========================================================================
	// ==========================================================================

	/*
	 * Metodos:
	 */

	/*
	 * Proporsiona informacion asociada a un paciente, su habitacion,
	 * su estado de cuenta, y una breve descripcion de su historia clinica
	 * 
	 * @param id Identificacion del paciente
	 * @return String Texto con la informacion del paciente
	 */
	public String verDetallesPaciente(int id) {
		Optional<Paciente> pacienteOptional = Paciente.getPacienteById(id);
		Paciente paciente = pacienteOptional.get();
		String salida;
		salida = "Paciente\n";
		salida += "  id: " + paciente.getId() + "\n";
		if(paciente.getHabitacion() == null) { // No existe habitacion
			salida += "  habitacion actual: No tiene habitacion asignada\n";
		} else {
			salida += "  habitacion actual: " + paciente.getHabitacion().getCodigo() + "\n";
		}
		salida += "  paz y salvo: " + (paciente.valorTotaldeProcedimientos() == 0 ? "Verdadero" : "Falso") + "\n";
		salida += "  Estado solicitudes: \n";
		ArrayList<Solicitud> solicitudes = paciente.getSolicitudes();
		for (Solicitud solicitud : solicitudes) {
			Procedimiento procedimiento = solicitud.getProcedimeinto();
			salida += solicitud.verDetalle();
			if(procedimiento != null) {
				salida += procedimiento.verDetalle();
			} else {
				salida += "    No hay procedimiento asociado\n";
			}			
			salida += "==================\n";
		}
		if (solicitudes.size() == 0) {
			salida += "    No hay solicitudes asociadas a este paciente. :(\n";
		}
		return salida;
	}

	/*
	 * Ver detalle solicitud --> Recorre lista de solicitudes de la clase
	 * administrador y mostrar detalle de cada solicitud. llama metodo toString de
	 * la clase solicitud. Retorna un string con todas las solicitudes con salto de
	 * linea.
	 * 
	 */
	public String detalleSolicitudes() {
		String detalle = "";
		for (Solicitud elemento : solicitudes) {
			if (elemento.isAprobado() == false) {
				detalle += elemento + "\n";
			}

		}
		return detalle;
	}
	//FUNCIONALIDAD: Aprobar Solicitud.
	// Recibe el codigo de una solicitud, se recorre arreglo de solicitudes, se selecciona la solicitud especifica.
	//Sólo si hay habitaciones disponibles en el hospital, se hace lo siguiente:
	//Se genera un nuevo procedimiento de acuerdo a la actividad solicitada.
	//Se asigna el procedimiento al médico y a la solicitud.
	//Se cambia el estado de la solicitud a aprobado=true.
	public void aprobarSolicitud(int codigoSolicitud, int costo) {

		for (Solicitud solicitud : solicitudes) {
			if (solicitud.getCodigo() == codigoSolicitud) {
				// verifica si hay habitaciones disponibles.
				if (this.hospital.habitacionesDisponibles() > 0) {

					Procedimiento procedimiento = new Procedimiento(
							hospital.consultarMedicoByEspecialidad(solicitud.getTipoActividad()), costo,
							hospital.habitacionByVacia(), solicitud); //Constructor de Procedimiento que recibe atributos de la solicitud, costo y del hospital.

					procedimiento.getMedico().agregarActividad(procedimiento); //Asignacion del procedimiento a medico
					solicitud.setProcedimiento(procedimiento); // asigno procedimiento.

					solicitud.setAprobado(true); // se cambia a true el atributo aprobado.
					System.out.println();
					System.out.println("Se ha aprobado con exito la solicitud para "+procedimiento.getMedico().getEspecialidad());
					System.out.println();
					System.out.println("El medico asignado es: " + procedimiento.getMedico().getNombre()+" de "+procedimiento.getMedico().getEspecialidad());

					System.out.println("El numero de habitacion asignada es: " + procedimiento.getHabitacion().getCodigo());
					System.out.println();

				} else {
					System.out.println("No hay habitaciones disponibles, no se puede aprobar solicitud");
				}

			}

		}

	}

	/*
	 * Metodo sobrecargado. Para ver detalle de las solicitudes por filtros:
	 * A=aprobado, N=No aprobado.
	 */
	public void detalleSolicitud(String param) {
		if (param.equalsIgnoreCase("A")) {
			for (Solicitud elemento : solicitudes) {
				if (elemento.isAprobado() == true) {
					System.out.println(elemento);
				}
			}
		} else if (param.equalsIgnoreCase("N")) {
			for (Solicitud elemento : solicitudes) {
				if (elemento.isAprobado() == false) {
					System.out.println(elemento);
				}
			}
		} else {
			System.out.println("Parametro no valido");
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

	/*
	 * Metodo consultarMedicosDePaciente() es parate de la Funcionalidad de
	 * "consultar lista de medicos que han atendido al paciente" Ruta de Clases
	 * accesadas:Administrador-->Paciente-->HistoriaClinica-->Procedimiento-->
	 * Medico.
	 */

	public String consultarMedicosDePaciente(int idPaciente) {
		/*
		 * HistoriaClinica historiaClinica = paciente.getHistoriaClinica();
		 * historiaClinica.medicos();
		 */
		String detalle = "";
		for (Paciente paciente : hospital.getPacientes()) {
			if (paciente.getId() == idPaciente) {
				HistoriaClinica auxHC = paciente.getHistoriaClinica();
				ArrayList<Procedimiento> procedAux = auxHC.getProcedimientos();
				for (Procedimiento proced : procedAux) {
					Medico medico = proced.getMedico();
					detalle += medico.getNombre() + "           " + medico.getEspecialidad() + "\n";
				}
			}
		}
		return "NOMBRE         Especialidad\n" + "==============   =============\n" + detalle;
	}

	/*
	 * Metodo detallesfinalizarProcedimiento() es parte de la funcionalidad de
	 * "Finalizar procedimiento" y su objetivo es mostrar los pacientes que se
	 * encuentran a paz (sin deudas) con el hospital y su procedimiento esta 
	 * completado.
	 * Ruta de las clases accedas:Administrador-->Paciente-->HistoriaClinica-->
	 * Procedimiento
	 */
	public String detallesfinalizarProcedimiento() {
		String detalle = "";
		//for recorre los pacientes en el hospital
		for (Paciente paciente : this.hospital.getPacientes()) {
			//guarda la historia clinica asociada al paciente
			HistoriaClinica auxHc = paciente.getHistoriaClinica();
			//guarda los procedimientos asociados a la histori clinica del paciente
			ArrayList<Procedimiento> procedAux = auxHc.getProcedimientos();
            //for reccorre los procedimientos asociados a la historia clinica del paciente
			for (Procedimiento proced : procedAux) {
				//verifica si el paciente no tiene deudas y su procedimiento esta completado
				if (proced.isPazYSalvo() == true && proced.isCompletado() == false) {
					detalle += paciente.getNombre() + "           " + paciente.getId() + "             "
							+ proced.getTipoActividad() + "           " + proced.getId() + "\n";
				}

			}
		}

		return "NOMBRE               ID                   PROCEDIMIENTO            ID\n"
				+ "==============      ========              ===============          =======\n" + detalle;
	}

	/*
	 * Metodo finalizarProcedimiento() es parte de la funcionalidad de
	 * "finalizar procedimiento" y su objetivo es verificar los pacientes
	 * que se encuentran a paz(sin deudas) con el hospital.
	 * Ruta de las clases accedas:Administrador-->Paciente-->HistoriaClinica-->
	 * Procedimiento
	 * @params idPaciente, idProcedmiento
	 */
	public String finalizarProcedimiento(int idPaciente, int idProcedimiento) {

		//for recorre los pacientes en el hospital
		for (Paciente paciente : this.hospital.getPacientes()) {
			//verifica si el usuario esta registrado en el hospital
			if (paciente.getId() == idPaciente) {
				//guarda la historia clinica del paciente
				HistoriaClinica auxHc = paciente.getHistoriaClinica();
				//guarda los procedimientos asociados a la historia clinica del paciente
				ArrayList<Procedimiento> procedAux = auxHc.getProcedimientos();
				//recorre todos los procedimientos asociado a la historica clinica del paciente
				for (Procedimiento proced : procedAux) {
					//verifica si el procedimiento se encuentra en la lista de procedimientos
					if (proced.getId() == idProcedimiento) {
						//verifica si el procedmiente asociado a la historia clinica del paciente
						//esta a paz y salvo(sin deudas) con el hospital
						if (proced.isPazYSalvo()) {
							//Si estas a paz se ha completado el procedimiento y se finaliza.
							proced.setCompletado(true);
							return "Se finalizo el procedimiento con el id: " + proced.getId() + "\ndel paciente: "
									+ paciente.getNombre() + " Exitosamente\n";
						}
					}
				}
			}
		}
		return "No se pudo finalizar el procedimiento!!";
	}
	
	/*
	 * Metodo detalledarDeAlta() es parte de la funcionalida
	 * "dar de Alta" y su objetivo es mostra los pacientes que ya
	 * se encuentran a paz(sin deudas) y su procedimiento esta finalizado.
	 * Ruta de clases accesadas: Administrador-->Paciente-->HistoriaClinica-->
	 * Procedimiento.
	 */

	public String detalledarDeAlta() {
		String detalle = "";
		//for recorre los pacientes registrados en el hospital
		for (Paciente paciente : hospital.getPacientes()) {
			//guarda la historia clinica del paciente
			HistoriaClinica auxHc = paciente.getHistoriaClinica();
			//guarda los procedimientos asociados a la historia clinica del paciente
			ArrayList<Procedimiento> procedimientos = auxHc.getProcedimientos();
			int count = 0;
			for (Procedimiento proced : procedimientos) {
				//verifica si dicho procedimiento esta completado a paz(sin deudas) y con
				//habitaciones ocupadas
				if (proced.isCompletado()==true && proced.isPazYSalvo()==true && proced.getHabitacion()!=null
						&& ((Paciente)proced.getSolicitud().getSolicitante()).isDeAlta()==false) {
					//count cuenta todos los procemientos que se encuentran completados,
					// a paz(sin deudas) y con habitaciones ocupas.
					count++;
				}
			}
			//verifica que count sea igual al la cantidad de procedimientos asociados a la historia
			//clinica del paciente
			if (count == procedimientos.size() && procedimientos.size()>0) {
				detalle += paciente.getNombre() + "           " + paciente.getId() + "\n";
			}
		}
		return "NOMBRE               ID \n" + "==============      ======== \n" + detalle;
	}

	
	/*
	 * Metodo darDeAlta() es parte de la funcionalida
	 * "dar de Alta" y su objetivo es dar de alta a los pacientes que ya
	 * se encuentran a paz(sin deudas) y su procedimiento esta finalizado.
	 * Ruta de clases accesadas: Administrador-->Paciente-->HistoriaClinica-->
	 * Procedimiento.
	 * @param idPaciente 
	 */
	
	public String darDeAlta(int idPaciente) {
		//Recorre los pacientes registrados en el hospital
		for (Paciente paciente : hospital.getPacientes()) {
			//verifica si el paciente esta registrado en el hospital
			if (paciente.getId() == idPaciente) {
				//recorre todos los procedimiento asociados a la historia clinica del paciente
				for(Procedimiento p:paciente.getHistoriaClinica().getProcedimientos()) {
					//se vacia la habitacion y se elimina el procedimiento
					p.getHabitacion().setOcupado(false);
					p.getHabitacion().setPaciente(null);
					p.getHabitacion().setProcedimiento(null);
				}
				
				//vacia la habitacion
				paciente.setHabitacion(null);
				//se de de alta al paciente
				paciente.setDeAlta(true);
				return "Se dio de alta al paciente: " + paciente.getNombre() + " con id: " + paciente.getId()
						+ " de forma exitosa\n";
			}
		}

		return "No se pudo dar de alta!!";
	}

}
