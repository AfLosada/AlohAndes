package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ServicioInmobiliario {

	//
	// Atributos
	//

	@JsonProperty( value = "costo")
	private double costo;

	@JsonProperty( value = "id")
	private int id;

	@JsonProperty( value = "tipo")
	private String tipo;
	
	
	//
	// Constructor
	//

	public ServicioInmobiliario(double costo, int id, String tipo) {
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
	
}
