package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Apartamento;
import vos.Apartamento;
import vos.Apartamento;
import vos.Apartamento;
import vos.Apartamento;
import vos.Apartamento;

public class DAOApartamento 
{

	//----------------------------------------------------------------------------------------------------------------------------------
	// CONSTANTES
	//----------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Constante para indicar el usuario Oracle del estudiante
	 */
	//TODO Requerimiento 1H: Modifique la constante, reemplazando al ususario PARRANDEROS por su ususario de Oracle
	public final static String USUARIO = "ISIS2304A881810";

	//----------------------------------------------------------------------------------------------------------------------------------
	// ATRIBUTOS
	//----------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Arraylits de recursos que se usan para la ejecucion de sentencias SQL
	 */
	private ArrayList<Object> recursos;

	/**
	 * Atributo que genera la conexion a la base de datos
	 */
	private Connection conn;

	//----------------------------------------------------------------------------------------------------------------------------------
	// METODOS DE INICIALIZACION
	//----------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Metodo constructor de la clase DAOApartamento <br/>
	 */
	public DAOApartamento() {
		recursos = new ArrayList<Object>();
	}
	
	/**
	 * Metodo que obtiene la informacion de todos los Apartamentoes en la Base de Datos <br/>
	 * <b>Precondicion: </b> la conexion a sido inicializadoa <br/>
	 * @return	lista con la informacion de todos los Apartamentoes que se encuentran en la Base de Datos
	 * @throws SQLException Genera excepcion si hay error en la conexion o en la consulta SQL
	 * @throws Exception Si se genera un error dentro del metodo.
	 */
	public ArrayList<Apartamento> getApartamentos() throws SQLException, Exception {
		ArrayList<Apartamento> apartamentos = new ArrayList<Apartamento>();

		//Aclaracion: Por simplicidad, solamente se obtienen los primeros 50 resultados de la consulta
		String sql = String.format("SELECT * FROM %1$s.ApartamentoES WHERE ROWNUM <= 50", USUARIO);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			apartamentos.add(convertResultSetToApartamento(rs));
		}
		return apartamentos;
	}
	
	
	/**
	 * Metodo que obtiene la informacion del Apartamento en la Base de Datos que tiene el identificador dado por parametro<br/>
	 * <b>Precondicion: </b> la conexion a sido inicializadoa <br/> 
	 * @param id el identificador del Apartamento
	 * @return la informacion del Apartamento que cumple con los criterios de la sentecia SQL
	 * 			Null si no existe el Apartamento conlos criterios establecidos
	 * @throws SQLException SQLException Genera excepcion si hay error en la conexion o en la consulta SQL
	 * @throws Exception Si se genera un error dentro del metodo.
	 */
	public Apartamento findApartamentoById(Long id) throws SQLException, Exception 
	{
		Apartamento Apartamento = null;

		String sql = String.format("SELECT * FROM %1$s.APARTAMENTO WHERE ID = %2$d", USUARIO, id); 

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		if(rs.next()) {
			Apartamento = convertResultSetToApartamento(rs);
		}

		return Apartamento;
	}
	
	/**
	 * Metodo que agregar la informacion de un nuevo Apartamento en la Base de Datos a partir del parametro ingresado<br/>
	 * <b>Precondicion: </b> la conexion a sido inicializadoa <br/>  
	 * @param Apartamento Apartamento que desea agregar a la Base de Datos
	 * @throws SQLException SQLException Genera excepcion si hay error en la conexion o en la consulta SQL
	 * @throws Exception Si se genera un error dentro del metodo.
	 */
	public void addApartamento(Apartamento apartamento) throws SQLException, Exception {

		String sql = String.format("INSERT INTO %1$s.ApartamentoES (amoblado, capacidad, id, precio) VALUES (%2$s, '%3$s', '%4$s', '%5$s')", 
									USUARIO, 
									apartamento.isAmoblado(), 
									apartamento.getCapacidad(),
									apartamento.getId(), 
									apartamento.getPrecio());
		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}


	/**
	 * Metodo que actualiza la informacion del apartamento en la Base de Datos que tiene el identificador dado por parametro<br/>
	 * <b>Precondicion: </b> la conexion a sido inicializadoa <br/>  
	 * @param apartamento Apartamento que desea actualizar a la Base de Datos
	 * @throws SQLException SQLException Genera excepcion si hay error en la conexion o en la consulta SQL
	 * @throws Exception Si se genera un error dentro del metodo.
	 */
	public void updateApartamento(Apartamento apartamento) throws SQLException, Exception {

		StringBuilder sql = new StringBuilder();
		sql.append (String.format ("UPDATE %s.BEBEDORES ", USUARIO));
		sql.append (String.format (
				"SET AMOBLADO = '%1$s', CAPACIDAD = '%2$s', ID = '%3$s' , PRECIO = '%4$s'",
				apartamento.isAmoblado(), 
				apartamento.getCapacidad(),
				apartamento.getId(), 
				apartamento.getPrecio()));
		sql.append ("WHERE ID = " + apartamento.getId ());
		System.out.println(sql);
		
		PreparedStatement prepStmt = conn.prepareStatement(sql.toString());
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	/**
	 * Metodo que actualiza la informacion del apartamento en la Base de Datos que tiene el identificador dado por parametro<br/>
	 * <b>Precondicion: </b> la conexion a sido inicializadoa <br/>  
	 * @param apartamento Apartamento que desea actualizar a la Base de Datos
	 * @throws SQLException SQLException Genera excepcion si hay error en la conexion o en la consulta SQL
	 * @throws Exception Si se genera un error dentro del metodo.
	 */
	public void deleteApartamento(Apartamento apartamento) throws SQLException, Exception {

		String sql = String.format("DELETE FROM %1$s.APARTAMENTO WHERE ID = %3$d", USUARIO, apartamento.getId());

		System.out.println(sql);
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	//----------------------------------------------------------------------------------------------------------------------------------
	// METODOS AUXILIARES
	//----------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * Metodo encargado de inicializar la conexion del DAO a la Base de Datos a partir del parametro <br/>
	 * <b>Postcondicion: </b> el atributo conn es inicializado <br/>
	 * @param connection la conexion generada en el TransactionManager para la comunicacion con la Base de Datos
	 */
	public void setConn(Connection connection){
		this.conn = connection;
	}
	
	/**
	 * Metodo que cierra todos los recursos que se encuentran en el arreglo de recursos<br/>
	 * <b>Postcondicion: </b> Todos los recurso del arreglo de recursos han sido cerrados.
	 */
	public void cerrarRecursos() {
		for(Object ob : recursos){
			if(ob instanceof PreparedStatement)
				try {
					((PreparedStatement) ob).close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
		}
	}
	
	/**
	 * Metodo que transforma el resultado obtenido de una consulta SQL (sobre la tabla ApartamentoES) en una instancia de la clase Apartamento.
	 * @param resultSet ResultSet con la informacion de un Apartamento que se obtuvo de la base de datos.
	 * @return Apartamento cuyos atributos corresponden a los valores asociados a un registro particular de la tabla ApartamentoES.
	 * @throws SQLException Si existe algun problema al extraer la informacion del ResultSet.
	 */
	public Apartamento convertResultSetToApartamento(ResultSet resultSet) throws SQLException {
		//TODO Requerimiento 1G: Complete el metodo con los atributos agregados previamente en la clase Apartamento. 
		//						 Tenga en cuenta los nombres de las columnas de la Tabla en la Base de Datos (ID, NOMBRE, PRESUPUESTO, CIUDAD)

		String amoblado = resultSet.getString("amoblado");
		boolean rta = false;
		if(amoblado.equals(1))
		{
			rta = true;
		}
		String capacidad = resultSet.getString("capacidad");
		String precio = resultSet.getString("precio");
		String id = resultSet.getString("id");

		Apartamento beb = new Apartamento(rta, Integer.parseInt(capacidad), Integer.parseInt(id), Integer.parseInt(precio));

		return beb;
	}
	

}
