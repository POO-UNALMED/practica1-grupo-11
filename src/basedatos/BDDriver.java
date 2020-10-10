package basedatos;

import java.util.ArrayList;

import gestoraplicacion.infraestructura.HistoriaClinica;
import gestoraplicacion.infraestructura.Hospital;
import gestoraplicacion.infraestructura.Procedimiento;
import gestoraplicacion.infraestructura.Room;
import gestoraplicacion.infraestructura.Solicitud;
import gestoraplicacion.usuarios.Administrador;
import gestoraplicacion.usuarios.Medico;
import gestoraplicacion.usuarios.Paciente;

/*
 * Esta clase BDDriver contiene las listas de objetos de inter�s para el sistema y el modelo l�gico.
 * En ellas se guardar� a informaci�n durante la ejecuci�n y ser�n serializadas al momento de cerrar la aplicaci�n.
 * Son de tipo est�tico y p�blico. 
 */

public class BDDriver {
	public static ArrayList<HistoriaClinica> historiasClinicas = new ArrayList<HistoriaClinica>();
	public static ArrayList<Hospital> hospitales = new ArrayList<Hospital>();
	public static ArrayList<Procedimiento> procedimientos = new ArrayList<Procedimiento>();
	public static ArrayList<Room> rooms = new ArrayList<Room>();
	public static ArrayList<Solicitud> solicitudes = new ArrayList<Solicitud>();
	public static ArrayList<Administrador> administradores = new ArrayList<Administrador>();
	public static ArrayList<Medico> medicos = new ArrayList<Medico>();
	public static ArrayList<Paciente> pacientes = new ArrayList<Paciente>();

}
