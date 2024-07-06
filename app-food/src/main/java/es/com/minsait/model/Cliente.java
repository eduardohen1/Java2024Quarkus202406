package es.com.minsait.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Cliente extends PanacheEntity {

    private String email;

    @OneToOne
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

    public String returnObjJson() {
        return "{\"id\":" + (this.id != null ? this.id : 0) +
                ",\"email\":\"" + this.email +
                "\",\"pessoa\":" + this.pessoa.returnObjJson() + "}";
    }
}
