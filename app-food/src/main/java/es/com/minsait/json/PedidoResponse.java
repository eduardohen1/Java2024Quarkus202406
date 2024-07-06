package es.com.minsait.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import es.com.minsait.model.Pedido;

@JsonDeserialize
public class PedidoResponse {

    private Boolean confirmed;
    //private Pedido pedido;
    private String pedido;

    public PedidoResponse() { }

    public PedidoResponse(Boolean confirmed, String pedido) {
        this.confirmed = confirmed;
        this.pedido = pedido;
    }

    public Boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }
}
