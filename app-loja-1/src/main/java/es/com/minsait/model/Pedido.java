package es.com.minsait.model;

import java.time.LocalDate;
import java.util.List;

public class Pedido {

    private Cliente cliente;
    private Loja loja;
    private LocalDate dataPedido;
    private String descricao;

    private List<ItemPedido> itensPedido;

}
