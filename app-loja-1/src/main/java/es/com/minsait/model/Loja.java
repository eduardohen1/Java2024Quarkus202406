package es.com.minsait.model;

public class Loja {

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

    @Override
    public String toString() {
        return "Loja{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", urlApi='" + urlApi + '\'' +
                '}';
    }
}
