package basedatos;

import gestoraplicacion.infraestructura.Hospital;
import gestoraplicacion.infraestructura.Room;
import gestoraplicacion.usuarios.Administrador;
import gestoraplicacion.usuarios.Medico;
import gestoraplicacion.usuarios.Paciente;

public class MainPruebas {

	public static void main(String[] args) {
		Hospital h1= new Hospital("Leon XIII");
		Administrador a1= new Administrador("Jaime Guzman");
		h1.setAdministradores(a1);
		a1.setHospital(h1);
		
		Room r1 = new Room();
		Room r2 = new Room();
		Room r3 = new Room();
		Room r4 = new Room();
		Room r5 = new Room();
		Room r6 = new Room();
		Room r7 = new Room();
		Room r8 = new Room();
		Room r9 = new Room();
		Room r10 = new Room();
		Room r11 = new Room();
		Room r12 = new Room();
		Room r13 = new Room();
		Room r14 = new Room();
		Room r15 = new Room();
		
		Medico m1 = new Medico("m1","e1");
		Medico m2 = new Medico("m2","e2");
		Medico m3 = new Medico("m3","e3");
		Medico m4 = new Medico("m4","e4");
		Medico m5 = new Medico("m5","e5");
		Medico m6 = new Medico("m6","e6");
		Medico m7 = new Medico("m7","e7");
		Medico m8 = new Medico("m8","e8");
		Medico m9 = new Medico("m9","e9");
		Medico m10 = new Medico("m10","e10");
		
		
		//BorradorDeArchivos.borrarContArchivos();
		
	}
}
