package es.com.minsait;

import es.com.minsait.model.Pedido;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/pedidos")
public class PedidoResource {

    @POST
    public Response createPedido(Pedido pedido){
        try{
            return Response.ok(pedido).build();
        }catch (Exception e){
            return Response.serverError().entity("Erro ao criar pedido").build();
        }
    }

}
