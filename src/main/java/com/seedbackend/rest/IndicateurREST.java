/**
 * 
 */
package com.seedbackend.rest;
import java.io.IOException;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.seedbackend.dto.IndiceDTO;
import com.seedbackend.model.Indice;
import com.seedbackend.service.IndiceService;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;


/**
 * @author Abdenour BAHLOUL
 *
 */
@Path("/indicateur")
@ManagedBean
public class IndicateurREST {

	@Inject
	private IndiceService serviceIndice;

	@GET 
	@Path("/default")
	public Response getDefault()  {

		String output  = "<h2 style='color:green;'> web service REST - url racine </h2>";

		return Response
				.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Headers",
						"origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", 
						"GET, POST, PUT, DELETE, OPTIONS, HEAD")
				.entity(output)
				.build();
	}

	/*
	 * get All indices in the DB
	 * */
	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMsgJson() throws JsonGenerationException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		String output;
		List <Indice> indices  = serviceIndice.getAll();
		output =  mapper.writeValueAsString(indices);

		// Décommenter ce code si la base de données n'a pas été crée 

		//			for (Indice indice : serviceIndice.bouchonDonnee()) {
		//				jsonInString = mapper.writeValueAsString(indice);
		//				output += jsonInString + ","; 
		//			}

		return Response
				.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Headers",
						"origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", 
						"GET, POST, PUT, DELETE, OPTIONS, HEAD")
				.entity(output)
				.build();
	}

	/*
	 * get the indice with the Id 
	 * */
	@GET
	@Path("/get/{param}")
	public Response getIndice(@PathParam("param") String numIndice) throws JsonGenerationException, JsonMappingException, IOException {

		IndiceDTO indice = null;
		String output = null;
		try {
			indice =  serviceIndice.get(Integer.parseInt(numIndice));
			if (indice != null ) {
				output  = indice.toString();
			}else {
				output = "Pas d indicateur pour cette valeur";
			}

		} catch(NumberFormatException nfex ) {
			output = "<h2 style='color:red;'> NumberFormatException : valeur érroné </h2>";
		}
		catch(IndexOutOfBoundsException ioOfbex ) {
			output = "<h2 style='color:red;'> IndexOutOfBoundsException : valeur inexistante  </h2>";
		}


		return Response
				.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Headers",
						"origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", 
						"GET, POST, PUT, DELETE, OPTIONS, HEAD")
				.entity(output)
				.build();
	}

	/*
	 * Update the indice with  
	 * */
	// TO DO : change the method GET to POST
	@GET
	@Path("/update/{param}")
	public Response updateIndice(@PathParam("param") String msg) throws JsonGenerationException, JsonMappingException, IOException {

		IndiceDTO indice = new IndiceDTO(22l, msg, msg, msg, msg, msg, msg,msg,msg);
		String output = null;

		try {
			serviceIndice.save(indice);
		} catch (NumberFormatException e) {
			output = "Pas d indicateur pour cette valeur";  
		}

		if (indice != null )
			output  = indice.toString(); 

		return Response
				.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Headers",
						"origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", 
						"GET, POST, PUT, DELETE, OPTIONS, HEAD")
				.entity(output)
				.build();
	}
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Indice createIndice(Indice indice) {

		
		serviceIndice.create(indice);
		
		return indice;
	}

}
