package es.com.minsait;

import es.com.minsait.dto.ItemCardapio;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;

import java.util.List;

@Path("/cardapio")
public class CardapioResource {

    private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(CardapioResource.class);
    @GET
    public Response getCardapio(){

        List<ItemCardapio> itensCadapio = List.of(
                new ItemCardapio("Coxinha", "Coxinha de frango com queijo", 10.0),
                new ItemCardapio("Pastel", "Pastel de 4 queijos", 15.0),
                new ItemCardapio("Refrigerante", "Latinha Refigerante de Cola", 2.0)
        );
        LOG.error("Cardapio solicitado: \n" + itensCadapio);
        return Response.ok(itensCadapio).build();
    }

}
