package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Apartamento 
{

	@JsonProperty( value = "amoblado")
	private boolean amoblado;

	@JsonProperty( value = "capacidad")
	private int capacidad;

	@JsonProperty( value = "id")
	private int id;

	@JsonProperty( value = "precio")
	private double precio;



	//
	// Constructor
	//

	public Apartamento(boolean amoblado, int capacidad, int id, double precio) {
		super();
		this.amoblado = amoblado;
		this.capacidad = capacidad;
		this.id = id;
		this.precio = precio;
	}

	//
	// Getters y Setters
	// 


	public boolean isAmoblado() {
		return amoblado;
	}

	public void setAmoblado(boolean amoblado) {
		this.amoblado = amoblado;
	}

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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
