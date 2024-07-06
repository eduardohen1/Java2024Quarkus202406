package es.com.minsait;

import es.com.minsait.model.Pedido;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;

@Path("/pedidos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PedidoResource {

    private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(PedidoResource.class);
    @POST
    public Response createPedido(Pedido pedido){
        try{
            LOG.error("Pedido recebido: \n" + pedido.toString());
            return Response.ok(pedido).build();
        }catch (Exception e){
            return Response.serverError().entity("Erro ao criar pedido").build();
        }
    }

}
