package gestoraplicacion.infraestructura;

import java.io.Serializable;
import java.util.ArrayList;

public interface Actividad extends Serializable{
	
	/*
	 * Array que contiene los tipos de actividad o procedimientos ofrecidos en el hospital.
	 */
	public static final String[] tipoActividad= {"Oncologia","Pediatria","Urologia",
			"Oftalmologia","Cardiologia","Neurologia","Nefrologia","Dermatologia","Psiquiatria","Ginecologia"};
	
	/*
	 * Método abstracto verDetalle de actividad, deberá devolver un string con detalles de la Actividad que lo implemente. 
	 */
	public abstract String verDetalle();
	
	
}
