package basedatos;

import gestoraplicacion.usuarios.Administrador;
import gestoraplicacion.usuarios.Medico;

public class MainPruebas {

	public static void main(String[] args) {
		
		Administrador admin= new Administrador();
		Medico med = new Medico();
		BDDriver.administradores.add(admin);
		BDDriver.medicos.add(med);
		
		Serializador.serializar();
		
		

	}

}
