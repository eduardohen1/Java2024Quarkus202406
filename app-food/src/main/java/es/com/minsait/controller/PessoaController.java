package es.com.minsait.controller;

import es.com.minsait.model.Pessoa;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/pessoa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaController {

    @GET
    public List<Pessoa> listAll(){
        return Pessoa.listAll();
    }

    @POST
    @Transactional
    public Pessoa create(Pessoa pessoa){
        pessoa.persist();
        return pessoa;
    }

}
