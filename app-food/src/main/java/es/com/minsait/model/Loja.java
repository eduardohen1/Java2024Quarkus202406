package es.com.minsait.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Loja extends PanacheEntity {

    private String nome;
    private String endereco;
    private String urlApi;

    public Loja() { }

    public Loja(String nome, String endereco, String urlApi) {
        this.nome = nome;
        this.endereco = endereco;
        this.urlApi = urlApi;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getUrlApi() {
        return urlApi;
    }

    public void setUrlApi(String urlApi) {
        this.urlApi = urlApi;
    }

    public String returnObjJson() {
        return "{\"id\":" + this.id +
                ",\"nome\":\"" + this.nome +
                "\",\"endereco\":\"" + this.endereco +
                "\",\"urlApi\":\"" + this.urlApi +
                "\"}";
    }
}
