package es.com.minsait;

import es.com.minsait.dto.ItemCardapio;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/cardapio")
public class CardapioResource {

    @GET
    public Response getCardapio(){

        List<ItemCardapio> itensCadapio = List.of(
                new ItemCardapio("Coxinha", "Coxinha de frango", 5.0),
                new ItemCardapio("Pastel", "Pastel de carne", 3.0),
                new ItemCardapio("Refrigerante", "Refigerante de Cola", 4.0)
        );
        return Response.ok(itensCadapio).build();
    }

}
