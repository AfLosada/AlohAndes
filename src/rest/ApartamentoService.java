package rest;

import java.util.List;

import tm.ParranderosTransactionManager;
import vos.Apartamento;

public class ApartamentoService 
{

	/**
	 * @author Santiago Cortes Fernandez 	- 	s.cortes@uniandes.edu.co
	 * @author Juan David Vega Guzman		-	jd.vega11@uniandes.edu.co
	 * Clase que expone servicios REST con ruta base: http://localhost:8080/TutorialParranderos/rest/apartamentos/...
	 */
	@Path("apartamentos")
	public class ApartamentoesService {

		//----------------------------------------------------------------------------------------------------------------------------------
		// ATRIBUTOS
		//----------------------------------------------------------------------------------------------------------------------------------

		/**
		 * Atributo que usa la anotacion @Context para tener el ServletContext de la conexion actual.
		 */
		@Context
		private ServletContext context;

		//----------------------------------------------------------------------------------------------------------------------------------
		// METODOS DE INICIALIZACION
		//----------------------------------------------------------------------------------------------------------------------------------
		/**
		 * Metodo que retorna el path de la carpeta WEB-INF/ConnectionData en el deploy actual dentro del servidor.
		 * @return path de la carpeta WEB-INF/ConnectionData en el deploy actual.
		 */
		private String getPath() {
			return context.getRealPath("WEB-INF/ConnectionData");
		}


		private String doErrorMessage(Exception e){
			return "{ \"ERROR\": \""+ e.getMessage() + "\"}" ;
		}

		//----------------------------------------------------------------------------------------------------------------------------------
		// METODOS REST
		//----------------------------------------------------------------------------------------------------------------------------------

		/**
		 * Metodo GET que trae a todos los apartamentos en la Base de datos. <br/>
		 * <b>Precondicion: </b> el archivo <em>'conectionData'</em> ha sido inicializado con las credenciales del usuario <br/>
		 * <b>URL: </b> http://localhost:8080/TutorialParranderos/rest/apartamentos <br/>
		 * @return	<b>Response Status 200</b> - JSON que contiene a todos los apartamentos que estan en la Base de Datos <br/>
		 * 			<b>Response Status 500</b> - Excepcion durante el transcurso de la transaccion
		 */			
		@GET
		@Produces({ MediaType.APPLICATION_JSON })
		public Response getApartamentoes() {

			try {
				ParranderosTransactionManager tm = new ParranderosTransactionManager(getPath());

				List<Apartamento> apartamentos;
				//Por simplicidad, solamente se obtienen los primeros 50 resultados de la consulta
				apartamentos = tm.getAllApartamentoes();
				return Response.status(200).entity(apartamentos).build();
			} 
			catch (Exception e) {
				return Response.status(500).entity(doErrorMessage(e)).build();
			}
		}

		/**
		 * Metodo GET que trae al bebedor en la Base de Datos con el ID dado por parametro <br/>
		 * <b>Precondicion: </b> el archivo <em>'conectionData'</em> ha sido inicializado con las credenciales del usuario <br/>
		 * <b>URL: </b> http://localhost:8080/TutorialParranderos/rest/apartamentos/{id} <br/>
		 * @return	<b>Response Status 200</b> - JSON Apartamento que contiene al bebedor cuyo ID corresponda al parametro <br/>
		 * 			<b>Response Status 500</b> - Excepcion durante el transcurso de la transaccion
		 */
		@GET
		@Path( "{id: \\d+}" )
		@Produces( { MediaType.APPLICATION_JSON } )
		public Response getApartamentoById( @PathParam( "id" ) Long id )
		{
			try{
				ParranderosTransactionManager tm = new ParranderosTransactionManager( getPath( ) );

				Apartamento bebedor = tm.getApartamentoById( id );
				return Response.status( 200 ).entity( bebedor ).build( );			
			}
			catch( Exception e )
			{
				return Response.status( 500 ).entity( doErrorMessage( e ) ).build( );
			}
		}

		/**
		 * Metodo que trae a los apartamentos de la Base de Datos que viven en la ciudad y tienen el presupuesto dados por parámetro <br/>
		 * <b>Precondicion: </b> el archivo <em>'conectionData'</em> ha sido inicializado con las credenciales del usuario <br/>
		 * <b>URL: </b> http://localhost:8080/TutorialParranderos/rest/apartamentos/filterBy?nombre=---&apellido=--- <br/>
		 * @param ciudad - <em>[QueryParam]</em> parametro que indica la ciudad de los apartamentos
		 * @param presupuesto - <em>[QueryParam]</em> parametro que indica el presupuesto de los apartamentos
		 * @return	<b>Response Status 200</b> - JSONs que contienen a los apartamentos que tengan el nombre o el apellido correspondiente<br/>
		 * 			<b>Response Status 500</b> - Excepcion durante el transcurso de la transaccion
		 */
		//TODO Requerimiento 2A: Identifique e implemente la anotacion correcta para la realizacion del metodo

		@Path( "/filterBy" )
		//TODO Requerimiento 2B: Identifique e implemente las anotaciones que indican el tipo de contenido que produce y/o consume el metodo 

