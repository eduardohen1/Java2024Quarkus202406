package es.com.minsait.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Pedido extends PanacheEntity {

    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Loja loja;
    private LocalDate dataPedido;
    private String descricao;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPedido> itensPedido;

    public Pedido(){}

    public Pedido(Cliente cliente, Loja loja, LocalDate dataPedido, String descricao, List<ItemPedido> itensPedido) {
        this.cliente = cliente;
        this.loja = loja;
        this.dataPedido = dataPedido;
        this.descricao = descricao;
        this.itensPedido = itensPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public String returnObjJson(){
        return "{ \"id\": " + (this.id != null ? this.id : 0) +
                ", \"cliente\": " + this.cliente.returnObjJson() +
                ", \"loja\": " + this.loja.returnObjJson() +
                ", \"dataPedido\": \"" + this.dataPedido +
                "\", \"descricao\": \"" + this.descricao +
                "\", \"itensPedido\": [" + this.returnItensPedidoJson() +
                "]}";
    }

    private String returnItensPedidoJson() {
        StringBuilder itensJson = new StringBuilder();
        for(int i = 0; i < this.itensPedido.size(); i++){
            ItemPedido item = this.itensPedido.get(i);

            itensJson.append("{")
                    .append("\"id\": " + (item.id != null ? item.id : 0) + ", ")
                    .append("\"quantidade\":").append(item.getQuantidade()).append(", ")
                    .append("\"preco\":").append(item.getPreco())
                    .append("}");
            if(i < this.itensPedido.size()-1)
                itensJson.append(", ");
        }
        /*

        for(ItemPedido item : this.itensPedido){
            itensJson.append("{");
            itensJson.append("\"id\": " + (item.id != null ? item.id : 0) + ", ");
            itensJson.append("\"nome\": \"" + item.getNome() + "\", ");
            itensJson.append("\"quantidade\": " + item.getQuantidade() + ", ");
            itensJson.append("\"preco\": " + item.getPreco() + ", ");
            itensJson.append("}");

            //se houver mais itens, colocar vírgula
            if(this.itensPedido.indexOf(item) < this.itensPedido.size() - 1){
                itensJson.append(", ");
            }
        }*/
        return itensJson.toString();
    }

}
