package basedatos;

import gestoraplicacion.usuarios.Administrador;
import gestoraplicacion.usuarios.Medico;

public class MainPruebas {

	public static void main(String[] args) {

		Administrador admin = new Administrador();
		Medico med = new Medico();
		BDDriver.administradores.add(admin);
		BDDriver.medicos.add(med);
		admin.setCargo("Jefe");
		Serializador.serializar();
		Deserializador.deserializar();

		for (Administrador administrador : BDDriver.administradores) {
			System.out.println(administrador.getCargo());
		}

	}

}
