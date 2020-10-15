package gestoraplicacion.usuarios;

import java.util.ArrayList;


import basedatos.BDDriver;
import gestoraplicacion.infraestructura.Actividad;
import gestoraplicacion.infraestructura.Hospital;
import gestoraplicacion.infraestructura.Procedimiento;


public class Medico extends Persona{
	/*
	 *Atributos 
	 */
	private static final long serialVersionUID = 6361786807611231845L;
	private int especialidad;
	private ArrayList<Procedimiento> procedAsignados=new ArrayList<Procedimiento>();
	private Hospital hospital=BDDriver.hospitales.get(0);
	private int estadoCuenta;
	
	/*
	 * Constructores
	 */
	public Medico() {
		super();
		
	}
	
	public Medico(String nombre, int id, int especialidad) {
		super(nombre, id);
		this.especialidad = especialidad;
		BDDriver.medicos.add(this);
	}
	
	/*
	 * Getters y Setters
	 */
	public int getEspecialidad() {
		return especialidad;
	}


	public void setEspecialidad(int especialidad) {
		this.especialidad = especialidad;
	}


	public ArrayList<Procedimiento> getProcedAsignados() {
		return procedAsignados;
	}


	public void setProcedAsignados(ArrayList<Procedimiento> procedAsignados) {
		this.procedAsignados = procedAsignados;
	}


	public Hospital getHospital() {
		return hospital;
	}


	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}


	public int getEstadoCuenta() {
		return estadoCuenta;
	}


	public void setEstadoCuenta(int estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}

	
	/*
	 * Metodos:
	 */
	
	
	/*
	 * M�todo que implementa ligadura din�mica
	 */
	@Override
	public void asignarActividad(Actividad actividad) {
		procedAsignados.add((Procedimiento) actividad);
		
	}
	
	
}
