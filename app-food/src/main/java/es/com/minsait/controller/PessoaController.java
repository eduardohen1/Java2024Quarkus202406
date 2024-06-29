package es.com.minsait.controller;

import es.com.minsait.model.Pessoa;
import es.com.minsait.repository.PessoaRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/pessoa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaController {

    @Inject
    PessoaRepository pessoaRepository;

    @GET
    public List<Pessoa> listAll(){
        return pessoaRepository.listAll();
    }

    @POST
    @Transactional
    public Pessoa create(Pessoa pessoa){
        pessoaRepository.persist(pessoa);
        return pessoa;
    }

}
