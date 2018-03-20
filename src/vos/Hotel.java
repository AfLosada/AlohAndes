package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Hotel extends Operador 
{
	@JsonProperty( value = "capacidad")
	private int capacidad;
	

	@JsonProperty( value = "id")
	private int id;
	
	
	public Hotel(boolean camaraComercio, String nombreOperador, boolean superIntendenciaTurismo, int capacidad,
			int idHotel) {
		super(camaraComercio, nombreOperador, superIntendenciaTurismo);
		this.capacidad = capacidad;
		this.id = idHotel;
	}

	

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getIdHotel() {
		return id;
	}

	public void setIdHotel(int idHotel) {
		this.id = idHotel;
	}
}
