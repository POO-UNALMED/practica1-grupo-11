package uimain;

import gestoraplicacion.infraestructura.Actividad;
import gestoraplicacion.infraestructura.HistoriaClinica;
import gestoraplicacion.infraestructura.Hospital;
import gestoraplicacion.infraestructura.Procedimiento;
import gestoraplicacion.infraestructura.Room;
import gestoraplicacion.infraestructura.Solicitud;
import gestoraplicacion.usuarios.Administrador;
import gestoraplicacion.usuarios.Medico;
import gestoraplicacion.usuarios.Paciente;
import gestoraplicacion.usuarios.Persona;

import java.util.ArrayList;
import java.util.Scanner;

import basedatos.BDDriver;
import basedatos.BorradorDeArchivos;
import basedatos.Deserializador;
import basedatos.Serializador;

/*
 * Inicio de ejecucion de la aplicacion
 */

public class Main {
	public static void main(String[] args) throws InterruptedException {

		/*
		 * Codigo donde se crean algunas instancias necesarias para el funcionamiento de
		 * la aplicacion, solo se crean algunos objetos y luego este codigo se comenta,
		 * ya que no necesitamos que se ejecute cada vez que se inicia la aplicacion.
		 */
//		Hospital h1= new Hospital("Hospital Universitario");
//		Persona a1= new Administrador("Jaime Alberto Guzman Luna");
//		h1.setAdministrador((Administrador) a1);
//		((Administrador) a1).setHospital(h1);
//		
//		Room r1 = new Room();
//		Room r2 = new Room();
//		Room r3 = new Room();
//		Room r4 = new Room();
//		Room r5 = new Room();
//		Room r6 = new Room();
//		Room r7 = new Room();
//		Room r8 = new Room();
//		Room r9 = new Room();
//		Room r10 = new Room();
//		Room r11 = new Room();
//		Room r12 = new Room();
//		Room r13 = new Room();
//		Room r14 = new Room();
//		Room r15 = new Room();
//		Room r16 = new Room();
//		Room r17 = new Room();
//		Room r18 = new Room();
//		Room r19 = new Room();
//		Room r20 = new Room();
//		Room r21 = new Room();
//		Room r22 = new Room();
//		Room r23 = new Room();
//		Room r24 = new Room();
//		Room r25 = new Room();
//		
//		
//		Persona m1 = new Medico("Carlos Mejia","Oncologia");
//		Persona m2 = new Medico("Jorge Ramirez","Pediatria");
//		Persona m3 = new Medico("Julian Moreno","Urologia");
//		Persona m4 = new Medico("Jose Gomez","Oftalmologia");
//		Persona m5 = new Medico("Hugo Restrepo","Cardiologia");
//		Persona m6 = new Medico("Alejandro Henao","Neurologia");
//		Persona m7 = new Medico("Bibiana Lopez","Nefrologia");
//		Persona m8 = new Medico("Francisco Diaz","Dermatologia");
//		Persona m9 = new Medico("Claudia Jimenez","Psiquiatria");
//		Persona m10 = new Medico("Blanca Cardona","Ginecologia");
//		Serializador.serializar();

		
		/*
		 * Deserializar los objetos es lo primero que se hace al iniciar la aplicacion
		 */
		Deserializador.deserializar();

		Scanner entrada = new Scanner(System.in);

		/*
		 * Se inicializan los objetos hospital y administrador, recuperandolos de la base de datos.
		 */
		Hospital hospital = BDDriver.hospitales.get(0);
		Administrador administrador = BDDriver.administradores.get(0);


		System.out.println("Hola Administrador " + administrador.getNombre() + "!.\n"
				+ "Bienvenido al Software HealthTech para Administrar el " + hospital.getNombre());
		System.out.println();

		System.out.println("Aqui esta su menu:");
		System.out.println();
		int opcion;

		/*
		 * Este es el inicio de ejecucion del cilo do-while para mantener un menu dinamico 
		 * y que el usuario pueda interactual con la aplicacion
		 */
		do {

			/*
			 * Aqui se imprimen las opciones del menu, para que el usuario se informe sobre las posibilidades
			 * que tiene
			 */
			System.out.println("MENU:");
			System.out.println();

			System.out.println("======================================================================");
			System.out.println("Ingrese 0 para:\n	-->Mostras detalles basicos del hospital");
			System.out.println("======================================================================");
			System.out.println("Ingrese 1 para:\n	-->Ingresar Paciente al sistema");
			System.out.println("======================================================================");
			System.out.println(
					"Ingrese 2 para:\n	-->Crear Solicitud de aprobacion de procedimineto para paciente existente");
			System.out.println("	Recuerde que el paciente debe estar registrado en nuestra base de datos");
			System.out.println("======================================================================");
			System.out.println(
					"Ingrese 3 para:\n" + "	-->Aprobar solicitud (Sujeto a disponibilidad de habitaciones)");
			System.out.println();
			System.out.println(
					" 	Si no hay disponibilidad es posibe que quiera darle de alta a algun paciente con la opcion 6");
			System.out.println("======================================================================");
			System.out.println("Ingrese 4 para:\n	-->Pagar deudas de paciente.");
			System.out.println("======================================================================");
			System.out.println("Ingrese 5 para:\n	-->Finalizar procedimiento");
			System.out.println();
			System.out.println(
					" 	Recuerde que solo pueden finalizar procedimiento aquellos pacientes que esten a paz y salvo en el respectivo procedimiento,");
			System.out.println("	para ello posiblemente quiera hacer uso de la opcion 4");
			System.out.println("======================================================================");
			System.out.println("Ingrese 6 para:\n	-->Dar de alta");
			System.out.println();
			System.out.println(
					"	Recuerde que para dar de alta al paciente, debe haber finalizado todos los procedimientos que tenga pendientes,");
			System.out.println("	para ello tal vez quiera hacer uso de la opcion 5.");
			System.out.println("======================================================================");
			System.out.println("Ingrese 7 para:\n	-->Ver detalles de pacientes");
			System.out.println("======================================================================");
			System.out.println("Ingrese 8 para:\n	-->Salir del sistema de forma segura");
			System.out.println("======================================================================");
			System.out.println();
			System.out.println();
			System.out.println("Ingrese su opcion:");

			opcion = entrada.nextInt();
			entrada.nextLine();

			switch (opcion) {
			case 0:
				System.out.println();
				System.out.println(administrador.detallesHospital());
				System.out.println(
						"Si dese volver al menu principal ingrese 1 , si desea cerrar el sistema de forma segura ingrese 8: ");
				opcion = entrada.nextInt();
				if (opcion == 8) {
					salirDelsistema();
				}
				break;
			case 1:
				System.out.println();
				System.out.println("Ingrese el nombre del paciente que desea ingresar: ");
				String nombre = entrada.nextLine();
				Persona paciente = administrador.ingresarPaciente(nombre);
				System.out.println("El paciente que acaba de ingresar se llama " + paciente.getNombre()
						+ " y tiene el id " + paciente.getId());
				System.out.println();
				System.out.println(
						"Su historia clinica tiene codigo: " + ((Paciente) paciente).getHistoriaClinica().getCodigo());
				System.out.println();
				System.out.println();
				System.out.println(
						"Si desea volver al menu principal ingrese 1 , si desea cerrar el sistema de forma segura ingrese 8: ");
				opcion = entrada.nextInt();
				if (opcion == 8) {
					salirDelsistema();
				}
				break;

			case 2:
				System.out.println();
				System.out.println(
						"Aqui esta la lista de pacientes ingresados en el sistema para que elija uno de sus IDs: ");
				System.out.println(administrador.detalleSimplePacientes());
				System.out.println();
				System.out.println("Aqui esta la lista de tipos de procedimiento posible, tambien debe elegir uno: ");
				System.out.println(administrador.detalleTipoActividad());
				if (administrador.getHospital().getPacientes().size() != 0) {
					System.out.println("Ingrese el id del" + " paciente al cual le desea crear una solicitud: ");
					int idPaciente = entrada.nextInt();
					System.out.println("Ingrese el tipo de solicitud exactamente como se le mostro en la tabla: ");
					String tipoActividad = entrada.next();
					Actividad solicitud = administrador.crearSolicitud(idPaciente, tipoActividad);
					System.out.println("Acaba de crear una solicitud para el paciente: ");
					System.out.println(administrador.consultarPacienteByID(idPaciente).getNombre());
					System.out.println("Con el id: ");
					System.out.println(administrador.consultarPacienteByID(idPaciente).getId());
					System.out.println("El codigo de la solicitud es:");
					System.out.println(((Solicitud) solicitud).getCodigo());
				}

				System.out.println(
						"Si desea volver al menu principal ingrese 1 , si desea cerrar el sistema de forma segura ingrese 8: ");
				opcion = entrada.nextInt();
				if (opcion == 8) {
					salirDelsistema();
				}
				
				//Aplicacion de funcionalidad APROBAR SOLICITUD.
				//Metodo detalle solicitud para mostrar un reporte de las solicitudes del sistema.
				//El programa permite escoger la solicitud a aprobar.
				//Aplicacion del metodo aprobarSolicitud con la solicitud seleccionada
				break;
			case 3:
				System.out.println();
				System.out.println("Aqui esta la lista de las solicitudes sin aprobar, elija un codigo: ");
				System.out.println();
				System.out.println(administrador.detalleSolicitudes());
				System.out.println();
				System.out.println("Ingrese el codigo de la solicitud que desea aprobar: ");
				int codigoSolicitud = entrada.nextInt();
				System.out.println();
				System.out.println("Ingrese el Costo del procedimiento a realizar: ");
				int costo = entrada.nextInt();
				administrador.aprobarSolicitud(codigoSolicitud, costo);
				System.out.println(
						"Si desea volver al menu principal ingrese 1 , si desea cerrar el sistema de forma segura ingrese 8: ");
				opcion = entrada.nextInt();
				if (opcion == 8) {
					salirDelsistema();
				}

				break;
				//Aplicacion de funcionalidad PAGAR DEUDA PACIENTE.
				//Llamado del metodo pacientesConDeudas, que muestra los pacientes con deudas registrados en el sistema del Hospital.
				//El programa permite escoger el paciente que desea pagar sus deudas.
				//Aplicacion del metodo pagarDeudaPaciente con el paciente deudor seleccionado.
			case 4:
				System.out.println("Aqui esta la lista de pacientes con deudas: ");
				System.out.println(administrador.getHospital().pacientesConDeudas());
				System.out.println();
				System.out.println("Ingrese el id del paciente que quiere pagar: ");
				int idDeudor = entrada.nextInt();

				administrador.getHospital().pagarDeudaPaciente(idDeudor);

				System.out.println(
						"Si desea volver al menu principal ingrese 1 , si desea cerrar el sistema de forma segura ingrese 8: ");
				opcion = entrada.nextInt();
				if (opcion == 8) {
					salirDelsistema();
				}

				break;
			case 5:
				//Aplicacion de funcionalidad FINALIZAR PROCEDIMIENTO.
				//Llamado del metodo detallesfinalizarProcedimiento, que muestra los pacientes que se encuentran a paz(sin deuda) con el Hospital.
				//El programa permite escoger el paciente que desea finalizar el procedimiento.
				//Aplicacion del metodo finalizar procedimiento con el paciente a paz y salvo seleccionado.
				System.out.println("Esta es la lista de pacientes que pueden finalizar procedimeintos asociados: ");
				System.out.println(administrador.detallesfinalizarProcedimiento() + "\n");
				System.out.println("Ingrese el id del paciente y del procedimiento que quiere finalizar: \n");
				System.out.println("Ingrese id Paciente: ");
				int idPaciente = entrada.nextInt();
				System.out.println("Ingrese id Procedimiento: ");
				int idProcedimiento = entrada.nextInt();
				System.out.println(administrador.finalizarProcedimiento(idPaciente, idProcedimiento));

				System.out.println(
						"Si desea volver al menu principal ingrese 1 , si desea cerrar el sistema de forma segura ingrese 8: ");
				opcion = entrada.nextInt();
				if (opcion == 8) {
					salirDelsistema();
				}
				break;
			case 6:
				//Aplicacion de funcionalidad DAR DE ALTA.
				//Llamado del metodo detallesdarDeAlta, que muestra los pacientes que se encuentran a paz(sin deuda) y el procedimiento finalizado con el Hospital.
				//El programa permite escoger el paciente que desea dar de alta.
				//Aplicacion del metodo dar de alta con el paciente a paz(sin deudas) y el procedimiento finalizado seleccionado.
				System.out.println("Esta es la lista de pacientes que pueden ser dados de Alta\n");
				System.out.println(administrador.detalledarDeAlta() + "\n");
				if (administrador.getHospital().getPacientes().size() != 0) {
					System.out.println("Ingrese el id del paciente que se quiere dar de alta: \n");
					System.out.println("Ingrese id Paciente: ");
					idPaciente = entrada.nextInt();
					System.out.println(administrador.darDeAlta(idPaciente));
				}
				System.out.println(
						"Si desea volver al menu principal ingrese 1 , si desea cerrar el sistema de forma segura ingrese 8: ");
				opcion = entrada.nextInt();
				if (opcion == 8) {
					salirDelsistema();
				}
				break;

			
			case 7:
				System.out.println("Esta es la lista de pacientes:\n");
				System.out.println(administrador.detalleSimplePacientes());
				System.out.println("Ingrese el ID de paciente de ver detalles:\n");
				idPaciente = entrada.nextInt();
				System.out.println(administrador.verDetallesPaciente(idPaciente));
				System.out.println(
						"Si desea volver al menu principal ingrese 1 , si desea cerrar el sistema de forma segura ingrese 8: ");
				opcion = entrada.nextInt();
				if (opcion == 8) {
					salirDelsistema();
				}

				break;
			case 8:
				salirDelsistema();
				break;
			default:
				System.out.println("Ingrese una opcion valida");
				System.out.println(
						"Si desea volver al menu principal ingrese 1 , si desea cerrar el sistema de forma segura ingrese 8: ");
				opcion = entrada.nextInt();
				if (opcion == 8) {
					salirDelsistema();
				}
			}
		} while (opcion != 8);

//		BorradorDeArchivos.borrarContArchivos();

	}

	//metodo estatico que cierra el sistema de forma correcta
	private static void salirDelsistema() {
		System.out.println("Vuelva pronto");
		Serializador.serializar();
		System.exit(0);
	}
}
