/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.ViviendaUniversitaria;

/**
 * @author Andres Losada
 *
 */
public class DAOViviendaUniversitaria
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
	 * Metodo constructor de la clase DAOViviendaUniversitaria <br/>
	 */
	public DAOViviendaUniversitaria() {
		recursos = new ArrayList<Object>();
	}

	/**
	 * Metodo que obtiene la informacion de todos los ViviendaUniversitariaes en la Base de Datos <br/>
	 * <b>Precondicion: </b> la conexion a sido inicializadoa <br/>
	 * @return	lista con la informacion de todos los ViviendaUniversitariaes que se encuentran en la Base de Datos
	 * @throws SQLException Genera excepcion si hay error en la conexion o en la consulta SQL
	 * @throws Exception Si se genera un error dentro del metodo.
	 */
	public ArrayList<ViviendaUniversitaria> getViviendaUniversitarias() throws SQLException, Exception {
		ArrayList<ViviendaUniversitaria> viviendaUniversitarias = new ArrayList<ViviendaUniversitaria>();

		//Aclaracion: Por simplicidad, solamente se obtienen los primeros 50 resultados de la consulta
		String sql = String.format("SELECT * FROM %1$s.ViviendaUniversitariaES WHERE ROWNUM <= 50", USUARIO);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			viviendaUniversitarias.add(convertResultSetToViviendaUniversitaria(rs));
		}
		return viviendaUniversitarias;
	}


	/**
	 * Metodo que obtiene la informacion del ViviendaUniversitaria en la Base de Datos que tiene el identificador dado por parametro<br/>
	 * <b>Precondicion: </b> la conexion a sido inicializadoa <br/> 
	 * @param id el identificador del ViviendaUniversitaria
	 * @return la informacion del ViviendaUniversitaria que cumple con los criterios de la sentecia SQL
	 * 			Null si no existe el ViviendaUniversitaria conlos criterios establecidos
	 * @throws SQLException SQLException Genera excepcion si hay error en la conexion o en la consulta SQL
	 * @throws Exception Si se genera un error dentro del metodo.
	 */
	public ViviendaUniversitaria findViviendaUniversitariaById(Long id) throws SQLException, Exception 
	{
		ViviendaUniversitaria ViviendaUniversitaria = null;

		String sql = String.format("SELECT * FROM %1$s.APARTAMENTO WHERE ID = %2$d", USUARIO, id); 

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		if(rs.next()) {
			ViviendaUniversitaria = convertResultSetToViviendaUniversitaria(rs);
		}

		return ViviendaUniversitaria;
	}

	/**
	 * Metodo que agregar la informacion de un nuevo ViviendaUniversitaria en la Base de Datos a partir del parametro ingresado<br/>
	 * <b>Precondicion: </b> la conexion a sido inicializadoa <br/>  
	 * @param ViviendaUniversitaria ViviendaUniversitaria que desea agregar a la Base de Datos
	 * @throws SQLException SQLException Genera excepcion si hay error en la conexion o en la consulta SQL
	 * @throws Exception Si se genera un error dentro del metodo.
	 */
	public void addViviendaUniversitaria(ViviendaUniversitaria viviendaUniversitaria) throws SQLException, Exception {

		String sql = String.format("INSERT INTO %1$s.VIVIENDAUNIVERSITARIA (capacidad, id, duracion, amoblamiento) VALUES (%2$s, '%3$s', '%4$s')", 
				USUARIO, 
				viviendaUniversitaria.getCapacidad(),
				viviendaUniversitaria.getId(),
				viviendaUniversitaria.getDuracion(),
				viviendaUniversitaria.toString(viviendaUniversitaria.isAmoblamiento()));
		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}


	/**
	 * Metodo que actualiza la informacion del viviendaUniversitaria en la Base de Datos que tiene el identificador dado por parametro<br/>
	 * <b>Precondicion: </b> la conexion a sido inicializadoa <br/>  
	 * @param viviendaUniversitaria ViviendaUniversitaria que desea actualizar a la Base de Datos
	 * @throws SQLException SQLException Genera excepcion si hay error en la conexion o en la consulta SQL
	 * @throws Exception Si se genera un error dentro del metodo.
	 */
	public void updateViviendaUniversitaria(ViviendaUniversitaria viviendaUniversitaria) throws SQLException, Exception {

		StringBuilder sql = new StringBuilder();
		sql.append (String.format ("UPDATE %s.BEBEDORES ", USUARIO));
		sql.append (String.format (
				"SET capacidad = '%1$s', caracteristicasSeguro = '%2$s', caracteristicas = '%3$s'",
				viviendaUniversitaria.getCapacidad(),
				viviendaUniversitaria.getId(),
				viviendaUniversitaria.getDuracion(),
				viviendaUniversitaria.toString(viviendaUniversitaria.isAmoblamiento())));
		sql.append ("WHERE ID = " + viviendaUniversitaria.getId());
		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql.toString());
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	/**
	 * Metodo que actualiza la informacion del viviendaUniversitaria en la Base de Datos que tiene el identificador dado por parametro<br/>
	 * <b>Precondicion: </b> la conexion a sido inicializadoa <br/>  
	 * @param viviendaUniversitaria ViviendaUniversitaria que desea actualizar a la Base de Datos
	 * @throws SQLException SQLException Genera excepcion si hay error en la conexion o en la consulta SQL
	 * @throws Exception Si se genera un error dentro del metodo.
	 */
	public void deleteViviendaUniversitaria(ViviendaUniversitaria viviendaUniversitaria) throws SQLException, Exception {

		String sql = String.format("DELETE FROM %1$s.APARTAMENTO WHERE ID = %3$d", USUARIO, viviendaUniversitaria.getId());

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
	 * Metodo que transforma el resultado obtenido de una consulta SQL (sobre la tabla ViviendaUniversitariaES) en una instancia de la clase ViviendaUniversitaria.
	 * @param resultSet ResultSet con la informacion de un ViviendaUniversitaria que se obtuvo de la base de datos.
	 * @return ViviendaUniversitaria cuyos atributos corresponden a los valores asociados a un registro particular de la tabla ViviendaUniversitariaES.
	 * @throws SQLException Si existe algun problema al extraer la informacion del ResultSet.
	 */
	public ViviendaUniversitaria convertResultSetToViviendaUniversitaria(ResultSet resultSet) throws SQLException {
		//TODO Requerimiento 1G: Complete el metodo con los atributos agregados previamente en la clase ViviendaUniversitaria. 
		//						 Tenga en cuenta los nombres de las columnas de la Tabla en la Base de Datos (ID, NOMBRE, PRESUPUESTO, CIUDAD)

		boolean rta1 = false;
		boolean rta2 = false;
		boolean rta3 = false;
		
		String camara = resultSet.getString("camara");

		if(camara.equals("1"))
		{
			rta1 = true;
		}
		String nombre = resultSet.getString("nombre");
		String superI = resultSet.getString("superIndendenciaFinanciera");
		if(superI.equals("1"))
		{
			rta2 = true;
		}

		String capacidad = resultSet.getString("capacidad");
		String caracteristicasSeguro = resultSet.getString("caracteristicasSeguro");
		String amoblamiento = resultSet.getString("amoblamiento");
		String id = resultSet.getString("id");
		String duracion = resultSet.getString("duracion");
		if(amoblamiento.equals("T"))
		{
			rta3 = true;
		}

		ViviendaUniversitaria beb = new ViviendaUniversitaria(rta1, nombre, rta2,Integer.parseInt(capacidad), Integer.parseInt(id),Double.parseDouble(duracion), rta3);

		return beb;
	}
}
