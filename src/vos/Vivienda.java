package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Vivienda 
{

	//
	// Atributos
	//
	@JsonProperty( value = "capacidad")
	private int capacidad;

	@JsonProperty( value = "caracteristicasSeguro")
	private String caracteristicasSeguro;

	@JsonProperty( value = "caracteristicas")
	private String caracteristicas;
	
	private int id;
	
	//
	// Constructor
	//
	
	public Vivienda(int capacidad, String caracteristicasSeguro, String caracteristicas, int id) {
		super();
		this.capacidad = capacidad;
		this.caracteristicasSeguro = caracteristicasSeguro;
		this.caracteristicas = caracteristicas;
		this.id = id;
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

	public String getCaracteristicasSeguro() {
		return caracteristicasSeguro;
	}

	public void setCaracteristicasSeguro(String caracteristicasSeguro) {
		this.caracteristicasSeguro = caracteristicasSeguro;
	}

	public String[] getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String[] caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
