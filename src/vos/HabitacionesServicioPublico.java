package vos;

public class HabitacionesServicioPublico 
{
	
	//
	// Atributos
	//
	
	private int idServicioPublico;
	
	private int idHabitacion;
	
	
	//
	// Constructor
	//
	
	/**
	 * @param idServicioPublico
	 * @param idHabitacion
	 */
	public HabitacionesServicioPublico(int idServicioPublico, int idHabitacion) {
		this.idServicioPublico = idServicioPublico;
		this.idHabitacion = idHabitacion;
	}
	
	//
	// Getters y Setters
	//
	
	/**
	 * @return the idServicioPublico
	 */
	public int getIdServicioPublico() {
		return idServicioPublico;
	}
	/**
	 * @param idServicioPublico the idServicioPublico to set
	 */
	public void setIdServicioPublico(int idServicioPublico) {
		this.idServicioPublico = idServicioPublico;
	}
	/**
	 * @return the idHabitacion
	 */
	public int getIdHabitacion() {
		return idHabitacion;
	}
	/**
	 * @param idHabitacion the idHabitacion to set
	 */
	public void setIdHabitacion(int idHabitacion) {
		this.idHabitacion = idHabitacion;
	}
	
}
