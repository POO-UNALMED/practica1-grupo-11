package uimain;

import gestoraplicacion.infraestructura.Actividad;
import gestoraplicacion.infraestructura.Hospital;
import gestoraplicacion.infraestructura.Room;
import gestoraplicacion.infraestructura.Solicitud;
import gestoraplicacion.usuarios.Administrador;
import gestoraplicacion.usuarios.Medico;
import gestoraplicacion.usuarios.Paciente;
import gestoraplicacion.usuarios.Persona;

import java.util.Scanner;

import basedatos.BDDriver;
import basedatos.BorradorDeArchivos;
import basedatos.Deserializador;
import basedatos.Serializador;

public class Main {
	public static void main(String[] args) throws InterruptedException {

		/*
		 * Codigo donde se crean algunas instancias necesarias para el funcionamiento de
		 * la aplicacion, solo se crean algunos objetos y luego este codigo se comenta,
		 * ya que no necesitamos que se ejecute cada vez que se inicia la aplicacion.
		 */
//		Hospital h1= new Hospital("Hospital Universitario");
//		Persona a1= new Administrador("Jaime Alberto Guzman Luna");
//		h1.setAdministrador(a1);
//		a1.setHospital(h1);
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
//		Persona m1 = new Medico("Carlos Mej�a","Oncologia");
//		Persona m2 = new Medico("Jorge Ram�rez","Pediatria");
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
		 * Este codigo se ejecuta desde el inicio de la aplicaicon
		 */

		Deserializador.deserializar();

		Scanner entrada = new Scanner(System.in);

		Hospital hospital = BDDriver.hospitales.get(0);
		Administrador administrador = BDDriver.administradores.get(0);

//		Paciente p1= new Paciente("Cristiano Ronaldo");
//		Paciente p2= new Paciente("Lionel Messi");
//		Paciente p3= new Paciente("Ronaldinho Gaucho");
//		Paciente p4= new Paciente("Neymar Junior");

		System.out.println("�Hola Administrador " + administrador.getNombre() + "!.\n"
				+ "Bienvenido al Software HealthTech para Administrar el " + hospital.getNombre());
		System.out.println();

		System.out.println("Aqu� est� su menu:");
		System.out.println();
		int opcion;

		do {

			System.out.println("MEN�:");
			System.out.println();

			System.out.println("======================================================================");
			System.out.println("Ingrese 0 para:\n	-->Mostras detalles b�sicos del hospital");
			System.out.println("======================================================================");
			System.out.println("Ingrese 1 para:\n	-->Ingresar Paciente al sistema");
			System.out.println("======================================================================");
			System.out.println(
					"Ingrese 2 para:\n	-->Crear Solicitud de aprobaci�n de procedimineto para paciente existente");
			System.out.println("	Recuerde que el paciente debe estar registrado en nuestra base de datos");
			System.out.println("======================================================================");
			System.out.println(
					"Ingrese 3 para:\n" + "	-->Aprobar solicitud (Sujeto a disponibilidad de habitaciones)");
			System.out.println();
			System.out.println(
					" 	Si no hay disponibilidad es posibe que quiera darle de alta a alg�n paciente con la opci�n 6");
			System.out.println("======================================================================");
			System.out.println("Ingrese 4 para:\n	-->Pagar deudas de paciente.");
			System.out.println("======================================================================");
			System.out.println("Ingrese 5 para:\n	-->Finalizar procedimiento");
			System.out.println();
			System.out.println(
					" 	Recuerde que s�lo pueden finalizar procedimiento aquellos pacientes que esten a paz y salvo en el respectivo procedimiento,");
			System.out.println("	para ello posiblemente quiera hacer uso de la opci�n 4");
			System.out.println("======================================================================");
			System.out.println("Ingrese 6 para:\n	-->Dar de alta");
			System.out.println();
			System.out.println(
					"	Recuerde que para dar de alta al paciente, debe haber finalizado todos los procedimientos que tenga pendientes,");
			System.out.println("	para ello tal vez quiera hacer uso de la opci�n 5.");
			System.out.println("======================================================================");
			System.out.println("Ingrese 7 para:\n	-->Ver procedimientos asignados a un m�dico");
			System.out.println("======================================================================");
			System.out.println("Ingrese 8 para:\n	-->Ver detalles de pacientes");
			System.out.println("======================================================================");
			System.out.println("Ingrese 9 para:\n	-->Salir del sistema de forma segura");
			System.out.println("======================================================================");
			System.out.println();
			System.out.println();
			System.out.println("Ingrese su opci�n:");

			opcion = entrada.nextInt();
			entrada.nextLine();

			switch (opcion) {
			case 0:
				System.out.println(administrador.detallesHospital());
				break;
			case 1:
				System.out.println("Ingrese el nombre del paciente que desea ingresar");
				String nombre = entrada.nextLine();
				Persona paciente = administrador.ingresarPaciente(nombre);
				System.out.println("El paciente que acaba de ingresar se llama " + paciente.getNombre()
						+ " y tiene el id " + paciente.getId());
				System.out.println();
				System.out.println();
//				Thread.sleep(2500);
				System.out.println(
						"Si dese volver al men� principal ingrese 1 , si desea cerrar el sistema de forma segura ingrese 8");
				opcion = entrada.nextInt();
				if (opcion == 8) {
					salirDelsistema();
				}
				break;

			// corregir case 2 para verificar nulidad de retorno
			case 2:
				System.out.println(
						"Aqui esta la lista de pacientes ingresados en el sistema para que elija uno de sus IDs: ");
				System.out.println(administrador.detalleSimplePacientes());
				System.out.println();
				System.out.println(
						"Ingrese el id del paciente al cual le desea crear una solicitud y el tipo de Procedimiento: ");
				int idPaciente = entrada.nextInt();
				Actividad solicitud = administrador.crearSolicitud(idPaciente);
				System.out.println("Acaba de crear una solicitud para el paciente: ");
				System.out.println(administrador.consultarPacienteByID(idPaciente).getNombre());
				System.out.println("Con el id: ");
				System.out.println(administrador.consultarPacienteByID(idPaciente).getId());

				break;
			case 3:
				System.out.println("Aqui esta la lista de las solicitudes sin aprobar, elija uno codigo: ");
				System.out.println(administrador.detalleSolicitudes());
				System.out.println();
				System.out.println("Ingrese el codigo de la solicitud que desea aprobar: ");
				int codigoSolicitud = entrada.nextInt();	
				System.out.println();
				System.out.println("Ingrese el Costo del procedimiento a realizar: ");
				int costo = entrada.nextInt();

				administrador.aprobarSolicitud(codigoSolicitud, costo);

				break;
			case 4:
				System.out.println("Aqui esta la lista de pacientes con deudas: ");
				System.out.println(administrador.getHospital().pacientesConDeudas());
				System.out.println();
				System.out.println("Ingrese el id del paciente que quiere pagar: ");
				int idDeudor = entrada.nextInt();
				
				administrador.getHospital().pagarDeudaPaciente(idDeudor);
				
				break;
			case 5:
				System.out.println("Esta es la lista de pacientes que pueden finalizar procedimeintos asociados: ");
				administrador.listfinalizarProcedimiento();
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				salirDelsistema();
				break;
			default:
				System.out.println("Ingrese una opcion valida");
				Thread.sleep(2000);
			}
		} while (opcion != 8);

//		BorradorDeArchivos.borrarContArchivos();

	}

	private static void salirDelsistema() {
		System.out.println("Vuelva pronto");
		// Serializador.serializar();
		System.exit(0);
	}
}
