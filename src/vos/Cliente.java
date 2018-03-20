package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Cliente 


{
	
	//
	// Atributos
	//
	
	@JsonProperty(value = "id")
	private int id;

	@JsonProperty(value = "edad")
	private int edad;
	

	@JsonProperty(value = "miembro")
	private boolean miembro;
	

	@JsonProperty(value = "nombre")
	private String nombre;
	

	@JsonProperty(value = "tipo")
	private String tipo;
	
	
	
	
	//
	// Metodo Constructor
	//
	
	

	public Cliente(	@JsonProperty(value = "idCliente") int id2, @JsonProperty(value = "edad")int pEdad, @JsonProperty(value = "miembroComunidadUniversitario")  boolean pMiembroComunidadUniversitario, @JsonProperty(value = "nombre")	 String pnombre, @JsonProperty(value = "tipo")  String ptipo)
	{
		this.id = id2;
		this.edad = pEdad;
		this.miembro = pMiembroComunidadUniversitario;
		this.nombre = pnombre;
		this.tipo = ptipo;
	}
	
	//
	// Getters y Setters
	//
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public boolean isMiembro() {
		return miembro;
	}


	public void setMiembro(boolean miembro) {
		this.miembro = miembro;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
