package es.com.minsait.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import es.com.minsait.model.Pedido;

@JsonDeserialize
public class PedidoResponse {

    private Boolean confirmed;
    private Pedido pedido;

    public PedidoResponse() { }

    public PedidoResponse(Boolean confirmed, Pedido pedido) {
        this.confirmed = confirmed;
        this.pedido = pedido;
    }

    public Boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
