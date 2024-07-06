package es.com.minsait.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

@Entity
public class Pessoa extends PanacheEntity {
    @Column(name = "nome")
    private String nome;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "uf")
    private String uf;
    @Column(name = "tipoDocumento")
    private TipoDocumento tipoDocumento;
    @Column(name = "documento")
    private String documento;

    public Pessoa() { }

    public Pessoa(Long id, String nome, String endereco, String cidade, String uf, TipoDocumento tipoDocumento, String documento) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.uf = uf;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    private String retornaTipoDocumento() {
        switch (this.tipoDocumento) {
            case CPF:
                return "CPF";
            case CNPJ:
                return "CNPJ";
            default:
                return "TIPO DE DOCUMENTO NÃO ENCONTRADO";
        }
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", cidade='" + cidade + '\'' +
                ", uf='" + uf + '\'' +
                ", tipoDocumento=" + tipoDocumento +
                ", documento='" + documento + '\'' +
                '}';
    }

    public String returnObjJson() {
        return "{ \"id\": " + (this.id != null ? this.id : 0) +
                ", \"nome\": \"" + this.nome +
                "\", \"endereco\": \"" + this.endereco +
                "\", \"cidade\": \"" + this.cidade +
                "\", \"uf\": \"" + this.uf +
                "\", \"tipoDocumento\": " + "\"" + retornaTipoDocumento() + "\"" +
                ", \"documento\": \"" + this.documento +
                "\"}";
    }
}
