package es.com.minsait;

import es.com.minsait.model.Pessoa;
import es.com.minsait.model.TipoDocumento;
import es.com.minsait.service.GreetingService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @Inject
    GreetingService greetingService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {

        //return "Hello RESTEasy \n" + p.toString();
        //return greetingService.greet();
        return greetingService.greetPessoa(new Pessoa(null,
                "Nome pessoa",
                "Endereco pessoa",
                "Cidade pessoa",
                "UF pessoa",
                TipoDocumento.CPF,
                "Documento pessoa"));
    }
}
