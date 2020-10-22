package uimain;

import gestoraplicacion.infraestructura.Hospital;
import gestoraplicacion.infraestructura.Room;
import gestoraplicacion.usuarios.Administrador;
import gestoraplicacion.usuarios.Medico;
import gestoraplicacion.usuarios.Paciente;

import java.util.Scanner;

import basedatos.BDDriver;
import basedatos.BorradorDeArchivos;
import basedatos.Deserializador;
import basedatos.Serializador;

public class Main {
	public static void main(String[] args) {

		/*
		 * Codigo donde se crean algunas instancias necesarias para el funcionamiento de
		 * la aplicacion, solo se crean algunos objetos y luego este codigo se comenta,
		 * ya que no necesitamos que se ejecute cada vez que se inicia la aplicacion.
		 */
//		Hospital h1= new Hospital("Hospital Universitario");
//		Administrador a1= new Administrador("Jaime Alberto Guzman Luna");
//		h1.setAdministradores(a1);
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
//		Medico m1 = new Medico("Carlos Mejía","Oncologia");
//		Medico m2 = new Medico("Jorge Mario Ramírez","Pediatria");
//		Medico m3 = new Medico("Julian Moreno","Urologia");
//		Medico m4 = new Medico("Jose Manuel Gomez","Oftalmologia");
//		Medico m5 = new Medico("Hugo Mesa","Cardiologia");
//		Medico m6 = new Medico("Alejandro Piedrahita","Neurologia");
//		Medico m7 = new Medico("Bibiana Lopez","Nefrologia");
//		Medico m8 = new Medico("Francisco Javier Diaz","Dermatologia");
//		Medico m9 = new Medico("Claudia Jimenez","Psiquiatria");
//		Medico m10 = new Medico("Blanca Cardona","Ginecologia");
//		Serializador.serializar();

		Deserializador.deserializar();

		Scanner entrada = new Scanner(System.in);

		Hospital hospital = BDDriver.hospitales.get(0);
		Administrador administrador = BDDriver.administradores.get(0);

		System.out.println("¡Hola Administrador " + administrador.getNombre() + "!.\n"
				+ "Bienvenido al Software HealthTech para Administrar el " + hospital.getNombre());
		System.out.println();
		System.out.println("Aquí está su menu:");
		
		
		System.out.println("======================================================================");
		System.out.println("Ingrese 0 para:\n	-->Mostras detalles básicos del hospital");
		System.out.println("======================================================================");
		System.out.println("Ingrese 1 para:\n	-->Ingresar Paciente al sistema");
		System.out.println("======================================================================");
		System.out.println("Ingrese 2 para:\n	-->Crear Solicitud de aprobación de procedimineto para paciente existente");
		System.out.println("======================================================================");
		System.out.println("Ingrese 3 para:\n"
				+ "	-->Aprobar solicitud (Sujeto a disponibilidad de habitaciones)");
		System.out.println();
		System.out.println(" 	Si no hay disponibilidad es posibe que quiera darle de alta a algún paciente con la opción 6");
		System.out.println("======================================================================");
		System.out.println("Ingrese 4 para:\n	-->Pagar deudas de paciente.");	
		System.out.println("======================================================================");
		System.out.println("Ingrese 5 para:\n	-->Finalizar procedimiento");
		System.out.println();
		System.out.println(" 	Recuerde que sólo pueden finalizar procedimiento aquellos pacientes que esten a paz y salvo en el respectivo procedimiento,");
		System.out.println("	para ello posiblemente quiera hacer uso de la opción 4");
		System.out.println("======================================================================");
		System.out.println("Ingrese 6 para:\n	-->Dar de alta");
		System.out.println();
		System.out.println("	Recuerde que para dar de alta al paciente, debe haber finalizado todos los procedimientos que tenga pendientes,");
		System.out.println("	para ello tal vez quiera hacer uso de la opción 5.");
		System.out.println("======================================================================");
		System.out.println("Ingrese 7 para:\n	-->Ver procedimientos asignados a un médico");
		System.out.println("======================================================================");
		System.out.println("Ingrese 8 para:\n	-->Ver detalles de pacientes");
		System.out.println("======================================================================");
		System.out.println("Ingrese 9 para:\n	-->Salir del sistema de forma segura");
		System.out.println("======================================================================");
		System.out.println();
		System.out.println();
		

		int opcion = entrada.nextInt();

		switch (opcion) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			System.exit(0);
			break;
		}

//		BorradorDeArchivos.borrarContArchivos();

	}
}
