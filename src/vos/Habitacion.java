package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Habitacion 
{
	
	//
	// Atributos
	//
	
	@JsonProperty( value = "capacidad" )
	private int capacidad;

	@JsonProperty( value = "id" )
	private int id;
	
	@JsonProperty( value = "precio" )
	private int precio;
	
	@JsonProperty( value = "tamanio" )
	private double tamanio;
	
	@JsonProperty( value = "ubicacion" )
	private String ubicacion;
	
	@JsonProperty( value = "tipo" )
	private TipoHabitacion tipo;
	
	
	private enum TipoHabitacion
	{
		Compartida, Individual, Suite, SemiSuite, Estandar;
	}
	
	
	//
	// Constructor
	//
	
	public Habitacion(int capacidad, int id, int precio, double tamanio, String ubicacion, String tipo) 
	{
		super();
		this.capacidad = capacidad;
		this.id = id;
		this.precio = precio;
		this.tamanio = tamanio;
		this.ubicacion = ubicacion;
		this.tipo = TipoHabitacion.valueOf(tipo);
	}
	
	//
	// Getters y Setters
	//
	
	public int getCapacidad() {
		return capacidad;
	}


	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}


	public double getTamanio() {
		return tamanio;
	}


	public void setTamanio(double tamanio) {
		this.tamanio = tamanio;
	}


	public String getUbicacion() {
		return ubicacion;
	}


	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}


	public TipoHabitacion getTipo() {
		return tipo;
	}


	public void setTipo(TipoHabitacion tipo) {
		this.tipo = tipo;
	}


	
}