		//TODO Requerimiento 2C: Complete la signatura del metodo (parametros) a partir de la documentacion dada.
		public Response getApartamentoesByCiudadAndPresupuesto(@QueryParam("ciudad")String ciudad){

			try{
				ParranderosTransactionManager tm = new ParranderosTransactionManager( getPath( ) );
				List<Apartamento>apartamentos;

				//TODO Requerimiento 2D: Llame al metodo del ParranderosTransactionManager que retorne el resultado esperado a partir de los criterios establecidos

				apartamentos = null;
				return Response.status( 200 ).entity( apartamentos ).build( );			
			}
			catch( Exception e )
			{
				return Response.status( 500 ).entity( doErrorMessage( e ) ).build( );
			}
		}

		/**
		 * Metodo que recibe un bebedor en formato JSON y lo agrega a la Base de Datos <br/>
		 * <b>Precondicion: </b> El archivo <em>'conectionData'</em> ha sido inicializado con las credenciales del usuario <br/>
		 * <b>Postcondicion: </b> Se agrega a la Base de datos la informacion correspondiente al bebedor. <br/>
		 * <b>URL: </b> http://localhost:8080/TutorialParranderos/rest/apartamentos <br/>
		 * @param bebedor JSON con la informacion del bebedor que se desea agregar
		 * @return	<b>Response Status 200</b> - JSON que contiene al bebedor que ha sido agregado <br/>
		 * 			<b>Response Status 500</b> - Excepcion durante el transcurso de la transaccion
		 */
		//TODO Requerimiento 3A: Identifique e implemente la anotacion correcta para la realizacion del metodo

		//TODO Requerimiento 3B: Identifique e implemente las anotaciones que indican el tipo de contenido que produce Y consume el metodo 


		public Response addApartamento(Apartamento bebedor) {

			//TODO Requerimiento 3C: Implemente el metodo a partir de los ejemplos anteriores y utilizando el Transaction Manager de Parranderos 
			return null;
		}

		/**
		 * Metodo POST que recibe un bebedor en formato JSON y lo agrega a la Base de Datos unicamente 
		 * si el número de apartamentos que existen en su ciudad es menor la constante CANTIDAD_MAXIMA <br/>
		 * <b>Precondicion: </b> El archivo <em>'conectionData'</em> ha sido inicializado con las credenciales del usuario <br/>
		 * <b>Postcondicion: </b> Se agrega a la Base de datos la informacion correspondiente al bebedor. <br/>
		 * <b>URL: </b> http://localhost:8080/TutorialParranderos/rest/apartamentos <br/>
		 * @param cantidadMaxima representa la cantidad maxima de apartamentos que pueden haber en la misma ciudad
		 * @return	<b>Response Status 200</b> - JSON que contiene al bebedor que ha sido agregado <br/>
		 * 			<b>Response Status 500</b> - Excepcion durante el transcurso de la transaccion
		 */
		@POST
		@Path( "restriccionCantidad" )
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Response addApartamentoWithLimitations(Apartamento bebedor) {

			//TODO Requerimiento 4A: Implemente el metodo a partir de los ejemplos anteriores y utilizando el Transaction Manager de Parranderos 
			return null;
		}



		/**
		 * Metodo que recibe un bebedor en formato JSON y lo agrega a la Base de Datos <br/>
		 * <b>Precondicion: </b> El archivo <em>'conectionData'</em> ha sido inicializado con las credenciales del usuario <br/>
		 * <b>Postcondicion: </b> Se actualiza la Base de datos con la informacion correspondiente al bebedor.<br/>
		 * @param bebedor JSON con la informacion del bebedor que se desea agregar
		 * @return	<b>Response Status 200</b> - JSON que contiene al bebedor que se desea modificar <br/>
		 * 			<b>Response Status 500</b> - Excepcion durante el transcurso de la transaccion
		 */
		//TODO Requerimiento 5A: Identifique e implemente la anotacion correcta para la realizacion del metodo

		//TODO Requerimiento 5B: Identifique e implemente las anotaciones que indican el tipo de contenido que produce Y consume el metodo 


		public Response updateApartamento(Apartamento bebedor) {
			//TODO Requerimiento 5B: Implemente el metodo a partir de los ejemplos anteriores y utilizando el Transaction Manager de Parranderos 
			return null;
		}

		/**
		 * Metodo que recibe un bebedor en formato JSON y lo elimina de la Base de Datos <br/>
		 * <b>Precondicion: </b> El archivo <em>'conectionData'</em> ha sido inicializado con las credenciales del usuario <br/>
		 * <b>Postcondicion: </b> Se elimina de la Base de datos al bebedor con la informacion correspondiente.<br/>
		 * <b>URL: </b> http://localhost:8080/TutorialParranderos/rest/apartamentos <br/>
		 * @param bebedor JSON con la informacion del bebedor que se desea eliminar
		 * @return	<b>Response Status 200</b> - JSON que contiene al bebedor que se desea eliminar <br/>
		 * 			<b>Response Status 500</b> - Excepcion durante el transcurso de la transaccion
		 */
		//TODO Requerimiento 6A: Identifique e implemente la anotacion correcta para la realizacion del metodo

		//TODO Requerimiento 6B: Identifique e implemente las anotaciones que indican el tipo de contenido que produce Y consume el metodo 


		public Response deleteApartamento(Apartamento bebedor) {
			//TODO Requerimiento 6C: Implemente el metodo a partir de los ejemplos anteriores y utilizando el Transaction Manager de Parranderos 
			return null;
		}

	}
