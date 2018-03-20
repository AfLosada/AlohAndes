package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class PersonaNatural extends Operador
{

	//
	// Atributos
	//
	
	@JsonProperty( value = "edad" )
	private int edad;

	@JsonProperty( value = "id" )
	private int id;
	
	@JsonProperty( value = "miembro" )
	private boolean miembro;
	
	
	//
	// Constructor
	//
	
	public PersonaNatural(boolean camaraComercio, String nombreOperador, boolean superIntendenciaTurismo, int edad,
			int id, boolean miembro) 
	{
		super(camaraComercio, nombreOperador, superIntendenciaTurismo);
		this.edad = edad;
		this.id = id;
		this.miembro = miembro;
	}
	
	// 
	// Getters y Setters 
	//
	
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isMiembro() {
		return miembro;
	}

	public void setMiembro(boolean miembro) {
		this.miembro = miembro;
	}
	
	
}
