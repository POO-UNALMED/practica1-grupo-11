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
	private String especialidad;
	private ArrayList<Procedimiento> procedAsignados=new ArrayList<Procedimiento>();
	private Hospital hospital;
	private int estadoCuenta;
	
	/*
	 * Constructores
	 */
	
	public Medico(String nombre,String especialidad) {
		super(nombre);
		this.especialidad = especialidad;
		BDDriver.medicos.add(this);
	}
	
	/*
	 * Getters y Setters
	 */
	public String getEspecialidad() {
		return especialidad;
	}


	public void setEspecialidad(String especialidad) {
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
	public void agregarActividad(Actividad actividad) {
		procedAsignados.add((Procedimiento) actividad);
		
	}
	
	
}
