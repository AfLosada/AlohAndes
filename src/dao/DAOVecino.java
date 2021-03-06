package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.PersonaNatural;
import vos.Vecino;

public class DAOVecino {


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
	 * Metodo constructor de la clase DAOVecino <br/>
	 */
	public DAOVecino() {
		recursos = new ArrayList<Object>();
	}

	/**
	 * Metodo que obtiene la informacion de todos los Vecinoes en la Base de Datos <br/>
	 * <b>Precondicion: </b> la conexion a sido inicializadoa <br/>
	 * @return	lista con la informacion de todos los Vecinoes que se encuentran en la Base de Datos
	 * @throws SQLException Genera excepcion si hay error en la conexion o en la consulta SQL
	 * @throws Exception Si se genera un error dentro del metodo.
	 */
	public ArrayList<Vecino> getVecinos() throws SQLException, Exception {
		ArrayList<Vecino> vecinos = new ArrayList<Vecino>();

		//Aclaracion: Por simplicidad, solamente se obtienen los primeros 50 resultados de la consulta
		String sql = String.format("SELECT * FROM %1$s.VecinoES WHERE ROWNUM <= 50", USUARIO);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			vecinos.add(convertResultSetToVecino(rs));
		}
		return vecinos;
	}


	/**
	 * Metodo que obtiene la informacion del Vecino en la Base de Datos que tiene el identificador dado por parametro<br/>
	 * <b>Precondicion: </b> la conexion a sido inicializadoa <br/> 
	 * @param id el identificador del Vecino
	 * @return la informacion del Vecino que cumple con los criterios de la sentecia SQL
	 * 			Null si no existe el Vecino conlos criterios establecidos
	 * @throws SQLException SQLException Genera excepcion si hay error en la conexion o en la consulta SQL
	 * @throws Exception Si se genera un error dentro del metodo.
	 */
	public Vecino findVecinoById(Long id) throws SQLException, Exception 
	{
		Vecino Vecino = null;

		String sql = String.format("SELECT * FROM %1$s.APARTAMENTO WHERE ID = %2$d", USUARIO, id); 

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		if(rs.next()) {
			Vecino = convertResultSetToVecino(rs);
		}

		return Vecino;
	}

	/**
	 * Metodo que agregar la informacion de un nuevo Vecino en la Base de Datos a partir del parametro ingresado<br/>
	 * <b>Precondicion: </b> la conexion a sido inicializadoa <br/>  
	 * @param Vecino Vecino que desea agregar a la Base de Datos
	 * @throws SQLException SQLException Genera excepcion si hay error en la conexion o en la consulta SQL
	 * @throws Exception Si se genera un error dentro del metodo.
	 */
	public void addVecino(Vecino vecino) throws SQLException, Exception {

		String sql = String.format("INSERT INTO %1$s.HOSTALES (camaraComercio, nombreOperador, superIntendenciaTurismo, capacidad, id) VALUES (%2$s, '%3$s', '%4$s', '%5$s', '%6$s', '%7$s')", 
				USUARIO, 
				vecino.isCamaraComercio(),
				vecino.getNombreOperador(),
				vecino.isSuperIntendenciaTurismo(),
				vecino.getIdVecino());
		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}


	/**
	 * Metodo que actualiza la informacion del vecino en la Base de Datos que tiene el identificador dado por parametro<br/>
	 * <b>Precondicion: </b> la conexion a sido inicializadoa <br/>  
	 * @param vecino Vecino que desea actualizar a la Base de Datos
	 * @throws SQLException SQLException Genera excepcion si hay error en la conexion o en la consulta SQL
	 * @throws Exception Si se genera un error dentro del metodo.
	 */
	public void updateVecino(Vecino vecino) throws SQLException, Exception {

		StringBuilder sql = new StringBuilder();
		sql.append (String.format ("UPDATE %s.BEBEDORES ", USUARIO));
		sql.append (String.format (
				"SET camaracomercio = '%1$s', nombreoperador = '%2$s', superintendeciaturismo = '%3$s' , capacidad = '%4$s',id = '%5$s', ",

				vecino.isCamaraComercio(),
				vecino.getNombreOperador(),
				vecino.isSuperIntendenciaTurismo(),
				vecino.getIdVecino()));
		sql.append ("WHERE ID = " + vecino.getIdVecino ());
		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql.toString());
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	/**
	 * Metodo que actualiza la informacion del vecino en la Base de Datos que tiene el identificador dado por parametro<br/>
	 * <b>Precondicion: </b> la conexion a sido inicializadoa <br/>  
	 * @param vecino Vecino que desea actualizar a la Base de Datos
	 * @throws SQLException SQLException Genera excepcion si hay error en la conexion o en la consulta SQL
	 * @throws Exception Si se genera un error dentro del metodo.
	 */
	public void deleteVecino(Vecino vecino) throws SQLException, Exception {

		String sql = String.format("DELETE FROM %1$s.APARTAMENTO WHERE ID = %3$d", USUARIO, vecino.getIdVecino());

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
	 * Metodo que transforma el resultado obtenido de una consulta SQL (sobre la tabla VecinoES) en una instancia de la clase Vecino.
	 * @param resultSet ResultSet con la informacion de un Vecino que se obtuvo de la base de datos.
	 * @return Vecino cuyos atributos corresponden a los valores asociados a un registro particular de la tabla VecinoES.
	 * @throws SQLException Si existe algun problema al extraer la informacion del ResultSet.
	 */
	public Vecino convertResultSetToVecino(ResultSet resultSet) throws SQLException {
		//TODO Requerimiento 1G: Complete el metodo con los atributos agregados previamente en la clase Vecino. 
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
		String id = resultSet.getString("id");
		String miembro = resultSet.getString("miembro");
		if(miembro.equals("1"))
		{
			rta3 = true;
		}
		String idVecino = resultSet.getString("idVecino");

		Vecino beb = new Vecino(rta1, nombre, rta2, Integer.parseInt(capacidad), Integer.parseInt(id), rta3, Integer.parseInt(idVecino));

		return beb;
	}

}
