package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Sala 
{


	//
	// Atributos
	//

	@JsonProperty( value = "costo")
	private double costo;

	@JsonProperty( value = "id")
	private int id;

	@JsonProperty( value = "proposito")
	private String proposito;

	@JsonProperty( value = "tieneCostoAdicional")
	private boolean tieneCostoAdicional;
	
	//
	// Constructor
	//
	
	public Sala(double costo, int id, String proposito, boolean tieneCostoAdicional) {
		super();
		this.costo = costo;
		this.id = id;
		this.proposito = proposito;
		this.tieneCostoAdicional = tieneCostoAdicional;
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

	public String getProposito() {
		return proposito;
	}

	public void setProposito(String proposito) {
		this.proposito = proposito;
	}

	public boolean isTieneCostoAdicional() {
		return tieneCostoAdicional;
	}

	public void setTieneCostoAdicional(boolean tieneCostoAdicional) {
		this.tieneCostoAdicional = tieneCostoAdicional;
	}
	
}
