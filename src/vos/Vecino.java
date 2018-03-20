package vos;

import java.util.List;


import org.codehaus.jackson.annotate.JsonProperty;

public class Vecino extends PersonaNatural
{


	//
	// Atributos
	//
	
	
	private int idVecino;

	
	//
	// Constructor
	//
	
	public Vecino(boolean camaraComercio, String nombreOperador, boolean superIntendenciaTurismo, int edad, int id,
			boolean miembro, int idVecino) {
		super(camaraComercio, nombreOperador, superIntendenciaTurismo, edad, id, miembro);
		this.idVecino = idVecino;
	}
	

	//
	// Getters y Setters
	//
	
	/**
	 * @return the idVecino
	 */
	public int getIdVecino() {
		return idVecino;
	}


	/**
	 * @param idVecino the idVecino to set
	 */
	public void setIdVecino(int idVecino) {
		this.idVecino = idVecino;
	}
	
}
