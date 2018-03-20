package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Hostal extends Operador
{

	@JsonProperty( value = "capacidad")
	private int capacidad;

	@JsonProperty( value = "id")
	private int id;

	@JsonProperty( value = "horaApertura")
	private String horaApertura;

	@JsonProperty( value = "horaCierre")
	private String horaCierre;

	@JsonProperty( value = "recepcion24horas")
	private boolean recepcion24horas;
	

	//
	// Constructor
	//


	public Hostal(boolean camaraComercio, String nombreOperador, boolean superIntendenciaTurismo, int capacidad, int id,
			String horaApertura, String horaCierre, boolean recepcion24horas) {
		super(camaraComercio, nombreOperador, superIntendenciaTurismo);
		this.capacidad = capacidad;
		this.id = id;
		this.horaApertura = horaApertura;
		this.horaCierre = horaCierre;
		this.recepcion24horas = recepcion24horas;
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
	

	public String getHoraApertura() {
		return horaApertura;
	}

	public void setHoraApertura(String horaApertura) {
		this.horaApertura = horaApertura;
	}

	public String getHoraCierre() {
		return horaCierre;
	}

	public void setHoraCierre(String horaCierre) {
		this.horaCierre = horaCierre;
	}

	public boolean isRecepcion24horas() {
		return recepcion24horas;
	}

	public void setRecepcion24horas(boolean recepcion24horas) {
		this.recepcion24horas = recepcion24horas;
	}
	
}
