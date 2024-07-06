package es.com.minsait.controller;

import es.com.minsait.dto.ItemCardapio;
import es.com.minsait.model.Loja;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

@Path("/loja")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LojaController {

    private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(LojaController.class);

    @GET
    public List<Loja> listAll(){
        return Loja.listAll();
    }

    @POST
    @Transactional
    public Response create(Loja loja){
        loja.persist();
        return Response.status(Response.Status.CREATED).entity(loja).build();
    }

    @GET
    @Path("/{id}/cardapio")
    public Response getCardapio(@PathParam("id") Long id){
        try {
            Loja loja = Loja.findById(id);
            if (loja == null) {
                LOG.error("Loja não encontrada para o id: " + id);
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            String url = loja.getUrlApi() + "cardapio";

            //implementar a consulta externa
            Client client = jakarta.ws.rs.client.ClientBuilder.newClient();
            Response cardapioResponse = client.target(url)
                    .request(MediaType.APPLICATION_JSON)
                    .get();

            if(cardapioResponse.getStatus() != Response.Status.OK.getStatusCode() &&
                    cardapioResponse.getStatus() != Response.Status.CREATED.getStatusCode()){
                LOG.error("Erro ao buscar cardápio da loja: " + loja.getNome() + ", URL: " + loja.getUrlApi());
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao buscar cardápio da loja.").build();
            }else {
                LOG.error(">>> Cardapio da URL:\n" + cardapioResponse);
            }

            List<ItemCardapio> itensCardapio = convertRequestToList(cardapioResponse);

            // -----------------------

            if (itensCardapio == null || itensCardapio.isEmpty()) {
                LOG.error("Cardápio não encontrado para a loja: " + loja.getNome() + ", URL: " + loja.getUrlApi());
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            return Response.ok(Response.Status.OK).entity(itensCardapio).build();
        }catch (Exception e){
            LOG.error("Erro ao buscar cardápio da loja: ", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    private List<ItemCardapio> convertRequestToList(Response cardapioResponse) throws Exception {
        List<ItemCardapio> itensCardapio = new ArrayList<>();
        itensCardapio = cardapioResponse.readEntity(List.class);
        return itensCardapio;
    }

    private List<ItemCardapio> retornaCardapioFake() {

        List<ItemCardapio> itensCardapio = new ArrayList<>();
        ItemCardapio itemCardapio = new ItemCardapio( "Hamburguer", "Hamburguer de carne", 10.0);
        itensCardapio.add(itemCardapio);

        itemCardapio = new ItemCardapio("Refrigerante", "Refrigerante de 500ml", 5.0);
        itensCardapio.add(itemCardapio);

        itemCardapio = new ItemCardapio("Batata Frita", "Porção de batata frita", 8.0);
        itensCardapio.add(itemCardapio);

        return itensCardapio;

    }

}
