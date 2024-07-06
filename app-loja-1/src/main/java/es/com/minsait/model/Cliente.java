package es.com.minsait.model;

public class Cliente {

    private String email;
    private Pessoa pessoa;

    public Cliente(){}

    public Cliente(String email, Pessoa pessoa) {
        this.email = email;
        this.pessoa = pessoa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "email='" + email + '\'' +
                ", pessoa=" + pessoa.toString() +
                '}';
    }
}
