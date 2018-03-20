package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Oferta 
{
	@JsonProperty( value = "id")
	private int id;

	@JsonProperty( value = "numReservas")
	private int numReservas;

	@JsonProperty( value = "vigente")
	private boolean vigente;

	@JsonProperty ( value = "idHostal" )
	private int idHostal;

	@JsonProperty ( value = "idPersona" )
	private int idPersona;

	@JsonProperty ( value = "idHotel" )
	private int idHotel;

	@JsonProperty ( value = "idViviendaU" )
	private int idViviendaU;

	@JsonProperty ( value = "idCliente" )
	private int idCliente;

	//
	// Constructor
	//


	/**
	 * @param id
	 * @param numReservas
	 * @param vigente
	 * @param idHostal
	 * @param idPersona
	 * @param idHotel
	 * @param idViviendaU
	 * @param idCliente
	 */
	public Oferta(int id, int numReservas, boolean vigente, int idHostal, int idPersona, int idHotel, int idViviendaU,
			int idCliente) {
		super();
		this.id = id;
		this.numReservas = numReservas;
		this.vigente = vigente;
		this.idHostal = idHostal;
		this.idPersona = idPersona;
		this.idHotel = idHotel;
		this.idViviendaU = idViviendaU;
		this.idCliente = idCliente;
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

	public int getNumReservas() {
		return numReservas;
	}

	public void setNumReservas(int numReservas) {
		this.numReservas = numReservas;
	}

	public boolean isVigente() {
		return vigente;
	}

	public void setVigente(boolean vigente) {
		this.vigente = vigente;
	}

	/**
	 * @return the idHostal
	 */
	public int getIdHostal() {
		return idHostal;
	}



	/**
	 * @param idHostal the idHostal to set
	 */
	public void setIdHostal(int idHostal) {
		this.idHostal = idHostal;
	}



	/**
	 * @return the idPersona
	 */
	public int getIdPersona() {
		return idPersona;
	}



	/**
	 * @param idPersona the idPersona to set
	 */
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}



	/**
	 * @return the idHotel
	 */
	public int getIdHotel() {
		return idHotel;
	}



	/**
	 * @param idHotel the idHotel to set
	 */
	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}



	/**
	 * @return the idViviendaU
	 */
	public int getIdViviendaU() {
		return idViviendaU;
	}



	/**
	 * @param idViviendaU the idViviendaU to set
	 */
	public void setIdViviendaU(int idViviendaU) {
		this.idViviendaU = idViviendaU;
	}



	/**
	 * @return the idCliente
	 */
	public int getIdCliente() {
		return idCliente;
	}



	/**
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


}
