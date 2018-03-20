package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ServicioPublico 
{

	//
	// Atributos
	//

	@JsonProperty( value = "costo")
	private double costo;

	@JsonProperty( value = "id")
	private int id;

	@JsonProperty( value = "habitaciones")
	private String tipo;

	@JsonProperty( value = "habitaciones")
	private List<Habitacion> habitaciones;
	
	
	//
	// Constructor
	//

	public ServicioPublico(double costo, int id, String tipo) {
		super();
		this.costo = costo;
		this.id = id;
		this.tipo = tipo;
	}
	
	//
	// Getters y Setters
	//

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	
}
