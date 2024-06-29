package es.com.minsait.service;

import es.com.minsait.model.Pessoa;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

    public String greet() {
        return "Hello form GreetingService!";
    }

    public String greetPessoa(Pessoa p){
        return "Cadastro de pessoa: \n" + p.toString();
    }

}
