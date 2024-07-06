package es.com.minsait.controller;

import es.com.minsait.model.Cliente;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/cliente")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteController {

    @GET
    public List<Cliente> listAll(){
        return Cliente.listAll();
    }

    @POST
    @Transactional
    public Response create(Cliente cliente){
        cliente.persist();
        return Response.status(Response.Status.CREATED).entity(cliente).build();
    }

}
