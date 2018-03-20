package vos;

import javax.swing.text.rtf.RTFEditorKit;

import org.codehaus.jackson.annotate.JsonProperty;

public class Operador 
{
	
	//
	// Atributos
	//
	
	@JsonProperty( value = "camaraComercio" )
	private boolean camaraComercio;

	@JsonProperty( value = "nombreOperador" )
	private String nombreOperador;
	
	@JsonProperty( value = "superIntendenciaTurismo" )
	private boolean superIntendenciaTurismo;
	
	//
	// Constructor
	//

	public Operador(boolean camaraComercio, String nombreOperador, boolean superIntendenciaTurismo) {
		super();
		this.camaraComercio = camaraComercio;
		this.nombreOperador = nombreOperador;
		this.superIntendenciaTurismo = superIntendenciaTurismo;
	}
	
	
	//
	// Getters y Setters
	//
	
	
	public boolean isCamaraComercio() {
		return camaraComercio;
	}

	public void setCamaraComercio(boolean camaraComercio) {
		this.camaraComercio = camaraComercio;
	}

	public String getNombreOperador() {
		return nombreOperador;
	}

	public void setNombreOperador(String nombreOperador) {
		this.nombreOperador = nombreOperador;
	}

	public boolean isSuperIntendenciaTurismo() {
		return superIntendenciaTurismo;
	}

	public void setSuperIntendenciaTurismo(boolean superIntendenciaTurismo) {
		this.superIntendenciaTurismo = superIntendenciaTurismo;
	}
	
	public String toString(boolean bul)
	{
		String rta = "F";
		if(bul)
		{
			rta = "T";
		}
		return rta;
	}
	
	public boolean fromString(String bul)
	{
		boolean rta = false;
		if(bul.equals("T"))
			rta= true;
		return rta;
	}
	
}
