package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.ServicioPublico;

public class DAOServicioPublico 
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
		 * Metodo constructor de la clase DAOServicioPublico <br/>
		 */
		public DAOServicioPublico() {
			recursos = new ArrayList<Object>();
		}

		/**
		 * Metodo que obtiene la informacion de todos los ServicioPublicoes en la Base de Datos <br/>
		 * <b>Precondicion: </b> la conexion a sido inicializadoa <br/>
		 * @return	lista con la informacion de todos los ServicioPublicoes que se encuentran en la Base de Datos
		 * @throws SQLException Genera excepcion si hay error en la conexion o en la consulta SQL
		 * @throws Exception Si se genera un error dentro del metodo.
		 */
		public ArrayList<ServicioPublico> getServicioPublicos() throws SQLException, Exception {
			ArrayList<ServicioPublico> servicioPublicos = new ArrayList<ServicioPublico>();

			//Aclaracion: Por simplicidad, solamente se obtienen los primeros 50 resultados de la consulta
			String sql = String.format("SELECT * FROM %1$s.ServicioPublicoES WHERE ROWNUM <= 50", USUARIO);

			PreparedStatement prepStmt = conn.prepareStatement(sql);
			recursos.add(prepStmt);
			ResultSet rs = prepStmt.executeQuery();

			while (rs.next()) {
				servicioPublicos.add(convertResultSetToServicioPublico(rs));
			}
			return servicioPublicos;
		}


		/**
		 * Metodo que obtiene la informacion del ServicioPublico en la Base de Datos que tiene el identificador dado por parametro<br/>
		 * <b>Precondicion: </b> la conexion a sido inicializadoa <br/> 
		 * @param id el identificador del ServicioPublico
		 * @return la informacion del ServicioPublico que cumple con los criterios de la sentecia SQL
		 * 			Null si no existe el ServicioPublico conlos criterios establecidos
		 * @throws SQLException SQLException Genera excepcion si hay error en la conexion o en la consulta SQL
		 * @throws Exception Si se genera un error dentro del metodo.
		 */
		public ServicioPublico findServicioPublicoById(Long id) throws SQLException, Exception 
		{
			ServicioPublico ServicioPublico = null;

			String sql = String.format("SELECT * FROM %1$s.SERVICIOINMOBILIARIO WHERE ID = %2$d", USUARIO, id); 

			PreparedStatement prepStmt = conn.prepareStatement(sql);
			recursos.add(prepStmt);
			ResultSet rs = prepStmt.executeQuery();

			if(rs.next()) {
				ServicioPublico = convertResultSetToServicioPublico(rs);
			}

			return ServicioPublico;
		}

		/**
		 * Metodo que agregar la informacion de un nuevo ServicioPublico en la Base de Datos a partir del parametro ingresado<br/>
		 * <b>Precondicion: </b> la conexion a sido inicializadoa <br/>  
		 * @param ServicioPublico ServicioPublico que desea agregar a la Base de Datos
		 * @throws SQLException SQLException Genera excepcion si hay error en la conexion o en la consulta SQL
		 * @throws Exception Si se genera un error dentro del metodo.
		 */
		public void addServicioPublico(ServicioPublico servicioPublico) throws SQLException, Exception {

			String sql = String.format("INSERT INTO %1$s.HOSTALES (costo, id, tipo) VALUES (%2$s, '%3$s', '%4$s')", 
					USUARIO, 
					servicioPublico.getCosto(),
					servicioPublico.getId(),
					servicioPublico.getTipo());
			System.out.println(sql);

			PreparedStatement prepStmt = conn.prepareStatement(sql);
			recursos.add(prepStmt);
			prepStmt.executeQuery();

		}


		/**
		 * Metodo que actualiza la informacion del servicioPublico en la Base de Datos que tiene el identificador dado por parametro<br/>
		 * <b>Precondicion: </b> la conexion a sido inicializadoa <br/>  
		 * @param servicioPublico ServicioPublico que desea actualizar a la Base de Datos
		 * @throws SQLException SQLException Genera excepcion si hay error en la conexion o en la consulta SQL
		 * @throws Exception Si se genera un error dentro del metodo.
		 */
		public void updateServicioPublico(ServicioPublico servicioPublico) throws SQLException, Exception {

			StringBuilder sql = new StringBuilder();
			sql.append (String.format ("UPDATE %s.BEBEDORES ", USUARIO));
			sql.append (String.format (
					"SET comercio = '%1$s', id = '%2$s', proposito = '%3$s' , tieneCostoAdicional = '%4$s'",
					servicioPublico.getCosto(),
					servicioPublico.getId(),
					servicioPublico.getTipo()));
			sql.append ("WHERE ID = " + servicioPublico.getId());
			System.out.println(sql);

			PreparedStatement prepStmt = conn.prepareStatement(sql.toString());
			recursos.add(prepStmt);
			prepStmt.executeQuery();
		}

		/**
		 * Metodo que actualiza la informacion del servicioPublico en la Base de Datos que tiene el identificador dado por parametro<br/>
		 * <b>Precondicion: </b> la conexion a sido inicializadoa <br/>  
		 * @param servicioPublico ServicioPublico que desea actualizar a la Base de Datos
		 * @throws SQLException SQLException Genera excepcion si hay error en la conexion o en la consulta SQL
		 * @throws Exception Si se genera un error dentro del metodo.
		 */
		public void deleteServicioPublico(ServicioPublico servicioPublico) throws SQLException, Exception {

			String sql = String.format("DELETE FROM %1$s.APARTAMENTO WHERE ID = %3$d", USUARIO, servicioPublico.getId());

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
		 * Metodo que transforma el resultado obtenido de una consulta SQL (sobre la tabla ServicioPublicoES) en una instancia de la clase ServicioPublico.
		 * @param resultSet ResultSet con la informacion de un ServicioPublico que se obtuvo de la base de datos.
		 * @return ServicioPublico cuyos atributos corresponden a los valores asociados a un registro particular de la tabla ServicioPublicoES.
		 * @throws SQLException Si existe algun problema al extraer la informacion del ResultSet.
		 */
		public ServicioPublico convertResultSetToServicioPublico(ResultSet resultSet) throws SQLException {
			//TODO Requerimiento 1G: Complete el metodo con los atributos agregados previamente en la clase ServicioPublico. 
			//						 Tenga en cuenta los nombres de las columnas de la Tabla en la Base de Datos (ID, NOMBRE, PRESUPUESTO, CIUDAD)

			boolean rta1 = false;
			boolean rta2 = false;
			boolean rta3 = false;


			String tipo = resultSet.getString("tipo");
			String proposito = resultSet.getString("proposito");
			String costo = resultSet.getString("costo");
			String capacidad = resultSet.getString("capacidad");
			String id = resultSet.getString("id");
			String miembro = resultSet.getString("miembro");
			if(miembro.equals("1"))
			{
				rta3 = true;
			}

			ServicioPublico beb = new ServicioPublico(Double.parseDouble(costo), Integer.parseInt(id), tipo);

			return beb;
		}
}
