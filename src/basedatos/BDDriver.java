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
 * Esta clase BDDriver contiene las listas de objetos de interés para el sistema y el modelo lógico.
 * En ellas se guardará a información durante la ejecución y serán serializadas al momento de cerrar la aplicación.
 * Son de tipo estático y público. 
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
	
	
	
	
	/*
	 * Está pendiente añadir métodos estáticos de fábrica para crear objetos, y ponerles condiciones para que:
	 *  
	 * 1. sólo pueda haber uno y solo un administrador y uno y solo un hospital
	 * 2. Cada vez que se cree un paciente también se cree su respectiva historia clinica.
	 * 
	 *  
	 *  y empezar a trabajar la interfaz gráfica. 
	 *  
	 */
	
	
	
}
