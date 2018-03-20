package vos;

public class HabitacionesServiciosInmobiliarios 
{
	//
	// Atributos
	//
	
	private int idServicioInmobiliario;
	
	private int idHabitacion;
	
	
	//
	// Constructor
	//
	
	/**
	 * @param idServicioInmobiliario
	 * @param idHabitacion
	 */
	public HabitacionesServiciosInmobiliarios(int idServicioInmobiliario, int idHabitacion) {
		super();
		this.idServicioInmobiliario = idServicioInmobiliario;
		this.idHabitacion = idHabitacion;
	}
	
	//
	// Getters y Setters
	//
	
	/**
	 * @return the idServicioInmobiliario
	 */
	public int getIdServicioInmobiliario() {
		return idServicioInmobiliario;
	}
	/**
	 * @param idServicioInmobiliario the idServicioInmobiliario to set
	 */
	public void setIdServicioInmobiliario(int idServicioInmobiliario) {
		this.idServicioInmobiliario = idServicioInmobiliario;
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
