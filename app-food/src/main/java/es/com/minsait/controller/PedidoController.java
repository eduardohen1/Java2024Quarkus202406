package es.com.minsait.controller;

import es.com.minsait.model.Loja;
import es.com.minsait.model.Pedido;
import jakarta.ws.rs.*;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;

import java.util.List;

@Path("/pedido")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PedidoController {

    private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(PedidoController.class);

    @GET
    public List<Pedido> listAll(){
        return Pedido.listAll();
    }

    @POST
    public Response create(Pedido pedido){
        try{
            if(pedido.getLoja() == null || pedido.getLoja().getUrlApi() == null){
                LOG.error("Loja não informada para o pedido");
                return Response.status(Response.Status.BAD_REQUEST).entity("Loja não informada para o pedido").build();
            }

            String url = pedido.getLoja().getUrlApi() + "pedidos";

            Client client = jakarta.ws.rs.client.ClientBuilder.newClient();
            String jsonPedido = pedido.returnObjJson();

            LOG.error(">>> Pedido a ser realizado: \n" + jsonPedido);

            //enviar o pedido para a url da Loja
            Response pedidoResponse = client.target(url)
                                       .request(MediaType.APPLICATION_JSON)
                                       .post(Entity.entity(jsonPedido, MediaType.APPLICATION_JSON));

            //testar se a requisição retornou OK (200 201)
            if(pedidoResponse.getStatus() != Response.Status.CREATED.getStatusCode() &&
               pedidoResponse.getStatus() != Response.Status.OK.getStatusCode()){
                LOG.error("Erro ao criar pedido na loja: " + pedido.getLoja().getNome() + ", URL: " + pedido.getLoja().getUrlApi());
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao criar pedido na loja.").build();
            }else{
                return Response.status(Response.Status.CREATED).entity(pedidoResponse).build();
            }
        }catch (Exception e){
            LOG.error("Erro ao criar pedido: ", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }


}
