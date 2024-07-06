package es.com.minsait.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class ItemPedido extends PanacheEntity {

    private String nome;
    private int quantidade;
    private Double preco;

    @ManyToOne
    private Pedido pedido;


    public ItemPedido() { }

    public ItemPedido(String nome, int quantidade, Double preco, Pedido pedido) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.pedido = pedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
