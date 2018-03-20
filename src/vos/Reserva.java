package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Reserva 
{

	//
	// Atributos
	//

	@JsonProperty( value = "confirmada")
	private boolean confirmada;


	@JsonProperty( value = "duracion")
	private String duracion;

	@JsonProperty( value = "fecha")
	private String fecha;

	@JsonProperty( value = "id")
	private int id;

	@JsonProperty( value = "pagoAnticipado")
	private boolean pagoAnticipado;

	@JsonProperty ( value = "tiempoCancelacion")
	private String tiempoCancelacion;

	@JsonProperty ( value = "valor")
	private double valor;


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

	public Reserva(boolean confirmada, String duracion, String fecha, int id, boolean pagoAnticipado,
			String tiempoCancelacion, double valor, int idHostal, int idPersona, int idHotel, int idViviendaU,
			int idCliente) {
		super();
		this.confirmada = confirmada;
		this.duracion = duracion;
		this.fecha = fecha;
		this.id = id;
		this.pagoAnticipado = pagoAnticipado;
		this.tiempoCancelacion = tiempoCancelacion;
		this.valor = valor;
		this.idHostal = idHostal;
		this.idPersona = idPersona;
		this.idHotel = idHotel;
		this.idViviendaU = idViviendaU;
		this.idCliente = idCliente;
	}




	//
	// Getters y Setters
	//

	public boolean isConfirmada() {
		return confirmada;
	}



	public void setConfirmada(boolean confirmada) {
		this.confirmada = confirmada;
	}



	public String getDuracion() {
		return duracion;
	}



	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}



	public String getFecha() {
		return fecha;
	}



	public void setFecha(String fecha) {
		this.fecha = fecha;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public boolean isPagoAnticipado() {
		return pagoAnticipado;
	}



	public void setPagoAnticipado(boolean pagoAnticipado) {
		this.pagoAnticipado = pagoAnticipado;
	}



	public String getTiempoCancelacion() {
		return tiempoCancelacion;
	}



	public void setTiempoCancelacion(String tiempoCancelacion) {
		this.tiempoCancelacion = tiempoCancelacion;
	}



	public double getValor() {
		return valor;
	}



	public void setValor(double valor) {
		this.valor = valor;
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
